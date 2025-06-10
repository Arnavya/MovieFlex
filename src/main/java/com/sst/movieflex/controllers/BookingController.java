package com.sst.movieflex.controllers;

import com.sst.movieflex.dtos.CreateBookingRequestDto;
import com.sst.movieflex.dtos.CreateBookingResponseDto;
import com.sst.movieflex.dtos.ResponseStatus;
import com.sst.movieflex.models.Booking;
import com.sst.movieflex.models.ShowSeat;
import com.sst.movieflex.models.User;
import com.sst.movieflex.services.BookingService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }
    @PostMapping
    public CreateBookingResponseDto createBooking(@RequestBody CreateBookingRequestDto requestDto) {
        CreateBookingResponseDto responseDto = new CreateBookingResponseDto();

        Booking booking = null;

        booking = bookingService.createBooking(
                requestDto.getUserId(),
                requestDto.getShowSeatsIds()
        );
        responseDto.setBooking(booking);
        responseDto.setResponseStatus(ResponseStatus.SUCCESS);

        if(booking == null){
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDto;
    }
}
