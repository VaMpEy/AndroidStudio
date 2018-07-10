package urinnenet.de.eanvalidierung;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EANTest {
    final static String EAN_VALID = "4004870001620";
    final static String EAN_INVALID = "4012700961309";

    private EAN ean;

    @BeforeEach
    void setUp() {
        ean = new Ean();
    }

    @Test
    void isValid() {
        ean.setValue(EAN_VALID);
        assertTrue(isValid());

        ean.setValue(EAN_INVALID);
        assertFalse(isValid());
    }
}