package com.sst.movieflex.models;

import com.sst.movieflex.models.enums.Feature;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Screen extends BaseModel{
    private String screenName;

    @OneToMany
    private List<Seat> seats;

    private List<Feature> features;
    @ManyToOne
    private Threatre threatre;
}
/*
SCREEN ------ THEATRE => M : 1

SCREEN ------ SEAT => 1 : M
 */

