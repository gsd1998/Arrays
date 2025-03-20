package interviewQA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeAllOverlappingIntervals {

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 4}, {3, 5}, {6, 7}};
        List<List<Integer>> outputArr = mergeOverlappingIntervals(intervals);
        System.out.println(outputArr);//[[1, 5], [6, 7]]
    }
    public static List<List<Integer>> mergeOverlappingIntervals(int [][]arr){

        List<List<Integer>> opList = new ArrayList<>();
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0],b[0]));
        for(int i = 0; i <= arr.length-1; i++){
            //If the outputlist is either empty or if current array elements zeroth index is greater
            //than  the output list's last added element's index 1 - meaning the current array is greater and not in the interval
            if(opList.isEmpty() || arr[i][0] > opList.get(opList.size()-1).get(1)){
                List<Integer> list = new ArrayList<>();
                list.add(arr[i][0]);
                list.add(arr[i][1]);
                opList.add(list);
            }else{ //this means the current array element's zeroth index is smaller than outputList's last added elements index 1
                opList.get(opList.size()-1).set(1, Math.max(arr[i][1],opList.get(opList.size()-1).get(1)));
            }
        }
        return opList;
    }
}
