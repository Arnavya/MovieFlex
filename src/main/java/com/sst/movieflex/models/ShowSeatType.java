package com.sst.movieflex.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShowSeatType extends BaseModel{

    private Show show;

    private Seat seat;

    private double price;
}
