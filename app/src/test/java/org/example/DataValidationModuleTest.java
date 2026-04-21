package org.example;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class DataValidationModuleTest {

    private final DataValidationModule validationModule = new DataValidationModule();

    // ===================== P1 =====================

    // TC1 - P1: Semua nilai valid
    @Test
    void testAllValidScores() {
        boolean result = validationModule.isValid(80, 70, 90);
        System.out.println("\nTC1 - P1 | Input: 80,70,90");
        System.out.println("Expected: true, Result: " + result);
        assertTrue(result);
    }

    // TC2 - P1: Salah satu nilai 0
    @Test
    void testZeroButNotAllZero() {
        boolean result = validationModule.isValid(0, 70, 90);
        System.out.println("\nTC2 - P1 | Input: 0,70,90");
        System.out.println("Expected: true, Result: " + result);
        assertTrue(result);
    }

    // TC10 - P1: semua nilai di batas atas
    @Test
    void testUpperBoundaryAllHundred() {
        boolean result = validationModule.isValid(100, 100, 100);
        System.out.println("\nTC10 - P1 (Boundary) | Input: 100,100,100");
        System.out.println("Expected: true, Result: " + result);
        assertTrue(result);
    }

    // ===================== P2 =====================

    // TC3 - P2: tugas < 0
    @Test
    void testTugasLessThanZero() {
        boolean result = validationModule.isValid(-5, 70, 90);
        System.out.println("\nTC3 - P2 | Input: -5,70,90");
        System.out.println("Expected: false, Result: " + result);
        assertFalse(result);
    }

    // TC4 - P2: tugas > 100
    @Test
    void testTugasMoreThanHundred() {
        boolean result = validationModule.isValid(105, 70, 90);
        System.out.println("\nTC4 - P2 | Input: 105,70,90");
        System.out.println("Expected: false, Result: " + result);
        assertFalse(result);
    }

    // ===================== P3 =====================

    // TC5 - P3: uts < 0
    @Test
    void testUtsLessThanZero() {
        boolean result = validationModule.isValid(80, -1, 90);
        System.out.println("\nTC5 - P3 | Input: 80,-1,90");
        System.out.println("Expected: false, Result: " + result);
        assertFalse(result);
    }

    // TC6 - P3: uts > 100
    @Test
    void testUtsMoreThanHundred() {
        boolean result = validationModule.isValid(80, 150, 90);
        System.out.println("\nTC6 - P3 | Input: 80,150,90");
        System.out.println("Expected: false, Result: " + result);
        assertFalse(result);
    }

    // ===================== P4 =====================

    // TC7 - P4: uas < 0
    @Test
    void testUasLessThanZero() {
        boolean result = validationModule.isValid(80, 70, -10);
        System.out.println("\nTC7 - P4 | Input: 80,70,-10");
        System.out.println("Expected: false, Result: " + result);
        assertFalse(result);
    }

    // TC8 - P4: uas > 100
    @Test
    void testUasMoreThanHundred() {
        boolean result = validationModule.isValid(80, 70, 200);
        System.out.println("\nTC8 - P4 | Input: 80,70,200");
        System.out.println("Expected: false, Result: " + result);
        assertFalse(result);
    }

    // ===================== P5 =====================

    // TC9 - P5: semua nilai di batas bawah (nilai 0)
    @Test
    void testAllZero() {
        boolean result = validationModule.isValid(0, 0, 0);
        System.out.println("\nTC9 - P5 | Input: 0,0,0");
        System.out.println("Expected: false, Result: " + result);
        assertFalse(result);
    }

    // TC11 - P5: Nilai Desimal
    @Test
    void testDecimalValues() {
        boolean result = validationModule.isValid(85.5, 70.5, 90.0);
        System.out.println("\nTC11 - P1 (Decimal) | Input: 85.5,70.5,90.0");
        System.out.println("Expected: true, Result: " + result);
        assertTrue(result);
    }
}