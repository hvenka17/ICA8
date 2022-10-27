/**
 * @author Hariraj Venkatesan
 */

package org.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Urinals {
    public static Boolean goodString(String s){
        Set<String> validCharacters = new HashSet<>(Arrays.asList("0", "1"));
        for(int i=0;i<s.length();i++) {
            if (!validCharacters.contains(Character.toString(s.charAt(i))))
                return false;
        }
        return true;
    }
}
