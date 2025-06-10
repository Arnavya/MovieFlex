package com.sst.movieflex.models;

import com.sst.movieflex.models.enums.ShowSeatStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeat extends BaseModel{

    @ManyToOne
    private Show show;

    @ManyToOne
    private Seat seat;

    @Enumerated(EnumType.ORDINAL)
    private ShowSeatStatus showSeatStatus;
}
/*
   1              1
ShowSeat ------ Show
    M             1
    S1A1       ---S1,S2,S3
    S1A2
    S2A1
    S2A2
    S3B1
    S3A1

    1            1
ShowSeat ------ Seat
    M             1

    S1A1       ---A1,B1,A2
    S1A2
    S2A1
    S2A2
    S3B1
    S3A1
 */