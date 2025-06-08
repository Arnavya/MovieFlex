package com.sst.movieflex.models;

import com.sst.movieflex.models.enums.Feature;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Screen extends BaseModel{
    private String screenName;
    private List<Seat> seats;
    private List<Feature> features;
    private Threatre threatre;
}
