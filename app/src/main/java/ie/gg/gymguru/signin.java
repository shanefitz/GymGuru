package ie.gg.gymguru;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;


public class signin extends AppCompatActivity {

    private EditText mEmailField;
    private EditText mpassword;

    private Button mlogin;

    private ProgressDialog mProgress;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    private Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin);

        mAuth = FirebaseAuth.getInstance();
        mEmailField = findViewById(R.id.emailField);
        mpassword = findViewById(R.id.passwordField);
        mlogin = findViewById(R.id.login);
        mProgress = new ProgressDialog(this);
        activity = this;

        activity.setTitle("Log in");

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() != null){
                    Toast.makeText(signin.this, "Signed in", Toast.LENGTH_SHORT).show();

                    changeActivity();
                }
            }
        };

        mlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startSignin();
            }
        });

    }

    public void changeActivity(){

        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }
    public void startSignin(){
        mProgress.setMessage("Signing in...");
        mProgress.show();

        String email = mEmailField.getText().toString();
        String password = mpassword.getText().toString();

        if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password))
        {
            Toast.makeText(signin.this, "Please complete both fields", Toast.LENGTH_LONG).show();
        }
        else {


            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (!task.isSuccessful()) {
                        if (task.getException().getMessage().equals("The password is invalid or the user does not have a password.") || task.getException().getMessage().equals("There is no user record corresponding to this identifier. The user may have been deleted.")) {
                            Toast.makeText(signin.this, "Invalid email or password", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(signin.this, "Sign in problem\n" + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                }
            });

            mProgress.dismiss();
        }

    }

}