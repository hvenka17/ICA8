/**
 * @author Hariraj Venkatesan
 */

package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

class UrinalsTest {
    @Test
    void testGoodStringShouldReturnTrueForValidString() {
        System.out.println("====== Hariraj Venkatesan == TEST ONE EXECUTED =======");
        Assertions.assertEquals( true , Urinals.goodString("10001"));
    }

    @Test
    void testGoodStringShouldReturnFalseWhenStringIsTooShort() {
        System.out.println("====== Hariraj Venkatesan == TEST TWO EXECUTED =======");
        Assertions.assertFalse(Urinals.goodString(""));
    }

    @Test
    void testGoodStringShouldReturnFalseWhenStringContainsInvalidCharacters() {
        System.out.println("====== Hariraj Venkatesan == TEST THREE EXECUTED =======");
        Assertions.assertFalse(Urinals.goodString("123"));
    }

    @Test
    void testGoodStringShouldReturnFalseWhenInputStringIsTooLong() {
        System.out.println("====== Hariraj Venkatesan == TEST SEVEN EXECUTED =======");
        Assertions.assertFalse(Urinals.goodString("123456789012345678901234567890"));
    }

    @Test
    void testOpenFileShouldThrowFileNotFoundExceptionIfInputFileDoesNotExist() {
        System.out.println("====== Hariraj Venkatesan == TEST FOUR EXECUTED =======");
        Assertions.assertThrows(FileNotFoundException.class, () -> Urinals.openFile("INVALID"));
    }

    @Test
    void testOpenFileShouldThrowInvalidFileExceptionIfInputFileIsEmpty() {
        System.out.println("====== Hariraj Venkatesan == TEST FIVE EXECUTED =======");
        Assertions.assertThrows(InvalidFileException.class, () -> Urinals.openFile("EmptyFile.dat"));
    }

    @Test
    void testOpenFileShouldThrowNumberFormatExceptionIfInputFileContainsInvalidNumbers() {
        System.out.println("====== Hariraj Venkatesan == TEST SIX EXECUTED =======");
        Assertions.assertThrows(NumberFormatException.class, () -> Urinals.openFile("InvalidNumberFormat.dat"));
    }

    @Test
    void testCountUrinalsShouldReturnCountOfAvailablePositions() {
        System.out.println("====== Hariraj Venkatesan == TEST EIGHT EXECUTED =======");
        Assertions.assertEquals(1, Urinals.countUrinals("10001"));
        Assertions.assertEquals(0, Urinals.countUrinals("1001"));
        Assertions.assertEquals(3, Urinals.countUrinals("00000"));
        Assertions.assertEquals(2, Urinals.countUrinals("0000"));
        Assertions.assertEquals(1, Urinals.countUrinals("01000"));
        Assertions.assertEquals(-1, Urinals.countUrinals("011"));
    }
}