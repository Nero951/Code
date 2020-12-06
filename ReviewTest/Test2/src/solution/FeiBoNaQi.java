package solution;

import java.util.Scanner;

public class FeiBoNaQi {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            int n = scan.nextInt();
            System.out.println(CountFeiBo(n));
        }
    }

    private static int CountFeiBo(int n) {
        int a = 0;
        int b = 1;
        int c = 1;
        int leftStep = 0,rightStep = 0;
        while(n!=0){
            a = b;
            b = c;
            c = a+b;
            if(c<n){
                leftStep = n-c;
            }else{
                rightStep = c-n;
                break;
            }
        }
        if(leftStep < rightStep){
            return leftStep;
        }else{
            return rightStep;
        }
    }
}