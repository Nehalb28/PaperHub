package com.example.android.procnect;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.NetworkError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class BankUpdateActivity extends AppCompatActivity {

    private Spinner sp_BankName;
    private EditText et_BankAccountName;
    private EditText et_BankAccount;
    private EditText et_BankIfsc;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_update);

        sp_BankName = findViewById(R.id.sp_bankname_list);
        et_BankAccountName = findViewById(R.id.et_bank_account_name);
        et_BankAccount = findViewById(R.id.et_bank_account_number);
        et_BankIfsc = findViewById(R.id.et_bank_ifsc);
        final Button button_submit = findViewById(R.id.button_update);
        progressBar = findViewById(R.id.progressBar);

        button_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                checkValidation();
            }
        });
    }
        private void checkValidation(){

            if (sp_BankName.getSelectedItem().toString().equals("Select Bank")){
                progressBar.setVisibility(View.VISIBLE);
                Toast.makeText(BankUpdateActivity.this, "Please select bank name", Toast.LENGTH_LONG).show();
            }
            else if (et_BankAccountName.getText().toString().equals("") || et_BankAccountName.getText().toString().length() == 0 ){
                progressBar.setVisibility(View.VISIBLE);
                Toast.makeText(BankUpdateActivity.this, "Please enter bank account name", Toast.LENGTH_LONG).show();
            }
            else if (et_BankAccount.getText().toString().equals("") || et_BankAccount.getText().toString().length() == 0 ){
                progressBar.setVisibility(View.VISIBLE);
                Toast.makeText(BankUpdateActivity.this, "Please enter bank account number", Toast.LENGTH_LONG).show();
            }
            else if (et_BankIfsc.getText().toString().equals("") || et_BankIfsc.getText().toString().length() == 0 ){
                progressBar.setVisibility(View.VISIBLE);
                Toast.makeText(BankUpdateActivity.this, "Please enter bank IFS Code", Toast.LENGTH_LONG).show();
            }
            else {
                final String bank_name = sp_BankName.getSelectedItem().toString();
                final String bank_account_name = et_BankAccountName.getText().toString();
                final String bank_account = et_BankAccount.getText().toString();
                final String bank_ifsc = et_BankIfsc.getText().toString();
                final String email = SaveSharedPreference.getUserName(this);
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success) {
                                progressBar.setVisibility(View.GONE);
                                Toast.makeText(BankUpdateActivity.this, "Bank details updated successfully.", Toast.LENGTH_LONG).show();
                                Intent userProfileIntent = new Intent(BankUpdateActivity.this, ProfileActivity.class);
                                startActivity(userProfileIntent);
                            } else {
                                final AlertDialog.Builder builder = new AlertDialog.Builder(BankUpdateActivity.this, R.style.Theme_AppCompat_Light_Dialog);
                                builder.setMessage("Error in updating bank details").setNegativeButton("Retry", null).create().show();
                            }
                        } catch (JSONException e) {
                            final AlertDialog.Builder builder = new AlertDialog.Builder(BankUpdateActivity.this, R.style.Theme_AppCompat_Light_Dialog);
                            builder.setMessage("Error. JSON Exception").setNegativeButton("Cancel", null).create().show();
                            e.printStackTrace();
                        }
                    }
                };
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        if (error instanceof NetworkError || error instanceof TimeoutError) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(BankUpdateActivity.this);
                            builder.setMessage("Please check your network connection").setNegativeButton("Retry", null).create().show();
                        }
                    }
                };

                BankUpdateRequest bankUpdateRequest = new BankUpdateRequest(email, bank_name, bank_account, bank_ifsc, bank_account_name, responseListener);
                RequestQueue requestQueue = Volley.newRequestQueue(BankUpdateActivity.this);
                requestQueue.add(bankUpdateRequest);
            }
    }
}
