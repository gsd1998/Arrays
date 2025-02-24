package interviewQA;

public class primeNumber {
    public static void main(String[] args) {
        int num = 43;
        boolean isPrime = primeNumberChecker(num);
        boolean isPrimeEfficient = primeNumberEfficientChecker(num);
        System.out.println("isPrime " + isPrime);
        System.out.println("isPrimeEfficient " + isPrimeEfficient);
    }

    private static boolean primeNumberChecker(int num) {
        if(num <= 1){
            return false;
        }

        /* We are checking till Square root of the number whether a divisor exists,
           basically we are checking for small divisors till the square root.
        */
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }

    /* This function is much for faster than the above function */
    private static boolean primeNumberEfficientChecker(int num) {
        if(num <= 1)
            return false;
        if(num <= 3)
            return true;
        if(num % 2 == 0 || num % 3 == 0)
            return false;
        System.out.println("Sqrt = " + Math.sqrt(num));
        for(int i = 5; i <= Math.sqrt(num); i += 6){
            System.out.println(" i = " + i + " ::: " + " i+2 =" + (i+2));
            System.out.println(num + " % " + (i) + " => " + (num % i == 0));
            System.out.println(num + " % " + (i+2) + " => " + (num % (i+2) == 0));
            if((num % i == 0) || (num % (i + 2) == 0))
                return false;
        }
        return true;
    }
    /*
    num = 121
    Sqrt = 11.0
    i = 5 :::  i+2 =7
    121 % 5 => false
    121 % 7 => false
    i = 11 :::  i+2 =13
    121 % 11 => true
    121 % 13 => false
    isPrime false
    isPrimeEfficient false


    num = 43
    Sqrt = 6.557438524302 (This means till 6 the number should have at least one divisor apart from 1)
    i = 5 :::  i+2 =7
    43 % 5 => false
    43 % 7 => false
    (next i will become 11 and  11 <= 6 will fail, hence it will come out of the for loop)
    isPrime true
    isPrimeEfficient true
     */
}
