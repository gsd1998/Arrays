package interviewQA;

import java.util.ArrayList;

public class IntersectionOfTwoSortedArrays {

    public static void main(String[] args) {

        int[] a = {1,1,2,2,3,3,4,5,6};
        int[] b = {1,2,2,3,4,5,6,7};

        //[1, 2, 2, 3, 4, 5, 6]
        int n1 = a.length;
        int n2 = b.length;
        int i = 0;
        int j = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while (i < n1 && j < n2) {

            if (a[i] < b[j]) {
                i++;
            } else if (a[i] > b[j]) {
                j++;
            } else {
                list.add(a[i]);
                i++;
                j++;
            }
        }

	    /*int[] visitedArr = new int[n2];
        for(int i = 0; i < n1; i++){
            for(int j = 0; j < n2; j++){
                if(a[i] == b[j] && visitedArr[j] == 0){
                    list.add(a[i]);
                    visitedArr[j] = 1;
                    break;
                }
            }
        }*/
        System.out.println(list);
    }
}
