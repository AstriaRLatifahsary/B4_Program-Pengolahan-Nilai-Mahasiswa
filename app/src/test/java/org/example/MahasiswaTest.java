package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MahasiswaTest {

    private Mahasiswa mahasiswa;

    @BeforeEach
    void setUp() {
        mahasiswa = new Mahasiswa("221011", "Budi");
    }

    @Test
    void constructorShouldSetIdentityFields() {
        assertEquals("221011", mahasiswa.getNim());
        assertEquals("Budi", mahasiswa.getNama());
    }

    @Test
    void setNilaiShouldUpdateAllScoreFields() {
        mahasiswa.setNilai(80.5, 75.0, 90.0);

        assertEquals(80.5, mahasiswa.getNilaiTugas());
        assertEquals(75.0, mahasiswa.getNilaiUts());
        assertEquals(90.0, mahasiswa.getNilaiUas());
    }

   @Test
    void TC3_NilaiValid() {
        mahasiswa.setNilai(70,80,90);
        assertTrue(mahasiswa.isNilaiValid(new DataValidationModule()));
    }

    @Test
    void TC4_NilaiTidakValid() {
        mahasiswa.setNilai(0,0,0);
        assertFalse(mahasiswa.isNilaiValid(new DataValidationModule()));
    }

    @Test
    void hitungNilaiAkhirShouldDelegateToCalculatorModule() {
        FinalScoreCalculationModule calculator = new FinalScoreCalculationModule();
        mahasiswa.setNilai(80.0, 70.0, 90.0);

        double hasil = mahasiswa.hitungNilaiAkhir(calculator);

        assertEquals(81.0, hasil, 0.0001);
    }

    @Test
    void tentukanGradeShouldUseGradeModuleOverride() {
        GradeDeterminationModule gradeModule = new GradeDeterminationModule();
        ScoreDecisionModule gradeModuleAsBaseType = gradeModule;

        String hasil = mahasiswa.tentukanGrade(gradeModule, 88.0);

        assertEquals("A", hasil);
        assertEquals("A", gradeModuleAsBaseType.determine(88.0));
    }

    @Test
    void tentukanStatusKelulusanShouldUsePassFailModuleOverride() {
        PassFailDeterminationModule passFailModule = new PassFailDeterminationModule();
        ScoreDecisionModule passFailModuleAsBaseType = passFailModule;

        String hasil = mahasiswa.tentukanStatusKelulusan(passFailModule, 58.0);

        assertEquals("Tidak Lulus", hasil);
        assertEquals("Tidak Lulus", passFailModuleAsBaseType.determine(58.0));
    }
}
