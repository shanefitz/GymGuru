package ie.gg.gymguru;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IntermediateDays extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intermediate_days);

        Button upperOneBtn = (Button) findViewById(R.id.upperOneBtn);
        Button upperTwoBtn = (Button) findViewById(R.id.upperTwoBtn);
        Button lowerOneBtn = (Button) findViewById(R.id.lowerOneBtn);
        Button lowerTwoBtn = (Button) findViewById(R.id.lowerTwoBtn);

        upperOneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1 = new Intent(IntermediateDays.this, UpperOne.class);
                startActivity(int1);
            }
        });

        upperTwoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int2 = new Intent(IntermediateDays.this, UpperTwo.class);
                startActivity(int2);
            }
        });

        lowerOneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int3 = new Intent(IntermediateDays.this, LowerOne.class);
                startActivity(int3);
            }
        });

        lowerTwoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int4 = new Intent(IntermediateDays.this, LowerTwo.class);
                startActivity(int4);
            }
        });

    }
}
