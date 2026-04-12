package org.example;

public class FinalScoreCalculationModule {

    /**
     * Menghitung nilai akhir berdasarkan bobot:
     * - Nilai Tugas: 30%
     * - Nilai UTS: 30%
     * - Nilai UAS: 40%
     * 
     * @param nilaiTugas nilai tugas (0-100)
     * @param nilaiUts nilai UTS (0-100)
     * @param nilaiUas nilai UAS (0-100)
     * @return nilai akhir, atau -1 jika terjadi error
     */
    public double calculateFinalScore(double nilaiTugas, double nilaiUts, double nilaiUas) {
        // Validasi nilai menggunakan DataValidationModule
        DataValidationModule validator = new DataValidationModule();
        if (!validator.isValid(nilaiTugas, nilaiUts, nilaiUas)) {
            return -1;
        }

        // Hitung nilai akhir dengan bobot
        double nilaiAkhir = (0.3 * nilaiTugas) + (0.3 * nilaiUts) + (0.4 * nilaiUas);

        // Jika hasil perhitungan melebihi 100, dianggap error
        if (nilaiAkhir > 100) {
            return -1;
        }

        return nilaiAkhir;
    }
}
