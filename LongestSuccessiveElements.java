package interviewQA;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestSuccessiveElements {
    public static void main(String[] args) {
        //int[] a = {15, 6, 2, 1, 16, 4, 2, 29, 9, 12, 8, 5, 14, 21, 8, 12, 17, 16, 6, 26, 3};
        int[] a = {5, 8, 3, 2, 1, 4};
        //int op = longestSuccessiveElements(a);
        //System.out.println("output : " + op);
        System.out.println(calcLongestSubSeq(a));
    }
    public static int longestSuccessiveElements(int []a) {
        Arrays.sort(a);
        int output = 0;
        int count = 0;
        int maxCount = 0;
        System.out.println(Arrays.toString(a));
        for(int i = 0; i <= a.length-2; i++){
            if(a[i+1] - a[i] == 1 || a[i+1] == a[i]){
                if(a[i+1] == a[i]){

                }else{
                    count++;
                }
                if(count > maxCount){
                    maxCount = count;
                }
            }else{
                count = 0;
            }
        }
        output = maxCount+1;
        return output;
    }

    //Using Set
    public static int calcLongestSubSeq(int[] a){
        int longest = 0;
        int count = 0;
        Set<Integer> set = new HashSet<>();

        for(int i : a){
            set.add(i);
        }

        for(int i : set){
            if(!set.contains(i-1)){
                int x = i;
                count = 1;
                while(set.contains(x+1)){
                    count++;
                    x = x+1;
                }
                longest =  Math.max(longest,count);
            }
        }
        return longest;
    }
}
