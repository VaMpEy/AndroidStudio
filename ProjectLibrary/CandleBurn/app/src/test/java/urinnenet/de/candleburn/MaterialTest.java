package urinnenet.de.candleburn;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaterialTest {

    private final double EXPECTED_DENSITY = 0.93;
    private final double EXPECTED_BURNINGTIME = 6.5;

    Material material;

    @BeforeEach
    void setUp() {
        material = Material.STEARIN;
    }

    @Test
    void getDensity() {
        assertEquals(EXPECTED_DENSITY,material.getDensity(),0.001);
    }

    @Test
    void getBurningTime() {
        assertEquals(EXPECTED_BURNINGTIME,material.getBurningTime(),0.001);
    }
}