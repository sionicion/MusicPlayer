package com.example.musicplayer;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class NowPlayingActivity extends AppCompatActivity {

    // This variable holds the state of the play button
    boolean isPlaying = false;

    // The onCreate method tries to retrieve some data from the MainActivity intent. Once it does
    // that, it calls the togglePlay method.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        TextView songName = findViewById(R.id.songName);
        Bundle getSongName = getIntent().getExtras();
        songName.setText(getSongName.getString("songName"));

        TextView artistName = findViewById(R.id.artistName);
        Bundle getArtistName = getIntent().getExtras();
        artistName.setText(getArtistName.getString("artistName"));

        togglePlay();

    }

    // This method simply calls the togglePlay method when the play button is clicked.
    // Oh and I could not figure out how to implement an OnClickListener here, but I did
    // use one for the ListView!
    public void playButtonClicked(View view)
    {togglePlay();}

    // This method assigns some variables to a couple drawables, then performs an
    // if statement that will check the isPlaying variable and sets the playButton drawable
    // to the opposite and then changes the isPlaying variable after.
    private void togglePlay()
    {
        ImageButton playButton =(ImageButton) findViewById(R.id.playButton);
        Drawable playIcon = getResources().getDrawable(android.R.drawable.ic_media_play);
        Drawable pauseIcon = getResources().getDrawable(android.R.drawable.ic_media_pause);
        playButton.setImageDrawable(pauseIcon);
        if (isPlaying == true)
    {playButton.setImageDrawable(playIcon); isPlaying = false;}
    else {playButton.setImageDrawable(pauseIcon); isPlaying = true;}
    }

    // This method is a simple intent to start the MainActivity.
    public void returnToLibrary(View view)
    {
        Intent returnToLibrary = new Intent(NowPlayingActivity.this, MainActivity.class);
        startActivity(returnToLibrary);
    }

}
