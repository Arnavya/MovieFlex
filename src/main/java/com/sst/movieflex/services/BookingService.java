package com.sst.movieflex.services;

import com.sst.movieflex.exceptions.ShowSeatNotAvailableException;
import com.sst.movieflex.exceptions.UserNotFoundException;
import com.sst.movieflex.models.Booking;
import com.sst.movieflex.models.ShowSeat;
import com.sst.movieflex.models.User;
import com.sst.movieflex.models.enums.BookingStatus;
import com.sst.movieflex.models.enums.ShowSeatStatus;
import com.sst.movieflex.repositories.BookingRepository;
import com.sst.movieflex.repositories.ShowSeatRepository;
import com.sst.movieflex.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    private UserRepository userRepository;
    private ShowSeatRepository showSeatRepository;
    private BookingPriceCalculatorService bookingPriceCalculatorService;
    private BookingRepository bookingRepository;

    public BookingService(UserRepository userRepository, ShowSeatRepository showSeatRepository,
                          BookingPriceCalculatorService bookingPriceCalculatorService,
                          BookingRepository bookingRepository) {
        this.userRepository = userRepository;
        this.showSeatRepository = showSeatRepository;
        this.bookingPriceCalculatorService = bookingPriceCalculatorService;
        this.bookingRepository = bookingRepository;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking createBooking(Long userId, List<Long> showSeatIds) throws UserNotFoundException, ShowSeatNotAvailableException {
        Optional<User> optionalUser = userRepository.findById(userId);

        if(optionalUser.isEmpty()){
            throw new UserNotFoundException("User with id:"+ userId + "not found");
        }
        User user = optionalUser.get();
        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds);

        for(ShowSeat showSeat : showSeats){
            if(!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)){
                throw new ShowSeatNotAvailableException("ShowSeat with showId: " +
                        showSeat.getShow().getId() + " and seatId:" +
                        showSeat.getSeat().getSeatNumber() + " is not available");
            }
        }
        for(ShowSeat showSeat : showSeats){
            showSeat.setShowSeatStatus(ShowSeatStatus.BLOCKED);
            showSeatRepository.save(showSeat);
        }
        Booking booking = new Booking();
        booking.setShowSeats(showSeats);
        booking.setBookingStatus(BookingStatus.PENDING);
        booking.setUser(user);
        booking.setAmount(bookingPriceCalculatorService.calculatePrice(showSeats));
        return bookingRepository.save(booking);
    }
}
