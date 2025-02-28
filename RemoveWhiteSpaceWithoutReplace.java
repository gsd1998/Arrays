package interviewQA;

public class RemoveWhiteSpaceWithoutReplace {
    public static void main(String[] args) {
        String input = "  Hello World  ";

        String newWord = removeWhileSpace(input);
        System.out.println("Output: " + newWord);

        String newWordFromStringBuilder = removeWhileSpaceUsingStringBuilder(input);
        System.out.println("newWordFromStringBuilder: " + newWordFromStringBuilder);
    }

    private static String removeWhileSpace(String input) {
        String newWord = "";
        char[] chars = input.toCharArray();
        for(char ch : chars){
            if(ch != ' '){
                newWord += ch;
            }
        }
        return newWord;

    }

    /* Using StringBuilder */
    private static String removeWhileSpaceUsingStringBuilder(String input) {
        StringBuilder builder = new StringBuilder();
        for(int i=0; i < input.length(); i++){
            if(input.charAt(i) != ' '){
                builder.append(input.charAt(i));
            }
        }
        return builder.toString();
    }
}
