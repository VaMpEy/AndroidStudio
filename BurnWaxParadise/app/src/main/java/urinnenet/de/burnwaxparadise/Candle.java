package urinnenet.de.burnwaxparadise;

import android.widget.Toast;

public class Candle {
    private double height; // or lenght - in cm
    private double width; // or diameter - in cm
    private double weight = 1.5;

    private Material material = new Material("Paraffin wax");

    private double burnTime; /* in h:m (hours and minutes)
                                Paraffinwachs: 7,5 g/h, Stearin: 6,5 g/h, Bienenwachs: 4,0 g/h */
    private double density; // Paraffinwachs: 0,90g/cm³, Stearin: 0,93g/cm³, Bienenwachs: 0,95g/cm³

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getDensity() {
        return density;
    }

    public void setDensity(double density) {
        this.density = density;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(String type) {
        this.material = new Material(type);
    }
}
