package interviewQA;

import java.util.ArrayList;

public class ReversePairs {

    public static void main(String[] args){
        int[] nums = {1,3,2,3,1};
        int output = reversePairs(nums);
        System.out.println(output);//2
    }

    public static int reversePairs(int[] nums) {
        int n = nums.length;
        return mergeSort(nums, 0 , n-1);
    }

    private static int mergeSort(int[] arr, int low, int high){
        int count = 0;
        if(low >= high)
            return count;
        int mid = (low+high)/2;
        count = count + mergeSort(arr,low,mid);
        count = count + mergeSort(arr,mid+1,high);
        // This function below does the work for us
        // It iIterates each element of the left array with very element in right array and updates the count
        count = count + reversePairs(arr,low,mid,high);
        merge(arr,low,mid,high);
        return count;
    }

    private static int reversePairs(int[] arr,int low, int mid, int high){
        int count = 0;
        int right = mid+1;
        for(int left = low; left <= mid; left++){
            while(right <= high && (long)arr[left] > (long)arr[right]*2){
                right++;
            }
            count = count + right - (mid+1);
        }
        return count;
    }

    private static void merge(int[] arr,int low, int mid, int high){
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid+1;

        while(left <= mid && right <= high){
            if(arr[left] <= arr[right]){
                temp.add(arr[left]);
                left++;
            }else{
                temp.add(arr[right]);
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
    }
}
