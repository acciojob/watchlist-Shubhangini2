package com.driver;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

      private String name; //private
     private  int durationInMinutes;
     private  double imdbRating;

      //NoArgs Constructor
  //  public Movie(){}
    //All args Constructor
   // public Movie(String name, int durationInMinutes, double imdbRating){
       // this.name=name;
       // this.durationInMinutes = durationInMinutes;
        //this.imdbRating= imdbRating;

    //}
}
