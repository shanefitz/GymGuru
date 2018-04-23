package ie.gg.gymguru;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BeginnerA extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beginner_a);

    }

    public void onClickBench(View view) {
        Intent int1 = new Intent(BeginnerA.this, exercise.class);
        Bundle extras = new Bundle();
        extras.putInt("EXTRA_MESSAGE", 5);
        extras.putString("EXTRA_IMAGE", "barbell_bench_press");
        extras.putString("EXTRA_NAME", "Bench Press");
        extras.putString("EXTRA_CODE", "bench_press");

        int1.putExtras(extras);
        startActivity(int1);

    }

    public void onClickSquat(View view) {
        Intent int1 = new Intent(BeginnerA.this, exercise.class);
        Bundle extras = new Bundle();
        extras.putInt("EXTRA_MESSAGE", 5);
        extras.putString("EXTRA_IMAGE", "barbellsquat");
        extras.putString("EXTRA_NAME", "Squat");
        extras.putString("EXTRA_CODE", "bench_press");

        int1.putExtras(extras);
        startActivity(int1);

    }

    public void onClickBentOverRow(View view) {
        Intent int1 = new Intent(BeginnerA.this, exercise.class);
        Bundle extras = new Bundle();
        extras.putInt("EXTRA_MESSAGE", 5);
        extras.putString("EXTRA_IMAGE", "barbell_bent_over_row");
        extras.putString("EXTRA_NAME", "Bent Over Row");
        extras.putString("EXTRA_CODE", "bench_press");

        int1.putExtras(extras);
        startActivity(int1);

    }

}