package com.driver;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Director {
    private String name;
    private int numberOfMovies;
    private double imdbRating;

    //Constructor
    //public Director(String name, int numberOfMovies, double imdbRating){
        //this.name=name;
        //this.numberOfMovies= numberOfMovies;
        //this.imdbRating= imdbRating;
    //}
}
