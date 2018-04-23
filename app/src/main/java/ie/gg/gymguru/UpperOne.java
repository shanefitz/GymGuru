package ie.gg.gymguru;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UpperOne extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upper_one);

        Button tbarBtn = (Button) findViewById(R.id.tbarBtn);
        Button inclineBtn = (Button) findViewById(R.id.inclineBtn);
        Button shoulderBtn = (Button) findViewById(R.id.shoulderBtn);
        Button triBtn = (Button) findViewById(R.id.triBtn);
        Button preacherBtn = (Button) findViewById(R.id.preacherBtn);


    }

    public void onClickSend_1(View view) { //tbarBtn
        Intent int1 = new Intent(UpperOne.this, exercise.class);
        Bundle extras = new Bundle();
        extras.putInt("EXTRA_MESSAGE", 3);
        extras.putString("EXTRA_IMAGE", "tbarrow");
        extras.putString("EXTRA_NAME", "T-Bar Row");
        extras.putString("EXTRA_CODE", "tbarrow");
        int1.putExtras(extras);
        startActivity(int1);


    }

    public void onClickSend_2(View view) { //InclineBtn
        Intent int2 = new Intent(UpperOne.this, exercise.class);
        Bundle extras = new Bundle();
        extras.putInt("EXTRA_MESSAGE", 3);
        extras.putString("EXTRA_IMAGE", "inclinebench");
        extras.putString("EXTRA_NAME", "Incline Bench");
        extras.putString("EXTRA_CODE", "inclinebench");
        int2.putExtras(extras);
        startActivity(int2);

    }

    public void onClickSend_3(View view) { //shoulderBtn
        Intent int3 = new Intent(UpperOne.this, exercise.class);
        Bundle extras = new Bundle();
        extras.putInt("EXTRA_MESSAGE", 3);
        extras.putString("EXTRA_IMAGE", "dbshoulder");
        extras.putString("EXTRA_NAME", "DB Shoulder Press");
        extras.putString("EXTRA_CODE", "dbshoulder");
        int3.putExtras(extras);
        startActivity(int3);

    }

    public void onClickSend_4(View view) { //triBtn
        Intent int4 = new Intent(UpperOne.this, exercise.class);
        Bundle extras = new Bundle();
        extras.putInt("EXTRA_MESSAGE", 3);
        extras.putString("EXTRA_IMAGE", "tricepcable");
        extras.putString("EXTRA_NAME", "Tricep Extension");
        extras.putString("EXTRA_CODE", "tricepcable");
        int4.putExtras(extras);
        startActivity(int4);

    }

    public void onClickSend_5(View view) { //triBtn
        Intent int5 = new Intent(UpperOne.this, exercise.class);
        Bundle extras = new Bundle();
        extras.putInt("EXTRA_MESSAGE", 3);
        extras.putString("EXTRA_IMAGE", "preacher");
        extras.putString("EXTRA_NAME", "Preacher Curls");
        extras.putString("EXTRA_CODE", "preacher");
        int5.putExtras(extras);
        startActivity(int5);
    }
}
