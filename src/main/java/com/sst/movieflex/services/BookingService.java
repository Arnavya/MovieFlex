package com.sst.movieflex.services;

import com.sst.movieflex.models.Booking;
import com.sst.movieflex.models.ShowSeat;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookingService {
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking createBooking(Long userId, List<Long> showSeatIds){
        return null;
    }
}
