package solution;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        int count = 0;
        for (int i = 0; i < str1.length(); i++){
            StringBuilder s = new StringBuilder(str1);
            s.insert(i,str2);
            if (IsPail(s.toString())){
                count++;
            }
        }
        System.out.println(count);
    }
    public static boolean IsPail(String str){
            int m = 0;
            int n = str.length()-1;
            while(m < n){
                if(str.charAt(m) != str.charAt(m)){
                   return false;
                }
                m++;
                n--;
            }
        return true;
    }

}
