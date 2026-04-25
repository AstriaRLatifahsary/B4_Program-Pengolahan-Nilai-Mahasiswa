package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FinalScoreCalculationModuleTest {

    private FinalScoreCalculationModule finalScoreModule;

    @BeforeEach
    void setUp() {
        finalScoreModule = new FinalScoreCalculationModule();
    }

    @Test
    void shouldCalculateCorrectFinalScoreWithValidInputs() {
        // Bobot: Tugas 30%, UTS 30%, UAS 40%
        // (0.3 * 80) + (0.3 * 70) + (0.4 * 90) = 24 + 21 + 36 = 81
        // (1) setup (arrange, build)
        double nilaiTugas = 80;
        double nilaiUts = 70;
        double nilaiUas = 90;

        // (2) exercise (act, operate)
        System.out.println("\nTC1: P1 - Kalkulasi nilaiAkhir dengan nilai normal (tugas=80, uts=70, uas=90)");
        double result = finalScoreModule.calculateFinalScore(nilaiTugas, nilaiUts, nilaiUas);

        // (3) verify (assert, check)
        System.out.println("Expected: 81.0, Result: " + result);
        assertEquals(81.0, result);
    }

    @Test
    void shouldReturnNegativeOneWhenInputsInvalid() {
        // Nilai tugas negatif
        // (1) setup (arrange, build)
        double nilaiTugas = -1;
        double nilaiUts = 70;
        double nilaiUas = 90;

        // (2) exercise (act, operate)
        System.out.println("\nTC2: P1 - Input tidak valid (tugas=-1, uts=70, uas=90)");
        double result = finalScoreModule.calculateFinalScore(nilaiTugas, nilaiUts, nilaiUas);

        // (3) verify (assert, check)
        System.out.println("Expected: -1, Result: " + result);
        assertEquals(-1, result);
    }

    @Test
    void shouldReturnNegativeOneWhenInputExceedsHundred() {
        // Nilai UTS lebih dari 100
        // (1) setup (arrange, build)
        double nilaiTugas = 80;
        double nilaiUts = 101;
        double nilaiUas = 90;

        // (2) exercise (act, operate)
        System.out.println("\nTC3: P1 - Input melebihi 100 (tugas=80, uts=101, uas=90)");
        double result = finalScoreModule.calculateFinalScore(nilaiTugas, nilaiUts, nilaiUas);

        // (3) verify (assert, check)
        System.out.println("Expected: -1, Result: " + result);
        assertEquals(-1, result);
    }

    @Test
    void shouldReturnNegativeOneWhenAllInputsAreZero() {
        // Semua nilai 0 tidak valid
        // (1) setup (arrange, build)
        double nilaiTugas = 0;
        double nilaiUts = 0;
        double nilaiUas = 0;

        // (2) exercise (act, operate)
        System.out.println("\nTC4: P1 - Semua nilai 0 (tugas=0, uts=0, uas=0)");
        double result = finalScoreModule.calculateFinalScore(nilaiTugas, nilaiUts, nilaiUas);

        // (3) verify (assert, check)
        System.out.println("Expected: -1, Result: " + result);
        assertEquals(-1, result);
    }

    @Test
    void shouldCalculateCorrectlyWithZeroInOneInput() {
        // Salah satu nilai boleh 0
        // (0.3 * 0) + (0.3 * 70) + (0.4 * 90) = 0 + 21 + 36 = 57
        // (1) setup (arrange, build)
        double nilaiTugas = 0;
        double nilaiUts = 70;
        double nilaiUas = 90;

        // (2) exercise (act, operate)
        System.out.println("\nTC5: P1 - Salah satu nilai 0 (tugas=0, uts=70, uas=90)");
        double result = finalScoreModule.calculateFinalScore(nilaiTugas, nilaiUts, nilaiUas);

        // (3) verify (assert, check)
        System.out.println("Expected: 57.0, Result: " + result);
        assertEquals(57.0, result);
    }

    @Test
    void shouldCalculateCorrectlyWithAllScoresMaximum() {
        // (0.3 * 100) + (0.3 * 100) + (0.4 * 100) = 30 + 30 + 40 = 100
        // (1) setup (arrange, build)
        double nilaiTugas = 100;
        double nilaiUts = 100;
        double nilaiUas = 100;

        // (2) exercise (act, operate)
        System.out.println("\nTC6: P1 - Semua nilai maksimal (tugas=100, uts=100, uas=100)");
        double result = finalScoreModule.calculateFinalScore(nilaiTugas, nilaiUts, nilaiUas);

        // (3) verify (assert, check)
        System.out.println("Expected: 100.0, Result: " + result);
        assertEquals(100.0, result);
    }

    @Test
    void shouldCalculateCorrectlyWithDifferentWeightDistribution() {
        // (0.3 * 60) + (0.3 * 80) + (0.4 * 100) = 18 + 24 + 40 = 82
        // (1) setup (arrange, build)
        double nilaiTugas = 60;
        double nilaiUts = 80;
        double nilaiUas = 100;

        // (2) exercise (act, operate)
        System.out.println("\nTC7: P1 - Nilai desimal (tugas=60, uts=80, uas=100)");
        double result = finalScoreModule.calculateFinalScore(nilaiTugas, nilaiUts, nilaiUas);

        // (3) verify (assert, check)
        System.out.println("Expected: 82.0, Result: " + result);
        assertEquals(82.0, result);
    }
}
