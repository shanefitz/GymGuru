package ie.gg.gymguru;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class register extends AppCompatActivity{


    private EditText mEmail;
    private EditText mPassword;
    private EditText mName;

    private Button mRegister;

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    private FirebaseAuth.AuthStateListener mAuthListener;

    private ProgressDialog mProgress;

    private Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        mEmail = findViewById(R.id.registerEmail);
        mPassword = findViewById(R.id.registerPassword);
        mName = findViewById(R.id.registerName);

        mRegister = findViewById(R.id.register);
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference().child("useraccs");

        activity = this;

        activity.setTitle("Log in");

        mProgress = new ProgressDialog(this);

        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startRegister();
            }
        });
    }

    public void startRegister()
    {
        String password = mPassword.getText().toString();
        String email = mEmail.getText().toString();
        final String name = mName.getText().toString();

        if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password) || TextUtils.isEmpty(password ))
        {
            Toast.makeText(register.this, "Please complete all fields", Toast.LENGTH_LONG).show();
        }
        else if(password.length()<6){
            Toast.makeText(register.this, "Password too short (min 6 characters)", Toast.LENGTH_SHORT).show();
        }
        else {

            mProgress.setMessage("Signing up...");
            mProgress.show();

            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>(){
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (!task.isSuccessful()) {

                        if (task.getException().getMessage().equals("The email address is already in use by another account.")) {
                            Toast.makeText(register.this, "Email already registered", Toast.LENGTH_LONG).show();
                        }
                        else if (task.getException().getMessage().equals("The email address is badly formatted.")) {
                            Toast.makeText(register.this, "Please enter a valid email", Toast.LENGTH_LONG).show();
                        }
                        else
                        {
                            Toast.makeText(register.this, "Sign up problem\n" + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                    else {
                        String user_id = mAuth.getCurrentUser().getUid();

                        DatabaseReference curent_user_db = mDatabase.child(user_id);
                        curent_user_db.child("Name").setValue(name);

                        sendInt();
                    }
                    mProgress.dismiss();

                }
            });

        }
    }

    public  void sendInt(){
        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);
    }
}
