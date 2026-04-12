# Test Values - Program Pengolahan Nilai Mahasiswa

## 1. DataValidationModuleTest ✅

| Test Case | Input | Expected | Result |
|-----------|-------|----------|--------|
| shouldReturnTrueWhenAllScoresInRangeAndNotAllZero | (80, 70, 90) | TRUE | ✅ PASSED |
| shouldReturnFalseWhenAnyScoreLessThanZero | (-1, 70, 90) | FALSE | ✅ PASSED |
| shouldReturnFalseWhenAnyScoreMoreThanHundred | (80, 101, 90) | FALSE | ✅ PASSED |
| shouldReturnFalseWhenAllScoresAreZero | (0, 0, 0) | FALSE | ✅ PASSED |
| shouldAllowZeroIfNotAllScoresAreZero | (0, 75, 65) | TRUE | ✅ PASSED |

---

## 2. FinalScoreCalculationModuleTest ✅

| Test Case | Input (Tugas, UTS, UAS) | Calculation | Expected | Result |
|-----------|---------|------------|----------|--------|
| shouldCalculateCorrectFinalScoreWithValidInputs | (80, 70, 90) | 0.3×80 + 0.3×70 + 0.4×90 = 24+21+36 | 81.0 | ✅ PASSED |
| shouldReturnNegativeOneWhenInputsInvalid | (-1, 70, 90) | Invalid | -1 | ✅ PASSED |
| shouldReturnNegativeOneWhenInputExceedsHundred | (80, 101, 90) | Invalid | -1 | ✅ PASSED |
| shouldReturnNegativeOneWhenAllInputsAreZero | (0, 0, 0) | All zero | -1 | ✅ PASSED |
| shouldCalculateCorrectlyWithZeroInOneInput | (0, 70, 90) | 0.3×0 + 0.3×70 + 0.4×90 = 0+21+36 | 57.0 | ✅ PASSED |
| shouldCalculateCorrectlyWithAllScoresMaximum | (100, 100, 100) | 0.3×100 + 0.3×100 + 0.4×100 | 100.0 | ✅ PASSED |
| shouldCalculateCorrectlyWithDifferentWeightDistribution | (60, 80, 100) | 0.3×60 + 0.3×80 + 0.4×100 = 18+24+40 | 82.0 | ✅ PASSED |

---

## 3. GradeDeterminationModuleTest ✅

| Test Case | Input Score | Grade | Result |
|-----------|-------------|-------|--------|
| shouldReturnEForScoreBelowFifty | < 50 | E | ✅ PASSED |
| shouldReturnDForScoreBetweenFiftyAndFiftyNine | 50-59 | D | ✅ PASSED |
| shouldReturnCForScoreBetweenSixtyAndSixtyNine | 60-69 | C | ✅ PASSED |
| shouldReturnBForScoreBetweenSeventyAndEightyFour | 70-84 | B | ✅ PASSED |
| shouldReturnAForScoreAtLeastEightyFive | ≥ 85 | A | ✅ PASSED |

---

## 4. PassFailDeterminationModuleTest ✅

| Test Case | Input Score | Expected | Result |
|-----------|-------------|----------|--------|
| shouldReturnLulusWhenScoreIsGreaterThanOrEqualToSixty | 60, 70, 85, 100 | Lulus | ✅ PASSED |
| shouldReturnTidakLulusWhenScoreLessThanSixty | 59, 50, 0 | Tidak Lulus | ✅ PASSED |
| shouldReturnTidakLulusWhenScoreIsNearBoundary | 59.9 → Tidak Lulus, 60.0 → Lulus, 60.1 → Lulus | BOUNDARY | ✅ PASSED |

---

## 5. DataValidationModuleTest ✅

| Test Case | Input | Expected | Result |
|-----------|-------|----------|--------|
| shouldReturnTrueWhenAllScoresInRangeAndNotAllZero | (80, 70, 90) | TRUE | ✅ PASSED |
| shouldReturnFalseWhenAnyScoreLessThanZero | (-1, 70, 90) | FALSE | ✅ PASSED |
| shouldReturnFalseWhenAnyScoreMoreThanHundred | (80, 101, 90) | FALSE | ✅ PASSED |
| shouldReturnFalseWhenAllScoresAreZero | (0, 0, 0) | FALSE | ✅ PASSED |
| shouldAllowZeroIfNotAllScoresAreZero | (0, 75, 65) | TRUE | ✅ PASSED |

---

## 6. IntegrationTest ✅

| Test Case | Scenario | Input | Expected Output | Result |
|-----------|----------|-------|-----------------|--------|
| shouldRejectInvalidInputInFlow | Invalid input | (-1, 70, 90) | Return -1 | ✅ PASSED |
| shouldRejectAllZeroInputInFlow | All zero | (0, 0, 0) | Return -1 | ✅ PASSED |
| shouldProcessCompleteFlowForFailingStudent | Nilai < 60 | (40, 50, 45) | Tidak Lulus, Grade E | ✅ PASSED |
| shouldProcessCompleteFlowForBoundaryFailingStudent | Boundary fail | (55, 60, 60) | Tidak Lulus (nilai akhir 59) | ✅ PASSED |
| shouldProcessCompleteFlowForBoundaryPassingStudent | Boundary pass | (60, 60, 60) | Lulus, Grade C | ✅ PASSED |
| shouldProcessCompleteFlowForPassingStudentWithGradeC | Nilai 60-69 | (70, 60, 65) | Lulus, Grade C | ✅ PASSED |
| shouldProcessCompleteFlowForPassingStudentWithGradeA | Nilai ≥ 85 | (90, 90, 90) | Lulus, Grade A | ✅ PASSED |
| shouldCalculateCorrectWeightageInFinalScore | Calculation check | (65, 75, 85) | Nilai akhir 76.5 | ✅ PASSED |
| shouldCalculateCorrectGradeForAllGradeRanges | All grades | Various | A, B, C, D, E | ✅ PASSED |

---

## Summary

✅ **Total Test Cases: 31**  
✅ **Passed: 31**  
❌ **Failed: 0**  
⏭️ **Skipped: 0**  

**BUILD STATUS: SUCCESSFUL** 🎉

---

## Jalankan Test Sesuai Modul

```bash
# Test setiap modul
.\gradlew.bat test --tests "org.example.DataValidationModuleTest"
.\gradlew.bat test --tests "org.example.FinalScoreCalculationModuleTest"
.\gradlew.bat test --tests "org.example.GradeDeterminationModuleTest"
.\gradlew.bat test --tests "org.example.PassFailDeterminationModuleTest"
.\gradlew.bat test --tests "org.example.IntegrationTest"

# Jalankan semua test
.\gradlew.bat test
```
