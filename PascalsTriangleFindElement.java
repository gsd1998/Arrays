package interviewQA;


/*Q1. Given the row and column number return the element in the position from the pascal triangle */
public class PascalsTriangleFindElement {

    public static void main(String[] args) {
        System.out.println(findElementOptimized(6,3));//10
    }

    /*Using nCr = n!/r!*(n-r)! => O(n) + O(r) + O(n-r)*/
    public static int findElement(int row, int col) {
        int nFact = recursion(row-1);
        int rFact = recursion(col-1);
        int nMinuSrFact = recursion(row-col);
        return nFact/(rFact * nMinuSrFact);
    }
    public static int recursion(int num){
        if(num==0)
            return 1;
        return num * recursion(num-1);
    }

    //This is an optimized approach of the above solution taking less time
    //TC -> 0(r)
    public static int findElementOptimized(int row, int col) {
         row = row - 1;
         col = col - 1;
         int result = 1;
         for(int i=0; i <= col-1; i++){
           result = result * (row-i);
           result = result/(i+1);
         }
         return result;
    }
}
