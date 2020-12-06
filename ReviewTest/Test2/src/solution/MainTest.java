package solution;

import java.util.Arrays;
import java.util.Scanner;

public class MainTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            int[] arr = new int[scan.nextInt()];
            for (int i = 0; i<arr.length; i++) {
                arr[i] = scan.nextInt();
            }
            Solution solution = new Solution();
            System.out.println(Arrays.toString(solution.multiply(arr)));
        }
    }
}
