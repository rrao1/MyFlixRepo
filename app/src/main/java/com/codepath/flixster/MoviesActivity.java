package com.codepath.flixster;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class MoviesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
        // To get the data to show up in the list, we need to:
        // 1. Get the actual movies
        ArrayList<Movie> movies = Movie.getFakeMovies();

        // 2. Get the ListView that we want to populate
        ListView lvMovies = (ListView) findViewById(R.id.lvMovies);

        // 3. Create an ArrayAdapter
        //ArrayAdapter<Movie> adapter = new ArrayAdapter<Movie>(this, android.R.layout.simple_list_item_1, movies);
        MoviesAdapter adapter = new MoviesAdapter(this, movies);

        // 4. Associate the adapter with the ListView
        if (lvMovies != null) {
            lvMovies.setAdapter(adapter);
        }

    }
}
