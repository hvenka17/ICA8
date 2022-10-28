/**
 * @author Hariraj Venkatesan
 */

package org.example;

import java.io.*;
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
        if (input.contains("11"))
            return -1;

        if (input.length() == 1)
            return input.contains("0") ? 1 : 0;

        char[] input_chars = input.toCharArray();
        int available = 0;
        if ( input_chars[0] == '0' && input_chars[1] == '0' ) {
            input_chars[0] = '1';
            available++;
        }

        for(int idx = 1; idx <input_chars.length - 1; idx++) {
            if(input_chars[idx] == '0' && input_chars[idx-1] == '0' && input_chars[idx+1] == '0') {
                available++;
                input_chars[idx] = '1';
            }
        }

        if (input_chars[input_chars.length - 2] == '0' && input_chars[input_chars.length-1] == '0')
            available++;

        return available;
    }

    public static void writeFile(List<Integer> values) throws IOException {
        String outName = "rule.txt";
        File folder = new File(".");
        List<String> fileNames = Arrays.stream(folder.listFiles()).map(File::getName)
                .filter(name -> name.matches("rule.*.txt")).sorted().toList();
        if (!fileNames.isEmpty()) {
            String highest = fileNames.get(fileNames.size() - 1);
            String numberValue = highest.substring(4, highest.length() - 4);
            if (numberValue.length() > 0)
                outName = String.format("rule%d.txt", Integer.parseInt(numberValue) + 1);
            else
                outName = "rule1.txt";

        }
        FileWriter file = new FileWriter(outName);
        for(Integer x:values) {
            file.write(x.toString()+"\n");
        }
        file.close();
    }

    public static void perform() throws InvalidFileException, IOException {
        List<String> inputLines = openFile(urinalsFilePath);
        List<Integer> count = new ArrayList<>();
        for(String s:inputLines)
            count.add(countUrinals(s));
        writeFile(count);
    }
}
