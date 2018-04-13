package com.example.android.procnect;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

class PriceUpdateRequest extends StringRequest {

    private static final String Register_Request_URL = "https://paperhubs.com/PriceUpdate.php";
    private final Map<String, String> params;
    public PriceUpdateRequest(String email, String mingsm, String maxgsm, String st_14, String st_16, String st_18, String st_20, String st_22,
                              String st_25, String st_28, String st_30, String st_32, String st_35, String insurance, String payment_terms, Response.Listener<String> listener)
    {
        super(Method.POST, Register_Request_URL, listener, null);
        params = new HashMap<>();
        params.put("email", email);
        params.put("mingsm", mingsm);
        params.put("maxgsm", maxgsm);
        params.put("st_14", st_14);
        params.put("st_16", st_16);
        params.put("st_18", st_18);
        params.put("st_20", st_20);
        params.put("st_22", st_22);
        params.put("st_25", st_25);
        params.put("st_28", st_28);
        params.put("st_30", st_30);
        params.put("st_32", st_32);
        params.put("st_35", st_35);
        params.put("insurance", insurance);
        params.put("payment_terms", payment_terms);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
