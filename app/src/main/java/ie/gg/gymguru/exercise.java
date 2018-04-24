package ie.gg.gymguru;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.google.firebase.database.DataSnapshot;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;


public class exercise extends AppCompatActivity implements LocationListener {

    private FirebaseAuth mAuth;

    private DatabaseReference mDatabaseUserPastResults, mDatabaseUserCurrResults, mDatbaseExercise, mDatbaseUser1WeekWeights, mDatbaseUser1WeekReps;
    private DatabaseReference mDatabaseDates;
    private DatabaseReference mDatbaseUserLoc;

    private LocationManager locationManager;
    private Geocoder geocoder;

    List<Address> addresses;
    private int rowChanged;

    Location location;

    private Activity activity;

    Double latitude, longitude;

    private TextView mNameView, mNumberOfSets;

    private ImageView mExercisePic;
    private int pressed=0;

    private ArrayList<Date> dates = new ArrayList<>();

    private Button addBtn;

    private EditText mRep1, mRep2, mRep3, mRep4, mRep5;
    private EditText mWeight1, mWeight2, mWeight3, mWeight4, mWeight5;

    Date e;

    String reps1="";
    String reps2="";
    String reps3="";
    String reps4 = "";
    String reps5 = "";

    String weights1 = "";
    String weights2 = "";
    String weights3 = "";
    String weights4 = "";
    String weights5 = "";

    String strDt="10-04-2018";
    String user_id;

    private String exercise;
    // = "bench_press"
    private int numberOfSets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercise);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        //numberOfSets = 5;

        //exercise = "bench_press";

        //exercise = extras.getString("EXTRA_MESSAGE");
        numberOfSets = extras.getInt("EXTRA_MESSAGE");
        String op = extras.getString("EXTRA_NAME");
        exercise = extras.getString("EXTRA_CODE");
        String op1 = extras.getString("EXTRA_IMAGE");

        activity = this;
        activity.setTitle(op);

        //mDatbaseExercise = FirebaseDatabase.getInstance().getReference().child("exercises").child(exercise);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        final Date c = Calendar.getInstance().getTime();

        final SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        final String today = df.format(c);

        try {
            e = df.parse(today);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }

        mAuth = FirebaseAuth.getInstance();
        user_id = mAuth.getCurrentUser().getUid();
        mDatabaseDates = FirebaseDatabase.getInstance().getReference().child("useraccs").child(user_id);
        //mNameView = findViewById(R.id.valueView);

        mRep1 = findViewById(R.id.reps1);
        mRep2 = findViewById(R.id.reps2);
        mRep3 = findViewById(R.id.reps3);
        mRep4 = findViewById(R.id.reps4);
        mRep5 = findViewById(R.id.reps5);

        mWeight1 = findViewById(R.id.weight1);
        mWeight2 = findViewById(R.id.weight2);
        mWeight3 = findViewById(R.id.weight3);
        mWeight4 = findViewById(R.id.weight4);
        mWeight5 = findViewById(R.id.weight5);

        mNumberOfSets = findViewById(R.id.sets);
        mNumberOfSets.append(" (" + numberOfSets + ")");

        mExercisePic = findViewById(R.id.imageView);
        Resources res = getResources();
        int resID = res.getIdentifier(op1, "drawable", getPackageName());

        mExercisePic.setImageResource(resID);

        if (numberOfSets != 5)
        {
            LinearLayout linearLayout = findViewById(R.id.set5_row);
            linearLayout.setVisibility(View.GONE);
        }

        //get name & image
        /*mDatbaseExercise.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String exercise_name = dataSnapshot.child("Name").getValue().toString();
                String exercise_image = dataSnapshot.child("Image").getValue().toString();

                mExercisePic = findViewById(R.id.imageView);
                Resources res = getResources();
                int resID = res.getIdentifier(exercise_image , "drawable", getPackageName());

               // mExercisePic.setImageResource(resID);
                //mNameView.setText(exercise_name);

                //activity.setTitle(exercise_name);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });*/

        mDatabaseDates.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Date date;
                Date mostRecent;

                for (DataSnapshot childSnapshot : dataSnapshot.getChildren()) {

                    try {
                        date = df.parse(childSnapshot.getKey());
                        dates.add(date);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
                if (dates.size() > 0) {


                    Collections.sort(dates);
                    Collections.reverse(dates);

                    SimpleDateFormat simpleDate = new SimpleDateFormat("dd-MM-yyyy");



                    if (dates.get(0).equals(e)) {


                        //mostRecent = dates.get(0);
                        strDt = simpleDate.format(e);

                        mDatabaseUserCurrResults = FirebaseDatabase.getInstance().getReference().child("useraccs").child(user_id).child(strDt);

                        mDatabaseUserCurrResults.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot snapshot) {
                                if (snapshot.hasChild(exercise)) {

                                    getCurrValues();
                                }
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });
                        if (dates.size() > 1) {
                            mostRecent = dates.get(1);

                            strDt = simpleDate.format(mostRecent);

                            mDatabaseUserPastResults = FirebaseDatabase.getInstance().getReference().child("users").child("1").child(strDt).child(exercise);

                            checkDate();
                        }
                    }
                    else
                    {
                        mostRecent = dates.get(0);

                        if (dates.get(0).equals(e)) {
                            mostRecent = dates.get(1);
                        }

                        strDt = simpleDate.format(mostRecent);

                        mDatabaseUserPastResults = FirebaseDatabase.getInstance().getReference().child("users").child("1").child(strDt).child(exercise);


                        checkDate();
                    }

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



        mDatbaseUser1WeekReps = FirebaseDatabase.getInstance().getReference().child("useraccs").child(user_id).child(today).child(exercise).child("reps");
        mDatbaseUser1WeekWeights = FirebaseDatabase.getInstance().getReference().child("useraccs").child(user_id).child(today).child(exercise).child("weights");
        mDatbaseUserLoc = FirebaseDatabase.getInstance().getReference().child("useraccs").child(user_id).child(today).child("Loc");


        //mNameView = findViewById(R.id.valueView);
        mRep1 = findViewById(R.id.reps1);
        mRep2 = findViewById(R.id.reps2);
        mRep3 = findViewById(R.id.reps3);
        mRep4 = findViewById(R.id.reps4);

        mWeight1 = findViewById(R.id.weight1);
        mWeight2 = findViewById(R.id.weight2);
        mWeight3 = findViewById(R.id.weight3);
        mWeight4 = findViewById(R.id.weight4);

        addBtn = findViewById(R.id.addBtn);



        mRep1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                rowChanged=1;
            }
        });

        mWeight1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                rowChanged=1;
            }
        });

        mRep2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                rowChanged=2;
            }
        });

        mWeight2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                rowChanged=2;
            }
        });

        mRep3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                rowChanged=3;
            }
        });

        mWeight3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                rowChanged=3;
            }
        });

        mRep4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                rowChanged=4;
            }
        });

        mRep4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                rowChanged=4;
            }
        });

        if (numberOfSets ==5)
        {
            mRep5.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                }

                @Override
                public void afterTextChanged(Editable s) {
                    rowChanged=5;
                }
            });

            mWeight5.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                }

                @Override
                public void afterTextChanged(Editable s) {
                    rowChanged=5;
                }
            });
        }


        addBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){


                    pressed++;
                

                if(pressed >0)
                {
                    reps1 = mRep1.getText().toString();
                    weights1 = mWeight1.getText().toString();

                    if (reps1.equals(""))
                    {
                        reps1 = mRep1.getHint().toString();
                        mRep1.setText(reps1);
                    }
                    if (weights1.equals(""))
                    {
                        weights1 = mWeight1.getHint().toString();
                        mWeight1.setText(weights1);
                    }

                    mRep2.setFocusableInTouchMode(true);
                    mRep2.setFocusable(true);
                    mRep2.requestFocus();

                    mWeight2.setFocusableInTouchMode(true);
                    mWeight2.setFocusable(true);

                }
                if(pressed > 1)
                {
                    reps2 = mRep2.getText().toString();
                    weights2 = mWeight2.getText().toString();

                    if (reps2.equals(""))
                    {
                        reps2 = mRep2.getHint().toString();
                        mRep2.setText(reps2);
                    }
                    if (weights2.equals(""))
                    {
                        weights2 = mWeight2.getHint().toString();
                        mWeight2.setText(weights2);
                    }

                    mRep3.setFocusableInTouchMode(true);
                    mRep3.setFocusable(true);
                    mRep3.requestFocus();

                    mWeight3.setFocusableInTouchMode(true);
                    mWeight3.setFocusable(true);
                }
                if(pressed >2)
                {
                    reps3 = mRep3.getText().toString();
                    weights3 = mWeight3.getText().toString();

                    if (reps3.equals(""))
                    {
                        reps3 = mRep3.getHint().toString();
                        mRep3.setText(reps3);
                    }
                    if (weights3.equals(""))
                    {
                        weights3 = mWeight3.getHint().toString();
                        mWeight3.setText(weights3);
                    }

                    mRep4.setFocusableInTouchMode(true);
                    mRep4.setFocusable(true);
                    mRep4.requestFocus();

                    mWeight4.setFocusableInTouchMode(true);
                    mWeight4.setFocusable(true);
                }
                if (pressed > 3)
                {
                    reps4 = mRep4.getText().toString();
                    weights4 = mWeight4.getText().toString();

                    if (reps4.equals(""))
                    {
                        reps4 = mRep4.getHint().toString();
                        mRep4.setText(reps4);
                    }
                    if (weights4.equals(""))
                    {
                        weights4 = mWeight4.getHint().toString();
                        mWeight4.setText(weights4);
                    }

                    if (numberOfSets==5)
                    {
                        mRep5.setFocusableInTouchMode(true);
                        mRep5.setFocusable(true);
                        mRep5.requestFocus();

                        mWeight5.setFocusableInTouchMode(true);
                        mWeight5.setFocusable(true);
                    }
                }
                if (numberOfSets==5 && pressed > 4 )
                {
                    reps5 = mRep5.getText().toString();
                    weights5 = mWeight5.getText().toString();

                    if (reps4.equals(""))
                    {
                        reps5 = mRep5.getHint().toString();
                        mRep5.setText(reps5);
                    }
                    if (weights5.equals(""))
                    {
                        weights5 = mWeight5.getHint().toString();
                        mWeight5.setText(weights5);
                    }
                }

                String reps = reps1 + " " + reps2 + " " + reps3 + " " + reps4 + " " + reps5;
                String weights = weights1 + " " + weights2 + " " + weights3 + " " + weights4 + " " + weights5;
                reps = reps.trim();
                weights = weights.trim();
                //myRef.setValue(value);

                mDatbaseUser1WeekReps.setValue(reps);
                mDatbaseUser1WeekWeights.setValue(weights);


                loc();

            }
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{
                        Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION },10);

                return;

            }
        }


    }

    public  void loc()
    {
        geocoder = new Geocoder(this, Locale.getDefault());

        locationManager= (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{
                        Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION },10);

                return;

            }
        }

        location = locationManager.getLastKnownLocation(locationManager.NETWORK_PROVIDER);

        onLocationChanged(location);
    }

    public void checkDate()
    {
        mDatabaseUserPastResults = FirebaseDatabase.getInstance().getReference().child("useraccs").child(user_id).child(strDt);

        mDatabaseUserPastResults.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                if (snapshot.hasChild(exercise)) {

                    getValues();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public void getCurrValues() {


        mDatabaseUserCurrResults.child(exercise).child("weights").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String weights = dataSnapshot.getValue().toString();

                String[] weightSeparated = weights.split("\\s+");

                if (weightSeparated.length > 0)
                {
                    mWeight1.setText(weightSeparated[0]);

                    mWeight2.setFocusableInTouchMode(true);
                    mWeight2.setFocusable(true);
                    pressed++;

                    if (weightSeparated.length > 1)
                    {
                        mWeight2.setText(weightSeparated[1]);
                        mWeight3.setFocusableInTouchMode(true);
                        mWeight3.setFocusable(true);
                        pressed++;

                        if (weightSeparated.length > 2)
                        {
                            mWeight3.setText(weightSeparated[2]);

                            mWeight4.setFocusableInTouchMode(true);
                            mWeight4.setFocusable(true);
                            pressed++;

                            if (weightSeparated.length > 3)
                            {
                                mWeight4.setText(weightSeparated[3]);
                                pressed++;
                                if (numberOfSets == 5)
                                {
                                    mWeight5.setFocusableInTouchMode(true);
                                    mWeight5.setFocusable(true);
                                    mWeight5.requestFocus();
                                }


                                if (weightSeparated.length > 4)
                                {
                                    mWeight5.setText(weightSeparated[4]);
                                }
                            }
                        }
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mDatabaseUserCurrResults.child(exercise).child("reps").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String reps = dataSnapshot.getValue().toString();

                String[] repsSeparated = reps.split("\\s+");

                if (repsSeparated.length > 0)
                {
                    mRep1.setText(repsSeparated[0]);

                    mRep2.setFocusableInTouchMode(true);
                    mRep2.setFocusable(true);
                    mRep2.requestFocus();


                    if (repsSeparated.length > 1)
                    {
                        mRep2.setText(repsSeparated[1]);

                        mRep3.setFocusableInTouchMode(true);
                        mRep3.setFocusable(true);
                        mRep3.requestFocus();


                        if (repsSeparated.length > 2)
                        {
                            mRep3.setText(repsSeparated[2]);

                            mRep4.setFocusableInTouchMode(true);
                            mRep4.setFocusable(true);
                            mRep4.requestFocus();


                            if (repsSeparated.length > 3)
                            {
                                mRep4.setText(repsSeparated[3]);

                                if (numberOfSets == 5)
                                {
                                    mRep5.setFocusableInTouchMode(true);
                                    mRep5.setFocusable(true);
                                    mRep5.requestFocus();
                                }


                                if (repsSeparated.length > 4)
                                {
                                    mRep4.setText(repsSeparated[4]);
                                }
                            }
                        }
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


    @Override
    public void onLocationChanged(Location location) {
        longitude  = location.getLongitude();
        latitude = location.getLatitude();
        //mNameView.setText(longitude + " " +latitude);
        convert();
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {
        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
    }


    public void convert(){
        try {
            addresses = geocoder.getFromLocation(latitude, longitude, 1);

            String address = addresses.get(0).getAddressLine(0);
            String area = addresses.get(0).getLocality();
            String city = addresses.get(0).getAdminArea();
            String country = addresses.get(0).getCountryCode();
            String postalcode = addresses.get(0).getPostalCode();

            String[] fulladdress = address.split(",");

            //mNameView.append();

            mDatbaseUserLoc.setValue(fulladdress[0]);
            Toast.makeText(exercise.this, "Set" + " saved\nLoc: " + fulladdress[0], Toast.LENGTH_SHORT).show();

        }
        catch (IOException e)
        {

        }
    }



    public void getValues() {


        mDatabaseUserPastResults.child(exercise).child("weights").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String weights = dataSnapshot.getValue().toString();

                String[] weightSeparated = weights.split("\\s+");

                if (weightSeparated.length > 0)
                {
                    mWeight1.setHint(weightSeparated[0]);

                    if (weightSeparated.length > 1)
                    {
                        mWeight2.setHint(weightSeparated[1]);
                        if (weightSeparated.length > 2)
                        {
                            mWeight3.setHint(weightSeparated[2]);
                            if (weightSeparated.length > 3)
                            {
                                mWeight4.setHint(weightSeparated[3]);
                                if (weightSeparated.length > 4)
                                {
                                    mWeight5.setHint(weightSeparated[4]);
                                }
                            }
                        }
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mDatabaseUserPastResults.child(exercise).child("reps").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String reps = dataSnapshot.getValue().toString();

                String[] repsSeparated = reps.split("\\s+");

                if (repsSeparated.length > 0)
                {
                    mRep1.setHint(repsSeparated[0]);

                    if (repsSeparated.length > 1)
                    {
                        mRep2.setHint(repsSeparated[1]);
                        if (repsSeparated.length > 2)
                        {
                            mRep3.setHint(repsSeparated[2]);
                            if (repsSeparated.length > 3)
                            {
                                mRep4.setHint(repsSeparated[3]);
                                if (repsSeparated.length > 4)
                                {
                                    mRep5.setHint(repsSeparated[4]);
                                }
                            }
                        }
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}