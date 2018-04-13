package com.example.android.procnect;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FeedbackActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitvity_feedback);

        final Spinner sp_Feedback = findViewById(R.id.sp_feedback);
        final EditText et_Feedback = findViewById(R.id.et_feedback);
        final Button b_Feedback = findViewById(R.id.button_feedback);

        b_Feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    public void run() {
                try {
                    String feedbackContent = et_Feedback.getText().toString();
                    String feedbackSubject = sp_Feedback.getSelectedItem().toString();
                    List<String> emailList = new ArrayList<>();
                    emailList.add(SaveSharedPreference.getUserName(FeedbackActivity.this));
                    emailList.add("abhipaliwal@gmail.com");
                    String finalList = emailList.toString();
                    String recipients = finalList.substring(1, finalList.length() -1);
                    String emailBody = "Dear Partner, \n\n" + feedbackContent + "\n\nThanks, " +
                            "\nTeam Procnect";
                    GMailSender sender = new GMailSender(
                            "info@alpanahotels.com",
                            "#Sharep0int");
                    //sender.addAttachment(Environment.getExternalStorageDirectory().getPath()+"/image.jpg");
                    sender.sendMail("Feedback: "+feedbackSubject, emailBody,
                            "info@alpanahotels.com", recipients);
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Error in feedback submission. Please contact help desk.", Toast.LENGTH_LONG).show();
                }
                    }
                }).start();
                Toast.makeText(FeedbackActivity.this, "Feedback submitted successfully.", Toast.LENGTH_LONG).show();
            }
        });
    }
}
