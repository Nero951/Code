package solution;

import java.util.Scanner;

public class MainTest2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            int n = scan.nextInt();
            System.out.println(count(n));
        }
    }

    private static int count(int n) {
        if(n%2 != 0 || n<6 || n==10){
            return -1;
        }
        if(n%8 == 0){
            return n/8;
        }else{
            return n/8+1;
        }
    }
}
