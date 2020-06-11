package de.haw_hamburg.wecker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;


import de.haw_hamburg.wecker.ReaderService;

public class EditAlarmActivity extends AppCompatActivity {

    private AlarmClock alarmClock = new AlarmClock(8, 0, false);;

    WriterService writerService = new WriterService();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_alarm);

        TimePicker timePicker = findViewById(R.id.timePicker);

        TextView monday = findViewById(R.id.edit_monday);
        TextView tuesday = findViewById(R.id.edit_tuesday);
        TextView wednesday = findViewById(R.id.edit_wednesday);
        TextView thursday = findViewById(R.id.edit_thursday);
        TextView friday = findViewById(R.id.edit_friday);
        TextView saturday = findViewById(R.id.edit_saturday);
        TextView sunday = findViewById(R.id.edit_sunday);

        Switch setActive = findViewById(R.id.edit_switch);
        ImageButton imageButton = findViewById(R.id.edit_save);

        setTextColor(monday, AlarmClock.MONDAY);
        setTextColor(tuesday, AlarmClock.TUESDAY);
        setTextColor(wednesday, AlarmClock.WEDNESDAY);
        setTextColor(thursday, AlarmClock.THURSDAY);
        setTextColor(friday, AlarmClock.FRIDAY);
        setTextColor(saturday, AlarmClock.SATURDAY);
        setTextColor(sunday, AlarmClock.SUNDAY);

        setTime(timePicker);
        setActive(setActive);
        save(imageButton);
    }

    public void setTime(TimePicker timePicker){
        timePicker.setOnTimeChangedListener((TimePicker view, int hour, int minute) -> {
            alarmClock.setHour(hour);
            alarmClock.setMinutes(minute);
        });
    }

    public void setTextColor(TextView textview, int index){
        textview.setOnClickListener(view -> {
            alarmClock.toggleDay(index);
            if(alarmClock.getDay(index)){
                textview.setTextColor(ContextCompat.getColor(EditAlarmActivity.this, R.color.blue));
            } else {
                textview.setTextColor(ContextCompat.getColor(EditAlarmActivity.this, R.color.defaultColor));
            }
        });
    }

    public void setActive(Switch setActive){
        setActive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(alarmClock.isOn()){
                   alarmClock.setOn(false);
               }else {
                   alarmClock.setOn(true);
               }
            }
        });
    }

    public void save(ImageButton imageButton){
        imageButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.i("Test", alarmClock.toString());

                writerService.writeObject(EditAlarmActivity.this, alarmClock);

                Intent intent = new Intent(EditAlarmActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
