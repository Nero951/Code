package solution;

import java.util.Scanner;

public class MainTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m, n;
        while (scan.hasNext()) {
            m = scan.nextInt();
            n = scan.nextInt();
            System.out.println(CommonMin(m, n));
        }
    }
    private static int CommonMin(int m, int n) {
        return DivisorMax(m,n)*(m/DivisorMax(m,n))*(n/DivisorMax(m,n));
    }
    private static int DivisorMax(int m, int n) {
        if(m==0 || n==0){
            return 0;
        }
        if(m>=n){
            int tmp = m;
            m = n;
            n = tmp;
        }
        while(m!=0){
            int temp = m;
            m = n%m;
            n = temp;
        }
        return n;
    }

}
