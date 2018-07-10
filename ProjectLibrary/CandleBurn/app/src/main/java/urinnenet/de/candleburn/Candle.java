package urinnenet.de.candleburn;

public class Candle {
    private double length;
    private double diameter;
    private Material material;

    public Candle(double length, double diameter, Material material) {
        setLength(length);
        setDiameter(diameter);
        setMaterial(material);
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        if (length > 0)
            this.length = length;
        else
            this.length = 0.0;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        if (diameter > 0)
            this.diameter = diameter;
        else
            this.diameter = 0.0;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public double getVolume() {
        double radius = diameter / 2.0;
        return radius * radius * Math.PI * length;
        //return Math.pow(diameter/2,2) * Math.PI * length;
    }

    public double getWeight() {
        return getVolume() * material.getDensity();
    }

    public double getBurningtime() {
        return getWeight() / material.getBurningTime();
    }

    public String getBurningTimeAsString() {
        return Time.asString(getBurningtime());
    }
}
