package com.sst.movieflex.models;

import com.sst.movieflex.models.enums.BookingStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Booking extends BaseModel{
    @ManyToOne
    private User user;

    private BookingStatus bookingStatus;

    private double amount;

    @OneToMany
    private List<ShowSeat> showSeats;

    @OneToMany
    private List<Payment> payments;

    private Date bookedAt;
}
/*
   1             1
BOOKING ------ USER => M : 1
   M             1


   1                M
BOOKING ------- SHOWSEAT => 1 : M
    1               1


    1              M
BOOKING ------- PAYMENT => 1 : M
    1               1
 */