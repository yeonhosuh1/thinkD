package com.example.thinkd;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.thinkd.request.RegisterRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {

    private EditText et_id, et_pw, et_pwcheck, et_name;
    String radioValue = "", spinnerValue = "";
    String[] spinner_items = {"10대","20대","30대","40대","50대","60대+"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        et_id = findViewById(R.id.et_id_reg);
        et_pw = findViewById(R.id.et_pw_reg);
        et_pwcheck = findViewById(R.id.et_pwcheck);
        et_name = findViewById(R.id.et_name_reg);
        RadioGroup radioGroup = findViewById(R.id.group_gender);

        Spinner spinner = findViewById(R.id.spin_age);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, spinner_items);
        arrayAdapter.setDropDownViewResource(R.layout.spinner_text);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinnerValue = spinner_items[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                spinnerValue = "";
            }
        });


        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.rbt_men) {
                radioValue = "men";
            } else if (checkedId == R.id.rbt_women) {
                radioValue = "women";
            }
        });


        // 회원가입 버튼 클릭 수행
        Button bt_register = findViewById(R.id.bt_register_reg);
        bt_register.setOnClickListener(v -> {
            String id = et_id.getText().toString();
            String password = et_pw.getText().toString();
            String userPwCheck = et_pwcheck.getText().toString();
            String name = et_name.getText().toString();

            if (id.equals("")) {
                syhDialog(getString(R.string.popup_empty_id), getString(R.string.register_failed));
            } else if (password.equals("")) {
                syhDialog(getString(R.string.popup_empty_pw), getString(R.string.register_failed));
            } else if (!password.equals(userPwCheck)) {
                syhDialog(getString(R.string.popup_diff_pwcheck), getString(R.string.register_failed));
            } else if (name.equals("")) {
                syhDialog(getString(R.string.popup_empty_name), getString(R.string.register_failed));
            } else if (radioValue.equals("")) {
                syhDialog(getString(R.string.popup_empty_gender), getString(R.string.register_failed));
            } else if (spinnerValue.equals("")) {
                syhDialog(getString(R.string.popup_empty_age), getString(R.string.register_failed));
            } else {
                Response.Listener<String> responseListener = response -> {
                    try {
                        JSONObject jsonObject = new JSONObject(response);
                        boolean success = jsonObject.getBoolean("success");
                        if (success) {
                            Toast.makeText(getApplicationContext(), "회원 등록에 성공했습니다.", Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            Toast.makeText(getApplicationContext(), "회원 등록에 실패했습니다.", Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                };

                RegisterRequest registerRequest = new RegisterRequest(id, password, name, radioValue, spinnerValue, responseListener);
                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                queue.add(registerRequest);
            }
        });

        // 취소 버튼 클릭 수행
        Button bt_cancel = findViewById(R.id.bt_cancel_reg);
        bt_cancel.setOnClickListener(v -> finish());
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