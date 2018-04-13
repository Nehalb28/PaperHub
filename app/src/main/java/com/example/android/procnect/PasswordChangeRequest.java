package com.example.android.procnect;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

class PasswordChangeRequest extends StringRequest {

    private static final String Login_Request_URL = "https://paperhubs.com/PasswordChange.php";
    private final Map<String, String> params;
    public PasswordChangeRequest(String passowrd, String email, Response.Listener<String> listener){
        super(Request.Method.POST, Login_Request_URL, listener, null);
        params = new HashMap<>();
        params.put("password", passowrd);
        params.put("email", email);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
