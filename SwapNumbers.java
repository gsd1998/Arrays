package interviewQA;

public class SwapNumbers {
    public static void main(String[] args) {

        /* Swap 2 numbers without a third variable */

        int a = 5;
        int b = 10;
        System.out.println("a = " + a + " :::  b = " + b);

        a = a + b;
        b = a - b;
        a = a - b;

        System.out.println("a = " + a + " :::  b = " + b);

        /*
        logic for b =>

        b = a - b, where a = a+b
        b = (a + b) - b
        b = a

        logic for a =>

        a = a - b, where a = a+b and b = a-b
        a = (a + b) - (a -b)
        a = (a + b) - a + b => substituting for a = a+b
        a = (a + b) -(a + b) + b
        a = (a + b) - a - b + b
        a = a + b - a
        a = b

        */

        /*
        output:
        a = 5  :::  b = 10
        a = 10 :::  b = 5
        */
    }
}
