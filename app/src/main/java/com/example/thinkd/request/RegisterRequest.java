package com.example.thinkd.request;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {

    final static private String URL = "http://ec2-18-190-48-55.us-east-2.compute.amazonaws.com/Register.php";
    private Map<String, String> map;

    public RegisterRequest(String id, String password, String name, String userGender, String age, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("id", id);
        map.put("password", password);
        map.put("name", name);
        map.put("userGender", userGender);
        map.put("age", age);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}
