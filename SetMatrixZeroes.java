package interviewQA;

import java.util.Arrays;

public class SetMatrixZeroes {

    public static void main(String[] args) {
        int a1[][] =  {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        //int[][] a1 = {{1,1,1},{1,0,1},{1,1,1}};
        //setZeroesBrute(a1);
        setZeroesUsingTwoExtraArrays(a1);
        for (int[] row : a1)
            System.out.println(Arrays.toString(row));

    }

    //This Brute force approach fails for test cases where matrix elements starts from Integer.MIN_VALUE
    public static void setZeroesBrute(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        for(int i = 0; i <= n-1; i++){
            for(int j = 0; j <= m-1; j++){
                if(matrix[i][j] == 0){
                    for(int k1 = 0; k1 <= m-1; k1++){
                        if(matrix[i][k1] != 0)
                            matrix[i][k1] = Integer.MIN_VALUE;
                    }
                    for(int k2 = 0; k2 <= n-1; k2++){
                        if(matrix[k2][j] != 0)
                            matrix[k2][j] = Integer.MIN_VALUE;
                    }
                }
            }
        }
        for(int i = 0; i <= n-1; i++){
            for(int j = 0; j <= m-1; j++){
                if(matrix[i][j] == Integer.MIN_VALUE){
                    matrix[i][j] = 0;
                }
            }
        }
    }

    //This approach is good, but it uses extra space for the two arrays.
    // Gives a TC of O(2*(N*M)) and SC of O(N)+O(M)
    public static void setZeroesUsingTwoExtraArrays(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] row = new int[n];
        int[] col = new int[m];
        for(int i = 0; i <= n-1; i++){
            for(int j = 0; j <= m-1; j++){
                if(matrix[i][j] == 0){
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
        for(int i = 0; i <= n-1; i++){
            for(int j = 0; j <= m-1; j++){
                if(row[i] == 1 || col[j] == 1){
                    matrix[i][j] = 0;
                }
            }
        }

    }
}
