package tfreese.de.candleburn;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CandleTest {
    private final static double LENGTH = 20.0;
    private final static double DIAMETER = 3.5;
    private final static Material MATERIAL = Material.STEARIN;

    private final static double EXPECTED_BURNING_TIME = 27.53;
    private final static String EXPECTED_BURNING_TIME_STRING = "27:31";
    private final static double EXPECTED_VOLUME = 192.42;
    private final static double EXPECTED_WEIGHT = 178.95;

    private Candle candle;

    @BeforeEach
    void setUp() {
        candle = new Candle(LENGTH,DIAMETER,MATERIAL);
    }

    @Test
    void getVolume() {
        assertEquals(EXPECTED_VOLUME, candle.getVolume(),0.01);
    }

    @Test
    void getWeight() {
        assertEquals(EXPECTED_WEIGHT, candle.getWeight(),0.01);
    }

    @Test
    void getBurningtime() {
        assertEquals(EXPECTED_BURNING_TIME, candle.getBurningtime(),0.01);
    }

    @Test
    void getBurningtimeAsString() {
        assertEquals(EXPECTED_BURNING_TIME_STRING, candle.getBurningtimeAsString());
    }
}