package interviewQA;
import java.util.*;
public class RotateImageBy90Degree {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int n = matrix.length;
        int[][] matrix2 = new int[n][n] ;
        //rotate(matrix, matrix2);
        rotateOptimal(matrix);
        for(int[] row : matrix){
            System.out.println(Arrays.toString(row )+ " ");
            System.out.println();
        }
        System.out.println("*****************");
        for(int[] row : matrix2){
            System.out.println(Arrays.toString(row )+ " ");
            System.out.println();
        }
    }

    //This approach uses extra space
    public static void rotate(int[][] matrix, int[][] matrix2) {
        int n = matrix.length;
        for(int i = 0; i <= n-1; i++){
            for(int j = 0; j <= n-1 ; j++){
                matrix2[j][n-1-i] = matrix[i][j];
            }
        }
    }

    //This is the optimal approach
    // First we transpose the matrix such that the row becomes column and the column becomes row and diagonal remains the same
    // Next we will reverse each row such that the matrix gets rotated
    //TC -> O(N*N) + O(N*N/2)
    public static void rotateOptimal(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i <= n-2; i++){
            for(int j = i+1; j <= n-1 ; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int i = 0; i <= n-1; i++){
            int[] row = matrix[i];
            int left = 0, right = n-1;
            while(left <= right){
                int temp   = row[left];
                row[left]  = row[right];
                row[right] = temp;
                left++;
                right--;
            }
        }
    }
}

//input /output
/*
   [1, 2, 3]
   [4, 5, 6]
   [7, 8, 9]
*****************
   [7, 4, 1]
   [8, 5, 2]
   [9, 6, 3]
 */