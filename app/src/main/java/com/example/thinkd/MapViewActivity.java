package com.example.thinkd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.thinkd.menu.CafeKioskActivity;

public class MapViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_view);

        VideoView videoView = findViewById(R.id.vv_map);

        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.mapvideo;

        videoView.setVideoURI(Uri.parse(videoPath));

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

        videoView.setOnCompletionListener(mp -> {
            Intent intent = new Intent(MapViewActivity.this, CafeKioskActivity.class);
            startActivity(intent);
            finish();
        });

        videoView.start();
    }
}