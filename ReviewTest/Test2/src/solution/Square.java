package solution;

import java.util.Scanner;

public class Square {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            int n = scan.nextInt();
            char c = scan.next().charAt(0);
            square(n, c);
        }
    }

    private static void square(int n, char c) {
        int row = n/2;
        if(n%2!=0){
            row = n/2+1;
        }
        for (int i = 0; i<row ; i++) {
            for(int j = 0; j<n; j++){
                if(i==0 || j==0 || i==row-1 || j==n-1){
                    System.out.print(c);
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
