package com.example.thinkd;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.thinkd.menu.OrderInformActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button bt_map = findViewById(R.id.buttonMap);
        bt_map.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), MapViewActivity.class);
            startActivity(intent);
        });

        Button bt_kiosk = findViewById(R.id.bt_kiosk);
        bt_kiosk.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), OrderInformActivity.class);
            startActivity(intent);
        });
    }
}