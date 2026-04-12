package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GradeDeterminationModuleTest {

    private final GradeDeterminationModule gradeModule = new GradeDeterminationModule();

    @Test
    void shouldReturnAForScoreAtLeastEightyFive() {
        assertEquals("A", gradeModule.determineGrade(85));
        assertEquals("A", gradeModule.determineGrade(100));
    }

    @Test
    void shouldReturnBForScoreBetweenSeventyAndEightyFour() {
        assertEquals("B", gradeModule.determineGrade(70));
        assertEquals("B", gradeModule.determineGrade(84));
    }

    @Test
    void shouldReturnCForScoreBetweenSixtyAndSixtyNine() {
        assertEquals("C", gradeModule.determineGrade(60));
        assertEquals("C", gradeModule.determineGrade(69));
    }

    @Test
    void shouldReturnDForScoreBetweenFiftyAndFiftyNine() {
        assertEquals("D", gradeModule.determineGrade(50));
        assertEquals("D", gradeModule.determineGrade(59));
    }

    @Test
    void shouldReturnEForScoreBelowFifty() {
        assertEquals("E", gradeModule.determineGrade(49));
        assertEquals("E", gradeModule.determineGrade(0));
    }
}
