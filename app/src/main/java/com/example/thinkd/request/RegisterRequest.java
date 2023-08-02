package com.example.thinkd.request;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {

    final static private String URL = "http://ec2-18-190-48-55.us-east-2.compute.amazonaws.com/Register.php";
    private Map<String, String> map;

    public RegisterRequest(String userID, String userPassword, String userName, String userGender, String userAge, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("userID", userID);
        map.put("userPassword", userPassword);
        map.put("userName", userName);
        map.put("userGender", userGender);
        map.put("userAge", userAge);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}
