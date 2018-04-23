package ie.gg.gymguru;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LowerOne extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lower_one);

        Button frontSquatBtn = (Button) findViewById(R.id.frontSquatBtn);
        Button lungesBtn = (Button) findViewById(R.id.lungesBtn);
        Button hackBtn = (Button) findViewById(R.id.hackBtn);
        Button boxBtn = (Button) findViewById(R.id.boxBtn);
        Button calfRaiseBtn = (Button) findViewById(R.id.calfRaiseBtn);


    }

    public void onClickSend_1(View view) { //frontSqautBtn
        Intent int1 = new Intent(LowerOne.this, exercise.class);
        Bundle extras = new Bundle();
        extras.putInt("EXTRA_MESSAGE", 3);
        extras.putString("EXTRA_IMAGE", "frontsquat");
        extras.putString("EXTRA_NAME", "Front Squat");
        extras.putString("EXTRA_CODE", "frontsquat");

        int1.putExtras(extras);
        startActivity(int1);


    }

    public void onClickSend_2(View view) { //lungesBtn
        Intent int2 = new Intent(LowerOne.this, exercise.class);
        Bundle extras = new Bundle();
        extras.putInt("EXTRA_MESSAGE", 3);
        extras.putString("EXTRA_IMAGE", "dumbbellbench");
        extras.putString("EXTRA_NAME", "Lunges");
        extras.putString("EXTRA_CODE", "lunges");
        int2.putExtras(extras);
        startActivity(int2);

    }

    public void onClickSend_3(View view) { //hackBtn
        Intent int3 = new Intent(LowerOne.this, exercise.class);
        Bundle extras = new Bundle();
        extras.putInt("EXTRA_MESSAGE", 3);
        extras.putString("EXTRA_IMAGE", "hacksquat");
        extras.putString("EXTRA_NAME", "Hack Squat");
        extras.putString("EXTRA_CODE", "hacksquat");

        int3.putExtras(extras);
        startActivity(int3);

    }

    public void onClickSend_4(View view) { //boxBtn
        Intent int4 = new Intent(LowerOne.this, exercise.class);
        Bundle extras = new Bundle();
        extras.putInt("EXTRA_MESSAGE", 3);
        extras.putString("EXTRA_IMAGE", "boxia");
        extras.putString("EXTRA_NAME", "Box Jumps");
        extras.putString("EXTRA_CODE", "boxia");
        int4.putExtras(extras);
        startActivity(int4);

    }

    public void onClickSend_5(View view) { //calfRaiseBtn
        Intent int5 = new Intent(LowerOne.this, exercise.class);
        Bundle extras = new Bundle();
        extras.putInt("EXTRA_MESSAGE", 3);
        extras.putString("EXTRA_IMAGE", "calfras");
        extras.putString("EXTRA_NAME", "Calf Raises");
        extras.putString("EXTRA_CODE", "calfas");
        int5.putExtras(extras);
        startActivity(int5);
    }
}
