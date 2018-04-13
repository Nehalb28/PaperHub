package com.example.android.procnect;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
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

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<EntityList> entityList;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        if (SaveSharedPreference.getLocation(this).length() == 0) {
            Intent queryActivityIntent = new Intent(RecyclerViewActivity.this, QueryEntityActivity.class);
            RecyclerViewActivity.this.startActivity(queryActivityIntent);
            finish();
        } else {
            final BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
            BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
            progressBar = findViewById(R.id.progressBar1);
            mRecyclerView = findViewById(R.id.rv_pmlist);
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            mRecyclerView.setLayoutManager(layoutManager);
            mRecyclerView.setHasFixedSize(true);
            entityList = new ArrayList<>();
            progressBar.setVisibility(View.VISIBLE);
            webCall();

            bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.action_home:
                            Intent recyclerViewIntent = new Intent(RecyclerViewActivity.this, QueryEntityActivity.class);
                            RecyclerViewActivity.this.startActivity(recyclerViewIntent);
                            break;

                        case R.id.action_settings:
                            if (SaveSharedPreference.getVendorType(RecyclerViewActivity.this).equals("Paper Manufacturer") ) {
                                Intent businessSettingsActivityIntent = new Intent(RecyclerViewActivity.this, BusinessSettingsActivity.class);
                                RecyclerViewActivity.this.startActivity(businessSettingsActivityIntent);
                                break;
                            }
                            else{
                                Toast.makeText(RecyclerViewActivity.this, "Settings is not accessible for your account", Toast.LENGTH_LONG).show();
                                break;
                            }
                        case R.id.action_sale_orders:
                            Intent userprofileIntent = new Intent(RecyclerViewActivity.this, SalesOrderSummaryActivity.class);
                            RecyclerViewActivity.this.startActivity(userprofileIntent);
                            break;

                        case R.id.action_purchase_orders:
                            Intent feedbackActivityIntent = new Intent(RecyclerViewActivity.this, OrderSummaryActivity.class);
                            RecyclerViewActivity.this.startActivity(feedbackActivityIntent);
                            break;

                        case R.id.action_more:
                            Intent moreActivityIntent = new Intent(RecyclerViewActivity.this, MoreActivity.class);
                            RecyclerViewActivity.this.startActivity(moreActivityIntent);
                            break;
                    }
                    return true;
                }
            });
        }
    }

    private void webCall() {
        String location = SaveSharedPreference.getLocation(this);
        final String Entity_Query_URL = "https://paperhubs.com/Entityquery.php?location="+location;
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Entity_Query_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                progressBar.setVisibility(View.GONE);
                afterWebCall(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (error instanceof NetworkError || error instanceof TimeoutError) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(RecyclerViewActivity.this, R.style.Theme_AppCompat_Light_Dialog);
                    builder.setMessage("Please check your network connection").setNegativeButton("Retry", null).create().show();
                }
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
    }

    private void afterWebCall(JSONArray array) {
        for (int i = 0; i < array.length(); i++) {
            EntityList entityList1 = new EntityList();
            JSONObject jsonObject;
            try {
                jsonObject = array.getJSONObject(i);
                entityList1.setName(jsonObject.getString("Name"));
                entityList1.setEmail(jsonObject.getString("Email"));
                entityList1.setLocation(jsonObject.getString("Location"));
                entityList1.setPbf14(jsonObject.getString("pbf14"));
                entityList1.setPbf16(jsonObject.getString("pbf16"));
                entityList1.setPbf18(jsonObject.getString("pbf18"));
                entityList1.setPbf20(jsonObject.getString("pbf20"));
                entityList1.setPbf22(jsonObject.getString("pbf22"));
                entityList1.setPbf25(jsonObject.getString("pbf25"));
                entityList1.setPbf28(jsonObject.getString("pbf28"));
                entityList1.setPbf30(jsonObject.getString("pbf30"));
                entityList1.setPbf32(jsonObject.getString("pbf32"));
                entityList1.setPbf35(jsonObject.getString("pbf35"));
                entityList1.setMingsm(jsonObject.getString("mingsm"));
                entityList1.setMaxgsm(jsonObject.getString("maxgsm"));
                entityList1.setInsurance(jsonObject.getString("insurance"));
                entityList1.setPaymentTerms(jsonObject.getString("payment_terms"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            entityList.add(entityList1);
        }

        RecyclerAdapter mAdapter = new RecyclerAdapter(entityList);
        mRecyclerView.setAdapter(mAdapter);
    }

}


