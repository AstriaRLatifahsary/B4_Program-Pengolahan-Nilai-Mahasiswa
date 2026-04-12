@echo off
REM Batch file untuk menjalankan Program Pengolahan Nilai Mahasiswa
REM
cd /d "%~dp0"

echo ╔════════════════════════════════════════════════════╗
echo ║  SISTEM PENGOLAHAN NILAI MAHASISWA                ║
echo ║  Starting Application...                          ║
echo ╚════════════════════════════════════════════════════╝
echo.

REM Build project
echo [1/2] Building project...
call gradlew.bat build > nul 2>&amp;1

if errorlevel 1 (
    echo ERROR: Build failed!
    pause
    exit /b 1
)

echo [2/2] Running application...
echo.

REM Run program
java -cp app\build\classes\java\main org.example.App

echo.
echo Program selesai. Tekan Enter untuk menutup...
pause
