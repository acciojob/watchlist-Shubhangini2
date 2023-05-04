package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository //to make beans of the class
public class MovieRepository {

    //name should be the primary key
    private HashMap<String, Movie> movieMap;
    private HashMap<String, Director> directorMap;
    private HashMap<String, List<String>> directorMovieMapping;
    //String=Director
    //List<String>=list of movies

    //Pair is Director name , list of movies Names

    //Initialization is very important
    public MovieRepository(){
        this.movieMap = new HashMap<String, Movie>();
        this.directorMap = new HashMap<String,Director>();
        this.directorMovieMapping = new HashMap<String, List<String>>();
    }

    //add Movie-put it into the hashmap
    public void saveMovie(Movie movie){
        
        movieMap.put(movie.getName(), movie);
    }
    // add Director - put it into the hashmap
    public void saveDirector(Director director){
        
        directorMap.put(director.getName(),director);
    }

    public void saveMovieDirectorPair(String movie, String director){

        List<String> currentMoviesByDirector = new ArrayList<>();
        if(directorMovieMapping.containsKey(director))
            currentMoviesByDirector= directorMovieMapping.get(director);

        currentMoviesByDirector.add(movie);

        directorMovieMapping.put(director,currentMoviesByDirector);
    }

    public Movie findMovie(String movie) {
        return movieMap.get(movie);
    }

    public Director findDirector(String director) {
        return directorMap.get(director);
    }

    public List<String> findMoviesFromDirector(String director){
        List<String> movieList = new ArrayList<>();
        if(directorMovieMapping.containsKey(director)) movieList = directorMovieMapping.get(director);
        return movieList;
    }//if director not found you can return empty list

    public List<String> findAllMovies(){
        return new ArrayList<>(movieMap.keySet());//converting set to an arrayList//(abel tp get the list of string)movieMap.keySet().stream().toList() //keySet itself is a list of movie names
        //if they want all movies then you should have done .Values and convert it into ArrayList
    }


    public void removeDirector(String director){
        directorMap.remove(director);
        directorMovieMapping.remove(director);
    }

    public void removeMovie(String movieName){
        movieMap.remove(movieName);
    }

    public List<String> getAllDirectors(){
        return new ArrayList<>(directorMap.keySet()); //name of the directors are in there keySet
    }
}








   /* public void deleteDirector(String director) {
        List<String> movies = new ArrayList<>();
        if (directorMovieMapping.containsKey(director)) {
            //1. Find the movie names by director from the pair
            movies = directorMovieMapping.get(director);

            //2. Deleting all the movies from movieDb by using movieName
            for (String movie : movies) {
                if (movieMap.containsKey(movie)) {
                    movieMap.remove(movie);
                }
            }
            //3. Deleting the pair
            directorMovieMapping.remove(director);
        }

        //4.Delete the director from directorDB
        if(directorMap.containsKey(director)){
            directorMap.remove(director);
        }
    }*/