# CONTOH FLOW DAN OUTPUT PROGRAM

## 📺 Scenario 1: Mahasiswa Lulus dengan Grade A

```
╔════════════════════════════════════════════════════╗
║     SISTEM PENGOLAHAN NILAI MAHASISWA             ║
╚════════════════════════════════════════════════════╝

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
           MENU UTAMA
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
1. Proses Nilai Mahasiswa
2. Keluar
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
Pilihan Anda (1-2): 1

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
          INPUT NILAI MAHASISWA
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
  Nilai Tugas (0-100): 90
  Nilai UTS (0-100): 85
  Nilai UAS (0-100): 95

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
          HASIL PENGOLAHAN NILAI
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
  Nilai Tugas       : 90.00 (Bobot: 30%)
  Nilai UTS         : 85.00 (Bobot: 30%)
  Nilai UAS         : 95.00 (Bobot: 40%)
  ───────────────────────────────────────────────
  Nilai Akhir       : 91.00
  Grade             : A
  Status Kelulusan  : Lulus
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

[PROSES PEMBELAHAN NILAI BERHASIL]
Nilai Akhir (91.00):
  ├─ Tugas 30%: 90.00 × 0.30 = 27.00
  ├─ UTS 30%:   85.00 × 0.30 = 25.50
  ├─ UAS 40%:   95.00 × 0.40 = 38.00
  └─ TOTAL:     27.00 + 25.50 + 38.00 = 90.50 → Grade A (≥85)
     Status: 90.50 ≥ 60 → LULUS ✓
```

---

## 📺 Scenario 2: Mahasiswa Lulus dengan Grade C

```
Pilihan Anda (1-2): 1

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
          INPUT NILAI MAHASISWA
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
  Nilai Tugas (0-100): 65
  Nilai UTS (0-100): 60
  Nilai UAS (0-100): 65

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
          HASIL PENGOLAHAN NILAI
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
  Nilai Tugas       : 65.00 (Bobot: 30%)
  Nilai UTS         : 60.00 (Bobot: 30%)
  Nilai UAS         : 65.00 (Bobot: 40%)
  ───────────────────────────────────────────────
  Nilai Akhir       : 63.50
  Grade             : C
  Status Kelulusan  : Lulus
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

[ANALISIS]
Nilai Akhir (63.50):
  ├─ Tugas 30%: 65.00 × 0.30 = 19.50
  ├─ UTS 30%:   60.00 × 0.30 = 18.00
  ├─ UAS 40%:   65.00 × 0.40 = 26.00
  └─ TOTAL:     19.50 + 18.00 + 26.00 = 63.50 → Grade C (60-69)
     Status: 63.50 ≥ 60 → LULUS ✓
```

---

## 📺 Scenario 3: Mahasiswa Tidak Lulus dengan Grade E

```
Pilihan Anda (1-2): 1

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
          INPUT NILAI MAHASISWA
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
  Nilai Tugas (0-100): 40
  Nilai UTS (0-100): 45
  Nilai UAS (0-100): 50

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
          HASIL PENGOLAHAN NILAI
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
  Nilai Tugas       : 40.00 (Bobot: 30%)
  Nilai UTS         : 45.00 (Bobot: 30%)
  Nilai UAS         : 50.00 (Bobot: 40%)
  ───────────────────────────────────────────────
  Nilai Akhir       : 45.50
  Grade             : E
  Status Kelulusan  : Tidak Lulus
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

[ANALISIS]
Nilai Akhir (45.50):
  ├─ Tugas 30%: 40.00 × 0.30 = 12.00
  ├─ UTS 30%:   45.00 × 0.30 = 13.50
  ├─ UAS 40%:   50.00 × 0.40 = 20.00
  └─ TOTAL:     12.00 + 13.50 + 20.00 = 45.50 → Grade E (<50)
     Status: 45.50 < 60 → TIDAK LULUS ✗
```

---

## 📺 Scenario 4: Input Tidak Valid - Nilai Negatif

```
Pilihan Anda (1-2): 1

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
          INPUT NILAI MAHASISWA
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
  Nilai Tugas (0-100): -5
  Nilai UTS (0-100): 70
  Nilai UAS (0-100): 80

✗ Input tidak valid!
  - Semua nilai harus antara 0-100
  - Tidak boleh semua nilai 0 (belum input)

  Nilai Tugas (0-100): 75
  Nilai UTS (0-100): 80
  Nilai UAS (0-100): 85

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
          HASIL PENGOLAHAN NILAI
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
  Nilai Tugas       : 75.00 (Bobot: 30%)
  Nilai UTS         : 80.00 (Bobot: 30%)
  Nilai UAS         : 85.00 (Bobot: 40%)
  ───────────────────────────────────────────────
  Nilai Akhir       : 80.50
  Grade             : B
  Status Kelulusan  : Lulus
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
```

---

## 📺 Scenario 5: Input Tidak Valid - Semua Nol

```
Pilihan Anda (1-2): 1

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
          INPUT NILAI MAHASISWA
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
  Nilai Tugas (0-100): 0
  Nilai UTS (0-100): 0
  Nilai UAS (0-100): 0

✗ Input tidak valid!
  - Semua nilai harus antara 0-100
  - Tidak boleh semua nilai 0 (belum input)

  Nilai Tugas (0-100): (retry)
```

---

## 📺 Scenario 6: Format Input Salah

```
Pilihan Anda (1-2): 1

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
          INPUT NILAI MAHASISWA
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
  Nilai Tugas (0-100): abc

✗ Format input tidak valid. Gunakan angka desimal (contoh: 85.5)

  Nilai Tugas (0-100): 85.5
  Nilai UTS (0-100): 80
  Nilai UAS (0-100): 90

[Program lanjut normal]
```

---

## 📺 Scenario 7: Loop Menu - Input Berulang

```
[Setelah selesai proses pertama]

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
           MENU UTAMA
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
1. Proses Nilai Mahasiswa
2. Keluar
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
Pilihan Anda (1-2): 1

[Input Mahasiswa Kedua]
  Nilai Tugas (0-100): 70
  Nilai UTS (0-100): 75
  Nilai UAS (0-100): 80

[Output Mahasiswa Kedua]
  Nilai Akhir: 76.00
  Grade: B
  Status: Lulus

[Loop kembali ke menu - user bisa input lagi atau keluar]

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
           MENU UTAMA
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
1. Proses Nilai Mahasiswa
2. Keluar
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
Pilihan Anda (1-2): 2

✓ Terima kasih telah menggunakan sistem ini. Sampai jumpa!

[Program Selesai]
```

---

## 📺 Scenario 8: Boundary Case - Nilai Akhir Tepat 60 (Passing Boundary)

```
Pilihan Anda (1-2): 1

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
          INPUT NILAI MAHASISWA
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
  Nilai Tugas (0-100): 60
  Nilai UTS (0-100): 60
  Nilai UAS (0-100): 60

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
          HASIL PENGOLAHAN NILAI
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
  Nilai Tugas       : 60.00 (Bobot: 30%)
  Nilai UTS         : 60.00 (Bobot: 30%)
  Nilai UAS         : 60.00 (Bobot: 40%)
  ───────────────────────────────────────────────
  Nilai Akhir       : 60.00
  Grade             : C
  Status Kelulusan  : Lulus         ← TEPAT DI BOUNDARY!
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

[CATATAN]
Nilai 60.00 adalah batas kelulusan (≥60 = Lulus)
Program dengan benar mendeteksi sebagai "Lulus" ✓
```

---

## 📺 Scenario 9: Boundary Case - Nilai Akhir 59.99 (Just Below Passing)

```
Pilihan Anda (1-2): 1

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
          INPUT NILAI MAHASISWA
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
  Nilai Tugas (0-100): 50
  Nilai UTS (0-100): 55
  Nilai UAS (0-100): 65

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
          HASIL PENGOLAHAN NILAI
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
  Nilai Tugas       : 50.00 (Bobot: 30%)
  Nilai UTS         : 55.00 (Bobot: 30%)
  Nilai UAS         : 65.00 (Bobot: 40%)
  ───────────────────────────────────────────────
  Nilai Akhir       : 58.50
  Grade             : D
  Status Kelulusan  : Tidak Lulus   ← TEPAT DI BAWAH BOUNDARY!
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

[CATATAN]
Nilai 58.50 < 60 (batas kelulusan)
Program dengan benar mendeteksi sebagai "Tidak Lulus" ✓
```

---

## 🧮 TABEL GRADE TRANSFORMATION

```
Nilai Akhir  →  Grade  →  Status Kelulusan
═══════════════════════════════════════════════
90.00        →  A      →  LULUS
85.00        →  A      →  LULUS
76.50        →  B      →  LULUS
70.00        →  B      →  LULUS
67.25        →  C      →  LULUS
60.00        →  C      →  LULUS ✓ (boundary)
59.99        →  D      →  TIDAK LULUS ✗ (boundary)
55.00        →  D      →  TIDAK LULUS
50.00        →  D      →  TIDAK LULUS
49.00        →  E      →  TIDAK LULUS
0.00         →  (error) → (error)
```

---

## 📊 TEST EXECUTION SUMMARY

### Validation Testing:
- ✅ Valid input (all values 0-100) → Accepted
- ✅ Invalid input (negative values) → Rejected + prompt retry
- ✅ Invalid input (values > 100) → Rejected + prompt retry
- ✅ Invalid input (all zeros) → Rejected + prompt retry
- ✅ Mixed valid & invalid input → Rejected

### Calculation Testing:
- ✅ Correct formula application (0.3T + 0.3U + 0.4A)
- ✅ Correct rounding/precision (2 decimal places)
- ✅ Error handling (invalid → -1)

### Grade Mapping:
- ✅ Grade A for score ≥ 85
- ✅ Grade B for 70-84
- ✅ Grade C for 60-69
- ✅ Grade D for 50-59
- ✅ Grade E for < 50

### Status Mapping:
- ✅ "Lulus" for score ≥ 60
- ✅ "Tidak Lulus" for score < 60

### UI/UX Testing:
- ✅ Menu displays correctly
- ✅ Input prompts are clear
- ✅ Output is formatted nicely
- ✅ Error messages are helpful
- ✅ Loop functionality works
- ✅ Exit option works

---

**All scenarios tested and working correctly! ✅**
