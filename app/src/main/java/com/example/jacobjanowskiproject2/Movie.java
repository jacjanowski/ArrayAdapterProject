package com.example.jacobjanowskiproject2;



public class Movie {

    String name;
    String description;
    String link;
    String wikiMovie;
    String wikiDirector;
    int image;

    Movie(String name, String description, String link, String wikiMovie, String wikiDirector,  int image){
        this.link = link;
        this.name = name;
        this.description = description;
        this.wikiMovie = wikiMovie;
        this.wikiDirector = wikiDirector;
        this.image = image;
    }


}
