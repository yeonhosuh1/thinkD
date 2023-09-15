package com.example.thinkd.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.thinkd.R;

public class TotalMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total_menu);

        Intent intent = getIntent();
        double totalAmount = intent.getDoubleExtra("totalAmount", 0.0);
        int totalCount = intent.getIntExtra("totalCount", 0);

        ImageView closeButton = findViewById(R.id.closeButton);
        closeButton.setOnClickListener(view -> {
            finish();
        });


        Button bt_usePoint = findViewById(R.id.bt_pointUse);
        TextView tvPoint = findViewById(R.id.tv_point);
        TextView tvTotalPrice = findViewById(R.id.tv_totalPrice);
        TextView tvUsedPoint = findViewById(R.id.tv_usedPoint);
        bt_usePoint.setOnClickListener(view -> {
            tvPoint.setText("10000원");
            tvTotalPrice.setText("5000원");
            tvUsedPoint.setText("-10000원");
        });

        TextView tv_orderBtn = findViewById(R.id.tv_orderBtn);
        tv_orderBtn.setOnClickListener(v -> {
            Intent intent1 = new Intent(TotalMenuActivity.this, OrderCompleteActivity.class);
            startActivity(intent1);
        });
    }
}