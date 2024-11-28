package com.example.disneymovies.UI.Fragment;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.disneymovies.Data.Movie;
import com.example.disneymovies.R;
import com.example.disneymovies.UI.Adapter.ListAdapter;
import com.example.disneymovies.UI.DetailsActivity;

import java.util.ArrayList;

public class MainFragment extends Fragment {

    ListAdapter listAdapter;
    ArrayList<Movie> dataArrayList = new ArrayList<>();
    Movie movie;
    MediaPlayer mediaPlayer;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Initialize and start the media player
        mediaPlayer = MediaPlayer.create(getActivity(), R.raw.background_music);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();

        // Setup ListView and its adapter
        ListView listView = view.findViewById(R.id.listview);

        int[] imageList = {R.drawable.cars, R.drawable.finding_nemo, R.drawable.monsters_inc, R.drawable.monsters_university, R.drawable.ratatouille, R.drawable.tangled, R.drawable.the_incredibles, R.drawable.the_lion_king, R.drawable.toy_story, R.drawable.up, R.drawable.walle};
        int[] yearsList = {R.string.cars_year, R.string.finding_nemo_year, R.string.monsters_inc_year, R.string.monsters_university_year, R.string.ratatouille_year, R.string.tangled_year, R.string.the_incredibles_year, R.string.the_lion_king_year, R.string.toy_story_year, R.string.up_year, R.string.WALLE_year};
        int[] durationList = {R.string.cars_duration, R.string.finding_nemo_duration, R.string.monsters_inc_duration, R.string.monsters_university_duration, R.string.ratatouille_duration, R.string.tangled_duration, R.string.the_incredibles_duration, R.string.the_lion_king_duration, R.string.toy_story_duration, R.string.up_duration, R.string.WALLE_duration};
        int[] descriptionList = {R.string.cars_description, R.string.finding_nemo_description, R.string.monsters_inc_description, R.string.monsters_university_description, R.string.ratatouille_description, R.string.tangled_description, R.string.the_incredibles_description, R.string.the_lion_king_description, R.string.toy_story_description, R.string.up_description, R.string.WALLE_description};
        int[] ratingList = {R.string.cars_rating, R.string.finding_nemo_rating, R.string.monsters_inc_rating, R.string.monsters_university_rating, R.string.ratatouille_rating, R.string.tangled_rating, R.string.the_incredibles_rating, R.string.the_lion_king_rating, R.string.toy_story_rating, R.string.up_rating, R.string.WALLE_rating};
        int[] quotesList = {R.string.cars_quote, R.string.finding_nemo_quote, R.string.monsters_inc_quote, R.string.monsters_university_quote, R.string.ratatouille_quote, R.string.tangled_quote, R.string.the_incredibles_quote, R.string.the_lion_king_quote, R.string.toy_story_quote, R.string.up_quote, R.string.WALLE_quote};
        String[] nameList = {"Cars", "Finding Nemo", "Monsters Inc", "Monsters University", "Ratatouille", "Tangled", "The Incredibles", "The Lion King", "Toy Story", "UP", "WALL.E"};

        for (int i = 0; i < imageList.length; i++) {
            movie = new Movie(nameList[i], yearsList[i], durationList[i], descriptionList[i], imageList[i], ratingList[i], quotesList[i]);
            dataArrayList.add(movie);
        }
        listAdapter = new ListAdapter(getActivity(), dataArrayList);
        listView.setAdapter(listAdapter);
        listView.setClickable(true);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), DetailsActivity.class);
                intent.putExtra("name", nameList[i]);
                intent.putExtra("year", yearsList[i]);
                intent.putExtra("duration", durationList[i]);
                intent.putExtra("description", descriptionList[i]);
                intent.putExtra("image", imageList[i]);
                intent.putExtra("quote", quotesList[i]);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // Stop the media player when the view is destroyed
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
