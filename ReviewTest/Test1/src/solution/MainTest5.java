package solution;

import java.util.Scanner;

public class MainTest5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            int a = scan.nextInt();
            int b = scan.nextInt();
            int c = scan.nextInt();
            int d = scan.nextInt();
            if((a+b) != (c-d)){
                System.out.println("No");
                return;
            }else{
                float A = (a+c)/2f;
                float B = (b+d)/2f;
                float C = (d-b)/2f;
                System.out.println(A +" "+B+" "+ C);
            }
        }
    }
}
