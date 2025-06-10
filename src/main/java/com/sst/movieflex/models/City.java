package com.sst.movieflex.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "cities")
public class City extends BaseModel{

    private String name;

    @OneToMany
    private List<Theatre> theatres;
}

/*
    1               M
CITY  -------  THEATRE => 1:M
    1               1
 */