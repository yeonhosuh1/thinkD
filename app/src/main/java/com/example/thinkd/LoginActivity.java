package com.example.thinkd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private long pressedTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button bt_register = findViewById(R.id.bt_register);
        bt_register.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
            startActivity(intent);
        });
    }

    public void onBackPressed() {
        long seconds = System.currentTimeMillis() - pressedTime;
        long FINISH_TIME = 3000;

        if (seconds > FINISH_TIME) {
            Toast.makeText(getApplicationContext(), " 한 번 더 누르면 종료됩니다." , Toast.LENGTH_SHORT).show();
            pressedTime = System.currentTimeMillis();
        }
        else {
            super.onBackPressed();
        }
    }
}