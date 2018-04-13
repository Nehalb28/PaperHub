package com.example.android.procnect;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;


class BankUpdateRequest extends StringRequest {

    private static final String Register_Request_URL = "https://paperhubs.com/BankUpdate.php";
    private final Map<String, String> params;
    public BankUpdateRequest(String email, String bank_name, String bank_account, String bank_ifsc, String bank_account_name, Response.Listener<String> listener)
    {
        super(Method.POST, Register_Request_URL, listener, null);
        params = new HashMap<>();
        params.put("email", email);
        params.put("bank_name", bank_name);
        params.put("bank_account", bank_account);
        params.put("bank_ifsc", bank_ifsc);
        params.put("bank_account_name", bank_account_name);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
