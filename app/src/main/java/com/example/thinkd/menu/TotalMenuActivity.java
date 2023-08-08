package com.example.thinkd.menu;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

        TextView totalAmountTextView = findViewById(R.id.textViewTotalAmount);
        TextView totalCountTextView = findViewById(R.id.textViewTotalCount);

        totalAmountTextView.setText("총 금액: " + totalAmount + " 원");
        totalCountTextView.setText("총 수량: " + totalCount + " 개");

        Button backButton = findViewById(R.id.buttonBack);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // 현재 액티비티 종료하여 이전 화면으로 돌아가기
            }
        });
    }
}