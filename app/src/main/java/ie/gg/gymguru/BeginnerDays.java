package ie.gg.gymguru;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BeginnerDays extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beginner_days);

        Button dayOneBtn = (Button) findViewById(R.id.workoutABtn);
        Button dayTwoBtn = (Button) findViewById(R.id.workoutBBtn);




        dayTwoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int2 = new Intent(BeginnerDays.this, BeginnerB.class
                );
                startActivity(int2);
            }
        });
    }

    public void onClickA(View view) {
        Intent int1 = new Intent(this, BeginnerA.class);
        startActivity(int1);

    }
}
