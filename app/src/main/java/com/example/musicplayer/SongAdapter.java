package com.example.musicplayer;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

// The SongAdapter extends the ArrayAdapter class and helps bridge the connection between the
// ArrayList and the ListView.
public class SongAdapter extends ArrayAdapter<Song> {

    // This default constructor is not used I believe. I referred to the course content for help
    // with this class.
public SongAdapter(Activity context, ArrayList<Song> songs)
{super(context,0,songs);}

// I modified this to accommodate the different variables, but pretty much the same thing going on.
@Override
    public View getView(int position, View convertView, ViewGroup parent)
{
    View listItemView = convertView;
    if(listItemView == null)
    {listItemView= LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
    }

    Song currentSong = getItem(position);
    TextView songNameTextView = (TextView) listItemView.findViewById(R.id.songName_text_view);
    songNameTextView.setText(currentSong.getSongName());
    TextView artistNameTextView = (TextView) listItemView.findViewById(R.id.artistName_text_view);
    artistNameTextView.setText(currentSong.getArtistName());

    return listItemView;
}

}
