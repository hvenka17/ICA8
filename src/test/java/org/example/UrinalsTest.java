/**
 * @author Hariraj Venkatesan
 */

package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
}