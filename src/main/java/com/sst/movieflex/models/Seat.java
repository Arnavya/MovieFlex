package com.sst.movieflex.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Seat extends BaseModel{

    private String seatNumber;

    private int rowVal;

    private int colVal;

    private SeatType seatType;
}
