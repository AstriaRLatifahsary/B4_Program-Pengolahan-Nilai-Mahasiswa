package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FinalScoreCalculationModuleTest {

    private FinalScoreCalculationModule module;

    @BeforeEach
    void setUp() {
        module = new FinalScoreCalculationModule();
    }

    // ======================
    // P1 - VALIDATION ERROR
    // ======================

    @Test
    void shouldReturnNegativeOneWhenNilaiTugasNegative() {
        double result = module.calculateFinalScore(-1.0, 70.0, 80.0);
        System.out.println("\nTC1\nExpected: -1.0, Result: " + result);
        assertEquals(-1.0, result);
    }

    @Test
    void shouldReturnNegativeOneWhenNilaiUtsNegative() {
        double result = module.calculateFinalScore(80.0, -5.0, 90.0);
        System.out.println("\nTC2\nExpected: -1.0, Result: " + result);
        assertEquals(-1.0, result);
    }

    @Test
    void shouldReturnNegativeOneWhenNilaiUasNegative() {
        double result = module.calculateFinalScore(75.0, 85.0, -10.0);
        System.out.println("\nTC3\nExpected: -1.0, Result: " + result);
        assertEquals(-1.0, result);
    }

    @Test
    void shouldReturnNegativeOneWhenAllInputsZero() {
        double result = module.calculateFinalScore(0.0, 0.0, 0.0);
        System.out.println("\nTC4\nExpected: -1.0, Result: " + result);
        assertEquals(-1.0, result);
    }

    @Test
    void shouldReturnNegativeOneWhenNilaiUasExceedsMax_case1() {
        double result = module.calculateFinalScore(100.0, 100.0, 101.0);
        System.out.println("\nTC5\nExpected: -1.0, Result: " + result);
        assertEquals(-1.0, result);
    }

    @Test
    void shouldReturnNegativeOneWhenNilaiUasExceedsMax_case2() {
        double result = module.calculateFinalScore(99.0, 99.0, 101.5);
        System.out.println("\nTC6\nExpected: -1.0, Result: " + result);
        assertEquals(-1.0, result);
    }

    @Test
    void shouldReturnNegativeOneWhenNilaiUtsExceedsMax() {
        double result = module.calculateFinalScore(80.0, 105.0, 90.0);
        System.out.println("\nTC7\nExpected: -1.0, Result: " + result);
        assertEquals(-1.0, result);
    }

    // ======================
    // P3 - VALID CALCULATION
    // ======================

    @Test
    void shouldReturnCorrectFinalScore_case1() {
        double result = module.calculateFinalScore(70.0, 80.0, 90.0);
        System.out.println("\nTC8\nExpected: 81.0, Result: " + result);
        assertEquals(81.0, result);
    }

    @Test
    void shouldReturnCorrectFinalScore_case2() {
        double result = module.calculateFinalScore(50.0, 60.0, 70.0);
        System.out.println("\nTC9\nExpected: 61.0, Result: " + result);
        assertEquals(61.0, result);
    }

    @Test
    void shouldReturnCorrectFinalScore_case3() {
        double result = module.calculateFinalScore(85.0, 90.0, 95.0);
        System.out.println("\nTC10\nExpected: 90.5, Result: " + result);
        assertEquals(90.5, result);
    }

    @Test
    void shouldReturnCorrectFinalScore_boundaryMax() {
        double result = module.calculateFinalScore(100.0, 100.0, 100.0);
        System.out.println("\nTC11\nExpected: 100.0, Result: " + result);
        assertEquals(100.0, result);
    }
}