package org.example;

public class Mahasiswa {
    private final String nim;
    private final String nama;
    private double nilaiTugas;
    private double nilaiUts;
    private double nilaiUas;

    public Mahasiswa(String nim, String nama) {
        this.nim = nim;
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public String getNama() {
        return nama;
    }

    public double getNilaiTugas() {
        return nilaiTugas;
    }

    public double getNilaiUts() {
        return nilaiUts;
    }

    public double getNilaiUas() {
        return nilaiUas;
    }

    public void setNilai(double nilaiTugas, double nilaiUts, double nilaiUas) {
        this.nilaiTugas = nilaiTugas;
        this.nilaiUts = nilaiUts;
        this.nilaiUas = nilaiUas;
    }

    public boolean isNilaiValid(DataValidationModule validator) {
        return validator.isValid(nilaiTugas, nilaiUts, nilaiUas);
    }

    public double hitungNilaiAkhir(FinalScoreCalculationModule scoreCalculator) {
        return scoreCalculator.calculateFinalScore(nilaiTugas, nilaiUts, nilaiUas);
    }

    public String tentukanGrade(GradeDeterminationModule gradeModule, double nilaiAkhir) {
        return gradeModule.determineGrade(nilaiAkhir);
    }

    public String tentukanStatusKelulusan(PassFailDeterminationModule passFailModule, double nilaiAkhir) {
        return passFailModule.determinePassStatus(nilaiAkhir);
    }
}