package com.example.android.procnect;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class BusinessSettingsActivityNext extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_settings_next);

        final Button b_Submit = findViewById(R.id.bSubmit);

        b_Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkValidation();
            }
        });
    }

    private void checkValidation() {

        final Spinner sp_MinGsm = findViewById(R.id.sp_mingsm);
        final Spinner sp_MaxGsm = findViewById(R.id.sp_maxgsm);
        final EditText et_Insurance = findViewById(R.id.et_insurance);
        final Spinner sp_payment_terms = findViewById(R.id.sp_payment_terms);

        if (SaveSharedPreference.getUserName(BusinessSettingsActivityNext.this).isEmpty())
        {Toast.makeText(getApplicationContext(), "Please re-login and update price.", Toast.LENGTH_LONG).show();}

        else if (sp_MinGsm.getSelectedItem().toString().equals("0") || sp_MaxGsm.getSelectedItem().toString().equals("0"))
        {
            Toast.makeText(this, "Please select GSM values", Toast.LENGTH_LONG).show();
        }

        else if (et_Insurance.getText().toString().equals("") || et_Insurance.getText().length() == 0 ){
            Toast.makeText(this, "Please enter insurance (%) value if applicable else enter 0", Toast.LENGTH_LONG).show();
        }

        else {
            final ProgressDialog progressDialog = new ProgressDialog(BusinessSettingsActivityNext.this, R.style.Theme_AppCompat_Light_Dialog);
            progressDialog.setIndeterminate(true);
            progressDialog.setMessage("Updating Prices...");
            Intent businessSettingIntent = getIntent();
            final String email = SaveSharedPreference.getUserName(BusinessSettingsActivityNext.this);
            final String mingsm = sp_MinGsm.getSelectedItem().toString();
            final String maxgsm = sp_MaxGsm.getSelectedItem().toString();
            final String insurance = et_Insurance.getText().toString();
            final String payment_terms = sp_payment_terms.getSelectedItem().toString();
            final String st_14 = businessSettingIntent.getStringExtra("st_14");
            final String st_16 = businessSettingIntent.getStringExtra("st_16");
            final String st_18 = businessSettingIntent.getStringExtra("st_18");
            final String st_20 = businessSettingIntent.getStringExtra("st_20");
            final String st_22 = businessSettingIntent.getStringExtra("st_22");
            final String st_25 = businessSettingIntent.getStringExtra("st_25");
            final String st_28 = businessSettingIntent.getStringExtra("st_28");
            final String st_30 = businessSettingIntent.getStringExtra("st_30");
            final String st_32 = businessSettingIntent.getStringExtra("st_32");
            final String st_35 = businessSettingIntent.getStringExtra("st_35");
            progressDialog.show();
            Response.Listener<String> responseListener = new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try
                    {
                        JSONObject jsonResponse = new JSONObject(response);
                        boolean success = jsonResponse.getBoolean("success");
                        if (success) {
                            progressDialog.dismiss();
                            Toast.makeText(getApplicationContext(), "Price Update Succesful.", Toast.LENGTH_LONG).show();
                            Intent queryEntityIntent = new Intent(BusinessSettingsActivityNext.this, QueryEntityActivity.class);
                            startActivity(queryEntityIntent);
                            finish();
                        }
                        else
                        {
                            progressDialog.dismiss();
                            AlertDialog.Builder builder = new AlertDialog.Builder(BusinessSettingsActivityNext.this);
                            builder.setMessage("Price Update Failed.").setNegativeButton("Retry", null).create().show();
                        }
                    }
                    catch (JSONException e) {
                        progressDialog.dismiss();
                        AlertDialog.Builder builder = new AlertDialog.Builder(BusinessSettingsActivityNext.this, R.style.Theme_AppCompat_Light_Dialog);
                        builder.setMessage("Price Update Failed. JSON Response Error").setNegativeButton("Retry", null).create().show();
                        e.printStackTrace();
                    }
                }
            };
            PriceUpdateRequest priceUpdateRequest = new PriceUpdateRequest(email, mingsm, maxgsm, st_14, st_16, st_18, st_20, st_22, st_25,
                    st_28, st_30, st_32, st_35, insurance, payment_terms, responseListener);
            RequestQueue requestQueue = Volley.newRequestQueue(BusinessSettingsActivityNext.this);
            requestQueue.add(priceUpdateRequest);
        }
    }
}
