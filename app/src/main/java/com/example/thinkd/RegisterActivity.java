package com.example.thinkd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.thinkd.request.RegisterRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {

    private EditText et_id, et_pw, et_pwcheck, et_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        et_id = findViewById(R.id.et_id_reg);
        et_pw = findViewById(R.id.et_pw_reg);
        et_pwcheck = findViewById(R.id.et_pwcheck);
        et_name = findViewById(R.id.et_name_reg);


        // 회원가입 버튼 클릭 수행
        Button bt_register = findViewById(R.id.bt_register_reg);
        bt_register.setOnClickListener(v -> {
            String userID = et_id.getText().toString();
            String userPassword = et_pw.getText().toString();
            String userPwCheck = et_pwcheck.getText().toString();
            String userName = et_name.getText().toString();

            if (userID.equals("")) ;
            if (userPassword.equals("")) ;
            if (!userPassword.equals(userPwCheck)) ;
            if (userName.equals(""));

            Response.Listener<String> responseListener = response -> {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    boolean success = jsonObject.getBoolean("success");
                    if (success) {
                        Toast.makeText(getApplicationContext(), "회원 등록에 성공했습니다.", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(), "회원 등록에 실패했습니다.", Toast.LENGTH_SHORT).show();
                        return;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            };

            RegisterRequest registerRequest = new RegisterRequest(userID, userPassword, userName, "남", "20", responseListener);
            RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
            queue.add(registerRequest);
        });

        // 취소 버튼 클릭 수행
        Button bt_cancel = findViewById(R.id.bt_cancel_reg);
        bt_cancel.setOnClickListener(v -> finish());
    }
}