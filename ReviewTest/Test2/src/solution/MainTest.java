package solution;

import java.util.Arrays;
import java.util.Scanner;

public class MainTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            int[] arr = new int[2];
            for (int i = 0; i<arr.length; i++) {
                arr[i] = scan.nextInt();
            }
//            Solution solution = new Solution();
            EXChange e = new EXChange();
            System.out.println(Arrays.toString(e.exchangeAB(arr)));
//            System.out.println(Arrays.toString(solution.multiply(arr)));
        }
    }
}
