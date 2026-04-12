# Program Pengolahan Nilai Mahasiswa - Panduan Praktis

## 📋 Deskripsi Program

Program ini adalah sistem pengolahan nilai mahasiswa yang mengintegrasikan 4 modul utama:
- Validasi data input
- Perhitungan nilai akhir
- Penentuan grade
- Penentuan status kelulusan

## 🎯 Fitur Utama

✅ **Validasi Input**: Memastikan nilai input berada dalam range 0-100  
✅ **Perhitungan Otomatis**: Menghitung nilai akhir dengan bobot (Tugas 30%, UTS 30%, UAS 40%)  
✅ **Penentuan Grade**: Grade A, B, C, D, E berdasarkan nilai akhir  
✅ **Status Kelulusan**: Lulus (≥60) atau Tidak Lulus (<60)  
✅ **Loop Menu**: User dapat input berulang kali tanpa menutup program  
✅ **User-Friendly**: Interface dengan format output yang jelas  

## 🚀 Cara Menjalankan

### Prasyarat
- JDK 11+
- Gradle (sudah tersedia di project)

### Langkah-Langkah:

#### 1. **Buka Terminal**
```bash
cd "path/to/B4_Program-Pengolahan-Nilai-Mahasiswa"
```

#### 2. **Compile Program**
```bash
# Windows
gradlew.bat build

# Linux/Mac
./gradlew build
```

#### 3. **Jalankan Program**

**Opsi A: Menggunakan Gradle**
```bash
# Windows
gradlew.bat run

# Linux/Mac  
./gradlew run
```

**Opsi B: Dari IDE**
- Buka App.java
- Klik kanan → Run

#### 4. **Jalankan Test**
```bash
# Windows
gradlew.bat test

# Lihat test report di: app/build/reports/tests/test/index.html
```

## 💻 Contoh Penggunaan

### Input:
```
Pilihan Anda (1-2): 1

INPUT NILAI MAHASISWA
  Nilai Tugas (0-100): 85
  Nilai UTS (0-100): 80
  Nilai UAS (0-100): 90
```

### Output:
```
HASIL PENGOLAHAN NILAI
  Nilai Tugas       : 85.00 (Bobot: 30%)
  Nilai UTS         : 80.00 (Bobot: 30%)
  Nilai UAS         : 90.00 (Bobot: 40%)
  ───────────────────────────────────────────────
  Nilai Akhir       : 85.50
  Grade             : A
  Status Kelulusan  : Lulus
```

## 📊 Kriteria Penilaian

### Grade:
- **A**: Nilai ≥ 85
- **B**: Nilai 70-84
- **C**: Nilai 60-69
- **D**: Nilai 50-59
- **E**: Nilai < 50

### Kelulusan:
- **Lulus**: Nilai Akhir ≥ 60
- **Tidak Lulus**: Nilai Akhir < 60

## 🧪 Unit Testing

**Total Test Cases: 37**

```bash
# Jalankan semua test
gradlew.bat test

# Test report: app/build/reports/tests/test/index.html
```

## 📁 Struktur Kode

```
src/main/java/org/example/
├── App.java                              ← Main Program
├── DataValidationModule.java
├── FinalScoreCalculationModule.java      
├── PassFailDeterminationModule.java      
└── GradeDeterminationModule.java

src/test/java/org/example/
├── AppTest.java
├── DataValidationModuleTest.java
├── FinalScoreCalculationModuleTest.java  
├── PassFailDeterminationModuleTest.java  
├── GradeDeterminationModuleTest.java
└── IntegrationTest.java
```

## 📝 Catatan

Program dibuat untuk praktikum Skema Pembelajaran Automation Testing dengan fokus pada:
- White box testing & path testing
- Automation testing environment (Gradle)
- Unit testing with JUnit 5
- Modular & isolated module design

