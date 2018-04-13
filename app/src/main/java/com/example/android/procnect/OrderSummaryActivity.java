package com.example.android.procnect;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.NetworkError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class OrderSummaryActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private List<OrderQueryList> orderQueryList;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_summary);

        progressBar = findViewById(R.id.progressBar2);
        mRecyclerView = findViewById(R.id.rv_orderlist);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
        orderQueryList = new ArrayList<>();
        progressBar.setVisibility(View.VISIBLE);
        webCall();
        }

    private void webCall() {
        final String buyer_email = SaveSharedPreference.getUserName(OrderSummaryActivity.this);
        final String Order_Query_URL = "https://paperhubs.com/OrderQuery.php?buyer_email="+buyer_email;
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Order_Query_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                progressBar.setVisibility(View.GONE);
                afterWebCall(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (error instanceof NetworkError || error instanceof TimeoutError) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(OrderSummaryActivity.this, R.style.Theme_AppCompat_Light_Dialog);
                    builder.setMessage("Please check your network connection").setNegativeButton("Retry", null).create().show();
                }
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
    }

    private void afterWebCall(JSONArray array) {
        for (int i = 0; i < array.length(); i++) {
            OrderQueryList orderQueryList1 = new OrderQueryList();
            JSONObject jsonObject;
            try {
                jsonObject = array.getJSONObject(i);
                String orderID = jsonObject.getString("order_id");
                if (orderID.equals("0")) {
                    Toast.makeText(this, "No orders exist!", Toast.LENGTH_LONG).show();
                }
                else {
                    orderQueryList1.setorderId(jsonObject.getString("order_id"));
                    orderQueryList1.setsalecompany(jsonObject.getString("sale_company"));
                    orderQueryList1.setbf(jsonObject.getString("bf"));
                    orderQueryList1.setprice(jsonObject.getString("price"));
                    orderQueryList1.setorderstatus(jsonObject.getString("order_status"));
                    orderQueryList1.setbuyeremail(jsonObject.getString("buyer_email"));
                    orderQueryList1.setpaymentterms(jsonObject.getString("payment_terms"));

                    orderQueryList1.setbuttonstatus("false");

                    orderQueryList1.setgsm1(jsonObject.getString("gsm1"));
                    orderQueryList1.setgsm2(jsonObject.getString("gsm2"));
                    orderQueryList1.setgsm3(jsonObject.getString("gsm3"));
                    orderQueryList1.setgsm4(jsonObject.getString("gsm4"));
                    orderQueryList1.setgsm5(jsonObject.getString("gsm5"));
                    orderQueryList1.setgsm6(jsonObject.getString("gsm6"));
                    orderQueryList1.setgsm7(jsonObject.getString("gsm7"));
                    orderQueryList1.setgsm8(jsonObject.getString("gsm8"));
                    orderQueryList1.setgsm9(jsonObject.getString("gsm9"));
                    orderQueryList1.setgsm10(jsonObject.getString("gsm10"));
                    orderQueryList1.setwidth1(jsonObject.getString("width1"));
                    orderQueryList1.setwidth2(jsonObject.getString("width2"));
                    orderQueryList1.setwidth3(jsonObject.getString("width3"));
                    orderQueryList1.setwidth4(jsonObject.getString("width4"));
                    orderQueryList1.setwidth5(jsonObject.getString("width5"));
                    orderQueryList1.setwidth6(jsonObject.getString("width6"));
                    orderQueryList1.setwidth7(jsonObject.getString("width7"));
                    orderQueryList1.setwidth8(jsonObject.getString("width8"));
                    orderQueryList1.setwidth9(jsonObject.getString("width9"));
                    orderQueryList1.setwidth10(jsonObject.getString("width10"));
                    orderQueryList1.setquantity1(jsonObject.getString("reels1"));
                    orderQueryList1.setquantity2(jsonObject.getString("reels2"));
                    orderQueryList1.setquantity3(jsonObject.getString("reels3"));
                    orderQueryList1.setquantity4(jsonObject.getString("reels4"));
                    orderQueryList1.setquantity5(jsonObject.getString("reels5"));
                    orderQueryList1.setquantity6(jsonObject.getString("reels6"));
                    orderQueryList1.setquantity7(jsonObject.getString("reels7"));
                    orderQueryList1.setquantity8(jsonObject.getString("reels8"));
                    orderQueryList1.setquantity9(jsonObject.getString("reels9"));
                    orderQueryList1.setquantity10(jsonObject.getString("reels10"));
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
            orderQueryList.add(orderQueryList1);
        }
        OrderSummaryAdapter orderAdapter= new OrderSummaryAdapter(orderQueryList);
        mRecyclerView.setAdapter(orderAdapter);
    }
}
