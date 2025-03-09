package interviewQA;

import java.util.HashMap;

public class LongestSubarrayWithSumK {

    public static void main(String[] args) {
        int[] nums = {10, 5, 2, 7, 1, -10};

        int[] positiveNums = {10, 5, 2, 7, 1};

        //System.out.println(longestSubArray(nums, 15));//6
        //System.out.println(longestSubarrayOptimized(nums,15));
        System.out.println(longestSubarrayForPositivesOnly(positiveNums,15));

    }

    //This is Brute Force approach
    public static int longestSubArray(int[] arr, int k) {

        int maxConsqLength = 0;
        for(int i=0; i <= arr.length-1; i++){
            int sum = 0;
            for(int j=i; j <= arr.length-1; j++){
                sum = sum + arr[j];
                if(sum == k){
                    maxConsqLength = Math.max(maxConsqLength, j-i+1);
                }
            }
            //System.out.println("i = " + i + " => " + maxConsqLength);
        }
        return maxConsqLength;
    }

    /* This method works for negatives, zeros and positives
    Here we are using the concept of prefix Sum
    we need k. we calculate the sum.
    at index i we got sum = k
    now by standing at index i we will look back to see if any other subArray exists
    For that we use this approach
    => (sum - k) + (k) = sum
    If at 'i' I got sum = k
    then I am checking if anywhere before this 'i' I have (sum-k) such that sum - k + k = sum which is k itself.
     */
    public static int longestSubarrayOptimized(int[] arr, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int maxConsqLength = 0;
        int sum = 0;
        for(int i=0; i <= arr.length-1; i++){

            sum = sum + arr[i];

            if(sum == k){
                maxConsqLength = Math.max(maxConsqLength, i+1);
            }

            int rem = sum - k;

            if(map.containsKey(rem)){
                int len = i - map.get(rem);
                maxConsqLength = Math.max(maxConsqLength, len);
            }

            if(!map.containsKey(sum)){
                map.put(sum,i);
            }
        }
        return maxConsqLength;
    }


    /* This method works for zeros and positives only
       We use two pointer approach here
       We keep moving right pointer till sum reaches 'k'
       Then we calculate the subArray with maxConsecutive length when sum = k.
       If sum becomes more than 'k' we trim down from the left by moving the left pointer and
       subtracting the left pointer value from sum till sum becomes less than or equal to k
    */
    public static int longestSubarrayForPositivesOnly(int[] arr, int k) {

        int maxConsqLength = 0;
        int sum = arr[0];
        int left = 0;
        int right = 0;
        int n = arr.length;
        while(right <= n-1){
            while(left <= right && sum > k){
                sum -= arr[left];
                left++;
            }
            if(sum == k){
                maxConsqLength = Math.max(maxConsqLength, right - left + 1);
            }
            right++;
            if(right <= n-1){
                sum += arr[right];
            }
        }
        return maxConsqLength;
    }
}
