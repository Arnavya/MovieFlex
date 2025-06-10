package com.sst.movieflex.models;

import com.sst.movieflex.models.enums.Feature;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "screens")
public class Screen extends BaseModel{
    private String screenName;

    @OneToMany
    @JoinColumn(name = "screen_id")
    private List<Seat> seats;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> features;
//    @ManyToOne
//    private Theatre threatre;
}
/*
SCREEN ------ THEATRE => M : 1

SCREEN ------ SEAT => 1 : M
 */

