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
    void testOpenFileShouldThrowFileNotFoundExceptionIfInputFileDoesNotExist() {
        System.out.println("====== Hariraj Venkatesan == TEST FOUR EXECUTED =======");
        Assertions.assertThrows(FileNotFoundException.class, () -> Urinals.openFile("INVALID"));
    }
}