package com.example.android.procnect;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

class LoginRequest extends StringRequest {
    private static final String Login_Request_URL = "https://paperhubs.com/Login.php";
    private final Map<String, String> params;
    public LoginRequest(String email, String password, Response.Listener<String> listener){
        super(Request.Method.POST, Login_Request_URL, listener, null);
        params = new HashMap<>();
        params.put("email", email);
        params.put("password", password);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
