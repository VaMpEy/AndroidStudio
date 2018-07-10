package urinnenet.de.burnwaxparadise;

public class Material {

    public Material(String type) {
        this.type = type;
    }

    private String type = "Paraffin wax";

    private double density; // Paraffinwachs: 0,90g/cm³, Stearin: 0,93g/cm³, Bienenwachs: 0,95g/cm³

    public void getRightDensity() {
        switch (type) {
            case "Paraffin wax":
                setDensity(0.90);
                break;
            case "Stearin":
                setDensity(0.93);
                break;
            case "Bees wax":
                setDensity(0.95);
                break;
        }
    }

    public void setDensity(double density) {
        this.density = density;
    }

    public double getDensity() {
        return density;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
