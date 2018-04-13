package com.example.android.procnect;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BusinessSelectedActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_selected);

        final TextView tv_listItemName = findViewById(R.id.tv_listItemName);
        final TextView tv_pbf14 = findViewById(R.id.tv_pbf14);
        final TextView tv_pbf16 = findViewById(R.id.tv_pbf16);
        final TextView tv_pbf18 = findViewById(R.id.tv_pbf18);
        final TextView tv_pbf20 = findViewById(R.id.tv_pbf20);
        final TextView tv_pbf22 = findViewById(R.id.tv_pbf22);
        final TextView tv_pbf25 = findViewById(R.id.tv_pbf25);
        final TextView tv_pbf28 = findViewById(R.id.tv_pbf28);
        final TextView tv_pbf30 = findViewById(R.id.tv_pbf30);
        final TextView tv_pbf32 = findViewById(R.id.tv_pbf32);
        final TextView tv_pbf35 = findViewById(R.id.tv_pbf35);

        final Button tv_pbf14_button = findViewById(R.id.tv_pbf14_button);
        final Button tv_pbf16_button = findViewById(R.id.tv_pbf16_button);
        final Button tv_pbf18_button = findViewById(R.id.tv_pbf18_button);
        final Button tv_pbf20_button = findViewById(R.id.tv_pbf20_button);
        final Button tv_pbf22_button = findViewById(R.id.tv_pbf22_button);
        final Button tv_pbf25_button = findViewById(R.id.tv_pbf25_button);
        final Button tv_pbf28_button = findViewById(R.id.tv_pbf28_button);
        final Button tv_pbf30_button = findViewById(R.id.tv_pbf30_button);
        final Button tv_pbf32_button = findViewById(R.id.tv_pbf32_button);
        final Button tv_pbf35_button = findViewById(R.id.tv_pbf35_button);

        final Intent businessSelectedIntent = getIntent();
        final String listItemName= businessSelectedIntent.getStringExtra("listItemName");
        final String Email= businessSelectedIntent.getStringExtra("Email");
        final String pbf14 = businessSelectedIntent.getStringExtra("pbf14");
        final String pbf16 = businessSelectedIntent.getStringExtra("pbf16");
        final String pbf18 = businessSelectedIntent.getStringExtra("pbf18");
        final String pbf20 = businessSelectedIntent.getStringExtra("pbf20");
        final String pbf22 = businessSelectedIntent.getStringExtra("pbf22");
        final String pbf25 = businessSelectedIntent.getStringExtra("pbf25");
        final String pbf28 = businessSelectedIntent.getStringExtra("pbf28");
        final String pbf30 = businessSelectedIntent.getStringExtra("pbf30");
        final String pbf32 = businessSelectedIntent.getStringExtra("pbf32");
        final String pbf35 = businessSelectedIntent.getStringExtra("pbf35");
        final String mingsm = businessSelectedIntent.getStringExtra("mingsm");
        final String maxgsm = businessSelectedIntent.getStringExtra("maxgsm");
        final String insurance = businessSelectedIntent.getStringExtra("insurance");
        final String payment_terms = businessSelectedIntent.getStringExtra("payment_terms");

        if (listItemName.equals("") || listItemName.length() == 0){
            tv_listItemName.setText("N/A");
        }
        else{
            tv_listItemName.setText(listItemName);
        }
        if (pbf14.equals("") || pbf14.length() == 0){
            tv_pbf14_button.setVisibility(TextView.INVISIBLE);
            tv_pbf14.setText("N/A");
        }
        else{
            tv_pbf14.setText(pbf14);
        }
        if (pbf16.equals("") || pbf16.length() == 0){
            tv_pbf16_button.setVisibility(TextView.INVISIBLE);
            tv_pbf16.setText("N/A");
        }
        else{
            tv_pbf16.setText(pbf16);
        }
        if (pbf18.equals("") || pbf18.length() == 0){
            tv_pbf18_button.setVisibility(TextView.INVISIBLE);
            tv_pbf18.setText("N/A");
        }
        else{
            tv_pbf18.setText(pbf18);
        }
        if (pbf20.equals("") || pbf20.length() == 0){
            tv_pbf20_button.setVisibility(TextView.INVISIBLE);
            tv_pbf20.setText("N/A");
        }
        else{
            tv_pbf20.setText(pbf20);
        }
        if (pbf22.equals("") || pbf22.length() == 0){
            tv_pbf22_button.setVisibility(TextView.INVISIBLE);
            tv_pbf22.setText("N/A");
        }
        else{
            tv_pbf22.setText(pbf22);
        }
        if (pbf25.equals("") || pbf25.length() == 0){
            tv_pbf25_button.setVisibility(TextView.INVISIBLE);
            tv_pbf25.setText("N/A");
        }
        else{
            tv_pbf25.setText(pbf25);
        }
        if (pbf28.equals("") || pbf28.length() == 0){
            tv_pbf28_button.setVisibility(TextView.INVISIBLE);
            tv_pbf28.setText("N/A");
        }
        else{
            tv_pbf28.setText(pbf28);
        }
        if (pbf30.equals("") || pbf30.length() == 0){
            tv_pbf30_button.setVisibility(TextView.INVISIBLE);
            tv_pbf30.setText("N/A");
        }
        else{
            tv_pbf30.setText(pbf30);
        }
        if (pbf32.equals("") || pbf32.length() == 0){
            tv_pbf32_button.setVisibility(TextView.INVISIBLE);
            tv_pbf32.setText("N/A");
        }
        else{
            tv_pbf32.setText(pbf32);
        }
        if (pbf35.equals("") || pbf35.length() == 0){
            tv_pbf35_button.setVisibility(TextView.INVISIBLE);
            tv_pbf35.setText("N/A");
        }
        else{
            tv_pbf35.setText(pbf35);
        }

        tv_pbf14_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pbf14_OrderIntent = new Intent(BusinessSelectedActivity.this, OrderActivity.class);
                pbf14_OrderIntent.putExtra("pbf14", pbf14);
                pbf14_OrderIntent.putExtra("bf14", "14 BF");
                pbf14_OrderIntent.putExtra("mingsm", mingsm);
                pbf14_OrderIntent.putExtra("maxgsm", maxgsm);
                pbf14_OrderIntent.putExtra("listitemname", listItemName);
                pbf14_OrderIntent.putExtra("Email", Email);
                pbf14_OrderIntent.putExtra("insurance", insurance);
                pbf14_OrderIntent.putExtra("payment_terms", payment_terms);
                pbf14_OrderIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                BusinessSelectedActivity.this.startActivity(pbf14_OrderIntent);
            }
        });

        tv_pbf16_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pbf16_OrderIntent = new Intent(BusinessSelectedActivity.this, OrderActivity.class);
                pbf16_OrderIntent.putExtra("pbf16", pbf16);
                pbf16_OrderIntent.putExtra("bf16", "16 BF");
                pbf16_OrderIntent.putExtra("mingsm", mingsm);
                pbf16_OrderIntent.putExtra("maxgsm", maxgsm);
                pbf16_OrderIntent.putExtra("listitemname", listItemName);
                pbf16_OrderIntent.putExtra("Email", Email);
                pbf16_OrderIntent.putExtra("insurance", insurance);
                pbf16_OrderIntent.putExtra("payment_terms", payment_terms);
                pbf16_OrderIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                BusinessSelectedActivity.this.startActivity(pbf16_OrderIntent);
            }
        });

        tv_pbf18_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pbf18_OrderIntent = new Intent(BusinessSelectedActivity.this, OrderActivity.class);
                pbf18_OrderIntent.putExtra("pbf18", pbf18);
                pbf18_OrderIntent.putExtra("bf18", "18 BF");
                pbf18_OrderIntent.putExtra("mingsm", mingsm);
                pbf18_OrderIntent.putExtra("maxgsm", maxgsm);
                pbf18_OrderIntent.putExtra("listitemname", listItemName);
                pbf18_OrderIntent.putExtra("Email", Email);
                pbf18_OrderIntent.putExtra("insurance", insurance);
                pbf18_OrderIntent.putExtra("payment_terms", payment_terms);
                pbf18_OrderIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                BusinessSelectedActivity.this.startActivity(pbf18_OrderIntent);
            }
        });

        tv_pbf20_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pbf20_OrderIntent = new Intent(BusinessSelectedActivity.this, OrderActivity.class);
                pbf20_OrderIntent.putExtra("pbf20", pbf20);
                pbf20_OrderIntent.putExtra("bf20", "20 BF");
                pbf20_OrderIntent.putExtra("mingsm", mingsm);
                pbf20_OrderIntent.putExtra("maxgsm", maxgsm);
                pbf20_OrderIntent.putExtra("listitemname", listItemName);
                pbf20_OrderIntent.putExtra("Email", Email);
                pbf20_OrderIntent.putExtra("insurance", insurance);
                pbf20_OrderIntent.putExtra("payment_terms", payment_terms);
                pbf20_OrderIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                BusinessSelectedActivity.this.startActivity(pbf20_OrderIntent);
            }
        });

        tv_pbf22_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pbf22_OrderIntent = new Intent(BusinessSelectedActivity.this, OrderActivity.class);
                pbf22_OrderIntent.putExtra("pbf22", pbf22);
                pbf22_OrderIntent.putExtra("bf22", "22 BF");
                pbf22_OrderIntent.putExtra("mingsm", mingsm);
                pbf22_OrderIntent.putExtra("maxgsm", maxgsm);
                pbf22_OrderIntent.putExtra("listitemname", listItemName);
                pbf22_OrderIntent.putExtra("insurance", insurance);
                pbf22_OrderIntent.putExtra("payment_terms", payment_terms);
                pbf22_OrderIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                BusinessSelectedActivity.this.startActivity(pbf22_OrderIntent);
            }
        });

        tv_pbf25_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pbf25_OrderIntent = new Intent(BusinessSelectedActivity.this, OrderActivity.class);
                pbf25_OrderIntent.putExtra("pbf25", pbf25);
                pbf25_OrderIntent.putExtra("bf25", "25 BF");
                pbf25_OrderIntent.putExtra("mingsm", mingsm);
                pbf25_OrderIntent.putExtra("maxgsm", maxgsm);
                pbf25_OrderIntent.putExtra("listitemname", listItemName);
                pbf25_OrderIntent.putExtra("Email", Email);
                pbf25_OrderIntent.putExtra("insurance", insurance);
                pbf25_OrderIntent.putExtra("payment_terms", payment_terms);
                pbf25_OrderIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                BusinessSelectedActivity.this.startActivity(pbf25_OrderIntent);
            }
        });

        tv_pbf28_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pbf28_OrderIntent = new Intent(BusinessSelectedActivity.this, OrderActivity.class);
                pbf28_OrderIntent.putExtra("pbf28", pbf28);
                pbf28_OrderIntent.putExtra("bf28", "28 BF");
                pbf28_OrderIntent.putExtra("mingsm", mingsm);
                pbf28_OrderIntent.putExtra("maxgsm", maxgsm);
                pbf28_OrderIntent.putExtra("listitemname", listItemName);
                pbf28_OrderIntent.putExtra("Email", Email);
                pbf28_OrderIntent.putExtra("insurance", insurance);
                pbf28_OrderIntent.putExtra("payment_terms", payment_terms);
                pbf28_OrderIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                BusinessSelectedActivity.this.startActivity(pbf28_OrderIntent);
            }
        });

        tv_pbf30_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pbf30_OrderIntent = new Intent(BusinessSelectedActivity.this, OrderActivity.class);
                pbf30_OrderIntent.putExtra("pbf30", pbf30);
                pbf30_OrderIntent.putExtra("bf30", "30 BF");
                pbf30_OrderIntent.putExtra("mingsm", mingsm);
                pbf30_OrderIntent.putExtra("maxgsm", maxgsm);
                pbf30_OrderIntent.putExtra("listitemname", listItemName);
                pbf30_OrderIntent.putExtra("Email", Email);
                pbf30_OrderIntent.putExtra("insurance", insurance);
                pbf30_OrderIntent.putExtra("payment_terms", payment_terms);
                pbf30_OrderIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                BusinessSelectedActivity.this.startActivity(pbf30_OrderIntent);
            }
        });

        tv_pbf32_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pbf32_OrderIntent = new Intent(BusinessSelectedActivity.this, OrderActivity.class);
                pbf32_OrderIntent.putExtra("pbf32", pbf32);
                pbf32_OrderIntent.putExtra("bf32", "32 BF");
                pbf32_OrderIntent.putExtra("mingsm", mingsm);
                pbf32_OrderIntent.putExtra("maxgsm", maxgsm);
                pbf32_OrderIntent.putExtra("listitemname", listItemName);
                pbf32_OrderIntent.putExtra("Email", Email);
                pbf32_OrderIntent.putExtra("insurance", insurance);
                pbf32_OrderIntent.putExtra("payment_terms", payment_terms);
                pbf32_OrderIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                BusinessSelectedActivity.this.startActivity(pbf32_OrderIntent);
            }
        });

        tv_pbf35_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pbf35_OrderIntent = new Intent(BusinessSelectedActivity.this, OrderActivity.class);
                pbf35_OrderIntent.putExtra("pbf35", pbf35);
                pbf35_OrderIntent.putExtra("bf35", "35 BF");
                pbf35_OrderIntent.putExtra("mingsm", mingsm);
                pbf35_OrderIntent.putExtra("maxgsm", maxgsm);
                pbf35_OrderIntent.putExtra("listitemname", listItemName);
                pbf35_OrderIntent.putExtra("Email", Email);
                pbf35_OrderIntent.putExtra("insurance", insurance);
                pbf35_OrderIntent.putExtra("payment_terms", payment_terms);
                pbf35_OrderIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                BusinessSelectedActivity.this.startActivity(pbf35_OrderIntent);
            }
        });
    }
}
