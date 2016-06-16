package com.codepath.flixster;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        TextView textView = (TextView) findViewById(R.id.tvTitle1);
        String title = getIntent().getStringExtra("movie title");
        textView.setText(title);

        TextView tvReleaseDate = (TextView) findViewById(R.id.tvReleaseDate);
        String date = getIntent().getStringExtra("release date");
        tvReleaseDate.setText(date);

        TextView tvOverview = (TextView) findViewById(R.id.tvOverview1);
        String overview = getIntent().getStringExtra("overview");
        tvOverview.setText(overview);
        tvOverview.setMovementMethod(new ScrollingMovementMethod());

    }

    public void onSubmit(View v) {

        Intent data = new Intent();
        setResult(RESULT_OK, data);
        finish();
    }
}
