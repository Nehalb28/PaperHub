package com.example.android.procnect;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.app.ProgressDialog;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    private EditText et_Email;
    private EditText et_Password;
    private String email;
    private String password;
    public final static String regEx = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,4}";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_Email = findViewById(R.id.etEmail);
        et_Password = findViewById(R.id.etPassword);
        Button b_Login = findViewById(R.id.bLogin);
        Button b_Register = findViewById(R.id.button_register_loginactivity);
        TextView tv_ForgotPassword = findViewById(R.id.tv_forgot_password);
        CheckBox cb_ShowHidePassword = findViewById(R.id.cb_ShowHidePpassword);

        Intent intent = getIntent();
        String action = intent.getAction();
        Uri data = intent.getData();

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            getSupportActionBar().setCustomView(R.layout.app_title);
        }

        tv_ForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent forgotpasswordIntent = new Intent(LoginActivity.this, ForgotPassword.class);
                    startActivity(forgotpasswordIntent);
                }
        });

        b_Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                {
                    Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                    LoginActivity.this.startActivity(registerIntent);
                }
            }
        });

        cb_ShowHidePassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    et_Password.setInputType(InputType.TYPE_CLASS_TEXT);
                    et_Password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    et_Password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    et_Password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }

            }
        });

        b_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = et_Email.getText().toString();
                password = et_Password.getText().toString();
                checkValidation();
            }
        });
    }

    private void checkValidation() {
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(email);
        if (email.equals("") || email.length() == 0
                || password.equals("") || password.length() == 0) {
            Toast.makeText(getApplicationContext(), "Enter both credentials.", Toast.LENGTH_LONG).show();}
        else if (!m.find()) {
            Toast.makeText(getApplicationContext(), "Your Email Id is Invalid.", Toast.LENGTH_LONG).show();}
        else {
            final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this, R.style.Theme_AppCompat_Light_Dialog);
            progressDialog.setIndeterminate(true);
            progressDialog.setMessage("Authenticating...");
            progressDialog.show();

            Response.Listener<String> responseListener = new Response.Listener<String>() {
                @Override
                public void onResponse(final String response) {
                    try {
                        JSONObject jsonResponse = new JSONObject(response);
                        boolean success = jsonResponse.getBoolean("success");
                        if (success) {
                            progressDialog.dismiss();
                            String vendortype = jsonResponse.getString("vendortype");
                            Intent recyclerViewActivityIntent = new Intent(LoginActivity.this, QueryEntityActivity.class);
                            Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_LONG).show();
                            SaveSharedPreference.setUserName(LoginActivity.this, email);
                            SaveSharedPreference.setVendorType(LoginActivity.this, vendortype);
                            recyclerViewActivityIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            LoginActivity.this.startActivity(recyclerViewActivityIntent);
                            finish();

                        } else {
                            progressDialog.dismiss();
                            final AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this, R.style.Theme_AppCompat_Light_Dialog);
                            builder.setMessage("Login failed").setNegativeButton("Retry", null).create().show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            };

            LoginRequest loginRequest = new LoginRequest(email, password, responseListener);
            RequestQueue requestQueue = Volley.newRequestQueue(LoginActivity.this);
            requestQueue.add(loginRequest);
        }
    }
}
