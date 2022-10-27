/**
 * @author Hariraj Venkatesan
 */

package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Urinals {
    public static Boolean goodString(String s){
        if (s.length() < 1)
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
}
