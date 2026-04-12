package org.example;

public class DataValidationModule {

    public boolean isValid(double nilaiTugas, double nilaiUts, double nilaiUas) {
        boolean semuaDalamRentang = dalamRentangNilai(nilaiTugas)
                && dalamRentangNilai(nilaiUts)
                && dalamRentangNilai(nilaiUas);

        if (!semuaDalamRentang) {
            return false;
        }

        // Semua nol dianggap belum input, maka tidak valid.
        return !(nilaiTugas == 0 && nilaiUts == 0 && nilaiUas == 0);
    }

    private boolean dalamRentangNilai(double nilai) {
        return nilai >= 0 && nilai <= 100;
    }
}
