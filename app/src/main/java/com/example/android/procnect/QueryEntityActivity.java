package com.example.android.procnect;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.PlaceBuffer;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;


public class QueryEntityActivity extends AppCompatActivity implements
        GoogleApiClient.OnConnectionFailedListener, GoogleApiClient.ConnectionCallbacks {

    private AutoCompleteTextView et_EntityQuery;
    private static final int GOOGLE_API_CLIENT_ID = 0;
    private GoogleApiClient mGoogleApiClient;
    private PlaceArrayAdapter mPlaceArrayAdapter;
    private static final LatLngBounds BOUNDS_INDIA =
            new LatLngBounds(new LatLng(23.63936, 68.14712), new LatLng(28.20453, 97.34466));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query_entity);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            getSupportActionBar().setCustomView(R.layout.app_title);
        }

        if (SaveSharedPreference.getUserName(this).length() == 0
                || SaveSharedPreference.getVendorType(this).length() == 0) {
            // call Login Activity
            Intent loginActivityIntent = new Intent(QueryEntityActivity.this, LoginActivity.class);
            loginActivityIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            loginActivityIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(loginActivityIntent);
            finish();
        } else {
            final BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
            BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);

            mGoogleApiClient = new GoogleApiClient.Builder(QueryEntityActivity.this)
                    .addApi(Places.GEO_DATA_API)
                    .enableAutoManage(this, GOOGLE_API_CLIENT_ID, this)
                    .addConnectionCallbacks(this)
                    .build();

            et_EntityQuery = findViewById(R.id.et_entityQuery);
            et_EntityQuery.setThreshold(3);

            et_EntityQuery.setOnItemClickListener(mAutocompleteClickListener);
            mPlaceArrayAdapter = new PlaceArrayAdapter(this,
                    BOUNDS_INDIA);
            et_EntityQuery.setAdapter(mPlaceArrayAdapter);

            final Button b_Search = findViewById(R.id.button_search);

            b_Search.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent recyclerViewIntent = new Intent(QueryEntityActivity.this, RecyclerViewActivity.class);
                    startActivity(recyclerViewIntent);
                }
            });

            bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.action_home:
                            Intent recyclerViewIntent = new Intent(QueryEntityActivity.this, QueryEntityActivity.class);
                            recyclerViewIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            QueryEntityActivity.this.startActivity(recyclerViewIntent);
                            break;

                        case R.id.action_settings:
                            if (SaveSharedPreference.getVendorType(QueryEntityActivity.this).equals("Paper Manufacturer") ) {
                                Intent businessSettingsActivityIntent = new Intent(QueryEntityActivity.this, BusinessSettingsActivity.class);
                                businessSettingsActivityIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                QueryEntityActivity.this.startActivity(businessSettingsActivityIntent);
                                break;
                            }
                            else{
                                Toast.makeText(QueryEntityActivity.this, "Settings is not accessible for your account", Toast.LENGTH_LONG).show();
                                break;
                            }
                        case R.id.action_sale_orders:
                            Intent userprofileIntent = new Intent(QueryEntityActivity.this, SalesOrderSummaryActivity.class);
                            userprofileIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            QueryEntityActivity.this.startActivity(userprofileIntent);
                            break;

                        case R.id.action_purchase_orders:
                            Intent feedbackActivityIntent = new Intent(QueryEntityActivity.this, OrderSummaryActivity.class);
                            feedbackActivityIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            QueryEntityActivity.this.startActivity(feedbackActivityIntent);
                            break;

                        case R.id.action_more:
                            Intent moreActivityIntent = new Intent(QueryEntityActivity.this, MoreActivity.class);
                            moreActivityIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            QueryEntityActivity.this.startActivity(moreActivityIntent);
                            break;
                    }
                    return true;
                }
            });
        }
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
            et_EntityQuery.setText(place.getName());
            SaveSharedPreference.setLocation(QueryEntityActivity.this, place.getName().toString());
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
}
