package com.example.thinkd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class ARActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aractivity);

        VideoView videoView = findViewById(R.id.videoView);

        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.arvideo;

        videoView.setVideoURI(Uri.parse(videoPath));

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

        videoView.setOnCompletionListener(mp -> {
            Intent intent = new Intent(ARActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        });

        videoView.start();
    }
}