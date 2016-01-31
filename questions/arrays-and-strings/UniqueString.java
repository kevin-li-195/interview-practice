/* 1. Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structure?
 *
 * 2. Given two strings, write a method to decide
 * if one is a permutation of the other.
 *
 * 4. Implement a method to perform basic string compression using the 
 * counts of repeated characters. For example, the string 'aabcccccaaa' would
 * become a2b1c5a3. If the compressed string would not become smaller
 * than the original string, your method should return the original string.
 *
 * 7. Assume you have a method isSubstring which checks if one word is a
 * substring of another. Given two strings, s1 and s2, write code to check
 * if s2 is a rotation of s1 using only one call to isSubstring.
 * (e.g. 'waterbottle' is a rotation of 'erbottlewat') */

import java.util.Hashtable;
import java.util.Set;
import java.util.Map;

public class UniqueString {
    // Question 1, implemented with a hashtable.
    static boolean isUnique(String s) {
        if (s == "") {
            return false;
        }

        char[] a = s.toCharArray();
        Hashtable<Character, Integer> t = new Hashtable<Character, Integer>();
        for (char c : a) {
            t.put(c, 1);
        }
        if (t.size() < a.length) return false;
        else return true;
    }

    // Question 1, implemented with no extra data structures (unless you count charsequences)
    static boolean isUniqueNoDS(String s) {
        if (s.length() <= 1) {
            return(true);
        }
        CharSequence c = s.subSequence(0,1);
        String ns = s.substring(1);
        if (ns.contains(c)) return(false);
        else return(isUniqueNoDS(ns));
    }

    //Question 2, checks if String a is a permutation of String b.
    static boolean isPermutation(String a, String b) {
        if (a == "") return true;
        char[] e = a.toCharArray();
        for (char c : e) {
            CharSequence d = Character.valueOf(c).toString().subSequence(0,1);
            if (!(b.contains(d))) return false;
        }
        return true;
    }

    //Question 4, basic string compression.
    static String compressString(String s) {
        Hashtable<Character, Integer> t = new Hashtable<Character, Integer>();
        for (char c : s.toCharArray()) {
            if (t.get(c) == null) {
                t.put(c, 1);
            } else {
                t.put(c, t.get(c)+1);
            }
        }
        Set<Map.Entry<Character, Integer>> set = t.entrySet();
        StringBuffer sb = new StringBuffer();
        for (Map.Entry<Character, Integer> o : set) {
            char ch = o.getKey();
            int in = o.getValue();
            sb.append(ch);
            sb.append(in);
        }
        if (sb.length() > s.length()) return(s);
        else return(sb.toString());
    }

    // Question 7 : check whether string 1 is a rotation of string 2 with only one call to 
    // a helper function 'isSubstring'
    static boolean isRotation(String s1, String s2) {
        return(s1.length() == s2.length() && (s1+s1).indexOf(s2) != -1);
    }

    public static void main(String[] args) {
        String a = "waterbottle";
        String b = "aterbottlew";
        if (isRotation(a, b)) System.out.println(a + " is rotation of " + b + ".");
    }
}
