package com.example.thinkd.sign;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.thinkd.HomeActivity;
import com.example.thinkd.R;
import com.example.thinkd.request.LoginRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    private long pressedTime = 0;
    private EditText et_id, et_pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_id = findViewById(R.id.et_id_lgn);
        et_pw = findViewById(R.id.et_pw_lgn);

        Button bt_login = findViewById(R.id.bt_login);
        bt_login.setOnClickListener(v -> {
            String id = et_id.getText().toString();
            String password = et_pw.getText().toString();

            if (id.equals("")) {
                syhDialog(getString(R.string.popup_empty_id), getString(R.string.login_failed));
            } else if (password.equals("")) {
                syhDialog(getString(R.string.popup_empty_pw), getString(R.string.login_failed));
            } else {
                Response.Listener<String> responseListener = response -> {
                    try {
                        Log.d("ServerResponse", response);

                        JSONObject jsonObject = new JSONObject(response);
                        boolean success = jsonObject.getBoolean("success");
                        success = true;
                        if (success) {
                            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(getApplicationContext(), "아이디와 비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                };

                LoginRequest loginRequest = new LoginRequest(id, password, responseListener);
                RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
                queue.add(loginRequest);
                Log.d("queue", "started");
            }
        });

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

    public void syhDialog(String message, String title) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this,
                android.R.style.Theme_DeviceDefault_Light_Dialog);

        dialog.setMessage(message)
                .setTitle(title)
                .setNegativeButton(R.string.ok, (dialog1, which) -> {

                })
                .setCancelable(false)
                .show();
    }
}