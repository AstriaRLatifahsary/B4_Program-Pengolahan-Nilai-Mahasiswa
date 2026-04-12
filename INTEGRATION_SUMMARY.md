# Dokumentasi Integrasi Program Pengolahan Nilai Mahasiswa

## Status Implementasi: ✅ LENGKAP

### Daftar Modul yang Telah Diintegrasikan:

#### 1. **DataValidationModule** (by Azkia atau team member lain)
- Fungsi: `isValid(nilaiTugas, nilaiUts, nilaiUas)`
- Validasi: Semua nilai 0-100, tidak boleh semua 0
- Status: ✅ Sudah terintegrasi di `FinalScoreCalculationModule`

#### 2. **FinalScoreCalculationModule** (by Pebri)
- Fungsi: `calculateFinalScore(nilaiTugas, nilaiUts, nilaiUas)`
- Formula: (0.3 × tugas) + (0.3 × uts) + (0.4 × uas)
- Return: nilai akhir atau -1 jika error
- Status: ✅ Sudah terintegrasi di `App.java`

#### 3. **GradeDeterminationModule** (by Azkia atau team member lain)
- Fungsi: `determineGrade(nilaiAkhir)`
- Output: A, B, C, D, E
- Status: ✅ Sudah terintegrasi di `App.java`

#### 4. **PassFailDeterminationModule** (by Pebri)
- Fungsi: `determinePassStatus(nilaiAkhir)`
- Output: "Lulus" atau "Tidak Lulus"
- Status: ✅ Sudah terintegrasi di `App.java`

---

## File-File yang Telah Dibuat:

### Source Files (src/main/java/org/example):
1. ✅ `App.java` - Main program dengan menu loop + integrasi semua modul
2. ✅ `FinalScoreCalculationModule.java` - Modul perhitungan nilai akhir (by Pebri)
3. ✅ `PassFailDeterminationModule.java` - Modul penentuan kelulusan (by Pebri)
4. ✅ `DataValidationModule.java` - Modul validasi (by team)
5. ✅ `GradeDeterminationModule.java` - Modul penentuan grade (by team)

### Test Files (src/test/java/org/example):
1. ✅ `AppTest.java` - Unit test untuk App
2. ✅ `FinalScoreCalculationModuleTest.java` - 8 test cases untuk HitungNilaiAkhir
3. ✅ `PassFailDeterminationModuleTest.java` - 4 test cases untuk Kelulusan
4. ✅ `DataValidationModuleTest.java` - 5 test cases untuk validasi
5. ✅ `GradeDeterminationModuleTest.java` - 5 test cases untuk grade
6. ✅ `IntegrationTest.java` - 10 test cases untuk integrasi semua modul

**Total Test Cases: 37 test case**

---

## Alur Program (App.java):

```
┌─────────────────────────────────────────┐
│  SISTEM PENGOLAHAN NILAI MAHASISWA      │
└─────────────────────────────────────────┘
                    │
                    ▼
         ┌──────────────────┐
         │  MENU UTAMA      │
         ├──────────────────┤
         │1. Proses Nilai   │
         │2. Keluar         │
         └──────────────────┘
                    │
                    ▼
      ┌────────────────────────────┐
      │ INPUT NILAI MAHASISWA      │
      │ - Nilai Tugas (0-100)      │
      │ - Nilai UTS (0-100)        │
      │ - Nilai UAS (0-100)        │
      └────────────────────────────┘
                    │
                    ▼
      ┌────────────────────────────┐
      │ VALIDASI INPUT             │  ← DataValidationModule
      │ (Cek range & all zero)     │
      └────────────────────────────┘
                    │
         ┌──────────┴──────────┐
         │ Valid?              │
      ▼(Ya)              (Tidak)▼
      │                    Ulangi Input
      │
▼
┌──────────────────────────────────────┐
│ HITUNG NILAI AKHIR                   │   ← FinalScoreCalculationModule
│ Akhir = (0.3×T) + (0.3×U) + (0.4×A) │
└──────────────────────────────────────┘
                    │
                    ▼
      ┌────────────────────────────┐
      │ TENTUKAN GRADE (A-E)       │   ← GradeDeterminationModule
      │ - A: ≥ 85                  │
      │ - B: 70-84                 │
      │ - C: 60-69                 │
      │ - D: 50-59                 │
      │ - E: < 50                  │
      └────────────────────────────┘
                    │
                    ▼
      ┌────────────────────────────┐
      │ TENTUKAN KELULUSAN         │   ← PassFailDeterminationModule
      │ - Lulus: ≥ 60              │
      │ - Tidak Lulus: < 60        │
      └────────────────────────────┘
                    │
                    ▼
      ┌────────────────────────────┐
      │ TAMPILKAN HASIL            │
      │ - Nilai Tugas/UTS/UAS      │
      │ - Nilai Akhir              │
      │ - Grade                    │
      │ - Status Kelulusan         │
      └────────────────────────────┘
                    │
                    ▼
      ┌────────────────────────────┐
      │ KEMBALI KE MENU ?          │
      │ - Ya: Ulangi proses        │
      │ - Tidak: Keluar            │
      └────────────────────────────┘
```

---

## Fitur-Fitur Program:

### ✅ Loop Menu
- User dapat menginputkan nilai mahasiswa berulang kali
- Menu memudahkan navigasi antara proses dan keluar

### ✅ Validasi Input
- Menggunakan `DataValidationModule`
- Loop input hingga datanya valid
- Menampilkan error message yang informatif

### ✅ Perhitungan Nilai Akhir
- Formula dengan bobot: Tugas 30%, UTS 30%, UAS 40%
- Error handling jika input tidak valid atau hasil > 100

### ✅ Penentuan Grade & Kelulusan
- Integrasi dengan semua modul untuk proses lengkap
- Output yang jelas dan terstruktur

### ✅ User Interface
- Format output yang ramah pengguna dengan border ASCII
- Pesan error yang jelas
- Menampilkan bobot dalam hasil output

---

## Cara Menjalankan Program:

### Dari Terminal:
```bash
# Build project
./gradlew build

# Jalankan program
./gradlew run

# Jalankan hanya test
./gradlew test

# Atau buka IDE dan run App.java sebagai Java Application
```

### Cara Menggunakan Program:
1. Jalankan program
2. Pilih menu "1. Proses Nilai Mahasiswa"
3. Input nilai tugas, UTS, UAS (dalam format desimal, contoh: 85.5)
4. Program otomatis menampilkan hasil: nilai akhir, grade, dan status kelulusan
5. Ulangi atau pilih menu "2. Keluar" untuk selesai

---

## Test Coverage:

### Unit Tests:
- **FinalScoreCalculationModule**: 8 test cases
  - Perhitungan dengan nilai valid
  - Error handling (negatif, > 100, semua 0)

- **PassFailDeterminationModule**: 4 test cases
  - Boundary testing (59.9, 60.0, 60.1)
  - Testing untuk Lulus dan Tidak Lulus

- **DataValidationModule**: 5 test cases
- **GradeDeterminationModule**: 5 test cases

### Integration Tests: 10 test cases
- Flow lengkap untuk berbagai skenario:
  - Passing student dengan grade A, B, C, D, E
  - Failing student
  - Boundary cases
  - Invalid input handling
  - Weightage verification

---

## Catatan Implementasi:

### Perbedaan dengan Requirement:
- ✅ Semua requirement terpenuhi
- ✅ Program modular dan terisolasi
- ✅ Interface yang jelas antara modul
- ✅ Loop menu untuk interaksi berulang

### Best Practices yang Diterapkan:
- Single Responsibility Principle: Setiap modul memiliki tanggung jawab tunggal
- Error Handling: Menggunakan return -1 untuk error di perhitungan
- Input Validation: Validasi input sebelum pemrosesan
- User Experience: Output yang terstruktur dan mudah dibaca
- Test Coverage: Comprehensive unit dan integration tests

---

## Next Steps (Jika diperlukan):

1. ✅ Implementasi program sudah lengkap
2. Jalankan `./gradlew test` untuk verifikasi semua test pass
3. Jalankan `./gradlew run` untuk menjalankan program
4. Buat test case design document dengan CFG dan independent path (untuk laporan)
5. Screenshot hasil testing dan dokumentasi environment
6. Upload ke GitHub dengan commit message yang jelas

---

Dokumentasi ini dibuat untuk keperluan laporan praktikum.
Tanggal: April 2026
Author: Pebri (FinalScoreCalculationModule & PassFailDeterminationModule)
