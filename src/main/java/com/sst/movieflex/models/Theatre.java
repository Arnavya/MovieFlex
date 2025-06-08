package com.sst.movieflex.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Theatre extends BaseModel{

    private String name;

    private String address;

    @OneToMany
    private List<Screen> screens;

}
/*
    1             M
Theatre ------- Screen
    1              1
 */