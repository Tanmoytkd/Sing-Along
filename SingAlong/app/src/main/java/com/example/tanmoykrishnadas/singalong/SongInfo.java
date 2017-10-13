package com.example.tanmoykrishnadas.singalong;

/**
 * Created by Tanmoy Krishna Das on 13-Oct-17.
 */
class SongInfo {
    String name, artist, url;

    public SongInfo(String name, String artist, String url) {
        this.name = name;
        this.artist = artist;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public String getUrl() {
        return url;
    }
}
