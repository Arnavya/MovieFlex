package com.sst.movieflex.models;

import com.sst.movieflex.models.enums.Feature;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Show extends BaseModel{

    private Movie movie;

    private Date startTime;

    private Date endTime;

    private List<Screen> screens;

    private List<Feature> features;
}
