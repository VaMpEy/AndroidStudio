package tfreese.de.candleburn;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimeTest {

    @Test
    void timeToString() {
        double time = 2.5;
        assertEquals("02:30",Time.asString(time));
    }
}