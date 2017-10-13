package com.example.tanmoykrishnadas.singalong;

import java.util.ArrayList;

public class Songs {
    ArrayList<SongInfo> playlist;
    int pos=0;

    public Songs() {
        playlist = new ArrayList<SongInfo>();
    }

    public void goNext() {
        pos++;
        if(pos==playlist.size()) {
            pos=0;
        }
    }

    public void goPrevious() {
        pos--;
        if(pos<0) {
            pos=playlist.size()-1;
        }
    }

    public void insert(String name, String artist, String url) {
        playlist.add(new SongInfo(name, artist, url));
    }

    public String getName() {
        return playlist.get(pos).getName();
    }

    public String getArtist() {
        return playlist.get(pos).getArtist();
    }

    public String getUrl() {
        return  playlist.get(pos).getUrl();
    }
}