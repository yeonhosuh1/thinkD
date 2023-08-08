package com.example.thinkd;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.thinkd.menu.CafeKioskActivity;

import java.util.Map;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button bt_map = findViewById(R.id.buttonMap);
        bt_map.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), CafeKioskActivity.class);
            startActivity(intent);
        });
    }
}