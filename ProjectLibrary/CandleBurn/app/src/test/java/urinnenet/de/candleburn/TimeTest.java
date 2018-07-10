package urinnenet.de.candleburn;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimeTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void timeToString() {
        double time = 2.5;
        assertEquals("02:30",Time.asString(time));
    }
}