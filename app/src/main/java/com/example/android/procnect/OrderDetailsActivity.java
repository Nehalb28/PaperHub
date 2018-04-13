package com.example.android.procnect;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OrderDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);

        final TextView tv_saleCompany = findViewById(R.id.tv_salecompany);
        final TextView tv_orderid = findViewById(R.id.tv_orderid);
        final TextView tv_bf = findViewById(R.id.tv_bf);
        final TextView tv_price = findViewById(R.id.tv_price);
        final TextView tv_orderstatus = findViewById(R.id.tv_orderstatus);
        final TextView tv_payment_terms = findViewById(R.id.tv_payment_terms);
        final Button b_confirm = findViewById(R.id.button_confirm);

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

        b_confirm.setVisibility(View.INVISIBLE);

        final Intent orderDetailsIntent = getIntent();

        final String order_status = orderDetailsIntent.getStringExtra("order_status");
        final String order_id = orderDetailsIntent.getStringExtra("order_id");
        final String sale_company = orderDetailsIntent.getStringExtra("sale_company");
        final String bf = orderDetailsIntent.getStringExtra("bf");
        final String price = orderDetailsIntent.getStringExtra("price");
        final String buyer_email = orderDetailsIntent.getStringExtra("buyer_email");
        final String payment_terms = orderDetailsIntent.getStringExtra("payment_terms");
        final String confirmButton_status = orderDetailsIntent.getStringExtra("confirm_button");

        final String gsm1 = orderDetailsIntent.getStringExtra("gsm1");
        final String gsm2 = orderDetailsIntent.getStringExtra("gsm2");
        final String gsm3 = orderDetailsIntent.getStringExtra("gsm3");
        final String gsm4 = orderDetailsIntent.getStringExtra("gsm4");
        final String gsm5 = orderDetailsIntent.getStringExtra("gsm5");
        final String gsm6 = orderDetailsIntent.getStringExtra("gsm6");
        final String gsm7 = orderDetailsIntent.getStringExtra("gsm7");
        final String gsm8 = orderDetailsIntent.getStringExtra("gsm8");
        final String gsm9 = orderDetailsIntent.getStringExtra("gsm9");
        final String gsm10 = orderDetailsIntent.getStringExtra("gsm10");
        final String width1 = orderDetailsIntent.getStringExtra("width1");
        final String width2 = orderDetailsIntent.getStringExtra("width2");
        final String width3 = orderDetailsIntent.getStringExtra("width3");
        final String width4 = orderDetailsIntent.getStringExtra("width4");
        final String width5 = orderDetailsIntent.getStringExtra("width5");
        final String width6 = orderDetailsIntent.getStringExtra("width6");
        final String width7 = orderDetailsIntent.getStringExtra("width7");
        final String width8 = orderDetailsIntent.getStringExtra("width8");
        final String width9 = orderDetailsIntent.getStringExtra("width9");
        final String width10 = orderDetailsIntent.getStringExtra("width10");
        final String quantity1 = orderDetailsIntent.getStringExtra("quantity1");
        final String quantity2 = orderDetailsIntent.getStringExtra("quantity2");
        final String quantity3 = orderDetailsIntent.getStringExtra("quantity3");
        final String quantity4 = orderDetailsIntent.getStringExtra("quantity4");
        final String quantity5 = orderDetailsIntent.getStringExtra("quantity5");
        final String quantity6 = orderDetailsIntent.getStringExtra("quantity6");
        final String quantity7 = orderDetailsIntent.getStringExtra("quantity7");
        final String quantity8 = orderDetailsIntent.getStringExtra("quantity8");
        final String quantity9 = orderDetailsIntent.getStringExtra("quantity9");
        final String quantity10 = orderDetailsIntent.getStringExtra("quantity10");

        tv_saleCompany.setText(sale_company);
        tv_orderid.setText(order_id);
        tv_bf.setText(bf);
        tv_price.setText(price);
        tv_orderstatus.setText(order_status);
        tv_payment_terms.setText(payment_terms);

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


        if (confirmButton_status.equals("true") && !order_status.equals("Confirmed")){
            b_confirm.setVisibility(View.VISIBLE);
        }

        b_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent confirmOrderIntent = new Intent(OrderDetailsActivity.this, ConfirmOrderActivity.class);
                confirmOrderIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                confirmOrderIntent.putExtra("sale_company", sale_company);
                confirmOrderIntent.putExtra("order_id", order_id);
                confirmOrderIntent.putExtra("bf", bf);
                confirmOrderIntent.putExtra("price", price);
                confirmOrderIntent.putExtra("payment_terms", payment_terms);
                confirmOrderIntent.putExtra("buyer_email", buyer_email);

                confirmOrderIntent.putExtra("gsm1", gsm1);
                confirmOrderIntent.putExtra("gsm2", gsm2);
                confirmOrderIntent.putExtra("gsm3", gsm3);
                confirmOrderIntent.putExtra("gsm4", gsm4);
                confirmOrderIntent.putExtra("gsm5", gsm5);
                confirmOrderIntent.putExtra("gsm6", gsm6);
                confirmOrderIntent.putExtra("gsm7", gsm7);
                confirmOrderIntent.putExtra("gsm8", gsm8);
                confirmOrderIntent.putExtra("gsm9", gsm9);
                confirmOrderIntent.putExtra("gsm10", gsm10);

                confirmOrderIntent.putExtra("width1", width1);
                confirmOrderIntent.putExtra("width2", width2);
                confirmOrderIntent.putExtra("width3", width3);
                confirmOrderIntent.putExtra("width4", width4);
                confirmOrderIntent.putExtra("width5", width5);
                confirmOrderIntent.putExtra("width6", width6);
                confirmOrderIntent.putExtra("width7", width7);
                confirmOrderIntent.putExtra("width8", width8);
                confirmOrderIntent.putExtra("width9", width9);
                confirmOrderIntent.putExtra("width10", width10);

                confirmOrderIntent.putExtra("quantity1", quantity1);
                confirmOrderIntent.putExtra("quantity2", quantity2);
                confirmOrderIntent.putExtra("quantity3", quantity3);
                confirmOrderIntent.putExtra("quantity4", quantity4);
                confirmOrderIntent.putExtra("quantity5", quantity5);
                confirmOrderIntent.putExtra("quantity6", quantity6);
                confirmOrderIntent.putExtra("quantity7", quantity7);
                confirmOrderIntent.putExtra("quantity8", quantity8);
                confirmOrderIntent.putExtra("quantity9", quantity9);
                confirmOrderIntent.putExtra("quantity10", quantity10);

                startActivity(confirmOrderIntent);
            }
        });
    }
}
