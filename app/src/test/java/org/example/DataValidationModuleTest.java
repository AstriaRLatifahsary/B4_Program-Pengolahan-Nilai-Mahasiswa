package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DataValidationModuleTest {

    private final DataValidationModule validationModule = new DataValidationModule();

    @Test
    void shouldReturnTrueWhenAllScoresInRangeAndNotAllZero() {
        System.out.println("\nTC1: P1 - Validasi input normal (tugas=80, uts=70, uas=90)");
        assertTrue(validationModule.isValid(80, 70, 90));
        System.out.println("Expected: true, Result: true");
    }

    @Test
    void shouldReturnFalseWhenAnyScoreLessThanZero() {
        System.out.println("\nTC2: P1 - Input negatif (tugas=-1, uts=70, uas=90)");
        assertFalse(validationModule.isValid(-1, 70, 90));
        System.out.println("Expected: false, Result: false");
    }

    @Test
    void shouldReturnFalseWhenAnyScoreMoreThanHundred() {
        System.out.println("\nTC3: P1 - Input melebihi 100 (tugas=80, uts=101, uas=90)");
        assertFalse(validationModule.isValid(80, 101, 90));
        System.out.println("Expected: false, Result: false");
    }

    @Test
    void shouldReturnFalseWhenAllScoresAreZero() {
        System.out.println("\nTC4: P1 - Semua nilai 0 (tugas=0, uts=0, uas=0)");
        assertFalse(validationModule.isValid(0, 0, 0));
        System.out.println("Expected: false, Result: false");
    }

    @Test
    void shouldAllowZeroIfNotAllScoresAreZero() {
        System.out.println("\nTC5: P1 - Salah satu nilai 0 (tugas=0, uts=75, uas=65)");
        assertTrue(validationModule.isValid(0, 75, 65));
        System.out.println("Expected: true, Result: true");
    }
}
