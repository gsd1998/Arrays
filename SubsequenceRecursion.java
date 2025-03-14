package interviewQA;

import java.util.ArrayList;
import java.util.List;

public class SubsequenceRecursion {

    public static void main(String[] args) {
        int[] nums = {3,2,1};
        List<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        calcSubsequeneces(0,list,nums,ans);
        System.out.println(ans);//[[3, 2, 1], [3, 2], [3, 1], [3], [2, 1], [2], [1], []]
    }
    private static void calcSubsequeneces(int index, ArrayList<Integer> list, int[] nums, List<ArrayList<Integer>> ans){
        if(index >= nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[index]);
        calcSubsequeneces(index+1,list,nums,ans);
        list.remove(list.size()-1);
        calcSubsequeneces(index+1,list,nums,ans);
    }
}
