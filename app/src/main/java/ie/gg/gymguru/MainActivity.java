package ie.gg.gymguru;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton workoutsBtn = (ImageButton) findViewById(R.id.workoutsBtn);
        ImageButton bmiBtn = (ImageButton) findViewById(R.id.bmiBtn);
        ImageButton nuBtn = (ImageButton) findViewById(R.id.nutritionBtn);


        workoutsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity();
            }
        });

        bmiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intBmi = new Intent(MainActivity.this, ToolsMenu.class);
                startActivity(intBmi);
            }
        });

        nuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intBmi = new Intent(MainActivity.this, nutricion.class);
                startActivity(intBmi);
            }
        });

    }

    public void openNewActivity() {
            Intent intent = new Intent(this, WorkoutChoices.class);
            startActivity(intent);
        }
}

