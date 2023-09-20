package com.example.thinkd.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.thinkd.ARActivity;
import com.example.thinkd.MainActivity;
import com.example.thinkd.R;

public class OrderCompleteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_complete);

        TextView tv_completeToMain = findViewById(R.id.tv_completeToMain);
        tv_completeToMain.setOnClickListener(view -> {
            Intent intent = new Intent(OrderCompleteActivity.this, ARActivity.class);
            startActivity(intent);
            finish();
        });
    }
}