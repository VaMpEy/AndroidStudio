package tfreese.de.candleburn;

public class Candle {
    private double length;
    private double diameter;
    private Material material;

    public Candle(double length, double diameter, Material material) {
        setLength(length);
        setDiameter(diameter);
        this.material = material;
    }

    public void setLength(double length) {
        if (length > 0.0)
            this.length = length;
        else
            this.length = 0.0;
    }

    public void setDiameter(double diameter) {
        if (length > 0.0)
            this.diameter = diameter;
        else
            this.diameter = 0.0;
    }

    public double getVolume() {
        double radius = diameter / 2.0;
        return radius * radius * Math.PI * length;
//        return Math.pow(diameter/2, 2) * Math.PI * length;
    }

    public double getWeight() {
        return getVolume() * material.getDensity();
    }

    public double getBurningtime() {
        return getWeight() / material.getBurningtime();
    }

    public String getBurningtimeAsString() {
        return Time.asString(getBurningtime());
    }

}
