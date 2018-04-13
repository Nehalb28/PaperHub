package com.example.android.procnect;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

class VerifyEmailRequest extends StringRequest {
    private static final String Login_Request_URL = "https://paperhubs.com/EmailVerify.php";
    private final Map<String, String> params;
    public VerifyEmailRequest(String email, String ques1, String ques2, Response.Listener<String> listener){
        super(Request.Method.POST, Login_Request_URL, listener, null);
        params = new HashMap<>();
        params.put("email", email);
        params.put("ques1", ques1);
        params.put("ques2", ques2);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}

