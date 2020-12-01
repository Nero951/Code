package solution;

import java.util.*;

public class PopSort {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            String str = scan.nextLine();
            String[] s = str.split(" ");
            int[] array = new int[s.length-1];
            for (int i = 0; i < array.length; i++) {
                array[i] = Integer.parseInt(s[i]);
            }
            int k = scan.nextInt();
            ArrayList<Integer> arrayList = popSortKth(array ,k);
            System.out.println(arrayList);
        }
    }


    private static ArrayList<Integer> popSortKth(int[] arr, int k) {
        boolean flag = true;
        ArrayList<Integer> arrayList = new ArrayList<>();
        if(k>arr.length){
            return arrayList;
        }
        for (int i = 0; i<k ; i++) {
            for(int j = 0; j<arr.length-i-1 ; j++){
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = false;
                }
            }
            arrayList.add(arr[i]);
            if(flag){
                break;
            }
        }
        return arrayList;
    }

}
