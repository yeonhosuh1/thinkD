package com.example.thinkd.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.thinkd.R;

public class OrderInformActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_infrom);

        VideoView videoView = findViewById(R.id.vv_orderinform1);

        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.informvideo1;

        videoView.setVideoURI(Uri.parse(videoPath));

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

        videoView.setOnCompletionListener(mp -> {
            Intent intent = new Intent(OrderInformActivity.this, CafeKioskActivity.class);
            startActivity(intent);
            finish();
        });

        videoView.start();

        TextView textview = findViewById(R.id.skipButton);

        textview.setOnClickListener(view -> {
            Intent intent = new Intent(OrderInformActivity.this, CafeKioskActivity.class);
            startActivity(intent);
            finish();
        });
    }
}