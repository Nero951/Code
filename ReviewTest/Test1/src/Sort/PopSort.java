package Sort;

public class PopSort {
    public void popSort(int[] arr){
        boolean flag = true;
        for (int i = 0; i<arr.length-1 ; i++) {
            for(int j = i; j<arr.length-i-1; j++){
                if (arr[j] > arr[j+1]){
                   int temp = arr[j];
                   arr[j] = arr[j+1];
                   arr[j+1] = temp;
                   flag = false;
                }
            }
            if(flag){
                break;
            }
        }
    }
}
