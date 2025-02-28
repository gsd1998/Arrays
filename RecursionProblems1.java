package interviewQA;

import java.util.Collections;

/*
1.Reverse a string using recursion - two variables
2.Reverse a string using recursion - single variable
3. Check if a string is a palindrome or not - single variable
 */


public class RecursionProblems1 {
    public static void main(String[] args) {

        String word1 = "modam";
        char[] words1  = word1.toCharArray();
        System.out.println("original word1 " + word1);

        //Reverse a string using recursion - two variables
        System.out.println("Two vars : ");
        System.out.println(reverseStringUsingRec(words1,0,word1.length()-1));

        //Reverse a string using recursion - single variable
        String word2 = "helix";
        char[] words2  = word2.toCharArray();
        System.out.println("original word2 " + word1);
        int i = 0;
        System.out.println("Single var : ");
        System.out.println(reverseStringSingleVar(words2,i));

        //check if a string is palindrome or not
        String word3 = "malayalam";
        char[] words3  = word3.toCharArray();
        System.out.println("is palindrome " + checkPalindrome(words3,0));
    }

    private static char[] reverseStringSingleVar(char[] words, int i) {
        if(i >= words.length/2)
            return words;
        swapLetters(words,i,(words.length - 1 - i));
        return reverseStringSingleVar(words,i+1);
    }

    private static char[] reverseStringUsingRec(char[] word,int left, int right) {
        if(left >= right)
            return word;
        swapLetters(word,left,right);
        return reverseStringUsingRec(word,left+1,right-1);
    }

    private static void swapLetters(char[] word, int l, int r) {
        char temp = word[l];
        word[l] = word[r];
        word[r] = temp;
    }

    private static boolean checkPalindrome(char[] words, int i) {
        if(i >= words.length/2)
            return true;
        if(words[i] != words[words.length - i -1]) {
            return false;
        }
        return checkPalindrome(words, i + 1);
    }

}

/*
size = 5
i = 0

i -> size - 1
0 -> 4
1 -> 3
2 -> 2

i -> size-1-i
0 -> 5-1-0 = 4
1 -> 5-1-1 = 3
2 -> 5-1-2 = 2

*/