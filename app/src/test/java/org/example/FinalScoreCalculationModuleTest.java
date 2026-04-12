package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FinalScoreCalculationModuleTest {

    private final FinalScoreCalculationModule scoreModule = new FinalScoreCalculationModule();

    // Test case untuk perhitungan yang valid
    @Test
    void shouldCalculateCorrectFinalScoreWithValidInput() {
        double result = scoreModule.calculateFinalScore(80, 70, 90);
        double expected = (0.3 * 80) + (0.3 * 70) + (0.4 * 90);
        assertEquals(expected, result, 0.01);
    }

    @Test
    void shouldCalculateCorrectFinalScoreWithDifferentValues() {
        double result = scoreModule.calculateFinalScore(90, 85, 95);
        double expected = (0.3 * 90) + (0.3 * 85) + (0.4 * 95);
        assertEquals(expected, result, 0.01);
    }

    @Test
    void shouldCalculateCorrectFinalScoreWithMinimumValidValues() {
        double result = scoreModule.calculateFinalScore(0.1, 0.1, 0.1);
        double expected = (0.3 * 0.1) + (0.3 * 0.1) + (0.4 * 0.1);
        assertEquals(expected, result, 0.01);
    }

    // Test case untuk input tidak valid (negative values)
    @Test
    void shouldReturnErrorWhenAnyScoreIsNegative() {
        assertEquals(-1, scoreModule.calculateFinalScore(-1, 70, 90));
        assertEquals(-1, scoreModule.calculateFinalScore(80, -5, 90));
        assertEquals(-1, scoreModule.calculateFinalScore(80, 70, -10));
    }

    // Test case untuk input tidak valid (nilai > 100)
    @Test
    void shouldReturnErrorWhenAnyScoreIsMoreThanHundred() {
        assertEquals(-1, scoreModule.calculateFinalScore(101, 70, 90));
        assertEquals(-1, scoreModule.calculateFinalScore(80, 101, 90));
        assertEquals(-1, scoreModule.calculateFinalScore(80, 70, 101));
    }

    // Test case untuk semua nilai 0 (dianggap belum input)
    @Test
    void shouldReturnErrorWhenAllScoresAreZero() {
        assertEquals(-1, scoreModule.calculateFinalScore(0, 0, 0));
    }

    @Test
    void shouldCalculateMaximumScoreCorrectly() {
        // Nilai maksimal yang valid adalah 100 untuk semua
        // Hasil: (0.3 * 100) + (0.3 * 100) + (0.4 * 100) = 100
        double result = scoreModule.calculateFinalScore(100, 100, 100);
        assertEquals(100.0, result, 0.01);
    }

    @Test
    void shouldCalculateCorrectlyWithZeroInOneComponent() {
        double result = scoreModule.calculateFinalScore(0, 80, 100);
        double expected = (0.3 * 0) + (0.3 * 80) + (0.4 * 100);
        assertEquals(expected, result, 0.01);
    }
}
