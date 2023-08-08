package com.example.thinkd.menu;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.thinkd.R;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CafeKioskActivity extends AppCompatActivity {

    private double totalAmount = 0.0;
    private int count = 0;
    private ThreadPoolExecutor executor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cafe_kiosk);

        // ThreadPoolExecutor 초기화
        executor = new ThreadPoolExecutor(
                5, // Core pool size
                10, // Maximum pool size
                1, // Keep-alive time for idle threads
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>()
        );

        final Button addToCartButton = findViewById(R.id.button6);

        // 임의로 추가한 부분~ (화면 연결을 위함)
        final ImageButton bt_back_kiosk = findViewById(R.id.bt_back_kiosk);
        bt_back_kiosk.setOnClickListener(v -> {
            finish();
        });
        // ~추가한 부분

        final TextView totalTextView = findViewById(R.id.textViewTotalAmount);
        final TextView countTextView = findViewById(R.id.textViewTotalCount);

        final ImageView americanoImageView = findViewById(R.id.imageButton2);
        final ImageView adeImageView = findViewById(R.id.imageButton4);
        final ImageView latteImageView = findViewById(R.id.imageButton3);
        final ImageView icedTeaImageView = findViewById(R.id.imageButton5);

        americanoImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateTotalAndCount(2400.0);
            }
        });

        adeImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateTotalAndCount(3900.0);
            }
        });

        latteImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateTotalAndCount(3100.0);
            }
        });

        icedTeaImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateTotalAndCount(2900.0);
            }
        });

        addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TotalMenuActivity로 전환하는 코드 추가
                Intent intent = new Intent(CafeKioskActivity.this, TotalMenuActivity.class);
                intent.putExtra("totalAmount", totalAmount);
                intent.putExtra("totalCount", count);
                startActivity(intent);
            }
        });

        final Button cancelButton = findViewById(R.id.button5);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 일괄 취소 시 수행할 동작 추가
                totalAmount = 0.0;
                count = 0;

                totalTextView.setText("총 금액: " + totalAmount + " 원");
                countTextView.setText("총 수량: " + count + " 개");
            }
        });
    }

    private void updateTotalAndCount(final double itemPrice) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                totalAmount += itemPrice;
                count++;

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        final TextView totalTextView = findViewById(R.id.textViewTotalAmount);
                        final TextView countTextView = findViewById(R.id.textViewTotalCount);

                        totalTextView.setText("총 금액: " + totalAmount + " 원");
                        countTextView.setText("총 수량: " + count + " 개");
                    }
                });
            }
        });
    }
}
