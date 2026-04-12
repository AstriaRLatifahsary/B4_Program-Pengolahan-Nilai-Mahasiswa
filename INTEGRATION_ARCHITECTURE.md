// Visualisasi Integrasi Modul di App.java
// ========================================

/*
   ALUR INTEGRASI DI APP.java
   
   main() → displayMenu() → switch(choice)
                                    │
                                    ├─→ case 1: processStudentGrades()
                                    │             │
                                    │             ├─→ Loop Input (sampai valid)
                                    │             │   └─→ getInputValue() × 3 (tugas, uts, uas)
                                    │             │
                                    │             ├─→ validator.isValid()
                                    │             │   ↳ DataValidationModule
                                    │             │
                                    │             ├─→ scoreCalculator.calculateFinalScore()
                                    │             │   ↳ FinalScoreCalculationModule
                                    │             │      (internally uses validator)
                                    │             │
                                    │             ├─→ gradeModule.determineGrade()
                                    │             │   ↳ GradeDeterminationModule
                                    │             │
                                    │             ├─→ passFailModule.determinePassStatus()
                                    │             │   ↳ PassFailDeterminationModule
                                    │             │
                                    │             └─→ displayResults()
                                    │                 (Display ke screen)
                                    │
                                    └─→ case 2: Keluar Program
   
   ========================================================
   DEFINISI ATRIBUT STATIS DI CLASS APP:
   ========================================================
   
   private static final DataValidationModule validator 
      = new DataValidationModule();
      └─ Untuk validasi nilai input (0-100, tidak semua 0)
   
   private static final FinalScoreCalculationModule scoreCalculator 
      = new FinalScoreCalculationModule();
      └─ Menghitung nilai akhir: (0.3*T) + (0.3*U) + (0.4*A)
   
   private static final GradeDeterminationModule gradeModule 
      = new GradeDeterminationModule();
      └─ Menentukan grade: A, B, C, D, E
   
   private static final PassFailDeterminationModule passFailModule 
      = new PassFailDeterminationModule();
      └─ Menentukan status: Lulus / Tidak Lulus
   
   private static final Scanner scanner = new Scanner(System.in);
      └─ Untuk input dari user
   
   ========================================================
   PEMANGGILAN MODUL DALAM APP:
   ========================================================
   
   1. DataValidationModule (dari FinalScoreCalculationModule):
      ├─ validator.isValid(nilaiTugas, nilaiUts, nilaiUas)
      └─ Digunakan di: processStudentGrades() & scoreCalculator.calculateFinalScore()
   
   2. FinalScoreCalculationModule:
      ├─ scoreCalculator.calculateFinalScore(nilaiTugas, nilaiUts, nilaiUas)
      └─ Return: double (nilai akhir atau -1 jika error)
   
   3. GradeDeterminationModule:
      ├─ gradeModule.determineGrade(nilaiAkhir)
      └─ Return: String (A, B, C, D, atau E)
   
   4. PassFailDeterminationModule:
      ├─ passFailModule.determinePassStatus(nilaiAkhir)
      └─ Return: String (Lulus atau Tidak Lulus)
   
   ========================================================
   METHOD-METHOD DI APP.java:
   ========================================================
   
   main(String[] args)
      └─ Entry point - Loop menu utama
      
   displayMenu()
      └─ Tampilkan pilihan menu
      
   getUserMenuChoice()
      └─ Input pilihan user dengan error handling
      
   processStudentGrades()
      └─ Proses utama:
         1. Loop input hingga valid
         2. Hitung nilai akhir
         3. Tentukan grade
         4. Tentukan kelulusan
         5. Display hasil
         
   getInputValue(String prompt)
      └─ Input single nilai dengan error handling
      
   displayResults(double, double, double, double, String, String)
      └─ Display hasil dengan formatting
      
   getGreeting()
      └─ Return greeting string (untuk test)
   
   ========================================================
   INTEGRASI DENGAN MODULE LAIN (Azkia):
   ========================================================
   
   Modul yang sudah ada (dibuat oleh Azkia/team):
   
   ✅ DataValidationModule.java
      Method: isValid(nilaiTugas, nilaiUts, nilaiUas): boolean
      - Cek semua nilai 0-100: Valid
      - Ada nilai < 0 atau > 100: Invalid
      - Semua nilai = 0: Invalid (belum input)
   
   ✅ GradeDeterminationModule.java
      Method: determineGrade(nilaiAkhir): String
      - ≥ 85 → A
      - 70-84 → B
      - 60-69 → C
      - 50-59 → D
      - < 50 → E
   
   ========================================================
   MODUL YANG DIBUAT PEBRI:
   ========================================================
   
   ✅ FinalScoreCalculationModule.java
      Method: calculateFinalScore(nilaiTugas, nilaiUts, nilaiUas): double
      - Formula: (0.3 * tugas) + (0.3 * uts) + (0.4 * uas)
      - Validasi input: jika invalid → return -1
      - Jika hasil > 100 → return -1
      - Return: nilai akhir (double)
   
   ✅ PassFailDeterminationModule.java
      Method: determinePassStatus(nilaiAkhir): String
      - ≥ 60 → "Lulus"
      - < 60 → "Tidak Lulus"
   
   ========================================================
   TEST FILES (37 test cases):
   ========================================================
   
   ✅ AppTest.java (2 test)
      - appShouldHaveCorrectGreeting()
      - appGreetingShouldNotBeNull()
   
   ✅ DataValidationModuleTest.java (5 test)
      - shouldReturnTrueWhenAllScoresInRangeAndNotAllZero()
      - shouldReturnFalseWhenAnyScoreLessThanZero()
      - shouldReturnFalseWhenAnyScoreMoreThanHundred()
      - shouldReturnFalseWhenAllScoresAreZero()
      - shouldAllowZeroIfNotAllScoresAreZero()
   
   ✅ FinalScoreCalculationModuleTest.java (8 test) - by Pebri
      - shouldCalculateCorrectFinalScoreWithValidInput()
      - shouldCalculateCorrectFinalScoreWithDifferentValues()
      - shouldCalculateCorrectFinalScoreWithMinimumValidValues()
      - shouldReturnErrorWhenAnyScoreIsNegative()
      - shouldReturnErrorWhenAnyScoreIsMoreThanHundred()
      - shouldReturnErrorWhenAllScoresAreZero()
      - shouldReturnErrorWhenFinalScoreExceedsHundred()
      - shouldCalculateCorrectlyWithZeroInOneComponent()
   
   ✅ PassFailDeterminationModuleTest.java (4 test) - by Pebri
      - shouldReturnLulusWhenScoreIsGreaterThanOrEqualToSixty()
      - shouldReturnTidakLulusWhenScoreLessThanSixty()
      - shouldReturnTidakLulusWhenScoreIsNearBoundary()
   
   ✅ GradeDeterminationModuleTest.java (5 test)
      - shouldReturnAForScoreAtLeastEightyFive()
      - shouldReturnBForScoreBetweenSeventyAndEightyFour()
      - shouldReturnCForScoreBetweenSixtyAndSixtyNine()
      - shouldReturnDForScoreBetweenFiftyAndFiftyNine()
      - shouldReturnEForScoreBelowFifty()
   
   ✅ IntegrationTest.java (13 test)
      - shouldProcessCompleteFlowForPassingStudentWithGradeA()
      - shouldProcessCompleteFlowForPassingStudentWithGradeC()
      - shouldProcessCompleteFlowForFailingStudent()
      - shouldProcessCompleteFlowForBoundaryPassingStudent()
      - shouldProcessCompleteFlowForBoundaryFailingStudent()
      - shouldRejectInvalidInputInFlow()
      - shouldRejectAllZeroInputInFlow()
      - shouldCalculateCorrectGradeForAllGradeRanges()
      - shouldCalculateCorrectWeightageInFinalScore()
      - (+ penambahan test lainnya)
   
   ========================================================
   DEPENDENCY GRAPH:
   ========================================================
   
   App.java
    ├─ uses → DataValidationModule
    ├─ uses → FinalScoreCalculationModule
    │           └─ internally uses → DataValidationModule
    ├─ uses → GradeDeterminationModule
    └─ uses → PassFailDeterminationModule
   
   ========================================================
   CONTOH EKSEKUSI PROGRAM:
   ========================================================
   
   Input Sequence:
   1. Program start → Display menu
   2. User input: 1
   3. Program ask: Nilai Tugas? → User input: 85
   4. Program ask: Nilai UTS? → User input: 80
   5. Program ask: Nilai UAS? → User input: 90
   
   Processing:
   6. Validate (85, 80, 90) → Valid ✓
   7. Calculate (85, 80, 90) → 85.50
   8. Determine Grade (85.50) → A
   9. Determine Pass (85.50) → Lulus
   
   Output:
   10. Display results:
       - Nilai Tugas: 85.00 (Bobot: 30%)
       - Nilai UTS: 80.00 (Bobot: 30%)
       - Nilai UAS: 90.00 (Bobot: 40%)
       - Nilai Akhir: 85.50
       - Grade: A
       - Status Kelulusan: Lulus
   
   11. Loop back to menu
      User dapat input ulang atau keluar program
   
   ========================================================
   MODULARITAS & SEPARATION OF CONCERNS:
   ========================================================
   
   ✓ DataValidationModule
     - HANYA bertanggung jawab untuk validasi
     - Tidak tahu tentang grade atau kelulusan
   
   ✓ FinalScoreCalculationModule
     - HANYA bertanggung jawab untuk perhitungan nilai akhir
     - Menggunakan validator untuk error checking
     - Return -1 untuk error
   
   ✓ GradeDeterminationModule
     - HANYA bertanggung jawab untuk mapping nilai → grade
     - Independent dari modul lain
   
   ✓ PassFailDeterminationModule
     - HANYA bertanggung jawab untuk mapping nilai → status kelulusan
     - Independent dari modul lain
   
   ✓ App.java
     - Menjadi orchestrator yang menggabungkan semua modul
     - Handle UI (input/output)
     - Handle program flow (loop menu)
   
   ========================================================
   FITUR UI DI APP.java:
   ========================================================
   
   ✓ ASCII Border untuk visual yang lebih menarik
   ✓ Loop input hingga valid dengan error message
   ✓ Format output yang terstruktur dengan alignment
   ✓ User-friendly prompts
   ✓ Error handling untuk invalid input
   ✓ Menu loop untuk interaksi berulang
   
   ========================================================
*/
