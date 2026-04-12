/*
 * Test untuk App - Main Program
 */
package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test 
    void appShouldHaveCorrectGreeting() {
        App classUnderTest = new App();
        assertEquals("Program Pengolahan Nilai Mahasiswa", classUnderTest.getGreeting());
    }

    @Test 
    void appGreetingShouldNotBeNull() {
        App classUnderTest = new App();
        assertNotNull(classUnderTest.getGreeting(), "app should have a greeting");
    }
}
