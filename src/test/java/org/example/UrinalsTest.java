/**
 * @author Hariraj Venkatesan
 */

package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

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

    @Test
    void testWriteFileCreatesOutputFile() throws IOException {
        System.out.println("====== Hariraj Venkatesan == TEST NINE EXECUTED =======");
        deleteRuleFiles();
        File outFile = new File("rule.txt");
        List<Integer> values = Arrays.asList(1,3);
        Urinals.writeFile(values);
        Assertions.assertTrue(outFile.exists());
    }

    private static List<String> ruleFilesList() {
        File folder = new File(".");
        return Arrays.stream(folder.listFiles()).map(File::getName)
                .filter(name -> name.matches("rule.*.txt")).sorted().toList();
    }

    private static void deleteRuleFiles() {
        ruleFilesList().forEach(file -> {
            File ruleFile = new File(file);
            try {
                Files.deleteIfExists(ruleFile.toPath());
            } catch (IOException e) {
                System.out.println("Exception when deleting files");
            }
        });
    }

    @Test
    void testWriteFileMustCreateRuleFileWithCounterIfRuleFileExists() throws IOException {
        System.out.println("====== Hariraj Venkatesan == TEST TEN EXECUTED =======");
        deleteRuleFiles();
        FileWriter outFile = new FileWriter("rule.txt");
        outFile.close();
        List<Integer> values = Arrays.asList(1,3);
        File expectedFile = new File("rule1.txt");
        Urinals.writeFile(values);
        Assertions.assertTrue(expectedFile.exists());
        expectedFile = new File("rule2.txt");
        Urinals.writeFile(values);
        Assertions.assertTrue(expectedFile.exists());
    }

    @Test
    void testPerformReadsInputFileAndWritesCountToOutputFile() throws InvalidFileException, IOException {
        System.out.println("====== Hariraj Venkatesan == TEST ELEVEN EXECUTED =======");
        int oldCount = ruleFilesList().size();
        Urinals.perform();
        int newCount = ruleFilesList().size();
        Assertions.assertEquals(oldCount+1, newCount);
    }
}