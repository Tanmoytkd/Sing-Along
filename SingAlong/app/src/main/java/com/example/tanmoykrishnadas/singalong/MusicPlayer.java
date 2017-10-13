package com.example.tanmoykrishnadas.singalong;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.TreeMap;

//add the import statements here to import the Button, TextView and View classes


public class MusicPlayer extends AppCompatActivity implements Runnable {
    private boolean started=false;
    private  int currentPosition = 0;
    private MediaPlayer mp;
    private SeekBar songSeekBar;
    private Thread soundThread;
    private String weather = "rainy";
    public TreeMap<String, Songs> data;
    ImageButton playButton, nextButton, previousButton;
    TextView songName, artistName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);

        mp = new MediaPlayer();
        getWeather();
        showWeather();

        data = new TreeMap<String, Songs>();
        SongCollector.collectSongs(data);

        playButton = (ImageButton) findViewById(R.id.playbutton);
        nextButton = (ImageButton) findViewById(R.id.nextbutton);
        previousButton = (ImageButton) findViewById(R.id.previousbutton);
        songSeekBar = (SeekBar) findViewById(R.id.songseekbar);

        songName = (TextView) findViewById(R.id.songname);
        artistName = (TextView) findViewById(R.id.artistname);

        setSong();
        setupListeners();

        soundThread = new Thread(this);
        soundThread.start();

        Intent returnIntent = getIntent();
        setResult(RESULT_OK, returnIntent);
    }

    private void setSong() {
        Songs currentSong = data.get(weather);
        songName.setText(currentSong.getName());
        artistName.setText(currentSong.getArtist());
        if(mp!=null) {
            mp.stop();
        }
        mp=MediaPlayer.create(getApplicationContext(), getResources().getIdentifier(currentSong.getUrl(),"raw",getPackageName()));
        started=false;
        currentPosition=0;
    }


    public void setupListeners() {
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(started) {
                    if(mp!=null) {
                        mp.pause();
                        currentPosition = mp.getCurrentPosition();
                        started=false;
                        //playButton.setBackground();
                    }
                } else {
                    if(mp==null) setSong();
                    mp.seekTo(currentPosition);
                    mp.start();
                    started=true;
                    //playButton.setBackground();
                }
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mp!=null) mp.stop();
                data.get(weather).goNext();
                boolean prevstarted = started;
                setSong();
                if(prevstarted) {
                    mp.start();
                    started=true;
                }
            }
        });

        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mp!=null) mp.stop();
                data.get(weather).goPrevious();
                boolean prevstarted = started;
                setSong();
                if(prevstarted) {
                    mp.start();
                    started=true;
                }
            }
        });

        songSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser) {
                    mp.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void showWeather() {

    }

    private void getWeather() {
    }

    @Override
    public void run() {
       int soundTotal = mp.getDuration();
        songSeekBar.setMax(soundTotal);

        while(mp!=null && currentPosition<soundTotal) {
            try {
                Thread.sleep(300);
                currentPosition = mp.getCurrentPosition();
            } catch(InterruptedException e) {
                return;
            } catch (Exception e) {
                return;
            }
            songSeekBar.setProgress(currentPosition);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        mp.stop();
    }
}