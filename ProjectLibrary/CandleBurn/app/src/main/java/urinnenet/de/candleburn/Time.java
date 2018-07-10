package urinnenet.de.candleburn;

public class Time {
    public static String asString(double decimalTime) {
        int hours = (int) decimalTime;
        int minutes = (int) ((decimalTime - (double) hours) * 60.0);
        return String.format("%02d:%02d", hours, minutes);
    }
}