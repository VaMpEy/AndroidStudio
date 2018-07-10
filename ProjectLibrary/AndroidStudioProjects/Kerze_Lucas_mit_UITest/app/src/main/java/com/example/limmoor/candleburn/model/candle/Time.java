package com.example.limmoor.candleburn.model.candle;

public class Time {
    private int hours;
    private int minutes;

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void calcWithDecimals(double hours){
        hours = hours > 0 ? hours : 0;
        this.hours = (int) hours;
        this.minutes = (int) (60 * hours - (this.hours*60));
    }

    @Override
    public String toString() {
        return hours + ":"+ minutes;
    }
}
