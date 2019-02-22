package com.example.musicplayer;

// The Song class is used to create an instance of a *song* with a given song name and artist name.
public class Song {

    // Song name entry
    private String mSongName;

    // Artist name entry
    private String mArtistName;

    // Default constructor
    public Song(String SongName, String ArtistName)
    {mSongName = SongName; mArtistName = ArtistName;}

    // Get the name of the song
    public String getSongName() {return mSongName;}

    // Get the name of the artist
    public String getArtistName() {return mArtistName;}
}