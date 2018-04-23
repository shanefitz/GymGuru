package ie.gg.gymguru;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdvancedDays extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced_days);

        Button pushBtn = (Button) findViewById(R.id.pushBtn);
        Button pullBtn = (Button) findViewById(R.id.pullBtn);
        //Button legBtn = (Button) findViewById(R.id.legBtn);

        pushBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1 = new Intent(AdvancedDays.this, PushDay.class);
                startActivity(int1);
            }
        });

        pullBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int2 = new Intent(AdvancedDays.this, PullDay.class);
                startActivity(int2);
            }
        });


    }

}
