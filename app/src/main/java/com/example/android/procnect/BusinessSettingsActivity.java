package com.example.android.procnect;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

 public class BusinessSettingsActivity extends AppCompatActivity {

    private CheckBox cb_14, cb_16, cb_18, cb_20, cb_22, cb_25, cb_28, cb_30, cb_32, cb_35;
    private EditText et_price_14, et_price_16, et_price_18, et_price_20, et_price_22, et_price_25, et_price_28, et_price_30, et_price_32, et_price_35;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_settings);

        cb_14 = findViewById(R.id.cb_bf14);
        cb_16 = findViewById(R.id.cb_bf16);
        cb_18 = findViewById(R.id.cb_bf18);
        cb_20 = findViewById(R.id.cb_bf20);
        cb_22 = findViewById(R.id.cb_bf22);
        cb_25 = findViewById(R.id.cb_bf25);
        cb_28 = findViewById(R.id.cb_bf28);
        cb_30 = findViewById(R.id.cb_bf30);
        cb_32 = findViewById(R.id.cb_bf32);
        cb_35 = findViewById(R.id.cb_bf35);
        et_price_14 = findViewById(R.id.et_price_bf14);
        et_price_16 = findViewById(R.id.et_price_bf16);
        et_price_18 = findViewById(R.id.et_price_bf18);
        et_price_20 = findViewById(R.id.et_price_bf20);
        et_price_22 = findViewById(R.id.et_price_bf22);
        et_price_25 = findViewById(R.id.et_price_bf25);
        et_price_28 = findViewById(R.id.et_price_bf28);
        et_price_30 = findViewById(R.id.et_price_bf30);
        et_price_32 = findViewById(R.id.et_price_bf32);
        et_price_35 = findViewById(R.id.et_price_bf35);

        final Button b_Next = findViewById(R.id.bNext);

        b_Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkValidation();
            }
        });
    }

    private void checkValidation() {

        final String st_14, st_16, st_18, st_20, st_22, st_25, st_28, st_30, st_32, st_35;

        if(cb_14.isChecked() && et_price_14.getText().toString().equals("")  || cb_14.isChecked() && et_price_14.length() == 0
                || cb_16.isChecked() && et_price_16.getText().toString().equals("")  || cb_16.isChecked() && et_price_16.length() == 0
                || cb_18.isChecked() && et_price_18.getText().toString().equals("")  || cb_18.isChecked() && et_price_18.length() == 0
                || cb_20.isChecked() && et_price_20.getText().toString().equals("")  || cb_20.isChecked() && et_price_20.length() == 0
                || cb_22.isChecked() && et_price_22.getText().toString().equals("")  || cb_22.isChecked() && et_price_22.length() == 0
                || cb_25.isChecked() && et_price_25.getText().toString().equals("")  || cb_25.isChecked() && et_price_25.length() == 0
                || cb_28.isChecked() && et_price_28.getText().toString().equals("")  || cb_28.isChecked() && et_price_28.length() == 0
                || cb_30.isChecked() && et_price_30.getText().toString().equals("")  || cb_30.isChecked() && et_price_30.length() == 0
                || cb_32.isChecked() && et_price_32.getText().toString().equals("")  || cb_32.isChecked() && et_price_32.length() == 0
                || cb_35.isChecked() && et_price_35.getText().toString().equals("")  || cb_35.isChecked() && et_price_35.length() == 0)
        {Toast.makeText(getApplicationContext(), "Please enter price for selected fields.", Toast.LENGTH_LONG).show();}

        else {

            if(et_price_14.getText().toString().equals("")  || et_price_14.length() == 0){
                st_14 = SaveSharedPreference.getPbf14(this);
            }
            else{
                st_14 = et_price_14.getText().toString();
                SaveSharedPreference.setPbf14(this, st_14);
            }

            if(et_price_16.getText().toString().equals("")  || et_price_16.length() == 0){
                st_16 = SaveSharedPreference.getPbf16(this);
            }
            else{
                st_16 = et_price_16.getText().toString();
                SaveSharedPreference.setPbf16(this, st_16);
            }

            if(et_price_18.getText().toString().equals("")  || et_price_18.length() == 0){
                st_18 = SaveSharedPreference.getPbf18(this);
            }
            else{
                st_18 = et_price_18.getText().toString();
                SaveSharedPreference.setPbf18(this, st_18);
            }

            if(et_price_20.getText().toString().equals("")  || et_price_20.length() == 0){
                st_20 = SaveSharedPreference.getPbf20(this);
            }
            else{
                st_20 = et_price_20.getText().toString();
                SaveSharedPreference.setPbf20(this, st_20);
            }

            if(et_price_22.getText().toString().equals("")  || et_price_22.length() == 0){
                st_22= SaveSharedPreference.getPbf22(this);
            }
            else{
                st_22 = et_price_22.getText().toString();
                SaveSharedPreference.setPbf22(this, st_22);
            }

            if(et_price_25.getText().toString().equals("")  || et_price_25.length() == 0){
                st_25 = SaveSharedPreference.getPbf25(this);
            }
            else{
                st_25 = et_price_25.getText().toString();
                SaveSharedPreference.setPbf25(this, st_25);
            }

            if(et_price_28.getText().toString().equals("")  || et_price_28.length() == 0){
                st_28 = SaveSharedPreference.getPbf28(this);
            }
            else{
                st_28 = et_price_28.getText().toString();
                SaveSharedPreference.setPbf28(this, st_28);
            }

            if(et_price_30.getText().toString().equals("")  || et_price_30.length() == 0){
                st_30 = SaveSharedPreference.getPbf30(this);
            }
            else{
                st_30 = et_price_30.getText().toString();
                SaveSharedPreference.setPbf30(this, st_30);
            }

            if(et_price_32.getText().toString().equals("")  || et_price_32.length() == 0){
                st_32 = SaveSharedPreference.getPbf32(this);
            }
            else{
                st_32 = et_price_32.getText().toString();
                SaveSharedPreference.setPbf32(this, st_32);
            }

            if(et_price_35.getText().toString().equals("")  || et_price_35.length() == 0){
                st_35 = SaveSharedPreference.getPbf35(this);
            }
            else{
                st_35 = et_price_35.getText().toString();
                SaveSharedPreference.setPbf35(this, st_35);
            }

            Intent businessSettingsIntent = new Intent(BusinessSettingsActivity.this, BusinessSettingsActivityNext.class);
            businessSettingsIntent.putExtra("st_14", st_14);
            businessSettingsIntent.putExtra("st_16", st_16);
            businessSettingsIntent.putExtra("st_18", st_18);
            businessSettingsIntent.putExtra("st_20", st_20);
            businessSettingsIntent.putExtra("st_22", st_22);
            businessSettingsIntent.putExtra("st_25", st_25);
            businessSettingsIntent.putExtra("st_28", st_28);
            businessSettingsIntent.putExtra("st_30", st_30);
            businessSettingsIntent.putExtra("st_32", st_32);
            businessSettingsIntent.putExtra("st_35", st_35);
            BusinessSettingsActivity.this.startActivity(businessSettingsIntent);
        }
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        cb_14.setOnCheckedChangeListener(new CheckedChangeListenerClass(1));
        cb_16.setOnCheckedChangeListener(new CheckedChangeListenerClass(2));
        cb_18.setOnCheckedChangeListener(new CheckedChangeListenerClass(3));
        cb_20.setOnCheckedChangeListener(new CheckedChangeListenerClass(4));
        cb_22.setOnCheckedChangeListener(new CheckedChangeListenerClass(5));
        cb_25.setOnCheckedChangeListener(new CheckedChangeListenerClass(6));
        cb_28.setOnCheckedChangeListener(new CheckedChangeListenerClass(7));
        cb_30.setOnCheckedChangeListener(new CheckedChangeListenerClass(8));
        cb_32.setOnCheckedChangeListener(new CheckedChangeListenerClass(9));
        cb_35.setOnCheckedChangeListener(new CheckedChangeListenerClass(10));
    }

    public class CheckedChangeListenerClass implements CompoundButton.OnCheckedChangeListener {
        final int position;
        public CheckedChangeListenerClass (int position) {
            this.position = position;
        }

        private void changeVisibility(EditText et, boolean isChecked){
            if (isChecked) {
                et.setVisibility(View.VISIBLE);
            } else {
                et.setVisibility(View.GONE);
                et.setText("");
            }
        }

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            switch (position) {
                case 1:
                    changeVisibility(et_price_14, isChecked);
                    break;
                case 2:
                    changeVisibility(et_price_16, isChecked);
                    break;
                case 3:
                    changeVisibility(et_price_18, isChecked);
                    break;
                case 4:
                    changeVisibility(et_price_20, isChecked);
                    break;
                case 5:
                    changeVisibility(et_price_22, isChecked);
                    break;
                case 6:
                    changeVisibility(et_price_25, isChecked);
                    break;
                case 7:
                    changeVisibility(et_price_28, isChecked);
                    break;
                case 8:
                    changeVisibility(et_price_30, isChecked);
                    break;
                case 9:
                    changeVisibility(et_price_32, isChecked);
                    break;
                case 10:
                    changeVisibility(et_price_35, isChecked);
                    break;
            }
        }
    }
}
