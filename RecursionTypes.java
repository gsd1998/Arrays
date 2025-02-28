package interviewQA;

/*
1.parametrized recursion
2.functional recursion
Q.Sum of N natural numbers
Q.Factor of N natural numbers
 */
public class RecursionTypes {
    public static void main(String[] args) {

        //Sum of first N natural numbers
        printNaturalNumbers(3, 0);
        System.out.println(sumOfNaturalNumbers(3, 0));
        System.out.println("= " + printFactorial(3));
    }

    //parametrized recursion
    private static void printNaturalNumbers(int i, int sum) {
        if (i < 1) {
            System.out.println(sum);
            return;
        }
        printNaturalNumbers(i - 1, sum + i);
    }

    //functional recursion
    private static int sumOfNaturalNumbers(int i, int sum) {
        if (i == 0)
            return 0;
        return i + sumOfNaturalNumbers(i - 1, sum);
    }

/*

 3 + sum(2,sum)
        2 + sum(1,sum)
              1 + sum (0,sum)
                    0 is returned

              1 +   0  =  1 is returned
        2 +   1        =  3 is returned
 3 +    3              =  6 is returned to the main function

 */

    private static int printFactorial(int i) {
        if (i == 0)
            return 1;
        System.out.print(i + " * ");
        return i * printFactorial(i - 1);
    }
}

