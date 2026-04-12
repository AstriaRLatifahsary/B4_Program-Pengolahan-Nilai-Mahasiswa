/*
 * Integration Test - Menguji integrasi semua modul
 * Test case meliputi: Validasi -> Perhitungan -> Grade -> Kelulusan
 */
package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class IntegrationTest {

    private final DataValidationModule validator = new DataValidationModule();
    private final FinalScoreCalculationModule scoreCalculator = new FinalScoreCalculationModule();
    private final GradeDeterminationModule gradeModule = new GradeDeterminationModule();
    private final PassFailDeterminationModule passFailModule = new PassFailDeterminationModule();

    @Test
    void shouldProcessCompleteFlowForPassingStudentWithGradeA() {
        // Arrange
        double nilaiTugas = 90;
        double nilaiUts = 85;
        double nilaiUas = 92;

        // Act - Complete flow: Validate -> Calculate -> Determine Grade -> Determine Pass Status
        assertTrue(validator.isValid(nilaiTugas, nilaiUts, nilaiUas), "Input harus valid");
        
        double nilaiAkhir = scoreCalculator.calculateFinalScore(nilaiTugas, nilaiUts, nilaiUas);
        assertNotEquals(-1, nilaiAkhir, "Nilai akhir tidak boleh error");
        assertTrue(nilaiAkhir > 0, "Nilai akhir harus positif");

        String grade = gradeModule.determineGrade(nilaiAkhir);
        assertEquals("A", grade, "Grade harus A untuk nilai >= 85");

        String statusKelulusan = passFailModule.determinePassStatus(nilaiAkhir);
        assertEquals("Lulus", statusKelulusan, "Status harus Lulus untuk nilai >= 60");
    }

    @Test
    void shouldProcessCompleteFlowForPassingStudentWithGradeC() {
        // Arrange
        double nilaiTugas = 65;
        double nilaiUts = 60;
        double nilaiUas = 65;

        // Act
        assertTrue(validator.isValid(nilaiTugas, nilaiUts, nilaiUas));
        double nilaiAkhir = scoreCalculator.calculateFinalScore(nilaiTugas, nilaiUts, nilaiUas);
        assertNotEquals(-1, nilaiAkhir);

        String grade = gradeModule.determineGrade(nilaiAkhir);
        assertEquals("C", grade, "Grade harus C untuk rentang 60-69");

        String statusKelulusan = passFailModule.determinePassStatus(nilaiAkhir);
        assertEquals("Lulus", statusKelulusan, "Status harus Lulus");
    }

    @Test
    void shouldProcessCompleteFlowForFailingStudent() {
        // Arrange
        double nilaiTugas = 40;
        double nilaiUts = 45;
        double nilaiUas = 50;

        // Act
        assertTrue(validator.isValid(nilaiTugas, nilaiUts, nilaiUas));
        double nilaiAkhir = scoreCalculator.calculateFinalScore(nilaiTugas, nilaiUts, nilaiUas);
        assertNotEquals(-1, nilaiAkhir);

        String grade = gradeModule.determineGrade(nilaiAkhir);
        assertEquals("E", grade, "Grade harus E untuk nilai < 50");

        String statusKelulusan = passFailModule.determinePassStatus(nilaiAkhir);
        assertEquals("Tidak Lulus", statusKelulusan, "Status harus Tidak Lulus");
    }

    @Test
    void shouldProcessCompleteFlowForBoundaryPassingStudent() {
        // Arrange - Nilai yang menghasilkan akhir tepat 60 (batas lulus)
        double nilaiTugas = 60;
        double nilaiUts = 60;
        double nilaiUas = 60;

        // Act
        assertTrue(validator.isValid(nilaiTugas, nilaiUts, nilaiUas));
        double nilaiAkhir = scoreCalculator.calculateFinalScore(nilaiTugas, nilaiUts, nilaiUas);
        assertEquals(60.0, nilaiAkhir, 0.01, "Nilai akhir harus 60");

        String grade = gradeModule.determineGrade(nilaiAkhir);
        assertEquals("C", grade);

        String statusKelulusan = passFailModule.determinePassStatus(nilaiAkhir);
        assertEquals("Lulus", statusKelulusan, "Status harus Lulus pada batas 60");
    }

    @Test
    void shouldProcessCompleteFlowForBoundaryFailingStudent() {
        // Arrange - Nilai yang menghasilkan akhir tepat 59.9 (dibawah batas lulus)
        double nilaiTugas = 50;
        double nilaiUts = 55;
        double nilaiUas = 65;

        // Act
        assertTrue(validator.isValid(nilaiTugas, nilaiUts, nilaiUas));
        double nilaiAkhir = scoreCalculator.calculateFinalScore(nilaiTugas, nilaiUts, nilaiUas);
        assertTrue(nilaiAkhir < 60, "Nilai akhir harus kurang dari 60");

        String statusKelulusan = passFailModule.determinePassStatus(nilaiAkhir);
        assertEquals("Tidak Lulus", statusKelulusan, "Status harus Tidak Lulus");
    }

    @Test
    void shouldRejectInvalidInputInFlow() {
        // Arrange
        double nilaiTugas = -5;
        double nilaiUts = 70;
        double nilaiUas = 80;

        // Act
        assertFalse(validator.isValid(nilaiTugas, nilaiUts, nilaiUas), "Validasi harus gagal");
        
        double nilaiAkhir = scoreCalculator.calculateFinalScore(nilaiTugas, nilaiUts, nilaiUas);
        assertEquals(-1, nilaiAkhir, "Perhitungan harus return error");
    }

    @Test
    void shouldRejectAllZeroInputInFlow() {
        // Arrange
        double nilaiTugas = 0;
        double nilaiUts = 0;
        double nilaiUas = 0;

        // Act
        assertFalse(validator.isValid(nilaiTugas, nilaiUts, nilaiUas), "Semua 0 harus invalid");
        double nilaiAkhir = scoreCalculator.calculateFinalScore(nilaiTugas, nilaiUts, nilaiUas);
        assertEquals(-1, nilaiAkhir, "Error handling untuk input invalid");
    }

    @Test
    void shouldCalculateCorrectGradeForAllGradeRanges() {
        // Test semua range grade: A, B, C, D, E
        double[] testScores = {85, 75, 65, 55, 40};
        String[] expectedGrades = {"A", "B", "C", "D", "E"};

        for (int i = 0; i < testScores.length; i++) {
            String grade = gradeModule.determineGrade(testScores[i]);
            assertEquals(expectedGrades[i], grade, 
                "Grade untuk nilai " + testScores[i] + " harus " + expectedGrades[i]);
        }
    }

    @Test
    void shouldCalculateCorrectWeightageInFinalScore() {
        // Arrange - Test dengan nilai yang jelas untuk verifikasi bobot
        double nilaiTugas = 100;
        double nilaiUts = 0;
        double nilaiUas = 0;

        // Act
        double nilaiAkhir = scoreCalculator.calculateFinalScore(nilaiTugas, nilaiUts, nilaiUas);

        // Assert - Expected: (0.3 * 100) + (0.3 * 0) + (0.4 * 0) = 30
        assertEquals(30.0, nilaiAkhir, 0.01, "Bobot tugas 30% harus dihitung dengan benar");
    }
}
