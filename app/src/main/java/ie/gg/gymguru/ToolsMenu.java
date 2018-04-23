package ie.gg.gymguru;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ToolsMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tools_menu);

        Button bmrBtn = (Button) findViewById(R.id.bmrBtn);
        Button bmiBtn = (Button) findViewById(R.id.bmiBtn);
        Button macroBtn = (Button) findViewById(R.id.macroBtn);

        bmrBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1 = new Intent(ToolsMenu.this, BmiCalculator.class);
                startActivity(int1);
            }
        });

        bmiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int2 = new Intent(ToolsMenu.this, indexCalculator.class);
                startActivity(int2);
            }
        });

        macroBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int3 = new Intent(ToolsMenu.this, MacroCalculator.class);
                startActivity(int3);
            }
        });
    }
}
