package ie.gg.gymguru;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class indexCalculator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index_calculator);

        Button calculateBtn = (Button) findViewById(R.id.calculateBtn);
        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText heightText = (EditText) findViewById(R.id.heightText);
                EditText weightText = (EditText) findViewById(R.id.weightText);
                TextView resultText = (TextView) findViewById(R.id.resultText);


                double height = Double.parseDouble(heightText.getText().toString());
                double weight = Double.parseDouble(weightText.getText().toString());

                double result = weight/(height*height);

                resultText.setText(result + "");
            }
        });
    }
}
