package ie.gg.gymguru;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WorkoutChoices extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_choices);

        Button beginnerBtn = (Button) findViewById(R.id.beginnerBtn);
        Button intermediateBtn = (Button) findViewById(R.id.intermediateBtn);
        Button advancedBtn = (Button) findViewById(R.id.advancedBtn);

        beginnerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1 = new Intent(WorkoutChoices.this, BeginnerDays.class);
                startActivity(int1);
            }
        });

        intermediateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int2 = new Intent(WorkoutChoices.this, IntermediateDays.class);
                startActivity(int2);
            }
        });

        advancedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int3 = new Intent(WorkoutChoices.this, AdvancedDays.class);
                startActivity(int3);
            }
        });
    }
}

