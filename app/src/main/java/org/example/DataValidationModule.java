package org.example;

public class DataValidationModule {

    public boolean isValid(double nilaiTugas, double nilaiUts, double nilaiUas) {
        // Aturan 2: Jika ada nilai < 0 atau > 100 -> Tidak Valid
        if (nilaiTugas < 0 || nilaiTugas > 100) { // Cek rentang nilai tugas
            return false;
        }
        if (nilaiUts < 0 || nilaiUts > 100) { // Cek rentang nilai UTS
            return false;
        }
        if (nilaiUas < 0 || nilaiUas > 100) { // Cek rentang nilai UAS
            return false;
        }

        // Aturan 3: Jika semua nilai = 0 -> Tidak Valid
        if (nilaiTugas == 0 && nilaiUts == 0 && nilaiUas == 0) {
            return false;
        }

        return true;
    }
}
