package interviewQA;

public class MaximumProductSubarray {

    public static void main(String[] args) {
        int[] nums ={2, 0, -3, 5, -1, 0, 2, -2}; //24
        System.out.println(maxProductOptimised(nums));
    }
    public static int maxProduct(int[] nums) {
        int maxProduct = Integer.MIN_VALUE;
        for(int i = 0; i <= nums.length-1; i++){
            int product = 1;
            for(int j = i; j <= nums.length-1; j++){
                product = product * nums[j];
                maxProduct = Math.max(maxProduct, product);
            }
        }
        return maxProduct;
    }

    public static int maxProductOptimised(int[] nums) {
        int maxProduct = Integer.MIN_VALUE;
        int prefix = 1;
        int suffix = 1;
        int n = nums.length;
        for(int i = 0; i <= nums.length-1; i++){
            if(prefix == 0){
                prefix = 1;
            }
            if(suffix == 0){
                suffix = 1;
            }
            prefix = prefix * nums[i];
            suffix = suffix * nums[n-i-1];

            maxProduct = Math.max(maxProduct, Math.max(prefix, suffix));
        }
        return maxProduct;
    }

}
