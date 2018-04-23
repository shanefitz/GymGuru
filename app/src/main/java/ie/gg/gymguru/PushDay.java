package ie.gg.gymguru;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PushDay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_push_day);
    }

    public void onClickBenchPress(View view) {
        Intent int1 = new Intent(this, exercise.class);
        Bundle extras = new Bundle();
        extras.putInt("EXTRA_MESSAGE", 3);
        extras.putString("EXTRA_IMAGE", "barbell_bench_press");
        extras.putString("EXTRA_NAME", "Bench Press");
        extras.putString("EXTRA_CODE", "bench_press");

        int1.putExtras(extras);
        startActivity(int1);

    }

    public void onClickInclineBenchPress(View view) {
        Intent int1 = new Intent(this, exercise.class);
        Bundle extras = new Bundle();
        extras.putInt("EXTRA_MESSAGE", 3);
        extras.putString("EXTRA_IMAGE", "bench_press");
        extras.putString("EXTRA_NAME", "Incline Bench Press");
        extras.putString("EXTRA_CODE", "bench_press");

        int1.putExtras(extras);
        startActivity(int1);

    }

    public void onClickOverHeadPress(View view) {
        Intent int1 = new Intent(this, exercise.class);
        Bundle extras = new Bundle();
        extras.putInt("EXTRA_MESSAGE", 5);
        extras.putString("EXTRA_IMAGE", "barbell_over_head_press");
        extras.putString("EXTRA_NAME", "Over Head Press");
        extras.putString("EXTRA_CODE", "bench_press");

        int1.putExtras(extras);
        startActivity(int1);

    }

    public void onClickTricepExtension(View view) {
        Intent int1 = new Intent(this, exercise.class);
        Bundle extras = new Bundle();
        extras.putInt("EXTRA_MESSAGE", 5);
        extras.putString("EXTRA_IMAGE", "triceps_push_down");
        extras.putString("EXTRA_NAME", "Tricep Extension");
        extras.putString("EXTRA_CODE", "bench_press");

        int1.putExtras(extras);
        startActivity(int1);

    }

    public void onClickLateralRasies(View view) {
        Intent int1 = new Intent(this, exercise.class);
        Bundle extras = new Bundle();
        extras.putInt("EXTRA_MESSAGE", 5);
        extras.putString("EXTRA_IMAGE", "lateral_raise");
        extras.putString("EXTRA_NAME", "Lateral Rasies");
        extras.putString("EXTRA_CODE", "bench_press");

        int1.putExtras(extras);
        startActivity(int1);

    }

}
