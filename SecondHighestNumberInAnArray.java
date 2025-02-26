package interviewQA;

import java.util.Arrays;

public class SecondHighestNumberInAnArray {
    public static void main(String[] args) {
        int[] arr = {123, 5, 7, 8, 2, 11, 210, 20};
        int secondHighest = findSecondHighest(arr);
        System.out.println("Second highest number in the array: " + secondHighest);
        int n=2;
        int nthHighest = findNthHighest(arr,n);
        System.out.println("Nth highest number in the array: " + nthHighest);

    }

    private static int findSecondHighest(int[] arr) {
        Arrays.sort(arr);
        /*
        NOTE:
        We can use a merge sort or quick sort depending on whether they are passing primitives or objects
        in case we don't want to go with predefined methods -> So do learn Quick and Merge sort
        Here we are using internally DualPivotQuicksort coz we are working with primitives
        For Objects like Integer array we use Tim Sort internally which is a combination of Merge and Insertion sort
         */
        System.out.println(Arrays.toString(arr));
        return arr[arr.length-2];
    }

    private static int findNthHighest(int[] arr, int n) {
        Arrays.sort(arr);
        return arr[arr.length-n];
    }
}

