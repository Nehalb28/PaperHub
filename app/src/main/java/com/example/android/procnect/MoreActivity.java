package com.example.android.procnect;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MoreActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);

        final TextView tv_Profile = findViewById(R.id.tv_profile);
        final TextView tv_Share = findViewById(R.id.tv_share);
        final TextView tv_Feedback = findViewById(R.id.tv_feedback);
        final TextView tv_Logout = findViewById(R.id.tv_logout);
        final TextView tv_RateUs = findViewById(R.id.tv_rateus);

        tv_Profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent profileActivityIntent = new Intent(MoreActivity.this, ProfileActivity.class);
                startActivity(profileActivityIntent);
            }
        });

        tv_Share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);

                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, "www.bedhubs.com");
                startActivity(Intent.createChooser(intent, "Share"));
            }
        });

        tv_Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SaveSharedPreference.logoutUser(MoreActivity.this);
                Intent loginActivityIntent = new Intent(MoreActivity.this, LoginActivity.class);
                loginActivityIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                loginActivityIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                Toast.makeText(MoreActivity.this, "Logout Successful", Toast.LENGTH_LONG).show();
                startActivity(loginActivityIntent);
            }
        });

        tv_RateUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("market://details?id=" + MoreActivity.this.getPackageName());
                Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                        Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                try {
                    startActivity(goToMarket);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://play.google.com/store/apps/details?id=" + MoreActivity.this.getPackageName())));
                }
            }
        });

        tv_Feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent feedbackActivityIntent = new Intent(MoreActivity.this, FeedbackActivity.class);
                startActivity(feedbackActivityIntent);
            }
        });
    }
}
