package com.example.disneymovies.UI;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.disneymovies.R;
import com.example.disneymovies.UI.Fragment.MainFragment;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.button);
        mediaPlayer.start();

        MediaPlayer mediaPlayer1 = MediaPlayer.create(this, R.raw.background_music);
        mediaPlayer1.setLooping(true);
        mediaPlayer1.start();

        TextView movieName = findViewById(R.id.movieName);
        ImageView detailImage = findViewById(R.id.detailImage);
        TextView detailYear = findViewById(R.id.detailYear);
        TextView detailDuration = findViewById(R.id.detailDuration);
        TextView detailDescription = findViewById(R.id.detailDescription);
        TextView detailQuote = findViewById(R.id.detailQuotes);

        Intent intent = this.getIntent();
        if (intent != null) {
            String name = intent.getStringExtra("name");
            int image = intent.getIntExtra("image", R.drawable.cars);
            int year = intent.getIntExtra("year", R.string.cars_year);
            int duration = intent.getIntExtra("duration", R.string.cars_duration);
            int description = intent.getIntExtra("description", R.string.cars_description);
            int quote = intent.getIntExtra("quote", R.string.cars_quote);

            movieName.setText(name);
            detailYear.setText(year);
            detailDuration.setText(duration);
            detailDescription.setText(description);
            detailQuote.setText(quote);
            detailImage.setImageResource(image);
        }
    }

    public void back(View view) {
        onBackPressed();  // Simply goes back to the previous fragment or activity in the stack
    }
}
