package com.example.android.procnect;


import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import java.util.HashMap;
import java.util.Map;

class FinalizeOrderRequest extends StringRequest {

    private static final String Order_Request_URL = "https://paperhubs.com/Orders.php";
    private final Map<String, String> params;
    public FinalizeOrderRequest(String sale_company, String bf, String price, String buyer_email, String seller_email, String order_status,
                                String insurance, String payment_terms, String gsm1, String width1, String reels1, String gsm2, String width2, String reels2,
                                String gsm3, String width3, String reels3, String gsm4, String width4, String reels4, String gsm5, String width5, String reels5,
                                String gsm6, String width6, String reels6, String gsm7, String width7, String reels7, String gsm8, String width8, String reels8,
                                String gsm9, String width9, String reels9, String gsm10, String width10, String reels10, Response.Listener<String> listener){
        super(Method.POST, Order_Request_URL, listener, null);
        params = new HashMap<>();
        params.put("sale_company", sale_company);
        params.put("bf", bf);
        params.put("price", price);
        params.put("buyer_email", buyer_email);
        params.put("seller_email", seller_email);
        params.put("order_status", order_status);
        params.put("insurance", insurance);
        params.put("payment_terms", payment_terms);
        params.put("gsm1", gsm1);
        params.put("width1", width1);
        params.put("reels1", reels1);
        params.put("gsm2", gsm2);
        params.put("width2", width2);
        params.put("reels2", reels2);
        params.put("gsm3", gsm3);
        params.put("width3", width3);
        params.put("reels3", reels3);
        params.put("gsm4", gsm4);
        params.put("width4", width4);
        params.put("reels4", reels4);
        params.put("gsm5", gsm5);
        params.put("width5", width5);
        params.put("reels5", reels5);
        params.put("gsm6", gsm6);
        params.put("width6", width6);
        params.put("reels6", reels6);
        params.put("gsm7", gsm7);
        params.put("width7", width7);
        params.put("reels7", reels7);
        params.put("gsm8", gsm8);
        params.put("width8", width8);
        params.put("reels8", reels8);
        params.put("gsm9", gsm9);
        params.put("width9", width9);
        params.put("reels9", reels9);
        params.put("gsm10", gsm10);
        params.put("width10", width10);
        params.put("reels10", reels10);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
