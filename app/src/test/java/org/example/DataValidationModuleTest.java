package org.example;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataValidationModuleTest {

    private DataValidationModule validationModule;

    @BeforeEach
    void setUp() {
        validationModule = new DataValidationModule();
    }

    // ===================== P1 =====================

    // TC1 - P1: Semua nilai valid
    @Test
    void testAllValidScores() {
        // (1) setup (arrange, build)
        double nilaiTugas = 80;
        double nilaiUts = 70;
        double nilaiUas = 90;

        // (2) exercise (act, operate)
        boolean result = validationModule.isValid(nilaiTugas, nilaiUts, nilaiUas);

        // (3) verify (assert, check)
        System.out.println("\nTC1 - P1 | Input: 80,70,90");
        System.out.println("Expected: true, Result: " + result);
        assertTrue(result);
    }

    // TC2 - P1: Salah satu nilai 0
    @Test
    void testZeroButNotAllZero() {
        // (1) setup (arrange, build)
        double nilaiTugas = 0;
        double nilaiUts = 70;
        double nilaiUas = 90;

        // (2) exercise (act, operate)
        boolean result = validationModule.isValid(nilaiTugas, nilaiUts, nilaiUas);

        // (3) verify (assert, check)
        System.out.println("\nTC2 - P1 | Input: 0,70,90");
        System.out.println("Expected: true, Result: " + result);
        assertTrue(result);
    }

    // TC10 - P1: semua nilai di batas atas
    @Test
    void testUpperBoundaryAllHundred() {
        // (1) setup (arrange, build)
        double nilaiTugas = 100;
        double nilaiUts = 100;
        double nilaiUas = 100;

        // (2) exercise (act, operate)
        boolean result = validationModule.isValid(nilaiTugas, nilaiUts, nilaiUas);

        // (3) verify (assert, check)
        System.out.println("\nTC10 - P1 (Boundary) | Input: 100,100,100");
        System.out.println("Expected: true, Result: " + result);
        assertTrue(result);
    }

    // ===================== P2 =====================

    // TC3 - P2: tugas < 0
    @Test
    void testTugasLessThanZero() {
        // (1) setup (arrange, build)
        double nilaiTugas = -5;
        double nilaiUts = 70;
        double nilaiUas = 90;

        // (2) exercise (act, operate)
        boolean result = validationModule.isValid(nilaiTugas, nilaiUts, nilaiUas);

        // (3) verify (assert, check)
        System.out.println("\nTC3 - P2 | Input: -5,70,90");
        System.out.println("Expected: false, Result: " + result);
        assertFalse(result);
    }

    // TC4 - P2: tugas > 100
    @Test
    void testTugasMoreThanHundred() {
        // (1) setup (arrange, build)
        double nilaiTugas = 105;
        double nilaiUts = 70;
        double nilaiUas = 90;

        // (2) exercise (act, operate)
        boolean result = validationModule.isValid(nilaiTugas, nilaiUts, nilaiUas);

        // (3) verify (assert, check)
        System.out.println("\nTC4 - P2 | Input: 105,70,90");
        System.out.println("Expected: false, Result: " + result);
        assertFalse(result);
    }

    // ===================== P3 =====================

    // TC5 - P3: uts < 0
    @Test
    void testUtsLessThanZero() {
        // (1) setup (arrange, build)
        double nilaiTugas = 80;
        double nilaiUts = -1;
        double nilaiUas = 90;

        // (2) exercise (act, operate)
        boolean result = validationModule.isValid(nilaiTugas, nilaiUts, nilaiUas);

        // (3) verify (assert, check)
        System.out.println("\nTC5 - P3 | Input: 80,-1,90");
        System.out.println("Expected: false, Result: " + result);
        assertFalse(result);
    }

    // TC6 - P3: uts > 100
    @Test
    void testUtsMoreThanHundred() {
        // (1) setup (arrange, build)
        double nilaiTugas = 80;
        double nilaiUts = 150;
        double nilaiUas = 90;

        // (2) exercise (act, operate)
        boolean result = validationModule.isValid(nilaiTugas, nilaiUts, nilaiUas);

        // (3) verify (assert, check)
        System.out.println("\nTC6 - P3 | Input: 80,150,90");
        System.out.println("Expected: false, Result: " + result);
        assertFalse(result);
    }

    // ===================== P4 =====================

    // TC7 - P4: uas < 0
    @Test
    void testUasLessThanZero() {
        // (1) setup (arrange, build)
        double nilaiTugas = 80;
        double nilaiUts = 70;
        double nilaiUas = -10;

        // (2) exercise (act, operate)
        boolean result = validationModule.isValid(nilaiTugas, nilaiUts, nilaiUas);

        // (3) verify (assert, check)
        System.out.println("\nTC7 - P4 | Input: 80,70,-10");
        System.out.println("Expected: false, Result: " + result);
        assertFalse(result);
    }

    // TC8 - P4: uas > 100
    @Test
    void testUasMoreThanHundred() {
        // (1) setup (arrange, build)
        double nilaiTugas = 80;
        double nilaiUts = 70;
        double nilaiUas = 200;

        // (2) exercise (act, operate)
        boolean result = validationModule.isValid(nilaiTugas, nilaiUts, nilaiUas);

        // (3) verify (assert, check)
        System.out.println("\nTC8 - P4 | Input: 80,70,200");
        System.out.println("Expected: false, Result: " + result);
        assertFalse(result);
    }

    // ===================== P5 =====================

    // TC9 - P5: semua nilai di batas bawah (nilai 0)
    @Test
    void testAllZero() {
        // (1) setup (arrange, build)
        double nilaiTugas = 0;
        double nilaiUts = 0;
        double nilaiUas = 0;

        // (2) exercise (act, operate)
        boolean result = validationModule.isValid(nilaiTugas, nilaiUts, nilaiUas);

        // (3) verify (assert, check)
        System.out.println("\nTC9 - P5 | Input: 0,0,0");
        System.out.println("Expected: false, Result: " + result);
        assertFalse(result);
    }

    // TC11 - P5: Nilai Desimal
    @Test
    void testDecimalValues() {
        // (1) setup (arrange, build)
        double nilaiTugas = 85.5;
        double nilaiUts = 70.5;
        double nilaiUas = 90.0;

        // (2) exercise (act, operate)
        boolean result = validationModule.isValid(nilaiTugas, nilaiUts, nilaiUas);

        // (3) verify (assert, check)
        System.out.println("\nTC11 - P1 (Decimal) | Input: 85.5,70.5,90.0");
        System.out.println("Expected: true, Result: " + result);
        assertTrue(result);
    }
}