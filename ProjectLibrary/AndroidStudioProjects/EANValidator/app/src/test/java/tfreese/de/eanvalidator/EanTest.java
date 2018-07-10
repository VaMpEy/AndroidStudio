package tfreese.de.eanvalidator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EanTest {
    final static String EAN_VALID = "4004870001620";
    final static String EAN_INVALID = "4012700961309";

    private Ean ean;

    @BeforeEach
    void setUp() {
        ean = new Ean();
    }

    @Test
    void isValid() {
        ean.setEan(EAN_VALID);
        assertTrue(ean.isValid());

        ean.setEan(EAN_INVALID);
        assertFalse(ean.isValid());
    }
}