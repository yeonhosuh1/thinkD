package com.example.thinkd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button bt_cancel_reg = findViewById(R.id.bt_cancel_reg);
        bt_cancel_reg.setOnClickListener(v -> finish());
    }
}