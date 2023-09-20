package com.example.thinkd.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.thinkd.R;

public class PayInformActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_inform);

        VideoView videoView = findViewById(R.id.vv_orderinform2);

        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.informvideo2;

        videoView.setVideoURI(Uri.parse(videoPath));

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

        videoView.setOnCompletionListener(mp -> {
            Intent intent = new Intent(PayInformActivity.this, TotalMenuActivity.class);
            startActivity(intent);
            finish();
        });

        videoView.start();

        TextView textview = findViewById(R.id.tv_skip);

        textview.setOnClickListener(view -> {
            Intent intent = new Intent(PayInformActivity.this, TotalMenuActivity.class);
            startActivity(intent);
            finish();
        });
    }
}