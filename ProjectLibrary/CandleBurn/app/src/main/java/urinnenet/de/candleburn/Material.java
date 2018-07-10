package urinnenet.de.candleburn;

public enum Material {
    PARAFFIN_WAX(0.9,7.5), // enum rufen Konstruktor auf
    STEARIN(0.93,6.5),
    BEESWAX(0.95,4.0);

    private double density;
    private double burningTime;

    Material(double density, double burningTime) {
        this.density = density;
        this.burningTime = burningTime;
    }

    public double getDensity() {
        return density;
    }

    public double getBurningTime() {
        return burningTime;
    }
}
