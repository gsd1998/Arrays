package interviewQA;

public class FibonacciSeries {
    public static void main(String[] args){

        //0 1 1 2 3 5 8 13 21 34
        int num = 4; //number of elements to be printed

        //Fibonacci(num);

        for(int i = 0; i < num; i++){
            System.out.println(" i : " + i);
            System.out.println("returned val : " + FibonacciRecursion(i) + " ");
            //FibonacciRecursion(i);
        }
    }

    private static void Fibonacci(int num) {
        int firstNumber  = 0;
        int secondNumber = 1;
        if(num == 1){
            System.out.print(firstNumber+ " ");
        }
        if(num == 2){
            System.out.print(firstNumber+ " " + secondNumber);
        }
        for(int i = 0; i < num-2; i++) {
            int sumOfBoth = firstNumber + secondNumber;
            if(i == 0) {
                System.out.print(firstNumber + " " + secondNumber + " " + sumOfBoth);
            } else {
                System.out.print(" " + sumOfBoth);
            }
            firstNumber = secondNumber;
            secondNumber = sumOfBoth;
        }
        System.out.println("");
    }
    private static int FibonacciRecursion(int num) {
        if(num <= 1){
            return num;
        }
        System.out.println("num : " + num);
        System.out.println("FibonacciRecursion(num-1) : " + (num-1) + "  FibonacciRecursion(num-2) : " + (num-2));
        return FibonacciRecursion(num-1) + FibonacciRecursion(num-2);
    }
}
/*
        num = 4
        --------
             i : 0
            returned val : 0
             i : 1
            returned val : 1
             i : 2
             num : 2
            FibonacciRecursion(num-1) : 1  FibonacciRecursion(num-2) : 0
            returned val : 1
             i : 3
             num : 3
            FibonacciRecursion(num-1) : 2  FibonacciRecursion(num-2) : 1
             num : 2
            FibonacciRecursion(num-1) : 1  FibonacciRecursion(num-2) : 0
            returned val : 2

Keeps drilling down till we reach FibonacciRecursion(1) and FibonacciRecursion(0) coz those two are the only values which we know
 */