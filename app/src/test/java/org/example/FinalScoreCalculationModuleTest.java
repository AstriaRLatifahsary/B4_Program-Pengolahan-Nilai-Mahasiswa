package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FinalScoreCalculationModuleTest {

    private final FinalScoreCalculationModule finalScoreModule = new FinalScoreCalculationModule();

    @Test
    void shouldCalculateCorrectFinalScoreWithValidInputs() {
        // Bobot: Tugas 30%, UTS 30%, UAS 40%
        // (0.3 * 80) + (0.3 * 70) + (0.4 * 90) = 24 + 21 + 36 = 81
        double result = finalScoreModule.calculateFinalScore(80, 70, 90);
        assertEquals(81.0, result);
    }

    @Test
    void shouldReturnNegativeOneWhenInputsInvalid() {
        // Nilai tugas negatif
        double result = finalScoreModule.calculateFinalScore(-1, 70, 90);
        assertEquals(-1, result);
    }

    @Test
    void shouldReturnNegativeOneWhenInputExceedsHundred() {
        // Nilai UTS lebih dari 100
        double result = finalScoreModule.calculateFinalScore(80, 101, 90);
        assertEquals(-1, result);
    }

    @Test
    void shouldReturnNegativeOneWhenAllInputsAreZero() {
        // Semua nilai 0 tidak valid
        double result = finalScoreModule.calculateFinalScore(0, 0, 0);
        assertEquals(-1, result);
    }

    @Test
    void shouldCalculateCorrectlyWithZeroInOneInput() {
        // Salah satu nilai boleh 0
        // (0.3 * 0) + (0.3 * 70) + (0.4 * 90) = 0 + 21 + 36 = 57
        double result = finalScoreModule.calculateFinalScore(0, 70, 90);
        assertEquals(57.0, result);
    }

    @Test
    void shouldCalculateCorrectlyWithAllScoresMaximum() {
        // (0.3 * 100) + (0.3 * 100) + (0.4 * 100) = 30 + 30 + 40 = 100
        double result = finalScoreModule.calculateFinalScore(100, 100, 100);
        assertEquals(100.0, result);
    }

    @Test
    void shouldCalculateCorrectlyWithDifferentWeightDistribution() {
        // (0.3 * 60) + (0.3 * 80) + (0.4 * 100) = 18 + 24 + 40 = 82
        double result = finalScoreModule.calculateFinalScore(60, 80, 100);
        assertEquals(82.0, result);
    }
}
