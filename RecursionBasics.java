package interviewQA;

/*
printing from 1 to N using i+1
printing from 1 to N but using i-1
printing from N to 1 using i-1
printing from N to 1 but using i+1
 */

public class RecursionBasics{

    public static void main(String[] args) {

        //printing from 1 to N using i+1
        int n1 = 10;
        //printNumberUsingIPlus1(n1,1);

        System.out.println("-----------------");

        //printing from 1 to N but using i-1
        int n2 = 10;
        //printNumberUsingIMinus1(n2,10);

        System.out.println("-----------------");

        //printing from N to 1 using i-1
        int n3 = 10;
        //printNumberNto1(n3,10);

        System.out.println("-----------------");

        //printing from N to 1 using i+1
        int n4 = 10;
        printNumberNto1Reverse(n4,1);
    }

    private static void printNumberUsingIPlus1(int n, int i) {
        if(i > n)
            return;
        System.out.println(i);
        printNumberUsingIPlus1(n, i+1);
    }

    private static void printNumberUsingIMinus1(int n, int i) {
        if(i < 1)
            return;
        printNumberUsingIMinus1(n, i-1);
        System.out.println(i);
    }

    private static void printNumberNto1(int n, int i) {
        if(i < 1)
            return;
        System.out.println(i);
        printNumberNto1(n, i-1);

    }

    private static void printNumberNto1Reverse(int n, int i) {
        if(i > 10)
            return;
        printNumberNto1Reverse(n,i+1);
        System.out.println(i);
    }
}
