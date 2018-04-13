package com.example.android.procnect;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.android.volley.NetworkError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;

public class ProfileActivity extends AppCompatActivity {

    TextView tvName, tvEmail, tvPhone, tvCity, tvGSTN, tvVendorType, tvBankName,
            tvBankAccount, tvBankIfsc;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        tvName = findViewById(R.id.tv_name);
        tvEmail = findViewById(R.id.tv_email);
        tvPhone = findViewById(R.id.tv_phone);
        tvCity = findViewById(R.id.tv_location);
        tvGSTN = findViewById(R.id.tv_gstin);
        tvVendorType = findViewById(R.id.tv_vendortype);
        tvBankName = findViewById(R.id.tv_bankname);
        tvBankAccount = findViewById(R.id.tv_bank_account);
        tvBankIfsc = findViewById(R.id.tv_bank_ifsc);

        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);

        final Button b_bankdetails = findViewById(R.id.button_update);

        getData();
        getBankData();

        b_bankdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bankUpdateIntent = new Intent(ProfileActivity.this, BankUpdateActivity.class);
                startActivity(bankUpdateIntent);
            }
        });
    }

    private void getData(){
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");
                    if (success) {
                        progressBar.setVisibility(View.GONE);
                        tvName.setText(jsonResponse.getString("name"));
                        tvGSTN.setText(jsonResponse.getString("gstin"));
                        tvPhone.setText(jsonResponse.getString("phone"));
                        tvCity.setText(jsonResponse.getString("location"));
                        tvVendorType.setText(jsonResponse.getString("vendortype"));
                        tvEmail.setText(SaveSharedPreference.getUserName(ProfileActivity.this));
                    } else {
                        progressBar.setVisibility(View.GONE);
                        final AlertDialog.Builder builder = new AlertDialog.Builder(ProfileActivity.this, R.style.Theme_AppCompat_Light_Dialog);
                        builder.setMessage("Error in fetching your profile").setNegativeButton("Retry", null).create().show();
                    }
                } catch (JSONException e) {
                    progressBar.setVisibility(View.GONE);
                    final AlertDialog.Builder builder = new AlertDialog.Builder(ProfileActivity.this, R.style.Theme_AppCompat_Light_Dialog);
                    builder.setMessage("Error. JSON Exception").setNegativeButton("Retry", null).create().show();
                    e.printStackTrace();
                }
            }
        };
        new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (error instanceof NetworkError || error instanceof TimeoutError) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(ProfileActivity.this);
                    builder.setMessage("Please check your network connection").setNegativeButton("Retry", null).create().show();
                }
            }
        };
        final String email = SaveSharedPreference.getUserName(this);
        ProfileRequest profileRequest = new ProfileRequest(email, responseListener);
        RequestQueue requestQueue = Volley.newRequestQueue(ProfileActivity.this);
        requestQueue.getCache().clear();
        requestQueue.add(profileRequest);
    }

    private void getBankData(){
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");
                    if (success) {
                        final String bankName = jsonResponse.getString("bank_name");
                        final String bankAccount = jsonResponse.getString("bank_account");
                        final String bankIfsc = jsonResponse.getString("bank_ifsc");
                        if (TextUtils.equals(bankName, "null") || TextUtils.equals(bankAccount, "null")
                                || TextUtils.equals(bankIfsc, "null")) {
                            tvBankName.setText(R.string.text_bankname);
                            tvBankAccount.setText(R.string.text_bank_account_number);
                            tvBankIfsc.setText(R.string.text_bank_ifsc);
                        } else {
                            tvBankName.setText(bankName);
                            tvBankAccount.setText(bankAccount);
                            tvBankIfsc.setText(bankIfsc);
                        }
                    } else {
                        final AlertDialog.Builder builder = new AlertDialog.Builder(ProfileActivity.this, R.style.Theme_AppCompat_Light_Dialog);
                        builder.setMessage("Error in fetching your profile").setNegativeButton("Retry", null).create().show();
                    }
                } catch (JSONException e) {
                    final AlertDialog.Builder builder = new AlertDialog.Builder(ProfileActivity.this, R.style.Theme_AppCompat_Light_Dialog);
                    builder.setMessage("Error. JSON Exception").setNegativeButton("Retry", null).create().show();
                    e.printStackTrace();
                }
            }
        };
        new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (error instanceof NetworkError || error instanceof TimeoutError) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(ProfileActivity.this);
                    builder.setMessage("Please check your network connection").setNegativeButton("Retry", null).create().show();
                }
            }
        };
        final String email = SaveSharedPreference.getUserName(this);
        ProfileBankDetailsRequest profileBankDetailsRequest= new ProfileBankDetailsRequest(email, responseListener);
        RequestQueue requestQueue = Volley.newRequestQueue(ProfileActivity.this);
        requestQueue.getCache().clear();
        requestQueue.add(profileBankDetailsRequest);
    }
}
