package interviewQA;

import java.util.Arrays;

public class HashingQA {
    public static void main(String[] args) {
        int[] arr = {1,2,5,8,3,2,1,14,14,0};

        //pre calculation
        int[] hash = new int[15];
        for(int i=0; i < arr.length; i++){
            hash[arr[i]]++; //hash[arr[i]] = hash[arr[i]] + 1;
        }

        //frequencyCalculator(3, hash);
        System.out.println(Arrays.toString(hash));

        /* ----------------------------------- */

        String word = "helloworlda";
        int[] charHash = new int[26];

        for(int i=0; i < word.length(); i++){
            charHash[word.charAt(i) - 'a']++; //ASCII conversion happens word.charAt(i) - 'a' returns an integer value
        }

        //frequencyCalculatorForChar('l', charHash);
        System.out.println(Arrays.toString(charHash));

        /* ----------------------------------- */

        String allWord = "HelloWorld";
        int[] allHash = new int[256];   //256 is the total number of characters we have

        for(int i=0; i < allWord.length(); i++){
            allHash[allWord.charAt(i)]++;   //ASCII conversion happens allWord.charAt(i) returns an integer value
        }

        frequencyCalculatorForAllChar('l', allHash);
        System.out.println(Arrays.toString(allHash));
    }

    private static void frequencyCalculatorForChar(char character, int[] hash) {
        System.out.println(character + " appears " + hash[character - 'a'] + " times");
    }

    private static void frequencyCalculatorForAllChar(char character, int[] hash) {
        System.out.println(character + " appears " + hash[character] + " times");
    }

    private static void frequencyCalculator(int element, int[] hash) {
        System.out.println(element + " appears " + hash[element] + " times");
    }
}
