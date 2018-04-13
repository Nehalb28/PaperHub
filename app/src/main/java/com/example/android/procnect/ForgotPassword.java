package com.example.android.procnect;
import android.app.ProgressDialog;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Button;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import android.content.Intent;



public class ForgotPassword extends AppCompatActivity {

    private EditText et_RegisteredEmail;
    private EditText et_Ques1;
    private EditText et_Ques2;
    private String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        et_RegisteredEmail = findViewById(R.id.et_registered_emailid);
        et_Ques1 = findViewById(R.id.et_Ques1);
        et_Ques2 = findViewById(R.id.et_Ques2);
        final Button b_Submit = findViewById(R.id.bSubmit);

        b_Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitButtonTask();
            }
        });
    }

    private void submitButtonTask() {
        email = et_RegisteredEmail.getText().toString();
        String ques1 = et_Ques1.getText().toString();
        String ques2 = et_Ques2.getText().toString();
        Pattern p = Pattern.compile(LoginActivity.regEx);
        Matcher m = p.matcher(email);
        if (et_RegisteredEmail.getText().toString().equals("") || et_RegisteredEmail.length() == 0
                || et_Ques1.getText().toString().equals("") || et_Ques1.length() == 0
                || et_Ques2.getText().toString().equals("") || et_Ques2.length() == 0){
            Toast.makeText(getApplicationContext(), "Please enter all credentials.", Toast.LENGTH_LONG).show();}
        else if (!m.find()){
            Toast.makeText(getApplicationContext(), "Your Email Id is Invalid.", Toast.LENGTH_LONG).show();}
        else{
            final ProgressDialog progressDialog = new ProgressDialog(ForgotPassword.this, R.style.Theme_AppCompat_Light_Dialog);
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
                            Toast.makeText(getApplicationContext(), "Authentication Successful.", Toast.LENGTH_LONG).show();
                            Intent passwordChangeIntent = new Intent(ForgotPassword.this, PasswordChangeActivity.class);
                            passwordChangeIntent.putExtra("email", email);
                            ForgotPassword.this.startActivity(passwordChangeIntent);

                        } else {
                            progressDialog.dismiss();
                            AlertDialog.Builder builder = new AlertDialog.Builder(ForgotPassword.this, R.style.Theme_AppCompat_Light_Dialog);
                            builder.setMessage("Your credentials do not match.").setNegativeButton("Retry", null).create().show();
                        }
                    } catch (JSONException e) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(ForgotPassword.this, R.style.Theme_AppCompat_Light_Dialog);
                        builder.setMessage("Authentication Failed. JSON Response Error").setNegativeButton("Retry", null).create().show();
                        e.printStackTrace();
                    }
                }
            };
            VerifyEmailRequest verifyEmailRequest = new VerifyEmailRequest(email, ques1, ques2, responseListener);
            RequestQueue requestQueue = Volley.newRequestQueue(ForgotPassword.this);
            requestQueue.add(verifyEmailRequest);
        }
    }
}
