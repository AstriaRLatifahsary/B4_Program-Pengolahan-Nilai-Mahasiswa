/*
 * Program Pengolahan Nilai Mahasiswa
 * Mengintegrasikan modul validasi, perhitungan nilai akhir, penentuan grade, dan status kelulusan
 */
package org.example;

import java.util.Scanner;

public class App {
    private static final DataValidationModule validator = new DataValidationModule();
    private static final FinalScoreCalculationModule scoreCalculator = new FinalScoreCalculationModule();
    private static final GradeDeterminationModule gradeModule = new GradeDeterminationModule();
    private static final PassFailDeterminationModule passFailModule = new PassFailDeterminationModule();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════╗");
        System.out.println("║     SISTEM PENGOLAHAN NILAI MAHASISWA             ║");
        System.out.println("╚════════════════════════════════════════════════════╝\n");

        boolean isRunning = true;
        while (isRunning) {
            displayMenu();
            int choice = getUserMenuChoice();

            switch (choice) {
                case 1:
                    processStudentGrades();
                    break;
                case 2:
                    System.out.println("\n✓ Terima kasih telah menggunakan sistem ini. Sampai jumpa!");
                    isRunning = false;
                    break;
                default:
                    System.out.println("✗ Pilihan tidak valid. Silakan coba lagi.\n");
            }
        }

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("           MENU UTAMA");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("1. Proses Nilai Mahasiswa");
        System.out.println("2. Keluar");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.print("Pilihan Anda (1-2): ");
    }

    private static int getUserMenuChoice() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void processStudentGrades() {
        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("          INPUT NILAI MAHASISWA");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

        double nilaiTugas = 0;
        double nilaiUts = 0;
        double nilaiUas = 0;
        boolean isValidInput = false;

        // Loop untuk input hingga valid
        while (!isValidInput) {
            try {
                nilaiTugas = getInputValue("Nilai Tugas (0-100)");
                nilaiUts = getInputValue("Nilai UTS (0-100)");
                nilaiUas = getInputValue("Nilai UAS (0-100)");

                // Validasi input
                if (!validator.isValid(nilaiTugas, nilaiUts, nilaiUas)) {
                    System.out.println("✗ Input tidak valid!");
                    System.out.println("  - Semua nilai harus antara 0-100");
                    System.out.println("  - Tidak boleh semua nilai 0 (belum input)\n");
                    continue;
                }

                isValidInput = true;

            } catch (NumberFormatException e) {
                System.out.println("✗ Format input tidak valid. Gunakan angka desimal (contoh: 85.5)\n");
            }
        }

        // Hitung nilai akhir
        double nilaiAkhir = scoreCalculator.calculateFinalScore(nilaiTugas, nilaiUts, nilaiUas);

        if (nilaiAkhir == -1) {
            System.out.println("✗ Terjadi kesalahan dalam perhitungan nilai akhir");
            return;
        }

        // Tentukan grade
        String grade = gradeModule.determineGrade(nilaiAkhir);

        // Tentukan status kelulusan
        String statusKelulusan = passFailModule.determinePassStatus(nilaiAkhir);

        // Tampilkan hasil
        displayResults(nilaiTugas, nilaiUts, nilaiUas, nilaiAkhir, grade, statusKelulusan);
    }

    private static double getInputValue(String prompt) throws NumberFormatException {
        System.out.print("  " + prompt + ": ");
        return Double.parseDouble(scanner.nextLine().trim());
    }

    private static void displayResults(double nilaiTugas, double nilaiUts, double nilaiUas,
                                      double nilaiAkhir, String grade, String statusKelulusan) {
        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("          HASIL PENGOLAHAN NILAI");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.printf("  Nilai Tugas       : %.2f (Bobot: 30%%)%n", nilaiTugas);
        System.out.printf("  Nilai UTS         : %.2f (Bobot: 30%%)%n", nilaiUts);
        System.out.printf("  Nilai UAS         : %.2f (Bobot: 40%%)%n", nilaiUas);
        System.out.println("  ───────────────────────────────────────────────");
        System.out.printf("  Nilai Akhir       : %.2f%n", nilaiAkhir);
        System.out.printf("  Grade             : %s%n", grade);
        System.out.printf("  Status Kelulusan  : %s%n", statusKelulusan);
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n");
    }

    public String getGreeting() {
        return "Program Pengolahan Nilai Mahasiswa";
    }
}
