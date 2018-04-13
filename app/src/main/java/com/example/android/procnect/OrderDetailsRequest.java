package com.example.android.procnect;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import java.util.HashMap;
import java.util.Map;


class OrderDetailsRequest extends StringRequest{
    private static final String Login_Request_URL = "https://paperhubs.com/Salequery.php";
    private final Map<String, String> params;
    public OrderDetailsRequest(String sale_company_email, Response.Listener<String> listener){
        super(Request.Method.POST, Login_Request_URL, listener, null);
        params = new HashMap<>();
        params.put("email", sale_company_email);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
