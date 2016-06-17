package com.codepath.flixster;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by ramyarao on 6/15/16.
 */
public class Movie {
    String originalTitle;
    String posterPath;
    String backdropPath;
    String overview;
    String releaseDate;
    double rating;
    public popValues pop;

    public enum popValues {
        POP, UNPOP
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterPath);
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getOverview() {
        return overview;
    }

    public String getBackdropPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", backdropPath);
    }
    public double getRating() {
        return rating;
    }



    public Movie(JSONObject jsonObject) throws JSONException {
        this.originalTitle = jsonObject.getString("original_title");
        this.posterPath = jsonObject.getString("poster_path");
        this.overview = jsonObject.getString("overview");
        this.backdropPath = jsonObject.getString("backdrop_path");
        this.releaseDate = jsonObject.getString("release_date");
        this.rating = jsonObject.getDouble("vote_average");
        if (rating > 5.00) {
            pop = popValues.POP;
        }
        else {
            pop = popValues.UNPOP;
        }
    }

    public boolean isPopular() {
        return rating > 5.00;
    }

    public static ArrayList<Movie> fromJSONArray(JSONArray array) {
        ArrayList<Movie> results = new ArrayList<>();

        for (int x = 0; x < array.length(); x++) {
            try {
                results.add(new Movie(array.getJSONObject(x)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return results;
    }

//    public static ArrayList<Movie> getFakeMovies() {
//        ArrayList<Movie> movies = new ArrayList<>();
//        for (int i = 0; i < 60; i++) {
//            movies.add(new Movie("The Social Network", "", 75));
//            movies.add(new Movie("The Internship", "", 50));
//            movies.add(new Movie("The Lion King", "", 100));
//        }
//        return movies;
//    }
//
//    @Override
//    public String toString() {
//        return title + " - " + rating;
//    }
}
