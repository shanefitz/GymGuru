package ie.gg.gymguru;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UpperTwo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upper_two);

        Button pullupBtn = (Button) findViewById(R.id.pullupBtn);
        Button dbBenchBtn = (Button) findViewById(R.id.dbBenchBtn);
        Button shoulderBtn = (Button) findViewById(R.id.shoulderBtn);
        Button triBtn = (Button) findViewById(R.id.triBtn);
        Button curlsBtn = (Button) findViewById(R.id.curlsBtn);


    }

    public void onClickSend_1(View view) { //pullupBtn
        Intent int1 = new Intent(UpperTwo.this, exercise.class);
        Bundle extras = new Bundle();
        extras.putInt("EXTRA_MESSAGE", 3);
        extras.putString("EXTRA_IMAGE", "pullup");
        extras.putString("EXTRA_NAME", "Wide Grip Pullup");
        extras.putString("EXTRA_CODE", "pullup");
        int1.putExtras(extras);
        startActivity(int1);


    }

    public void onClickSend_2(View view) { //dbBenchBtn
        Intent int2 = new Intent(UpperTwo.this, exercise.class);
        Bundle extras = new Bundle();
        extras.putInt("EXTRA_MESSAGE", 3);
        extras.putString("EXTRA_IMAGE", "dumbbellbench");
        extras.putString("EXTRA_NAME", "Dumbbell Bench");
        extras.putString("EXTRA_CODE", "dumbbellbench");
        int2.putExtras(extras);
        startActivity(int2);

    }

    public void onClickSend_3(View view) { //shoulderBtn
        Intent int3 = new Intent(UpperTwo.this, exercise.class);
        Bundle extras = new Bundle();
        extras.putInt("EXTRA_MESSAGE", 3);
        extras.putString("EXTRA_IMAGE", "dbshoulder");
        extras.putString("EXTRA_NAME", "DB Shoulder Press");
        extras.putString("EXTRA_CODE", "dbshoulder");
        int3.putExtras(extras);
        startActivity(int3);

    }

    public void onClickSend_4(View view) { //triBtn
        Intent int4 = new Intent(UpperTwo.this, exercise.class);
        Bundle extras = new Bundle();
        extras.putInt("EXTRA_MESSAGE", 3);
        extras.putString("EXTRA_IMAGE", "tricepcable");
        extras.putString("EXTRA_NAME", "Tricep Extension");
        extras.putString("EXTRA_CODE", "tricepcable");
        int4.putExtras(extras);
        startActivity(int4);

    }

    public void onClickSend_5(View view) { //curlsBtn
        Intent int5 = new Intent(UpperTwo.this, exercise.class);
        Bundle extras = new Bundle();
        extras.putInt("EXTRA_MESSAGE", 3);
        extras.putString("EXTRA_IMAGE", "preacher");
        extras.putString("EXTRA_NAME", "Barbell Curls");
        extras.putString("EXTRA_CODE", "preacher");
        int5.putExtras(extras);
        startActivity(int5);

    }
}
