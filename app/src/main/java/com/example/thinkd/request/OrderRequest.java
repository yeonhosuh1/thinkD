package com.example.thinkd.request;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;

public class OrderRequest extends StringRequest {

    final static private String URL = "http://ec2-18-190-48-55.us-east-2.compute.amazonaws.com/Order.php";
    private final Map<String, String> map;

    public OrderRequest(String uid, int price, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        LocalDate order_date = LocalDate.now();
        LocalTime order_time = LocalTime.now();

        map = new HashMap<>();
        map.put("uid", uid);
        map.put("price", String.valueOf(price));
        map.put("date", String.valueOf(order_date));
        map.put("time", String.valueOf(order_time));
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}