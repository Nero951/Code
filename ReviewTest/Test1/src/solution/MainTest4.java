package solution;

import java.util.Scanner;

public class MainTest4 {
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] volumn = new int[n];
            for (int i = 0; i < n; i++)
                volumn[i] = scanner.nextInt();
            int[] dp = new int[41];
            dp[0] = 1;
            for (int i = 0; i < n; i++) {
                for (int j = 40; j >= volumn[i]; j--) {
                    dp[j] += dp[j - volumn[i]];
                }
            }
            System.out.println(dp[40]);
        }
        scanner.close();
    }

    static int n;
    static int[] arr;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            n = scan.nextInt();
            arr = new int[n];
            for (int i = 0; i<n ; i++) {
                arr[i] = scan.nextInt();
            }
            System.out.println(page(n - 1, 40));
        }
    }

    static int page(int i, int PageNumber) {
        if(PageNumber == 0){
            return 1;
        }
        if(PageNumber < 0){
            return 0;
        }
        if(i == 0){
            return arr[0] == PageNumber ? 1 : 0;
        }
        return page(i-1,PageNumber)+page(i-1,PageNumber-arr[i]);
    }

}
