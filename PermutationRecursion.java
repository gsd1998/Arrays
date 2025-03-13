package interviewQA;

import java.util.ArrayList;
import java.util.List;

public class PermutationRecursion {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        ArrayList<Integer> ds = new ArrayList<>();
        List<ArrayList<Integer>> ans = new ArrayList<>();
        boolean[] visitedArr = new boolean[nums.length];
        recurse(ds, ans, nums, visitedArr);
        System.out.println(ans); //[[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]
    }

    private static void recurse(ArrayList<Integer> ds,  List<ArrayList<Integer>> ans, int[] nums, boolean[] visitedArr){
        if(ds.size() == nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i = 0; i <= nums.length-1; i++){
            if(!visitedArr[i]){
                visitedArr[i] = true;
                ds.add(nums[i]);
                recurse(ds, ans, nums, visitedArr);
                ds.remove(ds.size() - 1);
                visitedArr[i] = false;
            }
        }
    }
}
