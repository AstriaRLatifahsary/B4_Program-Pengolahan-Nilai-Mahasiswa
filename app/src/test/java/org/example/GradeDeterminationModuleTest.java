package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GradeDeterminationModuleTest {

    private final GradeDeterminationModule gradeModule = new GradeDeterminationModule();

    @Test
    void shouldReturnAForScoreAtLeastEightyFive() {
        System.out.println("\nTC1: P1 - Grade A (nilai >= 85)");
        assertEquals("A", gradeModule.determineGrade(85));
        System.out.println("  Input: 85 -> Result: A");
        assertEquals("A", gradeModule.determineGrade(100));
        System.out.println("  Input: 100 -> Result: A");
    }

    @Test
    void shouldReturnBForScoreBetweenSeventyAndEightyFour() {
        System.out.println("\nTC2: P1 - Grade B (70 <= nilai <= 84)");
        assertEquals("B", gradeModule.determineGrade(70));
        System.out.println("  Input: 70 -> Result: B");
        assertEquals("B", gradeModule.determineGrade(84));
        System.out.println("  Input: 84 -> Result: B");
    }

    @Test
    void shouldReturnCForScoreBetweenSixtyAndSixtyNine() {
        System.out.println("\nTC3: P1 - Grade C (60 <= nilai <= 69)");
        assertEquals("C", gradeModule.determineGrade(60));
        System.out.println("  Input: 60 -> Result: C");
        assertEquals("C", gradeModule.determineGrade(69));
        System.out.println("  Input: 69 -> Result: C");
    }

    @Test
    void shouldReturnDForScoreBetweenFiftyAndFiftyNine() {
        System.out.println("\nTC4: P1 - Grade D (50 <= nilai <= 59)");
        assertEquals("D", gradeModule.determineGrade(50));
        System.out.println("  Input: 50 -> Result: D");
        assertEquals("D", gradeModule.determineGrade(59));
        System.out.println("  Input: 59 -> Result: D");
    }

    @Test
    void shouldReturnEForScoreBelowFifty() {
        System.out.println("\nTC5: P1 - Grade E (nilai < 50)");
        assertEquals("E", gradeModule.determineGrade(49));
        System.out.println("  Input: 49 -> Result: E");
        assertEquals("E", gradeModule.determineGrade(0));
        System.out.println("  Input: 0 -> Result: E");
    }
}
