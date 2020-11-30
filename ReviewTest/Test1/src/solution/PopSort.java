package solution;

import java.util.Scanner;

public class PopSort {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] arr = {2,3,5,1,7,9,6};
        popSort(arr);
    }

    private static int[] popSort(int[] arr) {
        boolean flag = true;
        for (int i = 0; i<arr.length ; i++) {
            for(int j = 0; j<arr.length-i; j++){
                if (arr[j] < arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = false;
                }
            }

        }
    }

}
