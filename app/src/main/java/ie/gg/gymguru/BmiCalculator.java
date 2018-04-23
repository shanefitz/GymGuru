package ie.gg.gymguru;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class BmiCalculator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_calculator);


            Button calculateBtn = (Button) findViewById(R.id.calculateBtn);
            calculateBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EditText ageText = (EditText) findViewById(R.id.ageText);
                    EditText heightText = (EditText) findViewById(R.id.heightText);
                    EditText weightText = (EditText) findViewById(R.id.weightText);
                    TextView resultText = (TextView) findViewById(R.id.resultText);

                    double age = Double.parseDouble(ageText.getText().toString());
                    double height = Double.parseDouble(heightText.getText().toString());
                    double weight = Double.parseDouble(weightText.getText().toString());

                    double result = 66.5 + (13.75 * weight) + (5.003 * height) - (6.755 * age);

                    resultText.setText(result + "");
                }
            });
    }
}
