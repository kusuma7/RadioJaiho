package com.example.kavya.radiojaiho;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.Toast;

import java.io.IOException;

/**
 * Created by KUSUMA on 1/9/2017.
 */

public class LiveRadioActivity extends AppCompatActivity {

    ImageButton ibPlay, ibPause, ibStop;
    SeekBar sSeekBar;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_radio);

        ibPlay = (ImageButton)findViewById(R.id.image_button_play);
        ibPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast toast = Toast.makeText(LiveRadioActivity.this, "Takes few seconds to load and play after hitting play button", Toast.LENGTH_LONG);
                toast.show();

                String url = "http://49.206.7.1:8000/";
                mediaPlayer = new MediaPlayer();
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                try {
                    mediaPlayer.setDataSource(url);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    mediaPlayer.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                mediaPlayer.start();

            }
        });

        ibPause = (ImageButton)findViewById(R.id.image_button_pause);
        ibPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                }
                else {
                    mediaPlayer.start();
                }
            }
        });

        ibStop = (ImageButton)findViewById(R.id.image_button_stop);
        ibStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                }
            }
        });
    }

    @Override
    public void onBackPressed(){
       finish();
    }
}
