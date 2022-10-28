/**
 * @author Hariraj Venkatesan
 */

package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Urinals {

    private static final String urinalsFilePath = "Urinals.dat";

    public static Boolean goodString(String s){
        if (s.length() < 1 || s.length() > 20)
            return false;

        Set<String> validCharacters = new HashSet<>(Arrays.asList("0", "1"));
        for(int i=0;i<s.length();i++) {
            if (!validCharacters.contains(Character.toString(s.charAt(i))))
                return false;
        }
        return true;
    }

    public static List<String> openFile(String path) throws FileNotFoundException, InvalidFileException {
        List<String> lines = new ArrayList<>();

        File file = new File(path);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String inputLine = scanner.nextLine();
            if (inputLine.equals("-1"))
                break;
            else if (!goodString(inputLine))
                throw new NumberFormatException();
            lines.add(inputLine);
        }
        scanner.close();

        if (lines.isEmpty())
            throw new InvalidFileException();

        return lines;
    }

    public static int countUrinals(String input) {
        int available = input.length();
        for(int i=0;i<input.length();i++) {
            if (input.charAt(i) == '1') {
                if ((i!=input.length()-1) && (input.charAt(i+1) == '1'))
                    return -1;
            }

            if (input.charAt(i) == '1') {
                if (i == 0 || i == input.length()-1)
                    available -= 2;
                else
                    available -= 3;
            }
        }
        if (available > 1)
            available = (int)Math.ceil(available/2.0);
        return available;
    }
}
