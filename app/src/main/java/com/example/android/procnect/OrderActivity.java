package com.example.android.procnect;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity {

    private String listItemName;
    private String Email;
    private String BF;
    private String Price;
    private String Insurance;
    private String payment_terms;
    private int minGsm, maxGsm;
    private CheckBox cb_2, cb_3, cb_4, cb_5, cb_6, cb_7, cb_8, cb_9, cb_10;
    private EditText et_gsm_1, et_gsm_2, et_gsm_3, et_gsm_4, et_gsm_5, et_gsm_6, et_gsm_7, et_gsm_8, et_gsm_9, et_gsm_10,
            et_width_1, et_width_2, et_width_3, et_width_4, et_width_5, et_width_6, et_width_7, et_width_8, et_width_9, et_width_10,
            et_qty_1, et_qty_2, et_qty_3, et_qty_4, et_qty_5, et_qty_6, et_qty_7, et_qty_8, et_qty_9, et_qty_10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        final TextView tv_pbf = findViewById(R.id.tv_pbf);
        final TextView tv_bf = findViewById(R.id.tv_bf);
        final TextView tv_mingsm = findViewById(R.id.tv_min_gsm);
        final TextView tv_maxgsm = findViewById(R.id.tv_max_gsm);
        final TextView tv_listitemname = findViewById(R.id.tv_listitemname);
        final TextView tv_payment_terms = findViewById(R.id.tv_payment_terms);
        final Button b_Next = findViewById(R.id.button_next);

        cb_2 = findViewById(R.id.cb_2);
        cb_3 = findViewById(R.id.cb_3);
        cb_4 = findViewById(R.id.cb_4);
        cb_5 = findViewById(R.id.cb_5);
        cb_6 = findViewById(R.id.cb_6);
        cb_7 = findViewById(R.id.cb_7);
        cb_8 = findViewById(R.id.cb_8);
        cb_9 = findViewById(R.id.cb_9);
        cb_10 = findViewById(R.id.cb_10);
        et_gsm_1 = findViewById(R.id.et_gsm_in1);
        et_gsm_2 = findViewById(R.id.et_gsm_in2);
        et_gsm_3 = findViewById(R.id.et_gsm_in3);
        et_gsm_4 = findViewById(R.id.et_gsm_in4);
        et_gsm_5 = findViewById(R.id.et_gsm_in5);
        et_gsm_6 = findViewById(R.id.et_gsm_in6);
        et_gsm_7 = findViewById(R.id.et_gsm_in7);
        et_gsm_8 = findViewById(R.id.et_gsm_in8);
        et_gsm_9 = findViewById(R.id.et_gsm_in9);
        et_gsm_10 = findViewById(R.id.et_gsm_in10);
        et_width_1 = findViewById(R.id.et_width1);
        et_width_2 = findViewById(R.id.et_width2);
        et_width_3 = findViewById(R.id.et_width3);
        et_width_4 = findViewById(R.id.et_width4);
        et_width_5 = findViewById(R.id.et_width5);
        et_width_6 = findViewById(R.id.et_width6);
        et_width_7 = findViewById(R.id.et_width7);
        et_width_8 = findViewById(R.id.et_width8);
        et_width_9 = findViewById(R.id.et_width9);
        et_width_10 = findViewById(R.id.et_width10);
        et_qty_1 = findViewById(R.id.et_quantity1);
        et_qty_2 = findViewById(R.id.et_quantity2);
        et_qty_3 = findViewById(R.id.et_quantity3);
        et_qty_4 = findViewById(R.id.et_quantity4);
        et_qty_5 = findViewById(R.id.et_quantity5);
        et_qty_6 = findViewById(R.id.et_quantity6);
        et_qty_7 = findViewById(R.id.et_quantity7);
        et_qty_8 = findViewById(R.id.et_quantity8);
        et_qty_9 = findViewById(R.id.et_quantity9);
        et_qty_10 = findViewById(R.id.et_quantity10);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            minGsm = Integer.parseInt(extras.getString("mingsm"));
            maxGsm = Integer.parseInt(extras.getString("maxgsm"));
            listItemName = extras.getString("listitemname");
            Email = extras.getString("Email");
            tv_mingsm.setText(String.valueOf(minGsm));
            tv_maxgsm.setText(String.valueOf(maxGsm));
            tv_listitemname.setText(listItemName);

            if (extras.containsKey("pbf14")) {
                tv_bf.setText(extras.getString("bf14"));
                tv_pbf.setText(extras.getString("pbf14"));
                BF = extras.getString("bf14");
                Price = extras.getString("pbf14");
                Insurance = extras.getString("insurance");
                payment_terms = extras.getString("payment_terms");
                tv_payment_terms.setText(payment_terms);
            }
            if (extras.containsKey("pbf16")) {
                tv_bf.setText(extras.getString("bf16"));
                tv_pbf.setText(extras.getString("pbf16"));
                BF = extras.getString("bf16");
                Price = extras.getString("pbf16");
                Insurance = extras.getString("insurance");
                payment_terms = extras.getString("payment_terms");
                tv_payment_terms.setText(payment_terms);
            }
            if (extras.containsKey("pbf18")) {
                tv_bf.setText(extras.getString("bf18"));
                tv_pbf.setText(extras.getString("pbf18"));
                BF = extras.getString("bf18");
                Price = extras.getString("pbf18");
                Insurance = extras.getString("insurance");
                tv_payment_terms.setText(payment_terms);
            }
            if (extras.containsKey("pbf20")) {
                tv_bf.setText(extras.getString("bf20"));
                tv_pbf.setText(extras.getString("pbf20"));
                BF = extras.getString("bf20");
                Price = extras.getString("pbf20");
                Insurance = extras.getString("insurance");
                payment_terms = extras.getString("payment_terms");
                tv_payment_terms.setText(payment_terms);
            }
            if (extras.containsKey("pbf22")) {
                tv_bf.setText(extras.getString("bf22"));
                tv_pbf.setText(extras.getString("pbf22"));
                BF = extras.getString("bf22");
                Price = extras.getString("pbf22");
                Insurance = extras.getString("insurance");
                payment_terms = extras.getString("payment_terms");
                tv_payment_terms.setText(payment_terms);
            }
            if (extras.containsKey("pbf25")) {
                tv_bf.setText(extras.getString("bf25"));
                tv_pbf.setText(extras.getString("pbf25"));
                BF = extras.getString("bf25");
                Price = extras.getString("pbf25");
                Insurance = extras.getString("insurance");
                payment_terms = extras.getString("payment_terms");
                tv_payment_terms.setText(payment_terms);
            }
            if (extras.containsKey("pbf28")) {
                tv_bf.setText(extras.getString("bf28"));
                tv_pbf.setText(extras.getString("pbf28"));
                BF = extras.getString("bf28");
                Price = extras.getString("pbf28");
                Insurance = extras.getString("insurance");
                payment_terms = extras.getString("payment_terms");
                tv_payment_terms.setText(payment_terms);
            }
            if (extras.containsKey("pbf30")) {
                tv_bf.setText(extras.getString("bf30"));
                tv_pbf.setText(extras.getString("pbf30"));
                BF = extras.getString("bf30");
                Price = extras.getString("pbf30");
                Insurance = extras.getString("insurance");
                payment_terms = extras.getString("payment_terms");
                tv_payment_terms.setText(payment_terms);
            }
            if (extras.containsKey("pbf32")) {
                tv_bf.setText(extras.getString("bf32"));
                tv_pbf.setText(extras.getString("pbf32"));
                BF = extras.getString("bf32");
                Price = extras.getString("pbf32");
                Insurance = extras.getString("insurance");
                payment_terms = extras.getString("payment_terms");
                tv_payment_terms.setText(payment_terms);
            }
            if (extras.containsKey("pbf35")) {
                tv_bf.setText(extras.getString("bf35"));
                tv_pbf.setText(extras.getString("pbf35"));
                BF = extras.getString("bf35");
                Price = extras.getString("pbf35");
                Insurance = extras.getString("insurance");
                payment_terms = extras.getString("payment_terms");
                tv_payment_terms.setText(payment_terms);
            }
        }

        b_Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkvalidation();
            }
        });
    }

    private void checkvalidation(){

        if(et_gsm_1.getText().toString().equals("")  || et_gsm_1.length() == 0
                || cb_2.isChecked() && et_gsm_2.getText().toString().equals("")  || cb_2.isChecked() && et_gsm_2.length() == 0
                || cb_3.isChecked() && et_gsm_3.getText().toString().equals("")  || cb_3.isChecked() && et_gsm_3.length() == 0
                || cb_4.isChecked() && et_gsm_4.getText().toString().equals("")  || cb_4.isChecked() && et_gsm_4.length() == 0
                || cb_5.isChecked() && et_gsm_5.getText().toString().equals("")  || cb_5.isChecked() && et_gsm_5.length() == 0
                || cb_6.isChecked() && et_gsm_6.getText().toString().equals("")  || cb_6.isChecked() && et_gsm_6.length() == 0
                || cb_7.isChecked() && et_gsm_7.getText().toString().equals("")  || cb_7.isChecked() && et_gsm_7.length() == 0
                || cb_8.isChecked() && et_gsm_8.getText().toString().equals("")  || cb_8.isChecked() && et_gsm_8.length() == 0
                || cb_9.isChecked() && et_gsm_9.getText().toString().equals("")  || cb_9.isChecked() && et_gsm_9.length() == 0
                || cb_10.isChecked() && et_gsm_10.getText().toString().equals("")  || cb_10.isChecked() && et_gsm_10.length() == 0)
        {Toast.makeText(getApplicationContext(), "Please enter Gsm for selected fields.", Toast.LENGTH_LONG).show();}

        else if(et_width_1.getText().toString().equals("")  || et_width_1.length() == 0
                || cb_2.isChecked() && et_width_2.getText().toString().equals("")  || cb_2.isChecked() && et_width_2.length() == 0
                || cb_3.isChecked() && et_width_3.getText().toString().equals("")  || cb_3.isChecked() && et_width_3.length() == 0
                || cb_4.isChecked() && et_width_4.getText().toString().equals("")  || cb_4.isChecked() && et_width_4.length() == 0
                || cb_5.isChecked() && et_width_5.getText().toString().equals("")  || cb_5.isChecked() && et_width_5.length() == 0
                || cb_6.isChecked() && et_width_6.getText().toString().equals("")  || cb_6.isChecked() && et_width_6.length() == 0
                || cb_7.isChecked() && et_width_7.getText().toString().equals("")  || cb_7.isChecked() && et_width_7.length() == 0
                || cb_8.isChecked() && et_width_8.getText().toString().equals("")  || cb_8.isChecked() && et_width_8.length() == 0
                || cb_9.isChecked() && et_width_9.getText().toString().equals("")  || cb_9.isChecked() && et_width_9.length() == 0
                || cb_10.isChecked() && et_width_10.getText().toString().equals("")  || cb_10.isChecked() && et_width_10.length() == 0)
        {Toast.makeText(getApplicationContext(), "Please enter Width for selected fields.", Toast.LENGTH_LONG).show();}

        else if(et_qty_1.getText().toString().equals("")  || et_qty_1.length() == 0
                || cb_2.isChecked() && et_qty_2.getText().toString().equals("")  || cb_2.isChecked() && et_qty_2.length() == 0
                || cb_3.isChecked() && et_qty_3.getText().toString().equals("")  || cb_3.isChecked() && et_qty_3.length() == 0
                || cb_4.isChecked() && et_qty_4.getText().toString().equals("")  || cb_4.isChecked() && et_qty_4.length() == 0
                || cb_5.isChecked() && et_qty_5.getText().toString().equals("")  || cb_5.isChecked() && et_qty_5.length() == 0
                || cb_6.isChecked() && et_qty_6.getText().toString().equals("")  || cb_6.isChecked() && et_qty_6.length() == 0
                || cb_7.isChecked() && et_qty_7.getText().toString().equals("")  || cb_7.isChecked() && et_qty_7.length() == 0
                || cb_8.isChecked() && et_qty_8.getText().toString().equals("")  || cb_8.isChecked() && et_qty_8.length() == 0
                || cb_9.isChecked() && et_qty_9.getText().toString().equals("")  || cb_9.isChecked() && et_qty_9.length() == 0
                || cb_10.isChecked() && et_qty_10.getText().toString().equals("")  || cb_10.isChecked() && et_qty_10.length() == 0)
        {Toast.makeText(getApplicationContext(), "Please enter number of Reels for selected fields.", Toast.LENGTH_LONG).show();}

        else {
            int i_Gsm1 = Integer.parseInt(et_gsm_1.getText().toString());
            int i_Gsm2 = 0;
            if(!et_gsm_2.getText().toString().equals("")){
            i_Gsm2 = Integer.parseInt(et_gsm_2.getText().toString());}
            int i_Gsm3 = 0;
            if(!et_gsm_3.getText().toString().equals("")){
                i_Gsm3 = Integer.parseInt(et_gsm_3.getText().toString());}
            int i_Gsm4 = 0;
            if(!et_gsm_4.getText().toString().equals("")){
                i_Gsm4 = Integer.parseInt(et_gsm_4.getText().toString());}
            int i_Gsm5 = 0;
            if(!et_gsm_5.getText().toString().equals("")){
                i_Gsm5 = Integer.parseInt(et_gsm_5.getText().toString());}
            int i_Gsm6 = 0;
            if(!et_gsm_6.getText().toString().equals("")){
                i_Gsm6 = Integer.parseInt(et_gsm_6.getText().toString());}
            int i_Gsm7 = 0;
            if(!et_gsm_7.getText().toString().equals("")){
                i_Gsm7 = Integer.parseInt(et_gsm_7.getText().toString());}
            int i_Gsm8 = 0;
            if(!et_gsm_8.getText().toString().equals("")){
                i_Gsm8 = Integer.parseInt(et_gsm_8.getText().toString());}
            int i_Gsm9 = 0;
            if(!et_gsm_9.getText().toString().equals("")){
                i_Gsm9 = Integer.parseInt(et_gsm_9.getText().toString());}
            int i_Gsm10 = 0;
            if(!et_gsm_10.getText().toString().equals("")){
                i_Gsm10 = Integer.parseInt(et_gsm_10.getText().toString());}

            int i_Quantity1 = Integer.parseInt(et_qty_1.getText().toString());
            int i_Quantity2 = 0;
            if(!et_qty_2.getText().toString().equals("")){
                i_Quantity2 = Integer.parseInt(et_qty_2.getText().toString());}
            int i_Quantity3 = 0;
            if(!et_qty_3.getText().toString().equals("")){
                i_Quantity3 = Integer.parseInt(et_qty_3.getText().toString());}
            int i_Quantity4 = 0;
            if(!et_qty_4.getText().toString().equals("")){
                i_Quantity4 = Integer.parseInt(et_qty_4.getText().toString());}
            int i_Quantity5 = 0;
            if(!et_qty_5.getText().toString().equals("")){
                i_Quantity5 = Integer.parseInt(et_qty_5.getText().toString());}
            int i_Quantity6 = 0;
            if(!et_qty_6.getText().toString().equals("")){
                i_Quantity6 = Integer.parseInt(et_qty_6.getText().toString());}
            int i_Quantity7 = 0;
            if(!et_qty_7.getText().toString().equals("")){
                i_Quantity7 = Integer.parseInt(et_qty_7.getText().toString());}
            int i_Quantity8 = 0;
            if(!et_qty_8.getText().toString().equals("")){
                i_Quantity8 = Integer.parseInt(et_qty_8.getText().toString());}
            int i_Quantity9 = 0;
            if(!et_qty_9.getText().toString().equals("")){
                i_Quantity9 = Integer.parseInt(et_qty_9.getText().toString());}
            int i_Quantity10 = 0;
            if(!et_qty_10.getText().toString().equals("")){
                i_Quantity10 = Integer.parseInt(et_qty_10.getText().toString());}

            if (i_Gsm1 > maxGsm || i_Gsm1 < minGsm || cb_2.isChecked() && i_Gsm2 > maxGsm || cb_2.isChecked() && i_Gsm2 < minGsm || cb_3.isChecked() && i_Gsm3 > maxGsm || cb_3.isChecked() && i_Gsm3 < minGsm
                    || cb_4.isChecked() && i_Gsm4 > maxGsm || cb_4.isChecked() && i_Gsm4 < minGsm || cb_5.isChecked() && i_Gsm5 > maxGsm || cb_5.isChecked() && i_Gsm5 < minGsm || cb_6.isChecked() && i_Gsm6 > maxGsm ||
                    cb_6.isChecked() && i_Gsm6 < minGsm || cb_7.isChecked() && i_Gsm7 > maxGsm || cb_7.isChecked() && i_Gsm7 < minGsm || cb_8.isChecked() && i_Gsm8 > maxGsm || cb_8.isChecked() && i_Gsm8 < minGsm ||
                    cb_9.isChecked() && i_Gsm9 > maxGsm || cb_9.isChecked() && i_Gsm9 < minGsm || cb_10.isChecked() && i_Gsm10 > maxGsm || cb_10.isChecked() && i_Gsm10 < minGsm ) {
                Toast.makeText(OrderActivity.this, "Please enter GSM within specified range", Toast.LENGTH_LONG).show();
            }

            else if (i_Quantity1 < 1 || cb_2.isChecked() && i_Quantity2 < 1 || cb_3.isChecked() && i_Quantity3 < 1 || cb_4.isChecked() && i_Quantity4 < 1 || cb_5.isChecked() && i_Quantity5 < 1 ||
                    cb_6.isChecked() && i_Quantity6 < 1 || cb_7.isChecked() && i_Quantity7 < 1 || cb_8.isChecked() && i_Quantity8 < 1 || cb_9.isChecked() && i_Quantity9 < 1 ||
                    cb_10.isChecked() && i_Quantity10 < 1) {
                Toast.makeText(OrderActivity.this, "Minimum reel quantity is 1 per selected field", Toast.LENGTH_LONG).show();
            }

            else{
                Intent finalizeOrderActivityIntent = new Intent(OrderActivity.this, FinalizeOrderActivity.class);
                finalizeOrderActivityIntent.putExtra("listItemName", listItemName);
                finalizeOrderActivityIntent.putExtra("Email", Email);
                finalizeOrderActivityIntent.putExtra("BF", BF);
                finalizeOrderActivityIntent.putExtra("Price", Price);
                finalizeOrderActivityIntent.putExtra("insurance", Insurance);
                finalizeOrderActivityIntent.putExtra("payment_terms", payment_terms);
                finalizeOrderActivityIntent.putExtra("gsm1", et_gsm_1.getText().toString());
                finalizeOrderActivityIntent.putExtra("width1", et_width_1.getText().toString());
                finalizeOrderActivityIntent.putExtra("qty1", et_qty_1.getText().toString());
                finalizeOrderActivityIntent.putExtra("gsm2", et_gsm_2.getText().toString());
                finalizeOrderActivityIntent.putExtra("width2", et_width_2.getText().toString());
                finalizeOrderActivityIntent.putExtra("qty2", et_qty_2.getText().toString());
                finalizeOrderActivityIntent.putExtra("gsm3", et_gsm_3.getText().toString());
                finalizeOrderActivityIntent.putExtra("width3", et_width_3.getText().toString());
                finalizeOrderActivityIntent.putExtra("qty3", et_qty_3.getText().toString());
                finalizeOrderActivityIntent.putExtra("gsm4", et_gsm_4.getText().toString());
                finalizeOrderActivityIntent.putExtra("width4", et_width_4.getText().toString());
                finalizeOrderActivityIntent.putExtra("qty4", et_qty_4.getText().toString());
                finalizeOrderActivityIntent.putExtra("gsm5", et_gsm_5.getText().toString());
                finalizeOrderActivityIntent.putExtra("width5", et_width_5.getText().toString());
                finalizeOrderActivityIntent.putExtra("qty5", et_qty_5.getText().toString());
                finalizeOrderActivityIntent.putExtra("gsm6", et_gsm_6.getText().toString());
                finalizeOrderActivityIntent.putExtra("width6", et_width_6.getText().toString());
                finalizeOrderActivityIntent.putExtra("qty6", et_qty_6.getText().toString());
                finalizeOrderActivityIntent.putExtra("gsm7", et_gsm_7.getText().toString());
                finalizeOrderActivityIntent.putExtra("width7", et_width_7.getText().toString());
                finalizeOrderActivityIntent.putExtra("qty7", et_qty_7.getText().toString());
                finalizeOrderActivityIntent.putExtra("gsm8", et_gsm_8.getText().toString());
                finalizeOrderActivityIntent.putExtra("width8", et_width_8.getText().toString());
                finalizeOrderActivityIntent.putExtra("qty8", et_qty_8.getText().toString());
                finalizeOrderActivityIntent.putExtra("gsm9", et_gsm_9.getText().toString());
                finalizeOrderActivityIntent.putExtra("width9", et_width_9.getText().toString());
                finalizeOrderActivityIntent.putExtra("qty9", et_qty_9.getText().toString());
                finalizeOrderActivityIntent.putExtra("gsm10", et_gsm_10.getText().toString());
                finalizeOrderActivityIntent.putExtra("width10", et_width_10.getText().toString());
                finalizeOrderActivityIntent.putExtra("qty10", et_qty_10.getText().toString());
                startActivity(finalizeOrderActivityIntent);
            }
        }
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        cb_2.setOnCheckedChangeListener(new OrderActivity.CheckedChangeListenerClass(1));
        cb_3.setOnCheckedChangeListener(new OrderActivity.CheckedChangeListenerClass(2));
        cb_4.setOnCheckedChangeListener(new OrderActivity.CheckedChangeListenerClass(3));
        cb_5.setOnCheckedChangeListener(new OrderActivity.CheckedChangeListenerClass(4));
        cb_6.setOnCheckedChangeListener(new OrderActivity.CheckedChangeListenerClass(5));
        cb_7.setOnCheckedChangeListener(new OrderActivity.CheckedChangeListenerClass(6));
        cb_8.setOnCheckedChangeListener(new OrderActivity.CheckedChangeListenerClass(7));
        cb_9.setOnCheckedChangeListener(new OrderActivity.CheckedChangeListenerClass(8));
        cb_10.setOnCheckedChangeListener(new OrderActivity.CheckedChangeListenerClass(9));
    }

    public class CheckedChangeListenerClass implements CompoundButton.OnCheckedChangeListener {
        final int position;
        public CheckedChangeListenerClass (int position) {
            this.position = position;
        }

        private void changeVisibility(EditText et1, EditText et2, EditText et3, boolean isChecked){
            if (isChecked) {
                et1.setVisibility(View.VISIBLE);
                et2.setVisibility(View.VISIBLE);
                et3.setVisibility(View.VISIBLE);
            } else {
                et1.setVisibility(View.GONE);
                et1.setText("");
                et2.setVisibility(View.GONE);
                et2.setText("");
                et3.setVisibility(View.GONE);
                et3.setText("");
            }
        }

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            switch (position) {
                case 1:
                    changeVisibility(et_gsm_2, et_width_2, et_qty_2, isChecked);
                    break;
                case 2:
                    changeVisibility(et_gsm_3, et_width_3, et_qty_3, isChecked);
                    break;
                case 3:
                    changeVisibility(et_gsm_4, et_width_4, et_qty_4, isChecked);
                    break;
                case 4:
                    changeVisibility(et_gsm_5, et_width_5, et_qty_5, isChecked);
                    break;
                case 5:
                    changeVisibility(et_gsm_6, et_width_6, et_qty_6, isChecked);
                    break;
                case 6:
                    changeVisibility(et_gsm_7, et_width_7, et_qty_7, isChecked);
                    break;
                case 7:
                    changeVisibility(et_gsm_8, et_width_8, et_qty_8, isChecked);
                    break;
                case 8:
                    changeVisibility(et_gsm_9, et_width_9, et_qty_9, isChecked);
                    break;
                case 9:
                    changeVisibility(et_gsm_10, et_width_10, et_qty_10, isChecked);
                    break;
            }
        }
    }
}