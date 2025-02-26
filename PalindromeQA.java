package interviewQA;

public class PalindromeQA {
    public static void main(String[] args) {

        String word= "malayalam";
        boolean isPalindrome = isPalindrome(word);
        boolean isPalindromeWithoutReversing = isPalindromeWithoutReversing(word);
        System.out.println("Is the given word a palindrome? : " + isPalindrome);
        System.out.println("Is the given word a palindrome w/o reversing ? : " + isPalindromeWithoutReversing);
    }

    /* This function reverses and check */
    private static boolean isPalindrome(String word) {

        char[] ch = word.toCharArray();
        int start = 0;
        int end  = ch.length - 1;
        while(start < end){
            char temp = ch[start];
            ch[start] = ch[end];
            ch[end] = temp;
            start++;
            end--;
        }

        if(!word.equals(new String(ch))){
            return false;
        }
        return true;
    }

    /* This function check without reversing */
    private static boolean isPalindromeWithoutReversing(String word) {

        char[] ch = word.toCharArray();
        int start = 0;
        int end  = ch.length - 1;
        while(start < end){
            if(ch[start] != ch[end]){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
