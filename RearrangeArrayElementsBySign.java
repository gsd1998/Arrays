package interviewQA;

import java.util.ArrayList;
import java.util.Arrays;

public class RearrangeArrayElementsBySign {
    public static void main(String[] args) {
        int[] nums = {3,1,-2,-5,2,-4,1,-2,-4,-5,7};
        System.out.println(Arrays.toString(rearrangeArrayUnorderedPosAndNegs(nums)));
    }

    public static int[] rearrangeArray(int[] arr) {

        int len = arr.length;

        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();

        int[] outputArr = new int[len];

        for(int i = 0; i <= arr.length-1; i++){

            if(arr[i] > 0){
                arr1.add(arr[i]);
            }else{
                arr2.add(arr[i]);
            }
        }

        int left = 0;
        int right = 0;
        int index =0;
        while(left < arr1.size() && right < arr2.size()){
            outputArr[index] = arr1.get(left);
            index++;
            left++;
            outputArr[index] = arr2.get(right);
            right++;
            index++;
        }


        // int listCounter1 = 0;
        // for(int i = 0; i <= arr.length-1; i=i+2){
        //     outputArr[i] = arr1.get(i - listCounter1);
        //     listCounter1++;
        // }

        // //0 -> 0
        // //2 -> 2 - 1 = 1;
        // //4 -> 4 - 2 = 2;

        // int listCounter2 = 1;
        // for(int i = 1; i <= arr.length-1; i=i+2){
        //     outputArr[i] = arr2.get(i - listCounter2);
        //     listCounter2++;
        // }

        return outputArr;
    }

    //TC -> O(N) + O(N/2)
    //SC -> O(N)
    public static int[] rearrangeArrayReducingTC(int[] arr) {

        int len = arr.length/2;

        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();

        for(int i = 0; i <= arr.length-1; i++){

            if(arr[i] > 0){
                arr1.add(arr[i]);
            }else{
                arr2.add(arr[i]);
            }
        }

        for(int i = 0; i <= len-1; i++){
            arr[2*i] = arr1.get(i);
            arr[2*i+1] = arr2.get(i);
        }
        return arr;

    }

    //TC -> O(N)
    //SC -> O(N)
    public static int[] rearrangeArrayOptimized(int[] arr) {

        int len = arr.length;
        int posIndex = 0, negIndex = 1;
        int[] outputArr = new int[len];
        for(int i = 0; i <= arr.length-1; i++){
            if(arr[i] > 0){
                outputArr[posIndex] = arr[i];
                posIndex+=2;
            }else{
                outputArr[negIndex] = arr[i];
                negIndex+=2;
            }
            System.out.println(outputArr[i] +  " p " +  posIndex +  " n " + negIndex);
        }
        return outputArr;
    }

    public static int[] rearrangeArrayUnorderedPosAndNegs(int[] arr) {

        ArrayList<Integer> pArr = new ArrayList<>();
        ArrayList<Integer> nArr = new ArrayList<>();

        for(int i = 0; i <= arr.length-1; i++){
            if(arr[i] > 0){
                pArr.add(arr[i]);
            }else{
                nArr.add(arr[i]);
            }
        }

        if(pArr.size() > nArr.size()){
            for(int i = 0; i <= nArr.size()-1; i++){
                arr[2*i] = pArr.get(i);
                arr[2*i+1] = nArr.get(i);
            }

            for(int i = nArr.size(); i <= pArr.size()-1; i++){
                arr[2*nArr.size()] = pArr.get(i);
            }

        }else if(pArr.size() < nArr.size()){
            for(int i = 0; i <= pArr.size()-1; i++){
                arr[2*i] = pArr.get(i);
                arr[2*i+1] = nArr.get(i);
            }

            for(int i = pArr.size(); i <= nArr.size()-1; i++){
                arr[2*pArr.size()] = nArr.get(i);
            }
        }

        return arr;
    }

}
