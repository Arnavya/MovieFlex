package com.sst.movieflex.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Threatre extends BaseModel{

    private String name;

    private String address;

    private List<Screen> screens;

}
