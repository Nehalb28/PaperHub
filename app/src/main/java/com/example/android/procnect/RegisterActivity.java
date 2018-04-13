package com.example.android.procnect;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.PlaceBuffer;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

import org.json.JSONException;
import org.json.JSONObject;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity implements
        GoogleApiClient.OnConnectionFailedListener, GoogleApiClient.ConnectionCallbacks {

    private AutoCompleteTextView et_Location;
    private static final int GOOGLE_API_CLIENT_ID = 0;
    private GoogleApiClient mGoogleApiClient;
    private PlaceArrayAdapter mPlaceArrayAdapter;
    private static final LatLngBounds BOUNDS_INDIA =
            new LatLngBounds(new LatLng(23.63936, 68.14712), new LatLng(28.20453, 97.34466));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mGoogleApiClient = new GoogleApiClient.Builder(RegisterActivity.this)
                .addApi(Places.GEO_DATA_API)
                .enableAutoManage(this, GOOGLE_API_CLIENT_ID, this)
                .addConnectionCallbacks(this)
                .build();

        et_Location = findViewById(R.id.etLocation);
        et_Location.setThreshold(3);

        et_Location.setOnItemClickListener(mAutocompleteClickListener);
        mPlaceArrayAdapter = new PlaceArrayAdapter(this,
                BOUNDS_INDIA);
        et_Location.setAdapter(mPlaceArrayAdapter);

        final Button b_Register = findViewById(R.id.bRegister);

        b_Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkValidation();
            }
        });
    }

    private final AdapterView.OnItemClickListener mAutocompleteClickListener
            = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            final PlaceArrayAdapter.PlaceAutocomplete item = mPlaceArrayAdapter.getItem(position);
            final String placeId = String.valueOf(item != null ? item.placeId : null);
            PendingResult<PlaceBuffer> placeResult = Places.GeoDataApi.getPlaceById(mGoogleApiClient, placeId);
            placeResult.setResultCallback(mUpdatePlaceDetailsCallback);
        }
    };

    private final ResultCallback<PlaceBuffer> mUpdatePlaceDetailsCallback
            = new ResultCallback<PlaceBuffer>() {
        @Override
        public void onResult(@NonNull PlaceBuffer places) {
            if (!places.getStatus().isSuccess()) {
                return;
            }

            final Place place = places.get(0);
            et_Location.setText(place.getName());
            SaveSharedPreference.setLocation(RegisterActivity.this, place.getName().toString());
            /*CharSequence attributions = places.getAttributions();
            if (attributions != null) {
                SaveSharedPreference.setLocation(QueryEntityActivity.this, place.getName().toString());
                et_EntityQuery.setText(place.getName());
                et_EntityQuery.setText(Html.fromHtml(attributions.toString()));
            }*/
        }
    };

    @Override
    public void onConnected(Bundle bundle) {
        mPlaceArrayAdapter.setGoogleApiClient(mGoogleApiClient);
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

        Toast.makeText(this, "Google Places API connection failed with error code:" +
                connectionResult.getErrorCode(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onConnectionSuspended(int i) {
        mPlaceArrayAdapter.setGoogleApiClient(null);
    }

        private void checkValidation() {

            final String gstCheck = "[0-9]{2}+[A-Za-z0-9]{10}+[0-9]+[A-Za-z]+[A-Za-z0-9]";
            final ProgressDialog progressDialog = new ProgressDialog(RegisterActivity.this, R.style.Theme_AppCompat_Light_Dialog);
            progressDialog.setIndeterminate(true);
            progressDialog.setMessage("Registering...");

            final CheckBox cb_TermsAndConditions = findViewById(R.id.cb_terms_conditions);
            final EditText et_Name = findViewById(R.id.etName);
            final EditText et_Email = findViewById(R.id.etEmail);
            final EditText et_Password = findViewById(R.id.etPassword);
            final RadioGroup radioGroup = findViewById(R.id.spVendortype);
            final EditText et_Phone = findViewById(R.id.etPhone);
            final EditText et_Gstin = findViewById(R.id.etGst);
            final EditText et_Address = findViewById(R.id.etAddress);
            final EditText et_Ques1 = findViewById(R.id.etQues1);
            final EditText et_Ques2 = findViewById(R.id.etQues2);

            final String name = et_Name.getText().toString();
            final String email = et_Email.getText().toString();
            final String location = et_Location.getText().toString();
            final String password = et_Password.getText().toString();
            final String vendortype = ((RadioButton) findViewById(radioGroup.getCheckedRadioButtonId())).getText().toString();
            final String phone = et_Phone.getText().toString();
            final String gstin = et_Gstin.getText().toString();
            final String address = et_Address.getText().toString();
            final String ques1 = et_Ques1.getText().toString();
            final String ques2 = et_Ques2.getText().toString();

            Pattern pattern = Pattern.compile(LoginActivity.regEx);
            Matcher matcher = pattern.matcher(email);
            Pattern gstPattern = Pattern.compile(gstCheck);
            Matcher gstMatcher = gstPattern.matcher(gstin);

            if (name.equals("") || name.length() == 0
                    || et_Email.getText().toString().equals("") || et_Email.length() == 0
                    || et_Password.getText().toString().equals("") || et_Password.length() == 0) {
                Toast.makeText(getApplicationContext(), "Please enter company name.", Toast.LENGTH_LONG).show();
            }
            else if (!matcher.find()) {
                Toast.makeText(getApplicationContext(), "Your Email Id is Invalid.", Toast.LENGTH_LONG).show();
            }
            else if (password.length() < 6){
                Toast.makeText(getApplicationContext(), "Password should be atleast 6 digits.", Toast.LENGTH_LONG).show();
            }
            else if (location.equals("") || location.length() == 0){
                Toast.makeText(getApplicationContext(), "Please enter city.", Toast.LENGTH_LONG).show();
            }
            else if (phone.equals("") || phone.length() != 10){
                Toast.makeText(getApplicationContext(), "Your mobile number is invalid. Please enter 10 digit mobile number.", Toast.LENGTH_LONG).show();
            }
            else if (gstin.equals("") || gstin.length() == 0){
                Toast.makeText(getApplicationContext(), "Please enter GSTIN.", Toast.LENGTH_LONG).show();
            }
            else if (gstin.length() != 15 || !gstMatcher.find()){
                Toast.makeText(getApplicationContext(), "Your GSTIN is invalid.", Toast.LENGTH_LONG).show();
            }
            else if (address.length() == 0 || address.equals("")){
                Toast.makeText(getApplicationContext(), "Please enter shipping address.", Toast.LENGTH_LONG).show();
            }
            else if (ques1.equals("") || ques1.length() == 0 || ques2.equals("") || ques2.length() == 0){
                Toast.makeText(getApplicationContext(), "Please enter answers to secret questions.", Toast.LENGTH_LONG).show();
            }
            else if (!cb_TermsAndConditions.isChecked()) {
                Toast.makeText(getApplicationContext(), "Please select Terms and Conditions.", Toast.LENGTH_LONG).show();
            }
            else {
                progressDialog.show();
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            progressDialog.dismiss();
                            boolean success = jsonResponse.getBoolean("success");
                            if (success) {
                                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                RegisterActivity.this.startActivity(intent);
                                Toast.makeText(getApplicationContext(), "Registration succesful", Toast.LENGTH_LONG).show();
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this, R.style.Theme_AppCompat_Light_Dialog);
                                builder.setMessage("Regitration failed. Email id already registered").setNegativeButton("Retry", null).create().show();
                            }
                        } catch (JSONException e) {
                            progressDialog.dismiss();
                            AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this, R.style.Theme_AppCompat_Light_Dialog);
                            builder.setMessage("Regitration failed. JSON response error").setNegativeButton("Retry", null).create().show();
                            e.printStackTrace();
                        }
                    }
                };
                RegisterRequest registerRequest = new RegisterRequest(name, gstin, phone, location, vendortype, email, password, ques1, ques2, address, responseListener);
                RequestQueue requestQueue = Volley.newRequestQueue(RegisterActivity.this);
                requestQueue.add(registerRequest);
            }
        }
    }
