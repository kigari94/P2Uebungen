package de.haw_hamburg.wecker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Switch;
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

        TextView monday = findViewById((R.id.main_monday));
        TextView tuesday = findViewById((R.id.main_tuesday));
        TextView wednesday = findViewById((R.id.main_wednesday));
        TextView thursday = findViewById((R.id.main_thursday));
        TextView friday = findViewById((R.id.main_friday));
        TextView saturday = findViewById((R.id.main_saturday));
        TextView sunday = findViewById((R.id.main_sunday));

        TextView[] textViews = new TextView[]{monday, tuesday, wednesday, thursday, friday, saturday, sunday};

        Switch active = findViewById(R.id.main_switch);
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
                main_time.setText(String.format("%02d:%02d", alarmClock.getHour(), alarmClock.getMinutes()));

                for (int i = 0; i < 7; i++){
                    if(alarmClock.getDay(i)){
                        textViews[i].setTextColor(ContextCompat.getColor(MainActivity.this, R.color.blue));
                    } else {
                        textViews[i].setTextColor(ContextCompat.getColor(MainActivity.this, R.color.defaultColor));
                    }
                }

                if(alarmClock.isOn()){
                    active.setChecked(true);
                }else{
                    active.setChecked(false);
                }
            }
        }
    }

}
