package de.haw_hamburg.buttonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button buttonA;
    Button buttonB;
    Button buttonC;
    TextView txtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonA = findViewById(R.id.button);
        buttonB = findViewById(R.id.button2);
        buttonC = findViewById(R.id.button3);
        txtView = findViewById(R.id.textView);

        buttonA.setOnClickListener(this);
        buttonB.setOnClickListener(this);
        buttonC.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button){
            txtView.setText("A is clicked");
        }
        if(v.getId() == R.id.button2){
            txtView.setText("B is clicked");
        }
        if(v.getId() == R.id.button3){
            txtView.setText("C is clicked");
        }

    }
}
