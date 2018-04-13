package com.example.android.procnect;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class ConfirmOrderActivity extends AppCompatActivity {

    private String freight;
    private String delivery_days;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_order);

        final EditText et_freight = findViewById(R.id.et_freight);
        final EditText et_delivery_days = findViewById(R.id.et_delivery_days);

        final Button b_confirm = findViewById(R.id.button_confirm);

        Intent confirmOrderIntent = getIntent();
        final String order_id = confirmOrderIntent.getStringExtra("order_id");
        final String sale_company = confirmOrderIntent.getStringExtra("sale_company");
        final String bf = confirmOrderIntent.getStringExtra("bf");
        final String price = confirmOrderIntent.getStringExtra("price");
        final String buyer_email = confirmOrderIntent.getStringExtra("buyer_email");
        final String payment_terms = confirmOrderIntent.getStringExtra("payment_terms");
        final String order_status = "Confirmed";

        final String gsm1 = confirmOrderIntent.getStringExtra("gsm1");
        final String gsm2 = confirmOrderIntent.getStringExtra("gsm2");
        final String gsm3 = confirmOrderIntent.getStringExtra("gsm3");
        final String gsm4 = confirmOrderIntent.getStringExtra("gsm4");
        final String gsm5 = confirmOrderIntent.getStringExtra("gsm5");
        final String gsm6 = confirmOrderIntent.getStringExtra("gsm6");
        final String gsm7 = confirmOrderIntent.getStringExtra("gsm7");
        final String gsm8 = confirmOrderIntent.getStringExtra("gsm8");
        final String gsm9 = confirmOrderIntent.getStringExtra("gsm9");
        final String gsm10 = confirmOrderIntent.getStringExtra("gsm10");

        final String width1 = confirmOrderIntent.getStringExtra("width1");
        final String width2 = confirmOrderIntent.getStringExtra("width2");
        final String width3 = confirmOrderIntent.getStringExtra("width3");
        final String width4 = confirmOrderIntent.getStringExtra("width4");
        final String width5 = confirmOrderIntent.getStringExtra("width5");
        final String width6 = confirmOrderIntent.getStringExtra("width6");
        final String width7 = confirmOrderIntent.getStringExtra("width7");
        final String width8 = confirmOrderIntent.getStringExtra("width8");
        final String width9 = confirmOrderIntent.getStringExtra("width9");
        final String width10 = confirmOrderIntent.getStringExtra("width10");

        final String quantity1 = confirmOrderIntent.getStringExtra("quantity1");
        final String quantity2 = confirmOrderIntent.getStringExtra("quantity2");
        final String quantity3 = confirmOrderIntent.getStringExtra("quantity3");
        final String quantity4 = confirmOrderIntent.getStringExtra("quantity4");
        final String quantity5 = confirmOrderIntent.getStringExtra("quantity5");
        final String quantity6 = confirmOrderIntent.getStringExtra("quantity6");
        final String quantity7 = confirmOrderIntent.getStringExtra("quantity7");
        final String quantity8 = confirmOrderIntent.getStringExtra("quantity8");
        final String quantity9 = confirmOrderIntent.getStringExtra("quantity9");
        final String quantity10 = confirmOrderIntent.getStringExtra("quantity10");

        b_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (et_freight.getText().toString().equals("") || et_freight.getText().toString().length() == 0) {
                    freight = "Not Provided";
                }
                else{
                    freight = et_freight.getText().toString();
                }

                if (et_delivery_days.getText().toString().equals("") || et_delivery_days.getText().toString().length() == 0) {
                    delivery_days = "Not Provided";
                }
                else{
                    delivery_days = et_delivery_days.getText().toString();
                }

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try
                        {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success) {
                                Toast.makeText(getApplicationContext(), "Order Confirmed Successfully.", Toast.LENGTH_LONG).show();
                                AlertDialog.Builder builder = new AlertDialog.Builder(ConfirmOrderActivity.this, R.style.Theme_AppCompat_Light_Dialog);
                                builder.setMessage("Your order has been confirmed successfully! Confirmed Order ID: " + order_id).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        new Thread(new Runnable() {
                                            public void run() {
                                                try {
                                                    List<String> emailList = new ArrayList<>();
                                                    emailList.add(SaveSharedPreference.getUserName(ConfirmOrderActivity.this));
                                                    emailList.add(buyer_email);
                                                    emailList.add("abhipaliwal@gmail.com");
                                                    String finalList = emailList.toString();
                                                    String recipients = finalList.substring(1, finalList.length() - 1);
                                                    String emailBody = "Dear Partner, \n\nYour order has been confirmed by the manufacturer." +
                                                            "\n\nOrdered to: " + sale_company +
                                                            "\nOrder ID: " + order_id +
                                                            "\nBF: " + bf +
                                                            "\nPrice: INR " + price +
                                                            "\n\nCredit Days: " + payment_terms +
                                                            "\n\nFreight (Additional): INR " + freight +
                                                            "\nDeliver Days: " + delivery_days +
                                                            "\nOrder Status: " + order_status +
                                                            "\n\nGSM: " + gsm1 + "  Width (cm): " + width1 + "  Reels: " + quantity1 +
                                                            "\nGSM: " + gsm2 + "    Width (cm): " + width2 + "  Reels: " + quantity2 +
                                                            "\nGSM: " + gsm3 + "    Width (cm): " + width3 + "  Reels: " + quantity3 +
                                                            "\nGSM: " + gsm4 + "    Width (cm): " + width4 + "  Reels: " + quantity4 +
                                                            "\nGSM: " + gsm5 + "    Width (cm): " + width5 + "  Reels: " + quantity5 +
                                                            "\nGSM: " + gsm6 + "    Width (cm): " + width6 + "  Reels: " + quantity6 +
                                                            "\nGSM: " + gsm7 + "    Width (cm): " + width7 + "  Reels: " + quantity7 +
                                                            "\nGSM: " + gsm8 + "    Width (cm): " + width8 + "  Reels: " + quantity8 +
                                                            "\nGSM: " + gsm9 + "    Width (cm): " + width9 + "  Reels: " + quantity9 +
                                                            "\nGSM: " + gsm10 + "    Width (cm): " + width10 + "  Reels: " + quantity10 +
                                                            "\n\nThanks," +
                                                            "\nTeam Procnect";

                                                    GMailSender sender = new GMailSender(
                                                            "info@alpanahotels.com",
                                                            "#Sharep0int");
                                                    //sender.addAttachment(Environment.getExternalStorageDirectory().getPath()+"/image.jpg");
                                                    sender.sendMail("Your order has been confirmed! Confirmed Order ID: " + order_id, emailBody,
                                                            "info@alpanahotels.com", recipients);
                                                } catch (Exception e) {
                                                    Toast.makeText(getApplicationContext(), "Error in sending email", Toast.LENGTH_LONG).show();
                                                }
                                            }
                                        }).start();

                                        Intent successOrderIntent = new Intent(ConfirmOrderActivity.this, QueryEntityActivity.class);
                                        successOrderIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                        startActivity(successOrderIntent);
                                        finish();
                                    }
                                }).create().show();
                            }
                            else
                            {
                                AlertDialog.Builder builder = new AlertDialog.Builder(ConfirmOrderActivity.this, R.style.Theme_AppCompat_Light_Dialog);
                                builder.setMessage("Order Confirmation Failed.").setNegativeButton("Cancel", null).create().show();
                            }
                        }
                        catch (JSONException e) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(ConfirmOrderActivity.this, R.style.Theme_AppCompat_Light_Dialog);
                            builder.setMessage("Order Confirmation Failed. JSON Response Error").setNegativeButton("Cancel", null).create().show();
                            e.printStackTrace();
                        }
                    }
                };
                ConfirmOrderRequest confirmOrderRequest = new ConfirmOrderRequest(order_status, order_id, freight, delivery_days, responseListener);
                RequestQueue requestQueue = Volley.newRequestQueue(ConfirmOrderActivity.this);
                requestQueue.add(confirmOrderRequest);

            }
        });
    }
}
