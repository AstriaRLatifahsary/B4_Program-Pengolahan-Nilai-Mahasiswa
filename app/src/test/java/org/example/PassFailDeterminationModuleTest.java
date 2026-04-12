package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PassFailDeterminationModuleTest {

    private final PassFailDeterminationModule passFailModule = new PassFailDeterminationModule();

    @Test
    void shouldReturnLulusWhenScoreIsGreaterThanOrEqualToSixty() {
        assertEquals("Lulus", passFailModule.determinePassStatus(60));
        assertEquals("Lulus", passFailModule.determinePassStatus(70));
        assertEquals("Lulus", passFailModule.determinePassStatus(85));
        assertEquals("Lulus", passFailModule.determinePassStatus(100));
    }

    @Test
    void shouldReturnTidakLulusWhenScoreLessThanSixty() {
        assertEquals("Tidak Lulus", passFailModule.determinePassStatus(59));
        assertEquals("Tidak Lulus", passFailModule.determinePassStatus(50));
        assertEquals("Tidak Lulus", passFailModule.determinePassStatus(0));
    }

    @Test
    void shouldReturnTidakLulusWhenScoreIsNearBoundary() {
        assertEquals("Tidak Lulus", passFailModule.determinePassStatus(59.9));
        assertEquals("Lulus", passFailModule.determinePassStatus(60.0));
        assertEquals("Lulus", passFailModule.determinePassStatus(60.1));
    }
}
