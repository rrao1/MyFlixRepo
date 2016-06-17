package com.codepath.flixster;

import android.content.Context;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

/**
 * Created by ramyarao on 6/15/16.
 */
public class MoviesAdapter extends ArrayAdapter<Movie> {

    private static class ViewHolder {
        TextView title;
        TextView overVi;
        ImageView pic;
    }
    boolean isPortrait;
    public MoviesAdapter(Context context, List<Movie> movies) {
        super(context, android.R.layout.simple_list_item_1, movies);
        isPortrait = getContext().getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT;
        //super(context, R.layout.item_movie, movies);
    }

    @Override
    public int getViewTypeCount() {
        return Movie.popValues.values().length;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Movie movie = getItem(position);

        ViewHolder viewHolder;
        boolean checker = getItemViewType(position) == Movie.popValues.POP.ordinal();

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            viewHolder = new ViewHolder();
            int type = getItemViewType(position);
            convertView = getInflatedLayoutForType(type);
            //convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_movie, parent, false);
            viewHolder.pic = (ImageView) convertView.findViewById(R.id.ivMovieImage);

            if (!checker) {
                viewHolder.title = (TextView) convertView.findViewById(R.id.tvTitle);
                viewHolder.overVi = (TextView) convertView.findViewById(R.id.tvOverview);
            }

            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        //ImageView ivImage = (ImageView) convertView.findViewById(R.id.ivMovieImage);
        viewHolder.pic.setImageResource(0);
        //ivImage.setImageResource(0);

        boolean isPortrait = getContext().getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT;

//        if (bool || (!isPortrait)) {
        if (!isPortrait) {
            // Lookup view for data population
//            TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
//
//            TextView tvOverview = (TextView) convertView.findViewById(R.id.tvOverview);
            //clear out the image from convertView

            if (!checker) {
                viewHolder.title.setText(movie.getOriginalTitle());
                viewHolder.overVi.setText(movie.getOverview());
            }


            // Populate the data into the template view using the data object
//            tvTitle.setText(movie.getOriginalTitle());
//            tvOverview.setText(movie.getOverview());

            Picasso.with(getContext()).load(movie.getBackdropPath())
                    .into(viewHolder.pic);
//            Picasso.with(getContext()).load(movie.getBackdropPath()).transform(new RoundedCornersTransformation(20, 20)).into(ivImage);
        }
        else if (getItemViewType(position) == Movie.popValues.POP.ordinal()) {
          //  Picasso.with(getContext()).load(movie.getBackdropPath()).placeholder(R.drawable.top_rated)
            //        .into(viewHolder.topRated);
            Picasso.with(getContext()).load(movie.getBackdropPath()).transform(new RoundedCornersTransformation(20, 20)).into(viewHolder.pic);
        }
        else {
            // Lookup view for data population
            viewHolder.title = (TextView) convertView.findViewById(R.id.tvTitle);
            viewHolder.overVi = (TextView) convertView.findViewById(R.id.tvOverview);
            viewHolder.title.setText(movie.getOriginalTitle());
            viewHolder.overVi.setText(movie.getOverview());


//            TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
//
//            TextView tvOverview = (TextView) convertView.findViewById(R.id.tvOverview);
//            //clear out the image from convertView
//
//
//            // Populate the data into the template view using the data object
//            tvTitle.setText(movie.getOriginalTitle());
//            tvOverview.setText(movie.getOverview());
            Picasso.with(getContext()).load(movie.getPosterPath()).transform(new RoundedCornersTransformation(20, 20)).into(viewHolder.pic);
        }



//        else if (getContext().getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
//            Picasso.with(getContext()).load(movie.getPosterPath()).transform(new RoundedCornersTransformation(20, 20)).into(ivImage);
//
//        } else {
//            Picasso.with(getContext()).load(movie.getBackdropPath()).transform(new RoundedCornersTransformation(20, 20)).into(ivImage);
//        }

//        Picasso.with(getContext()).load(movie.getPosterPath()).transform(new RoundedCornersTransformation(20, 20)).into(ivImage);


        //return the view
        return convertView;

  //      Log.d("MoviesAdapter", "Position: " + position);

        //String imageUri = "https://i.imgur.com/tGbaZCY.jpg";

        // Return the completed view to render on screen
//        return convertView;

    }

    private View getInflatedLayoutForType(int type) {
        if (!isPortrait && !(type == Movie.popValues.POP.ordinal())) {

            return LayoutInflater.from(getContext()).inflate(R.layout.item_movie, null);

        }
        else if (type == Movie.popValues.POP.ordinal()) {
            return LayoutInflater.from(getContext()).inflate(R.layout.popular_movie, null);
        }
        else {

            return LayoutInflater.from(getContext()).inflate(R.layout.item_movie, null);
        }
//        if (bool) {
//            return LayoutInflater.from(getContext()).inflate(R.layout.popular_movie, parent, false);
//        }
//        else {
//            return LayoutInflater.from(getContext()).inflate(R.layout.item_movie, parent, false);
//        }
    }

    @Override
    public int getItemViewType(int position) {
        return getItem(position).pop.ordinal();
    }






}
