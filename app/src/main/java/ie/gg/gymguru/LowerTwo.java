package ie.gg.gymguru;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LowerTwo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lower_two);

        Button deadliftBtn = (Button) findViewById(R.id.deadliftBtn);
        Button romanianBtn = (Button) findViewById(R.id.romanianBtn);
        Button legPressBtn = (Button) findViewById(R.id.legPressBtn);
        Button abductionBtn = (Button) findViewById(R.id.aabductionBtn);
        Button calfraiseBtn = (Button) findViewById(R.id.calfRaiseBtn);

    }

        public void onClickSend_1(View view) { //DeadliftBtn
            Intent int1 = new Intent(LowerTwo.this, exercise.class);
            Bundle extras = new Bundle();
            extras.putInt("EXTRA_MESSAGE", 3);
            extras.putString("EXTRA_IMAGE", "deadlig");
            extras.putString("EXTRA_NAME", "Deadlift");
            extras.putString("EXTRA_CODE", "deadlift");

            int1.putExtras(extras);
            startActivity(int1);


        }

        public void onClickSend_2(View view) { //romanianBtn
            Intent int2 = new Intent(LowerTwo.this, exercise.class);
            Bundle extras = new Bundle();
            extras.putInt("EXTRA_MESSAGE", 3);
            extras.putString("EXTRA_IMAGE", "dumbbellbench");
            extras.putString("EXTRA_NAME", "Lunges");
            extras.putString("EXTRA_CODE", "lunges");
            int2.putExtras(extras);
            startActivity(int2);

        }

        public void onClickSend_3(View view) { //legPressBtn
            Intent int3 = new Intent(LowerTwo.this, exercise.class);
            Bundle extras = new Bundle();
            extras.putInt("EXTRA_MESSAGE", 3);
            extras.putString("EXTRA_IMAGE", "legpress");
            extras.putString("EXTRA_NAME", "Leg Press");
            extras.putString("EXTRA_CODE", "legpress");
            int3.putExtras(extras);
            startActivity(int3);

        }

        public void onClickSend_4(View view) { //abductionBtn
            Intent int4 = new Intent(LowerTwo.this, exercise.class);
            Bundle extras = new Bundle();
            extras.putInt("EXTRA_MESSAGE", 3);
            extras.putString("EXTRA_IMAGE", "abduct");
            extras.putString("EXTRA_NAME", "Abduction Machine");
            extras.putString("EXTRA_CODE", "abduct");
            int4.putExtras(extras);
            startActivity(int4);

        }

        public void onClickSend_5(View view) { //calfRaiseBtn
            Intent int5 = new Intent(LowerTwo.this, exercise.class);
            Bundle extras = new Bundle();
            extras.putInt("EXTRA_MESSAGE", 3);
            extras.putString("EXTRA_IMAGE", "calfras");
            extras.putString("EXTRA_NAME", "Calf Raises");
            extras.putString("EXTRA_CODE", "calfras");
            int5.putExtras(extras);
            startActivity(int5);
        }
    }

