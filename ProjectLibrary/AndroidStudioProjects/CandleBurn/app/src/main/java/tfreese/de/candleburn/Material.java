package tfreese.de.candleburn;

public enum Material {
    PARAFFIN_WAX(0.9, 7.5),
    STEARIN(0.93, 6.5),
    BEESWAX(0.95, 4.0);

    private double density;
    private double burningtime;

    Material(double density, double burningtime) {
        this.density = density;
        this.burningtime = burningtime;
    }

    public double getDensity() {
        return density;
    }

    public double getBurningtime() {
        return burningtime;
    }
}
