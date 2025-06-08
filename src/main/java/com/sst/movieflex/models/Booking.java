package com.sst.movieflex.models;

import com.sst.movieflex.models.enums.BookingStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Booking extends BaseModel{

    private User user;

    private BookingStatus bookingStatus;

    private double amount;

    private List<ShowSeat> showSeats;

    private List<Payment> payments;

    private Date bookedAt;
}
