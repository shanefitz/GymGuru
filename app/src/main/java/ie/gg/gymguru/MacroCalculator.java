package ie.gg.gymguru;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MacroCalculator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_macro_calculator);

        Button calculateBtn = (Button) findViewById(R.id.calculateBtn);

        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText weightText = (EditText) findViewById(R.id.weightText);
                EditText calText = (EditText) findViewById(R.id.calText);
                TextView displayText = (TextView) findViewById(R.id.displayText);

                double weight = Double.parseDouble(weightText.getText().toString());
                double calories = Double.parseDouble(calText.getText().toString());
                double fat = weight/2;
                double remaining = calories - ((weight*4)+(fat*9));
                double carbs = remaining/4;

                String result = ("Protein: " + weight + "g\nFat: "+ fat + "g\nCarbohydrates: "+carbs+"g");

                displayText.setText(result);
            }
        });
    }
}
