package ie.gg.gymguru;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class BeginnerB extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beginner_b);
    }


    public void onClickOverHeadPress(View view) {
        Intent int1 = new Intent(this, exercise.class);
        Bundle extras = new Bundle();
        extras.putInt("EXTRA_MESSAGE", 5);
        extras.putString("EXTRA_IMAGE", "barbell_over_head_press");
        extras.putString("EXTRA_NAME", "Over Head Press");
        extras.putString("EXTRA_CODE", "barbell_over_head_press");

        int1.putExtras(extras);
        startActivity(int1);

    }

    public void onClickSquat(View view) {
        Intent int1 = new Intent(this, exercise.class);
        Bundle extras = new Bundle();
        extras.putInt("EXTRA_MESSAGE", 5);
        extras.putString("EXTRA_IMAGE", "barbellsquat");
        extras.putString("EXTRA_NAME", "Squat");
        extras.putString("EXTRA_CODE", "barbellsquat");

        int1.putExtras(extras);
        startActivity(int1);

    }

    public void onClickDeadlift(View view) {
        Intent int1 = new Intent(this, exercise.class);
        Bundle extras = new Bundle();
        extras.putInt("EXTRA_MESSAGE", 5);
        extras.putString("EXTRA_IMAGE", "barbell_deadlift");
        extras.putString("EXTRA_NAME", "Deadlift");
        extras.putString("EXTRA_CODE", "barbell_deadlift");

        int1.putExtras(extras);
        startActivity(int1);

    }
}
