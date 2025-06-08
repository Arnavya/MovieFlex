package com.sst.movieflex.models;

import com.sst.movieflex.models.enums.Feature;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Movie extends BaseModel{

    private String movieName;

    private double rating;

    private int durationInMinutes;

    private List<Feature> features;
}
