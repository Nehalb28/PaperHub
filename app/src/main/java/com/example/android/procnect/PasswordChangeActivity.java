package com.example.android.procnect;

import android.app.ProgressDialog;
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

public class PasswordChangeActivity extends AppCompatActivity {

    private String sPassword;
    private String sConfirmPassword;
    private String email;
    private EditText password;
    private EditText confirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_change);

        password = findViewById(R.id.et_password_change);
        confirmPassword = findViewById(R.id.et_password_change_confirm);
        final Button bSubmit = findViewById(R.id.bSubmit);
        Intent passwordChangeIntent = getIntent();
        email = passwordChangeIntent.getStringExtra("email");

        bSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sPassword = password.getText().toString();
                sConfirmPassword = confirmPassword.getText().toString();
                if (!sPassword.equals(sConfirmPassword))
                {
                    Toast.makeText(getApplicationContext(), "Passwords do not match", Toast.LENGTH_LONG).show();
                }
                else if (sPassword.length() < 6){
                    Toast.makeText(getApplicationContext(), "Password should be atleast 6 digits.", Toast.LENGTH_LONG).show();
                }
                else
                {
                    final ProgressDialog progressDialog = new ProgressDialog(PasswordChangeActivity.this, R.style.Theme_AppCompat_Light_Dialog);
                    progressDialog.setIndeterminate(true);
                    progressDialog.setMessage("Authenticating...");
                    progressDialog.show();

                    Response.Listener<String> responseListener = new Response.Listener<String>() {
                        @Override
                        public void onResponse(final String response) {
                            try {
                                JSONObject jsonResponse = new JSONObject(response);
                                boolean success = jsonResponse.getBoolean("success");
                                if (success)
                                {
                                    progressDialog.dismiss();
                                    Toast.makeText(getApplicationContext(), "Password changed successfully.", Toast.LENGTH_LONG).show();
                                    Intent loginActivityIntent = new Intent(PasswordChangeActivity.this, LoginActivity.class);
                                    PasswordChangeActivity.this.startActivity(loginActivityIntent);
                                }
                                else
                                {
                                    progressDialog.dismiss();
                                    AlertDialog.Builder builder = new AlertDialog.Builder(PasswordChangeActivity.this, R.style.Theme_AppCompat_Light_Dialog);
                                    builder.setMessage("Password Reset Failed").setNegativeButton("Retry", null).create().show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                                AlertDialog.Builder builder = new AlertDialog.Builder(PasswordChangeActivity.this, R.style.Theme_AppCompat_Light_Dialog);
                                builder.setMessage("Authentication Failed. JSON Response Error").setNegativeButton("Retry", null).create().show();
                            }
                        }
                    };

                    PasswordChangeRequest loginRequest = new PasswordChangeRequest(sPassword, email, responseListener);
                    RequestQueue requestQueue = Volley.newRequestQueue(PasswordChangeActivity.this);
                    requestQueue.add(loginRequest);
                }
            }
        });

    }
}
