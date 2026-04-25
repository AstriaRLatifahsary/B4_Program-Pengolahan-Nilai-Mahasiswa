package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GradeDeterminationModuleTest {

    private GradeDeterminationModule gradeModule;

    @BeforeEach
    void setUp() {
        gradeModule = new GradeDeterminationModule();
    }

    @Test
    void TC1_P1_BatasBawahGradeA() {
        System.out.println("\nTC1: P1 - Menguji batas bawah Grade A (>=85)");
        // (1) setup (arrange, build)
        double nilaiAkhir = 85;

        // (2) exercise (act, operate)
        String actual = gradeModule.determineGrade(nilaiAkhir);

        // (3) verify (assert, check)
        assertEquals("A", actual);
    }

    @Test
    void TC2_P1_BatasAtasGradeA() {
        System.out.println("\nTC2: P1 - Menguji batas atas Grade A");
        // (1) setup (arrange, build)
        double nilaiAkhir = 100;

        // (2) exercise (act, operate)
        String actual = gradeModule.determineGrade(nilaiAkhir);

        // (3) verify (assert, check)
        assertEquals("A", actual);
    }

    @Test
    void TC3_P2_BatasBawahGradeB() {
        System.out.println("\nTC3: P2 - Menguji batas bawah Grade B");
        // (1) setup (arrange, build)
        double nilaiAkhir = 70;

        // (2) exercise (act, operate)
        String actual = gradeModule.determineGrade(nilaiAkhir);

        // (3) verify (assert, check)
        assertEquals("B", actual);
    }

    @Test
    void TC4_P2_BatasAtasGradeB() {
        System.out.println("\nTC4: P2 - Menguji batas atas Grade B");
        // (1) setup (arrange, build)
        double nilaiAkhir = 84;

        // (2) exercise (act, operate)
        String actual = gradeModule.determineGrade(nilaiAkhir);

        // (3) verify (assert, check)
        assertEquals("B", actual);
    }

    @Test
    void TC5_P3_BatasBawahGradeC() {
        System.out.println("\nTC5: P3 - Menguji batas bawah Grade C");
        // (1) setup (arrange, build)
        double nilaiAkhir = 60;

        // (2) exercise (act, operate)
        String actual = gradeModule.determineGrade(nilaiAkhir);

        // (3) verify (assert, check)
        assertEquals("C", actual);
    }

    @Test
    void TC6_P3_BatasAtasGradeC() {
        System.out.println("\nTC6: P3 - Menguji batas atas Grade C");
        // (1) setup (arrange, build)
        double nilaiAkhir = 69;

        // (2) exercise (act, operate)
        String actual = gradeModule.determineGrade(nilaiAkhir);

        // (3) verify (assert, check)
        assertEquals("C", actual);
    }

    @Test
    void TC7_P4_BatasBawahGradeD() {
        System.out.println("\nTC7: P4 - Menguji batas bawah Grade D");
        // (1) setup (arrange, build)
        double nilaiAkhir = 50;

        // (2) exercise (act, operate)
        String actual = gradeModule.determineGrade(nilaiAkhir);

        // (3) verify (assert, check)
        assertEquals("D", actual);
    }

    @Test
    void TC8_P4_BatasAtasGradeD() {
        System.out.println("\nTC8: P4 - Menguji batas atas Grade D");
        // (1) setup (arrange, build)
        double nilaiAkhir = 59;

        // (2) exercise (act, operate)
        String actual = gradeModule.determineGrade(nilaiAkhir);

        // (3) verify (assert, check)
        assertEquals("D", actual);
    }

    @Test
    void TC9_P5_NilaiDibawah50() {
        System.out.println("\nTC9: P5 - Menguji nilai di bawah 50");
        // (1) setup (arrange, build)
        double nilaiAkhir = 49;

        // (2) exercise (act, operate)
        String actual = gradeModule.determineGrade(nilaiAkhir);

        // (3) verify (assert, check)
        assertEquals("E", actual);
    }

    @Test
    void TC10_P5_NilaiMinimum() {
        System.out.println("\nTC10: P5 - Menguji nilai minimum");
        // (1) setup (arrange, build)
        double nilaiAkhir = 0;

        // (2) exercise (act, operate)
        String actual = gradeModule.determineGrade(nilaiAkhir);

        // (3) verify (assert, check)
        assertEquals("E", actual);
    }
}