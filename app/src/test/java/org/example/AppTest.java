/*
 * Test untuk App - Main Program
 */
package org.example;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AppTest {

    private App classUnderTest;
    private PrintStream originalOut;
    private ByteArrayOutputStream output;

    @BeforeEach
    void setUp() {
        originalOut = System.out;
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        classUnderTest = new App();
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void appShouldHaveCorrectGreeting() {
        // (1) setup (arrange, build)
        String expected = "Program Pengolahan Nilai Mahasiswa";
        String actual;

        // (2) exercise (act, operate)
        actual = classUnderTest.getGreeting();

        // (3) verify (assert, check)
        assertEquals(expected, actual);
    }

    @Test
    void appGreetingShouldNotBeNull() {
        // (1) setup (arrange, build)
        String actual;

        // (2) exercise (act, operate)
        actual = classUnderTest.getGreeting();

        // (3) verify (assert, check)
        assertNotNull(actual, "app should have a greeting");
    }

    @Test
    void mainShouldHandleDefaultMenuBranchThenExit() {
        setAppScanner("9\n2\n");

        App.main(new String[]{});

        String printedOutput = output.toString(StandardCharsets.UTF_8);
        assertTrue(printedOutput.contains("Pilihan tidak valid"));
        assertTrue(printedOutput.contains("Terima kasih"));
    }

    @Test
    void mainShouldProcessMenuPathThenExit() {
        setAppScanner("1\n80\n80\n80\n2\n");

        App.main(new String[]{});

        String printedOutput = output.toString(StandardCharsets.UTF_8);
        assertTrue(printedOutput.contains("HASIL PENGOLAHAN NILAI"));
        assertTrue(printedOutput.contains("Nilai Akhir"));
        assertTrue(printedOutput.contains("Terima kasih"));
    }

    @Test
    void getUserMenuChoiceShouldReturnMinusOneForInvalidParsing() throws Exception {
        setAppScanner("abc\n");

        Method method = App.class.getDeclaredMethod("getUserMenuChoice");
        method.setAccessible(true);
        int result = (int) method.invoke(null);

        assertEquals(-1, result);
    }

    @Test
    void processStudentGradesShouldRetryAfterInvalidValidationInput() throws Exception {
        setAppScanner("0\n0\n0\n70\n70\n70\n");

        Method method = App.class.getDeclaredMethod("processStudentGrades");
        method.setAccessible(true);
        method.invoke(null);

        String printedOutput = output.toString(StandardCharsets.UTF_8);
        assertTrue(printedOutput.contains("Input tidak valid"));
        assertTrue(printedOutput.contains("HASIL PENGOLAHAN NILAI"));
    }

    @Test
    void processStudentGradesShouldHandleNumberFormatExceptionAndRetry() throws Exception {
        setAppScanner("abc\n90\n90\n90\n");

        Method method = App.class.getDeclaredMethod("processStudentGrades");
        method.setAccessible(true);
        method.invoke(null);

        String printedOutput = output.toString(StandardCharsets.UTF_8);
        assertTrue(printedOutput.contains("Format input tidak valid"));
        assertTrue(printedOutput.contains("HASIL PENGOLAHAN NILAI"));
    }

    private void setAppScanner(String input) {
        App.setScannerForTesting(new Scanner(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8))));
    }
}