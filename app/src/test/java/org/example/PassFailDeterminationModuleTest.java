package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PassFailDeterminationModuleTest {

    private PassFailDeterminationModule module;

    @BeforeEach
    void setUp() {
        module = new PassFailDeterminationModule();
    }

    // =====================
    // P1 - TRUE BRANCH (LULUS)
    // =====================

    @Test
    void shouldReturnLulus_case1() {
        String result = module.determinePassStatus(85.0);
        System.out.println("\nTC1\nExpected: Lulus, Result: " + result);
        assertEquals("Lulus", result);
    }

    @Test
    void shouldReturnLulus_case2_boundary() {
        String result = module.determinePassStatus(60.0);
        System.out.println("\nTC2\nExpected: Lulus, Result: " + result);
        assertEquals("Lulus", result);
    }

    @Test
    void shouldReturnLulus_case3_max() {
        String result = module.determinePassStatus(100.0);
        System.out.println("\nTC3\nExpected: Lulus, Result: " + result);
        assertEquals("Lulus", result);
    }

    // =====================
    // P2 - FALSE BRANCH (TIDAK LULUS)
    // =====================

    @Test
    void shouldReturnTidakLulus_case1() {
        String result = module.determinePassStatus(55.0);
        System.out.println("\nTC4\nExpected: Tidak Lulus, Result: " + result);
        assertEquals("Tidak Lulus", result);
    }

    @Test
    void shouldReturnTidakLulus_case2_boundary() {
        String result = module.determinePassStatus(59.9);
        System.out.println("\nTC5\nExpected: Tidak Lulus, Result: " + result);
        assertEquals("Tidak Lulus", result);
    }

    @Test
    void shouldReturnTidakLulus_case3_zero() {
        String result = module.determinePassStatus(0.0);
        System.out.println("\nTC6\nExpected: Tidak Lulus, Result: " + result);
        assertEquals("Tidak Lulus", result);
    }
}