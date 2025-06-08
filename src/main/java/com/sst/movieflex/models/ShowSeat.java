package com.sst.movieflex.models;

import com.sst.movieflex.models.enums.ShowSeatStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShowSeat extends BaseModel{

    private Show show;

    private Seat seat;

    private ShowSeatStatus showSeatStatus;
}
