package ie.gg.gymguru;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class nutricion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nutricion);

    }

    public void b1(View view) {
        Intent int1 = new Intent(this, meals.class);
        Bundle extras = new Bundle();
        extras.putString("EXTRA_NAME", "breakfast1");
        int1.putExtras(extras);
        startActivity(int1);

    }

    public void b2(View view) {
        Intent int1 = new Intent(this, meals.class);
        Bundle extras = new Bundle();
        extras.putString("EXTRA_NAME", "breakfast2");
        int1.putExtras(extras);
        startActivity(int1);

    }

    public void b3(View view) {
        Intent int1 = new Intent(this, meals.class);
        Bundle extras = new Bundle();
        extras.putString("EXTRA_NAME", "breakfast3");
        int1.putExtras(extras);
        startActivity(int1);

    }

    public void l1(View view) {
        Intent int1 = new Intent(this, meals.class);
        Bundle extras = new Bundle();
        extras.putString("EXTRA_NAME", "lunch1");
        int1.putExtras(extras);
        startActivity(int1);

    }

    public void l2(View view) {
        Intent int1 = new Intent(this, meals.class);
        Bundle extras = new Bundle();
        extras.putString("EXTRA_NAME", "lunch2");
        int1.putExtras(extras);
        startActivity(int1);

    }

    public void l3(View view) {
        Intent int1 = new Intent(this, meals.class);
        Bundle extras = new Bundle();
        extras.putString("EXTRA_NAME", "lunch3");
        int1.putExtras(extras);
        startActivity(int1);

    }

    public void d1(View view) {
        Intent int1 = new Intent(this, meals.class);
        Bundle extras = new Bundle();
        extras.putString("EXTRA_NAME", "dinner1");
        int1.putExtras(extras);
        startActivity(int1);

    }

    public void d2(View view) {
        Intent int1 = new Intent(this, meals.class);
        Bundle extras = new Bundle();
        extras.putString("EXTRA_NAME", "dinner2");
        int1.putExtras(extras);
        startActivity(int1);

    }

    public void d3(View view) {
        Intent int1 = new Intent(this, meals.class);
        Bundle extras = new Bundle();
        extras.putString("EXTRA_NAME", "dinner3");
        int1.putExtras(extras);
        startActivity(int1);

    }
}
