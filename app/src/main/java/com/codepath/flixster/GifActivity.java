package com.codepath.flixster;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class GifActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gif);



        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            ImageView ivGif2 = (ImageView) findViewById(R.id.ivGif);
            // Display the GIF (from raw resource) into the ImageView
            Glide.with(this).load(R.raw.gify3).asGif().into(ivGif2);

            ImageView ivGif3 = (ImageView) findViewById(R.id.ivGif3);
            // Display the GIF (from raw resource) into the ImageView
            Glide.with(this).load(R.raw.gify5).asGif().into(ivGif3);

            ImageView ivGif4 = (ImageView) findViewById(R.id.ivGif4);
            // Display the GIF (from raw resource) into the ImageView
            Glide.with(this).load(R.raw.gify6).asGif().into(ivGif4);

            ImageView ivGif = (ImageView) findViewById(R.id.ivGif2);
            // Display the GIF (from raw resource) into the ImageView
            Glide.with(this).load(R.raw.gify4).asGif().into(ivGif);
        }

    }

    public void toMain(View view) {
        launchComposeView();
    }

    public void launchComposeView() {
        Intent i = new Intent(GifActivity.this, MoviesActivity.class);
        startActivity(i);
    }
}
