package ie.gg.gymguru;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.content.Intent;
import android.widget.Toast;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;



public class index extends Activity {



    private FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index);

        mAuth = FirebaseAuth.getInstance();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() != null){
                    //Toast.makeText(index.this, "Already signed in", Toast.LENGTH_LONG).show();

                    View t=null;
                    OpenExercise(t);
                }
            }
        };

    }

    @Override
    protected void onStart()
    {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    public void OpenExercise(View view) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }


    public void OpenRegister(View view) {

        Intent intent = new Intent(this, register.class);
        startActivity(intent);

    }


    public void OpenLogin(View view) {
        Intent intent = new Intent(this, signin.class);
        startActivity(intent);
    }


}
