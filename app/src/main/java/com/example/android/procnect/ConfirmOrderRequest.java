package com.example.android.procnect;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

class ConfirmOrderRequest extends StringRequest{
    private static final String Register_Request_URL = "https://paperhubs.com/ConfirmOrder.php";
    private final Map<String, String> params;
    public ConfirmOrderRequest(String order_status, String order_id, String freight, String delivery_days, Response.Listener<String> listener){
        super(Request.Method.POST, Register_Request_URL, listener, null);
        params = new HashMap<>();
        params.put("order_status", order_status);
        params.put("order_id", order_id);
        params.put("freight", freight);
        params.put("delivery_days", delivery_days);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
