package de.haw_hamburg.wecker;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.Arrays;

public class AlarmClock implements Serializable {

    private int hour;
    private int minutes;
    private boolean[] check = new boolean[7];
    private boolean isOn;

    public static final int MONDAY = 0;
    public static final int TUESDAY = 1;
    public static final int WEDNESDAY = 2;
    public static final int THURSDAY = 3;
    public static final int FRIDAY = 4;
    public static final int SATURDAY = 5;
    public static final int SUNDAY = 6;

    public AlarmClock(int hour, int minutes, boolean isOn){
        super();
        this.hour = hour;
        this.minutes = minutes;
        this.isOn = isOn;

    }
    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public boolean isOn(){
        return isOn;
    }

    public void setOn(boolean On) {
        this.isOn = On;
    }

    public void toggleDay(int index){
        check[index] =! check[index];
    }

    public boolean getDay(int index){
        return check[index];
    }

    private boolean checkIndex(int index) {
        return index < this.check.length && index >= 0;
    }

    @NonNull
    @Override
    public String toString() {
        return "AlarmClock{ " + "Hour: " + hour + " Minutes: " + minutes + " Day: " + Arrays.toString(check) + " Is On: " + isOn + " }";
    }
}
