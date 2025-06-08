package com.sst.movieflex.models;

import com.sst.movieflex.models.enums.Feature;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Show extends BaseModel{

    @ManyToOne
    private Movie movie;

    private Date startTime;

    private Date endTime;

    @ManyToOne
    private List<Screen> screens;

    private List<Feature> features;
}
/*
  1          1
Show ------ Movie
 M            1

  1             1
 Show ------ Screen
  M             1
 */