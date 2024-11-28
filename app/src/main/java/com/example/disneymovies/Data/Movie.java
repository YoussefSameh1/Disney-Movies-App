package com.example.disneymovies.Data;

public class Movie {
    public String name;
    public int year;
    int duration;
    int description;
    public int image;
    public int rating;
    int quote;

    public Movie(String name, int year, int duration, int description, int image, int rating, int quote) {
        this.name = name;
        this.year = year;
        this.duration = duration;
        this.description = description;
        this.image = image;
        this.rating = rating;
        this.quote = quote;
    }
}