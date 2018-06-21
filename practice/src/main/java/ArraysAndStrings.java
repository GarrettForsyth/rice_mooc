import java.util.HashSet;

public class ArraysAndStrings {

    // what kind of characters can I expect as input?
// what is the length of the string?

    /**
     *  Returns true if there are duplicate characters in the string
     *  @param input string
     *  @return boolean indicating duplicate character
     */
    public static boolean hasDuplicate(String input){
        HashSet<Character> seenCharacters = new HashSet<>();

        for (char ch : input.toCharArray()){
            if (seenCharacters.contains(ch)) return true;
            seenCharacters.add(ch);
        }

        return false;
    }

    /**
     *  Reverses a C - style string
     * @param inputString the string to be reversed
     * @return reversedCString the reversed C-String
     */
    public static String reverseCString(String inputString){
        if (inputString.equals("\0")) return inputString;
        if (inputString == null)        return null;
        StringBuilder sb = new StringBuilder();

        for  (int i = inputString.length() - 2;i < 0; i--){
            sb.append(inputString.charAt(i));
        }

        sb.append("\0");
        return  sb.toString();
    }


    /**
     * Checks if two strings are an anagram of each other
     * @param str1 first string to be compared
     * @param str2 second string to be compared
     * @return true if str1 and str2 are anagrams of eachother
     */
    public static boolean isAnagram(String str1, String str2)
            throws IllegalArgumentException {
        if(str1 == null || str2 == null) throw new IllegalArgumentException();
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        int[] str1LetterCount  =  countLetters(str1);
        int[] str2LetterCount =  countLetters(str2);
        return compareIntArray(str1LetterCount, str2LetterCount);
    }

    /* Returns an int array representing the letter counts
       in a word */
    private static int[] countLetters(String word){

        final int ASCII_a = (int) 'a';
        int[] letterCount = new int[26];

        // loop over each word and count the letters
        for(int i=0; i < word.length(); i++){
            char ch = word.charAt(i);
            int index = (int) ch - ASCII_a;
            letterCount[index]++;
        }
        return letterCount;
    }

    /* Returns true if two int arrays contain the same values */
    private static boolean compareIntArray(int[] arr1, int[] arr2)
      throws IllegalArgumentException{
      if(arr1 == null || arr2 == null) throw new IllegalArgumentException();
      if(arr1.length != arr2.length) return false;

      // check each letter count is the same
      for(int i=0; i < arr1.length; i++){
        if(arr1[i] != arr2[i]) return false;
      }
      return true;
    }



    /**
     * Replaces the occurences of toBeReplaced in string, with replacement
     * @param string the original string
     * @param toBeReplaced the substring to be searched for and replaced in string
     * @param replacement the string to replace any occurances of tobeReplaced with
     */
    public static String replaceSubstring(String string, String toBeReplaced, String replacement)
            throws IllegalArgumentException{
        if (toBeReplaced == null || replacement == null) throw new IllegalArgumentException();

        int tbrLen = toBeReplaced.length();
        if (string.length() < tbrLen) return string;

        StringBuilder newString = new StringBuilder();
        int remainderCharacters = 0;

        // iterate through the string and check for toBeReplaced
        for(int i=0; i < string.length()-tbrLen; i++){
            if(string.substring(i,i+tbrLen).equals(toBeReplaced)){
                newString.append(replacement);
                i += tbrLen;
            }
            newString.append(string.charAt(i));
            remainderCharacters = string.length() - i;
        }

        for(int i=string.length()- remainderCharacters+1;
                i < string.length();
                i++){
            newString.append(string.charAt(i));
        }

        if(string.substring(string.length()-tbrLen).equals(toBeReplaced)){
            newString.append(replacement);
        }
        else{
            for(int i=string.length()- remainderCharacters+1;
                 i < string.length();
                 i++){
            newString.append(string.charAt(i));
        }


        }

        return newString.toString();
    }
}

