package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PassFailDeterminationModuleTest {

    private PassFailDeterminationModule passFailModule;

    @BeforeEach
    void setUp() {
        passFailModule = new PassFailDeterminationModule();
    }

    @Test
    void shouldReturnLulusWhenScoreIsGreaterThanOrEqualToSixty() {
        System.out.println("\nTC1: P1 - Status Lulus (nilai >= 60)");
        // (1) setup (arrange, build)
        double nilai1 = 60;
        double nilai2 = 70;
        double nilai3 = 85;
        double nilai4 = 100;

        // (2) exercise (act, operate)
        String actual1 = passFailModule.determinePassStatus(nilai1);
        String actual2 = passFailModule.determinePassStatus(nilai2);
        String actual3 = passFailModule.determinePassStatus(nilai3);
        String actual4 = passFailModule.determinePassStatus(nilai4);

        // (3) verify (assert, check)
        assertEquals("Lulus", actual1);
        System.out.println("  Input: 60 -> Result: Lulus");
        assertEquals("Lulus", actual2);
        System.out.println("  Input: 70 -> Result: Lulus");
        assertEquals("Lulus", actual3);
        System.out.println("  Input: 85 -> Result: Lulus");
        assertEquals("Lulus", actual4);
        System.out.println("  Input: 100 -> Result: Lulus");
    }

    @Test
    void shouldReturnTidakLulusWhenScoreLessThanSixty() {
        System.out.println("\nTC2: P1 - Status Tidak Lulus (nilai < 60)");
        // (1) setup (arrange, build)
        double nilai1 = 59;
        double nilai2 = 50;
        double nilai3 = 0;

        // (2) exercise (act, operate)
        String actual1 = passFailModule.determinePassStatus(nilai1);
        String actual2 = passFailModule.determinePassStatus(nilai2);
        String actual3 = passFailModule.determinePassStatus(nilai3);

        // (3) verify (assert, check)
        assertEquals("Tidak Lulus", actual1);
        System.out.println("  Input: 59 -> Result: Tidak Lulus");
        assertEquals("Tidak Lulus", actual2);
        System.out.println("  Input: 50 -> Result: Tidak Lulus");
        assertEquals("Tidak Lulus", actual3);
        System.out.println("  Input: 0 -> Result: Tidak Lulus");
    }

    @Test
    void shouldReturnTidakLulusWhenScoreIsNearBoundary() {
        System.out.println("\nTC3: P1 - Boundary Testing (nilai sekitar 60)");
        // (1) setup (arrange, build)
        double nilai1 = 59.9;
        double nilai2 = 60.0;
        double nilai3 = 60.1;

        // (2) exercise (act, operate)
        String actual1 = passFailModule.determinePassStatus(nilai1);
        String actual2 = passFailModule.determinePassStatus(nilai2);
        String actual3 = passFailModule.determinePassStatus(nilai3);

        // (3) verify (assert, check)
        assertEquals("Tidak Lulus", actual1);
        System.out.println("  Input: 59.9 -> Result: Tidak Lulus");
        assertEquals("Lulus", actual2);
        System.out.println("  Input: 60.0 -> Result: Lulus");
        assertEquals("Lulus", actual3);
        System.out.println("  Input: 60.1 -> Result: Lulus");
    }
}
