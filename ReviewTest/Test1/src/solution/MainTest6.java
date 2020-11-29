package solution;

import java.util.Scanner;

public class MainTest6 {
    static int[] arr = new int[10];
    public static void main(String[] args) {
        int[] num = {1, 2, 4, 4,4,6,6,6,6,6,6,6,6,6,6,6, 4, 2, 6, 8, 2, 7, 7};
        Scanner scan = new Scanner(System.in);
        //int[] arr = new int[100];
            for (int i = 0; i<arr.length ; i++) {
                arr[i] = scan.nextInt();
            }
        System.out.println(moreThanHaft(num));
    }
    public static int moreThanHaft(int[] num) {
        int result = -1;
        int times = 0;
        for (int i = 0; i < num.length; i++) {
            if (times == 0) {
                result = num[i];
                times++;
            } else {
                if (num[i] == result) {
                    times++;
                } else {
                    times--;
                }
            }
        }
        return result;
    }
}