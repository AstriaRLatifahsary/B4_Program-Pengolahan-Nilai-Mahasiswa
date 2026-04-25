package org.example;

public class PassFailDeterminationModule extends ScoreDecisionModule {

    /**
     * Menentukan status kelulusan berdasarkan nilai akhir.
     * Kriteria: Nilai >= 60 = Lulus, Nilai < 60 = Tidak Lulus
     * 
     * @param nilaiAkhir nilai akhir mahasiswa
     * @return "Lulus" jika nilai >= 60, "Tidak Lulus" jika nilai < 60
     */
    public String determinePassStatus(double nilaiAkhir) {
        return determine(nilaiAkhir);
    }

    @Override
    public String determine(double nilaiAkhir) {
        if (nilaiAkhir >= 60) {
            return "Lulus";
        }
        return "Tidak Lulus";
    }
}
