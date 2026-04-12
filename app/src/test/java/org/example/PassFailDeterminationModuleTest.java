package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PassFailDeterminationModuleTest {

    private final PassFailDeterminationModule passFailModule = new PassFailDeterminationModule();

    @Test
    void shouldReturnLulusWhenScoreIsGreaterThanOrEqualToSixty() {
        System.out.println("\nTC1: P1 - Status Lulus (nilai >= 60)");
        assertEquals("Lulus", passFailModule.determinePassStatus(60));
        System.out.println("  Input: 60 -> Result: Lulus");
        assertEquals("Lulus", passFailModule.determinePassStatus(70));
        System.out.println("  Input: 70 -> Result: Lulus");
        assertEquals("Lulus", passFailModule.determinePassStatus(85));
        System.out.println("  Input: 85 -> Result: Lulus");
        assertEquals("Lulus", passFailModule.determinePassStatus(100));
        System.out.println("  Input: 100 -> Result: Lulus");
    }

    @Test
    void shouldReturnTidakLulusWhenScoreLessThanSixty() {
        System.out.println("\nTC2: P1 - Status Tidak Lulus (nilai < 60)");
        assertEquals("Tidak Lulus", passFailModule.determinePassStatus(59));
        System.out.println("  Input: 59 -> Result: Tidak Lulus");
        assertEquals("Tidak Lulus", passFailModule.determinePassStatus(50));
        System.out.println("  Input: 50 -> Result: Tidak Lulus");
        assertEquals("Tidak Lulus", passFailModule.determinePassStatus(0));
        System.out.println("  Input: 0 -> Result: Tidak Lulus");
    }

    @Test
    void shouldReturnTidakLulusWhenScoreIsNearBoundary() {
        System.out.println("\nTC3: P1 - Boundary Testing (nilai sekitar 60)");
        assertEquals("Tidak Lulus", passFailModule.determinePassStatus(59.9));
        System.out.println("  Input: 59.9 -> Result: Tidak Lulus");
        assertEquals("Lulus", passFailModule.determinePassStatus(60.0));
        System.out.println("  Input: 60.0 -> Result: Lulus");
        assertEquals("Lulus", passFailModule.determinePassStatus(60.1));
        System.out.println("  Input: 60.1 -> Result: Lulus");
    }
}
