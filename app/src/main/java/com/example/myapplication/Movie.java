package com.example.myapplication;

public class Movie {
    private String title;
    private String year;
    private String genre;
    private String posterResource;

    public Movie(String title, String year, String genre, String posterResource) {
        this.title = (title != null && !title.isEmpty()) ? title : "Unknown movie name";
        this.year = year;
        this.genre = (genre != null && !genre.isEmpty()) ? genre : "Unknown Genre";
        this.posterResource = (posterResource != null) ? posterResource : "default_poster";
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        if (year == null || year.isEmpty()) {
            return "Unknown Year";
        }

        try {
            int yearValue = Integer.parseInt(year);
            if (yearValue < 0) {
                return String.valueOf(Math.abs(yearValue));
            }
            return year;
        } catch (NumberFormatException e) {
            return "Unknown Year";
        }
    }

    public String getGenre() {
        return genre;
    }

    public String getPosterResource() {
        return posterResource;
    }
}
