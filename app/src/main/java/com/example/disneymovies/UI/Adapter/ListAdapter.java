package com.example.disneymovies.UI.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.disneymovies.Data.Movie;
import com.example.disneymovies.R;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<Movie> {
    public ListAdapter(Context context, ArrayList<Movie> dataArrayList) {
        super(context, R.layout.list_item, dataArrayList);
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        Movie movie = getItem(position);

        if (view == null){
            view = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        ImageView listImage = view.findViewById(R.id.listImage);
        TextView listName = view.findViewById(R.id.listName);
        TextView listYear = view.findViewById(R.id.listYear);
        TextView listRating = view.findViewById(R.id.listRating);

        listImage.setImageResource(movie.image);
        listName.setText(movie.name);
        listYear.setText(movie.year);
        listRating.setText(movie.rating);
        return view;
    }
}