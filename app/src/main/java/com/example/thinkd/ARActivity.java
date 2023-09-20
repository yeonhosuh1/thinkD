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

        // 비디오 파일의 경로를 설정합니다.
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.arvideo; // "your_video"를 실제 파일 이름으로 변경합니다.

        // VideoView에 비디오 파일을 설정합니다.
        videoView.setVideoURI(Uri.parse(videoPath));

        // MediaController를 설정하여 비디오 재생 컨트롤러를 활성화합니다.
        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

        // 비디오 재생이 완료되면 다른 화면으로 이동합니다.
        videoView.setOnCompletionListener(mp -> {
            // 다른 화면으로 이동하는 코드를 여기에 추가합니다.
            // 예를 들어, 다른 액티비티를 시작하는 Intent를 사용할 수 있습니다.
            Intent intent = new Intent(ARActivity.this, HomeActivity.class);
            startActivity(intent);

            // 현재 액티비티를 종료할 수도 있습니다.
            finish();
        });

        // 비디오를 시작합니다.
        videoView.start();
    }
}