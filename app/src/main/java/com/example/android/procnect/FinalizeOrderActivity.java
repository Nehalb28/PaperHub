package com.example.android.procnect;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
//import android.os.Environment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class FinalizeOrderActivity extends AppCompatActivity {

    private String sale_company, buyer_company;
    private String sale_company_email, buyer_company_email;
    private String bf;
    private String gsm1, gsm2, gsm3, gsm4, gsm5, gsm6, gsm7, gsm8, gsm9, gsm10;
    private String width1, width2, width3, width4, width5, width6, width7, width8, width9, width10;
    private String quantity1, quantity2, quantity3, quantity4, quantity5, quantity6, quantity7, quantity8, quantity9, quantity10;
    private String price;
    private String insurance;
    private String payment_terms;
    private String gstin;
    private String address;
    private String bankName, bankAccount, bankIfsc, bankAccountName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalize_order);

        final TextView tv_listitemname = findViewById(R.id.tv_listitemname);
        final TextView tv_payment_terms = findViewById(R.id.tv_payment_terms);
        final TextView tv_bf = findViewById(R.id.tv_bf);
        final TextView tv_price = findViewById(R.id.tv_pbf);

        final TextView tv_gsm1 = findViewById(R.id.tv_gsm_in1);
        final TextView tv_gsm2 = findViewById(R.id.tv_gsm_in2);
        final TextView tv_gsm3 = findViewById(R.id.tv_gsm_in3);
        final TextView tv_gsm4 = findViewById(R.id.tv_gsm_in4);
        final TextView tv_gsm5 = findViewById(R.id.tv_gsm_in5);
        final TextView tv_gsm6 = findViewById(R.id.tv_gsm_in6);
        final TextView tv_gsm7 = findViewById(R.id.tv_gsm_in7);
        final TextView tv_gsm8 = findViewById(R.id.tv_gsm_in8);
        final TextView tv_gsm9 = findViewById(R.id.tv_gsm_in9);
        final TextView tv_gsm10 = findViewById(R.id.tv_gsm_in10);

        final TextView tv_width1 = findViewById(R.id.tv_width1);
        final TextView tv_width2 = findViewById(R.id.tv_width2);
        final TextView tv_width3 = findViewById(R.id.tv_width3);
        final TextView tv_width4 = findViewById(R.id.tv_width4);
        final TextView tv_width5 = findViewById(R.id.tv_width5);
        final TextView tv_width6 = findViewById(R.id.tv_width6);
        final TextView tv_width7 = findViewById(R.id.tv_width7);
        final TextView tv_width8 = findViewById(R.id.tv_width8);
        final TextView tv_width9 = findViewById(R.id.tv_width9);
        final TextView tv_width10 = findViewById(R.id.tv_width10);

        final TextView tv_quantity1 = findViewById(R.id.tv_quantity1);
        final TextView tv_quantity2 = findViewById(R.id.tv_quantity2);
        final TextView tv_quantity3 = findViewById(R.id.tv_quantity3);
        final TextView tv_quantity4 = findViewById(R.id.tv_quantity4);
        final TextView tv_quantity5 = findViewById(R.id.tv_quantity5);
        final TextView tv_quantity6 = findViewById(R.id.tv_quantity6);
        final TextView tv_quantity7 = findViewById(R.id.tv_quantity7);
        final TextView tv_quantity8 = findViewById(R.id.tv_quantity8);
        final TextView tv_quantity9 = findViewById(R.id.tv_quantity9);
        final TextView tv_quantity10 = findViewById(R.id.tv_quantity10);

        final Button b_Submit = findViewById(R.id.button_submit);

        buyer_company_email= SaveSharedPreference.getUserName(FinalizeOrderActivity.this);

        getIntentDetails();
        getOrderDetails();
        getBankDetails();

        tv_listitemname.setText(sale_company);
        tv_bf.setText(bf);

        tv_gsm1.setText(gsm1);
        tv_gsm2.setText(gsm2);
        tv_gsm3.setText(gsm3);
        tv_gsm4.setText(gsm4);
        tv_gsm5.setText(gsm5);
        tv_gsm6.setText(gsm6);
        tv_gsm7.setText(gsm7);
        tv_gsm8.setText(gsm8);
        tv_gsm9.setText(gsm9);
        tv_gsm10.setText(gsm10);

        tv_width1.setText(width1);
        tv_width2.setText(width2);
        tv_width3.setText(width3);
        tv_width4.setText(width4);
        tv_width5.setText(width5);
        tv_width6.setText(width6);
        tv_width7.setText(width7);
        tv_width8.setText(width8);
        tv_width9.setText(width9);
        tv_width10.setText(width10);

        tv_quantity1.setText(quantity1);
        tv_quantity2.setText(quantity2);
        tv_quantity3.setText(quantity3);
        tv_quantity4.setText(quantity4);
        tv_quantity5.setText(quantity5);
        tv_quantity6.setText(quantity6);
        tv_quantity7.setText(quantity7);
        tv_quantity8.setText(quantity8);
        tv_quantity9.setText(quantity9);
        tv_quantity10.setText(quantity10);

        tv_price.setText(price);
        tv_payment_terms.setText(payment_terms);

        if (quantity2.equals("") || TextUtils.equals(quantity1, "null")){
            tv_gsm2.setVisibility(View.INVISIBLE);
            tv_width2.setVisibility(View.INVISIBLE);
            tv_quantity2.setVisibility(View.INVISIBLE);
        }
        if (quantity3.equals("") || TextUtils.equals(quantity3, "null")){
            tv_gsm3.setVisibility(View.INVISIBLE);
            tv_width3.setVisibility(View.INVISIBLE);
            tv_quantity3.setVisibility(View.INVISIBLE);
        }
        if (quantity4.equals("") || TextUtils.equals(quantity4, "null")){
            tv_gsm4.setVisibility(View.INVISIBLE);
            tv_width4.setVisibility(View.INVISIBLE);
            tv_quantity4.setVisibility(View.INVISIBLE);
        }
        if (quantity5.equals("") || TextUtils.equals(quantity5, "null")){
            tv_gsm5.setVisibility(View.INVISIBLE);
            tv_width5.setVisibility(View.INVISIBLE);
            tv_quantity5.setVisibility(View.INVISIBLE);
        }
        if (quantity6.equals("") || TextUtils.equals(quantity6, "null")){
            tv_gsm6.setVisibility(View.INVISIBLE);
            tv_width6.setVisibility(View.INVISIBLE);
            tv_quantity6.setVisibility(View.INVISIBLE);
        }
        if (quantity7.equals("") || TextUtils.equals(quantity7, "null")){
            tv_gsm7.setVisibility(View.INVISIBLE);
            tv_width7.setVisibility(View.INVISIBLE);
            tv_quantity7.setVisibility(View.INVISIBLE);
        }
        if (quantity8.equals("") || TextUtils.equals(quantity8, "null")){
            tv_gsm8.setVisibility(View.INVISIBLE);
            tv_width8.setVisibility(View.INVISIBLE);
            tv_quantity8.setVisibility(View.INVISIBLE);
        }
        if (quantity9.equals("") || TextUtils.equals(quantity9, "null")){
            tv_gsm9.setVisibility(View.INVISIBLE);
            tv_width9.setVisibility(View.INVISIBLE);
            tv_quantity9.setVisibility(View.INVISIBLE);
        }
        if (quantity10.equals("") || TextUtils.equals(quantity10, "null")){
            tv_gsm10.setVisibility(View.INVISIBLE);
            tv_width10.setVisibility(View.INVISIBLE);
            tv_quantity10.setVisibility(View.INVISIBLE);
        }

        b_Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submit();
            }
        });
    }

    private void getIntentDetails() {
        Intent finalOrderIntent = getIntent();
        sale_company = finalOrderIntent.getStringExtra("listItemName");
        sale_company_email = finalOrderIntent.getStringExtra("Email");
        bf = finalOrderIntent.getStringExtra("BF");
        price = finalOrderIntent.getStringExtra("Price");
        insurance = finalOrderIntent.getStringExtra("insurance");
        payment_terms = finalOrderIntent.getStringExtra("payment_terms");

        gsm1 = finalOrderIntent.getStringExtra("gsm1");
        gsm2 = finalOrderIntent.getStringExtra("gsm2");
        gsm3 = finalOrderIntent.getStringExtra("gsm3");
        gsm4 = finalOrderIntent.getStringExtra("gsm4");
        gsm5 = finalOrderIntent.getStringExtra("gsm5");
        gsm6 = finalOrderIntent.getStringExtra("gsm6");
        gsm7 = finalOrderIntent.getStringExtra("gsm7");
        gsm8 = finalOrderIntent.getStringExtra("gsm8");
        gsm9 = finalOrderIntent.getStringExtra("gsm9");
        gsm10 = finalOrderIntent.getStringExtra("gsm10");

        width1 = finalOrderIntent.getStringExtra("width1");
        width2 = finalOrderIntent.getStringExtra("width2");
        width3 = finalOrderIntent.getStringExtra("width3");
        width4 = finalOrderIntent.getStringExtra("width4");
        width5 = finalOrderIntent.getStringExtra("width5");
        width6 = finalOrderIntent.getStringExtra("width6");
        width7 = finalOrderIntent.getStringExtra("width7");
        width8 = finalOrderIntent.getStringExtra("width8");
        width9 = finalOrderIntent.getStringExtra("width9");
        width10 = finalOrderIntent.getStringExtra("width10");

        quantity1 = finalOrderIntent.getStringExtra("qty1");
        quantity2 = finalOrderIntent.getStringExtra("qty2");
        quantity3 = finalOrderIntent.getStringExtra("qty3");
        quantity4 = finalOrderIntent.getStringExtra("qty4");
        quantity5 = finalOrderIntent.getStringExtra("qty5");
        quantity6 = finalOrderIntent.getStringExtra("qty6");
        quantity7 = finalOrderIntent.getStringExtra("qty7");
        quantity8 = finalOrderIntent.getStringExtra("qty8");
        quantity9 = finalOrderIntent.getStringExtra("qty9");
        quantity10 = finalOrderIntent.getStringExtra("qty10");
    }

    private void getOrderDetails(){
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(final String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");
                    if (success) {
                        buyer_company = jsonResponse.getString("name");
                        gstin = jsonResponse.getString("gstin");
                        address = jsonResponse.getString("address");
                    } else {
                        final AlertDialog.Builder builder = new AlertDialog.Builder(FinalizeOrderActivity.this, R.style.Theme_AppCompat_Light_Dialog);
                        builder.setMessage("Error in fetching GSTIN and Address details").setNegativeButton("Cancel", null).create().show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        OrderDetailsRequest orderDetailsRequest = new OrderDetailsRequest(buyer_company_email, responseListener);
        RequestQueue requestQueue = Volley.newRequestQueue(FinalizeOrderActivity.this);
        requestQueue.add(orderDetailsRequest);
    }

    private void getBankDetails(){

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");
                    if (success) {
                        bankName = jsonResponse.getString("bank_name");
                        bankAccount = jsonResponse.getString("bank_account");
                        bankIfsc = jsonResponse.getString("bank_ifsc");
                        bankAccountName = jsonResponse.getString("bank_account_name");

                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(FinalizeOrderActivity.this, R.style.Theme_AppCompat_Light_Dialog);
                        builder.setMessage("Bank Order Submission Failed!").setNegativeButton("Retry", null).create().show();
                    }
                } catch (JSONException e) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(FinalizeOrderActivity.this, R.style.Theme_AppCompat_Light_Dialog);
                    builder.setMessage("Bank Order submission failed!. JSON response error").setNegativeButton("Retry", null).create().show();
                    e.printStackTrace();
                }
            }
        };

        String email = SaveSharedPreference.getUserName(FinalizeOrderActivity.this);
        ProfileBankDetailsRequest profileBankDetailsRequest = new ProfileBankDetailsRequest(email, responseListener);
        RequestQueue requestQueue = Volley.newRequestQueue(FinalizeOrderActivity.this);
        requestQueue.add(profileBankDetailsRequest);
    }

    private void submit() {

            Response.Listener<String> responseListener = new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        JSONObject jsonResponse = new JSONObject(response);
                        boolean success = jsonResponse.getBoolean("success");
                        if (success) {
                            final int order_id = jsonResponse.getInt("order_id");

                            AlertDialog.Builder builder = new AlertDialog.Builder(FinalizeOrderActivity.this, R.style.Theme_AppCompat_Light_Dialog);
                            builder.setMessage("Order Request ID: " +order_id).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    new Thread(new Runnable() {
                                        public void run() {
                                            try {
                                                List<String> emailList = new ArrayList<>();
                                                emailList.add(SaveSharedPreference.getUserName(FinalizeOrderActivity.this));
                                                emailList.add(sale_company_email);
                                                emailList.add("abhipaliwal@gmail.com");
                                                String finalList = emailList.toString();
                                                String recipients = finalList.substring(1, finalList.length() -1);
                                                String emailBody = "Dear Partner, \n\nYour order request has been placed with the manufacturer." +
                                                        "\n\nSeller: " + sale_company +
                                                        "\n\nBuyer: " +buyer_company +
                                                        "\nGSTIN: " + gstin +
                                                        "\nShipping Address: " + address +
                                                        "\n\nOrder ID: " + order_id +
                                                        "\nBF: " + bf +
                                                        "\nPrice: INR " + price +
                                                        "\nCredit Days: " + payment_terms + " days" +
                                                        "\n\nGSM: " + gsm1 + "  Width (cm): " + width1 + "  Reels: " + quantity1 +
                                                        "\nGSM: " + gsm2 + "  Width (cm): " + width2 + "  Reels: " + quantity2 +
                                                        "\nGSM: " + gsm3 + "  Width (cm): " + width3 + "  Reels: " + quantity3 +
                                                        "\nGSM: " + gsm4 + "  Width (cm): " + width4 + "  Reels: " + quantity4 +
                                                        "\nGSM: " + gsm5 + "  Width (cm): " + width5 + "  Reels: " + quantity5 +
                                                        "\nGSM: " + gsm6 + "  Width (cm): " + width6 + "  Reels: " + quantity6 +
                                                        "\nGSM: " + gsm7 + "  Width (cm): " + width7 + "  Reels: " + quantity7 +
                                                        "\nGSM: " + gsm8 + "  Width (cm): " + width8 + "  Reels: " + quantity8 +
                                                        "\nGSM: " + gsm9 + "  Width (cm): " + width9 + "  Reels: " + quantity9 +
                                                        "\nGSM: " + gsm10 + "  Width (cm): " + width10 + "  Reels: " + quantity10 +
                                                        "\n\nFreight (Additional): Pending" +
                                                        "\nOrder Status: Pending" +
                                                        "\n\nPlease deposit the amount in the bank details below (as per applicable payment terms): " +
                                                        "\nBank Name: " + bankName +
                                                        "\nBank Account Name: " + bankAccountName +
                                                        "\nBank Account Number: " + bankAccount +
                                                        "\nBank IFS Code: " + bankIfsc +
                                                        "\n\nThanks," +
                                                        "\nTeam Procnect";
                                                GMailSender sender = new GMailSender(
                                                        "info@alpanahotels.com",
                                                        "#Sharep0int");
                                                //sender.addAttachment(Environment.getExternalStorageDirectory().getPath()+"/image.jpg");
                                                sender.sendMail("Order Request ID: "+order_id, emailBody,
                                                        "info@alpanahotels.com", recipients);
                                            } catch (Exception e) {
                                                Toast.makeText(getApplicationContext(),"Error in sending email",Toast.LENGTH_LONG).show();
                                            }
                                        }
                                    }).start();
                                    Intent queryEntityIntent = new Intent(FinalizeOrderActivity.this, QueryEntityActivity.class);
                                    startActivity(queryEntityIntent);
                                    finish();
                                }
                            }).create().show();
                        } else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(FinalizeOrderActivity.this, R.style.Theme_AppCompat_Light_Dialog);
                            builder.setMessage("Order submission failed!").setNegativeButton("Retry", null).create().show();
                        }
                    } catch (JSONException e) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(FinalizeOrderActivity.this, R.style.Theme_AppCompat_Light_Dialog);
                        builder.setMessage("Order submission failed!. JSON response error").setNegativeButton("Retry", null).create().show();
                        e.printStackTrace();
                    }
                }
            };

            String order_status = "Pending";
            FinalizeOrderRequest finalizeOrderRequest = new FinalizeOrderRequest(sale_company, bf, price, buyer_company_email, sale_company_email, order_status, insurance, payment_terms, gsm1, width1,
                    quantity1, gsm2, width2, quantity2, gsm3, width3, quantity3, gsm4, width4, quantity4, gsm5, width5, quantity5, gsm6, width6, quantity6,
                    gsm7, width7, quantity7, gsm8, width8, quantity8, gsm9, width9, quantity9, gsm10, width10, quantity10, responseListener);
            RequestQueue requestQueue = Volley.newRequestQueue(FinalizeOrderActivity.this);
            requestQueue.add(finalizeOrderRequest);
    }
}
