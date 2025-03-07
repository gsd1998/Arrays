package interviewQA;

import java.util.ArrayList;

public class UnionOfTwoSortedArrays {

    public static void main(String[] args) {

        int[] a = {1, 2, 3, 4, 5};
        int[] b = {1, 2, 3, 6, 7};
        ArrayList<Integer> list = findUnion(a,b);
        System.out.println(list);
    }

    public static ArrayList<Integer> findUnion(int a[], int b[]) {

        ArrayList<Integer> list = new  ArrayList<>();

        int i = 0;
        int j = 0;
        int n1 = a.length;
        int n2 = b.length;

        while(i< n1 && j < n2) {
            if(a[i]<=b[j]){
                if(list.size() == 0 || list.get(list.size()-1) != a[i] ){
                    list.add(a[i]);
                }
                i++;
            }else{
                if(list.size() == 0 || list.get(list.size()-1) != b[j] ){
                    list.add(b[j]);
                }
                j++;
            }
        }
        while(i < n1){
            if(list.get(list.size()-1) != a[i]){
                list.add(a[i]);
            }
            i++;
        }
        while(j < n2){
            if(list.get(list.size()-1) != b[j]){
                list.add(b[j]);
            }
            j++;
        }

        return list;
    }
}
