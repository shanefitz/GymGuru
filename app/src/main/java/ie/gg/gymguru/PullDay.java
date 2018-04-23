package ie.gg.gymguru;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PullDay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull_day);
    }

    public void onClickDeadlift(View view) {
        Intent int1 = new Intent(this, exercise.class);
        Bundle extras = new Bundle();
        extras.putInt("EXTRA_MESSAGE", 3);
        extras.putString("EXTRA_IMAGE", "barbell_deadlift");
        extras.putString("EXTRA_NAME", "Deadlift");
        extras.putString("EXTRA_CODE", "bench_press");

        int1.putExtras(extras);
        startActivity(int1);

    }

    public void onClickTbarRow(View view) {
        Intent int1 = new Intent(this, exercise.class);
        Bundle extras = new Bundle();
        extras.putInt("EXTRA_MESSAGE", 5);
        extras.putString("EXTRA_IMAGE", "tbar_row");
        extras.putString("EXTRA_NAME", "T-bar Row");
        extras.putString("EXTRA_CODE", "bench_press");

        int1.putExtras(extras);
        startActivity(int1);

    }

    public void onClickPullUp(View view) {
        Intent int1 = new Intent(this, exercise.class);
        Bundle extras = new Bundle();
        extras.putInt("EXTRA_MESSAGE", 5);
        extras.putString("EXTRA_IMAGE", "pull_up");
        extras.putString("EXTRA_NAME", "Wide Grip Pull Up");
        extras.putString("EXTRA_CODE", "bench_press");

        int1.putExtras(extras);
        startActivity(int1);

    }

    public void onClickDumbellRow(View view) {
        Intent int1 = new Intent(this, exercise.class);
        Bundle extras = new Bundle();
        extras.putInt("EXTRA_MESSAGE", 5);
        extras.putString("EXTRA_IMAGE", "dumbbell_row");
        extras.putString("EXTRA_NAME", "Single Arm Row");
        extras.putString("EXTRA_CODE", "bench_press");

        int1.putExtras(extras);
        startActivity(int1);

    }

    public void onClickDumbellCurls(View view) {
        Intent int1 = new Intent(this, exercise.class);
        Bundle extras = new Bundle();
        extras.putInt("EXTRA_MESSAGE", 5);
        extras.putString("EXTRA_IMAGE", "dumbbell_alternate_biceps_curl");
        extras.putString("EXTRA_NAME", "Dumbbell Curls");
        extras.putString("EXTRA_CODE", "bench_press");

        int1.putExtras(extras);
        startActivity(int1);

    }
}
