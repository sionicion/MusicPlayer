package com.example.musicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //The onCreate method creates an instance of an ArrayList of the Song object, creates an
    // instance of SongAdapter which extends ArrayAdapter, then creates an instance of ListView
    // and sets the adapter to the SongAdapter. Finally, it sets the Item Click Listener
    // and tries to pass some strings about the selected Song object over to the NowPlayingActivity.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list);

        ArrayList<Song> songs = new ArrayList<Song>();
        songs.add(new Song("Oops!...I Did It Again","Britney Spears"));
        songs.add(new Song("break up with your girlfriend, i'm bored","Ariana Grande"));
        songs.add(new Song("Filthy","Justin Timberlake"));
        songs.add(new Song("I'll Make It Up To You","Imagine Dragons"));
        songs.add(new Song("Only You","Calum Scott"));
        songs.add(new Song("I'll Never Love Again","Bradley Cooper"));
        songs.add(new Song("Head Above Water","Avril Lavigne"));
        songs.add(new Song("Fallin' 4 U","Will Heard"));

        SongAdapter adapter = new SongAdapter(this,songs);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onItemClick(AdapterView<?> listView, View view, int position, long id) {
                Song currentSong = (Song) listView.getAdapter().getItem(position);
                Intent numbersIntent = new Intent(MainActivity.this, NowPlayingActivity.class);
                numbersIntent.putExtra("songName",currentSong.getSongName());
                numbersIntent.putExtra("artistName",currentSong.getArtistName());
                startActivity(numbersIntent);
            }
        });
}}
