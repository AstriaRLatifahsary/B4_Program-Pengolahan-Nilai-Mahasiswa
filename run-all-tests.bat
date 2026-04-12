@echo off
cd /d "d:\KULIAH\Semester6\Pengujian Perangkat Lunak\Praktek\Pertemuan7\B4_Program-Pengolahan-Nilai-Mahasiswa"
echo Running Tests...
echo.
call gradlew.bat test --info
echo.
echo Test completed. Check: app/build/reports/tests/test/index.html
pause
