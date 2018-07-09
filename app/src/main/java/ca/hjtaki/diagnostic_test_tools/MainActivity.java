package ca.hjtaki.diagnostic_test_tools;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void open1(View view) {
        Intent intent = new Intent(this,Alignment.class);
        startActivity(intent);
    }

    public void open2(View view) {
        Intent intent = new Intent(this,EdgeLeveling.class);
        startActivity(intent);

    }

    public void open3(View view) {
        Intent intent = new Intent(this,Particle.class);
        startActivity(intent);


    }
}
