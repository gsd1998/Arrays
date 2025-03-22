package interviewQA;

import java.util.ArrayList;

public class CountInversions {

    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 1, 4};
        int n = arr.length;
        System.out.println(numberOfInversions(arr,n)); //7
    }

    //Brute Force
    public static int inversionCount(int arr[]) {
        int n = arr.length;
        int inversionCount = 0;
        for(int i = 0; i <= n-1 ; i++){
            for(int j = i+1; j <= n-1; j++){
                if(arr[j] < arr[i]){
                    inversionCount++;
                }
            }
        }
        return inversionCount;
    }

    //Optimal solution using merge sort
    //Areas of modification include introducing a count and summing it up when left array element is > right array element
    //since this forms a pair. Also, we have to return count from left, right and the final sorted array and sum it up.
    public static int numberOfInversions(int []a, int n) {
        return mergeSort(a,0,n-1);
    }

    private static int mergeSort(int a[], int low, int high){
        int count = 0;
        if(low >= high){
            return count;
        }
        int mid = (low+high)/2;
        count = count + mergeSort(a,low,mid);
        count = count + mergeSort(a,mid+1,high);
        count = count + merge(a,low,mid,high);
        return count;
    }

    private static int merge(int arr[], int low, int mid, int high){
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid+1;
        int count = 0;
        while(left <= mid && right <= high){
            if(arr[left] <= arr[right]){
                temp.add(arr[left]);
                left++;
            }else{
                temp.add(arr[right]);
                count = count + (mid-left+1);
                right++;
            }
        }

        while(left <= mid){
            temp.add(arr[left]);
            left++;
        }

        while(right <= high){
            temp.add(arr[right]);
            right++;
        }

        for(int i = low; i <= high; i++){
            arr[i] = temp.get(i-low);
        }
        return count;

    }
}
