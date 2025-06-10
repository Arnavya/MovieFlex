package com.sst.movieflex.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "theatres")
public class Theatre extends BaseModel{

    private String name;

    private String address;

    @OneToMany
    @JoinColumn(name = "theatre_id")
    private List<Screen> screens;

}
/*
    1             M
Theatre ------- Screen
    1              1
 */