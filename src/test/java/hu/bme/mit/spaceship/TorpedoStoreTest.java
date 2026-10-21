package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class TorpedoStoreTest {

    @Test
    void fire_Success() {
        // Arrange
        TorpedoStore store = new TorpedoStore(1);

        // Act
        boolean result = store.fire(1);

        // Assert
        assertEquals(true, result);
    }

    @Test
    void fire_Success_DecreasesTorpedoCount() {
        TorpedoStore store = new TorpedoStore(3, 0.0);

        boolean result = store.fire(1);

        assertTrue(result);
        assertEquals(2, store.getTorpedoCount());
    }

    @Test
    void fire_Failure_LeavesTorpedoCountUnchanged() {
        TorpedoStore store = new TorpedoStore(3, 1.0);

        boolean result = store.fire(1);

        assertFalse(result);
        assertEquals(3, store.getTorpedoCount());
    }
}
