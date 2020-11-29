import java.util.Arrays;

public class Anagram {
    /**
    Given an array of strings to the method isAnagram(@param String[])
    compares the strings and finds out if the string is anagram to the other string in the same array.
     */
    // Time Complexity: O(nLogn)
    public static void isAnagram(String[] arr){

        char[][] chars = new char[arr.length][256];
        for (int i = 0; i < arr.length; i++) {
            chars[i] = arr[i].toCharArray();
            Arrays.sort(chars[i]);
            //System.out.println(chars[i]);
        }

        for (int i=0; i<arr.length;i++){
            for (int j = i+1; j < arr.length; j++) {
                if (Arrays.toString(chars[i]).compareToIgnoreCase(Arrays.toString(chars[j])) == 0){
                    System.out.println(i+1 + ": " + arr[i] + " is anagram to " + arr[j]);
                }
            }
        }
    }

    /**
        areAnagram(@param String, @param String) takes two strings and returns a boolean value whether the passed strings 
        are anagram or not.
     */
    public static boolean areAnagram(String str1, String str2){

        if (str1.length() != str2.length()) return false;

        //XOR value
        int value = 0;
        for (int i=0; i<str1.length(); i++){
            value = value ^ (int) str1.charAt(i);
            value = value ^ (int) str2.charAt(i);
        }

        return value == 0;
    }
    public static void main(String[] args) {

        String[] s = {"geeksquiz", "geeksforgeeks", "abcd",
                "forgeeksgeeks", "zuiqkeegs", "Kavin Raju", "Raju Kavin"};
        System.out.println("Is anagram:");
        isAnagram(s);

        System.out.println("\nAre anagram");
        for (int i=0;i<s.length;i++){
            for (int j = i+1; j < s.length; j++) {
                if (areAnagram(s[i],s[j])){
                    System.out.println(s[i] + " and " + s[j] + " are angram.");
                }
            }
        }
    }
}