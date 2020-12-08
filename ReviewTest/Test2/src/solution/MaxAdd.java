package solution;

import java.util.Scanner;

public class MaxAdd {
    public static void main(String[] argv) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            String max = scan.next();
            String addMax = scan.next();
            System.out.println(maxAdd(max, addMax));
        }
    }
    private static String maxAdd(String max, String addMax) {
        StringBuilder sb = new StringBuilder();
        int len1 = max.length();
        int len2 = addMax.length();
        int num1;
        int num2;
        int res;
        int last = 0;
        for(int i = len1-1 ,j = len2-1; i>0||j>0; i--,j--){
            if(i>0){
                num1 = max.charAt(i)-'0';
            }else{
                num1 = 0;
            }
            if(j>0){
                num2 = addMax.charAt(j)-'0';
            }else{
                num2 = 0;
            }
            res = num1+num2+last;
            if(res>=10){
                last = 1;
                res -= 10;
            }
            sb.append(res);
            res = 0;
        }
        if(last!=0){
            sb.append(last);
        }
        return sb.reverse().toString();
    }

}
