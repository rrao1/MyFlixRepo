package com.codepath.flixster;

/**
 * Created by ramyarao on 6/16/16.
 */
public class Popularity {
    public enum PopularValues {
        UNPOPULAR, POPULAR
    }

    public Popularity(String label, PopularValues popular) {
        super();
        this.label = label;
        this.popular = popular;
    }

    public String label;
    public PopularValues popular;




}
