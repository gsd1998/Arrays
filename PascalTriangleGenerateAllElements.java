package interviewQA;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleGenerateAllElements {
    public static void main(String[] args) {
        System.out.println(generateAllRows(6));//[[1], [1, 1], [1, 2, 1], [1, 3, 3, 1], [1, 4, 6, 4, 1], [1, 5, 10, 10, 5, 1]]
    }


    /* This method will generate for each row */
    public static List<Integer> generateRow(int rowNumber){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        int ans = 1;
        for(int col = 1; col <= rowNumber-1; col++){
            ans = ans * (rowNumber - col);
            ans = ans / col;
            list.add(ans);
        }
        return list;
    }

    /* This method will generate the total number of rows */
    public static List<List<Integer>> generateAllRows(int rows){
        List<List<Integer>> outputList = new ArrayList<>();
        for(int i = 1; i <= rows; i++){
            List<Integer> list = generateRow(i);
            outputList.add(list);
        }
        return outputList;
    }
}
