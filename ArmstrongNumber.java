package interviewQA;

public class ArmstrongNumber {
    public static void main(String[] args) {
        // 370 is an Armstrong number because 3^3 + 7^3 + 0^3 = 370
        int num = 371;
        isArmstrong(num);
        isArmstrongUsingModAndDiv(num);
    }

    private static void isArmstrong(int num) {
        int length = String.valueOf(num).length();
        char[] ch = String.valueOf(num).toCharArray();
        int sum = 0;
        for(char c : ch){
            int value  = Integer.parseInt(String.valueOf(c));
            var result = Math.pow(value,length);
            sum += result;
        }
        System.out.println(sum == num ? num + " is Armstrong" : num + " is not Armstrong");
    }

    private static void isArmstrongUsingModAndDiv(int num) {
        int length = String.valueOf(num).length();
        var original = num;
        int sum = 0;
        while(num > 0){
           int mod = num % 10;
           sum += Math.pow(mod, length);
           num = num/10;
        }
        System.out.println(sum == original ? original + " is Armstrong" : original + " is not Armstrong");
    }
}
