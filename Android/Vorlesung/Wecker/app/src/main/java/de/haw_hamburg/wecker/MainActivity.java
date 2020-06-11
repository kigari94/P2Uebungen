package de.haw_hamburg.wecker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    ReaderService reader = new ReaderService();
    TextView main_time;
    AlarmClock alarmClock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main_time = findViewById(R.id.main_time);

        FloatingActionButton floatingActionButton = findViewById(R.id.editImageButtonAM);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Want to add a new entry",
                        Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this, EditAlarmActivity.class);
                startActivity(intent);
            }
        });
        Object object = ReaderService.readObject(MainActivity.this);
        if(object != null) {
            Log.i("Test", object.toString());
            if(object instanceof AlarmClock){
                alarmClock = (AlarmClock) object;
                main_time.setText(alarmClock.getHour() + ":" + alarmClock.getMinutes());
            }
        }
    }
}
