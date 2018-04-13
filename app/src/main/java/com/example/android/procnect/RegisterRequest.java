package com.example.android.procnect;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

class RegisterRequest extends StringRequest {

    private static final String Register_Request_URL = "https://paperhubs.com/Register2.php";
    private final Map<String, String> params;
    public RegisterRequest(String name, String gstin, String phone, String location, String vendortype, String email, String password, String ques1, String ques2, String address, Response.Listener<String> listener){
        super(Method.POST, Register_Request_URL, listener, null);
        params = new HashMap<>();
        params.put("name", name);
        params.put("gstin", gstin);
        params.put("phone", phone);
        params.put("location", location);
        params.put("vendortype", vendortype);
        params.put("email", email);
        params.put("password", password);
        params.put("ques1", ques1);
        params.put("ques2", ques2);
        params.put("address", address);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
