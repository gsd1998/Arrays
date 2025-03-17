package interviewQA;

import java.util.ArrayList;
import java.util.List;

/*Q2. Given the row number return all the elements in this particular row from a Pascals Triangle */
public class PascalsTriangleGenerateARow {

    public static void main(String[] args) {
        System.out.println(generateRows(4));//[1, 3, 3, 1]
        System.out.println(generateRowsOptimized(4));
    }

    //This Approach has high time complexity since it basically finds the nCr of each element and add it to the list
    public static List<Integer> generateRows(int rowNumber) {
        int ans = 1;
        List<Integer> list = new ArrayList<>();

        for(int col = 1; col <= rowNumber; col++){
            int nFact = recursion(rowNumber-1);
            int rFact = recursion(col-1);
            int nMinuSrFact = recursion(rowNumber-col);
            list.add(nFact/(rFact * nMinuSrFact));
        }
        return list;
    }
    public static int recursion(int num){
        if(num==0)
            return 1;
        return num * recursion(num-1);
    }

    /*This is the optimal approach where it uses a formula which is  => ans *(rowNumber - col)/ col
      Where rowNumber is the actual rowNumber and col starts from 1 */
    /*TC -> O(r) */
    public static List<Integer> generateRowsOptimized(int rowNumber) {
        int ans = 1;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for(int col = 1; col <= rowNumber-1; col++){
            ans = ans * (rowNumber - col);
            ans = ans / col;
            list.add(ans);
        }
        return list;
    }
}
