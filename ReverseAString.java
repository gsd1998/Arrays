package interviewQA;

public class ReverseAString {
    public static void main(String[] args) {
        String word = "hello";

        String reverseUsingStringBuilder = new StringBuilder(word).reverse().toString();
        String reverseUsingForLoop = reverseStringUsingFor(word);
        String reverseUsingWhile = reverseUsingWhile(word);

        System.out.println(reverseUsingStringBuilder);
        System.out.println(reverseUsingForLoop);
        System.out.println(reverseUsingWhile);
    }

    //Using for loop
    public static String reverseStringUsingFor(String word) {
        char[] ch  =  word.toCharArray();
        String reversedWord = "";
        for(int i = ch.length - 1  ; i >= 0  ; i--){
            reversedWord = reversedWord + ch[i];
        }
        return reversedWord;
    }

    //Using while loop
    public static String reverseUsingWhile(String word) {
        char[] ch  =  word.toCharArray();

        int start = 0;
        int end = ch.length -1;
        while(start < end){
            System.out.println(ch[start] + " : " + ch[end]);
            char temp = ch[start];
            ch[start] = ch[end];
            ch[end] = temp;
            System.out.println(ch[start] + " : " + ch[end]);
            start++;
            end--;
        }
        return new String(ch);
    }
    /*
    h : o
    o : h
    e : l
    l : e
    hello => olleh
     */

}
