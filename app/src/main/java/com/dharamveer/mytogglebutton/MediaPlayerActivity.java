package com.dharamveer.mytogglebutton;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;

import com.dharamveer.mytogglebutton.databinding.ActivityMediaPlayerBinding;

public class MediaPlayerActivity extends AppCompatActivity {

    MediaPlayer mp;
    private ActivityMediaPlayerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMediaPlayerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        try {
            mp = MediaPlayer.create(this, R.raw.shriram_ashtakam);
            mp.setScreenOnWhilePlaying(true);
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        binding.fab.setOnClickListener(v -> {
            if (mp.isPlaying()) {
                pause();
            } else {
                play();
            }
        });


    }

    private void play() {
        binding.fab.setImageDrawable(getDrawable(android.R.drawable.ic_media_pause));
        mp.start();
    }

    private void pause() {
        binding.fab.setImageDrawable(getDrawable(android.R.drawable.ic_media_play));
        mp.pause();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mp.isPlaying()) {
            pause();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mp.getCurrentPosition() != 0) {
            play();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mp.isPlaying()) {
            mp.stop();
        }
        mp.reset();
        mp.release();
        mp = null;
    }
}