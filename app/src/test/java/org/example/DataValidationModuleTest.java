package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DataValidationModuleTest {

    private final DataValidationModule validationModule = new DataValidationModule();

    @Test
    void shouldReturnTrueWhenAllScoresInRangeAndNotAllZero() {
        assertTrue(validationModule.isValid(80, 70, 90));
    }

    @Test
    void shouldReturnFalseWhenAnyScoreLessThanZero() {
        assertFalse(validationModule.isValid(-1, 70, 90));
    }

    @Test
    void shouldReturnFalseWhenAnyScoreMoreThanHundred() {
        assertFalse(validationModule.isValid(80, 101, 90));
    }

    @Test
    void shouldReturnFalseWhenAllScoresAreZero() {
        assertFalse(validationModule.isValid(0, 0, 0));
    }

    @Test
    void shouldAllowZeroIfNotAllScoresAreZero() {
        assertTrue(validationModule.isValid(0, 75, 65));
    }
}
