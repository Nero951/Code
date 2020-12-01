package solution;

import java.util.ArrayList;
import java.util.Scanner;

public class DeleteNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            int n =scan.nextInt();
            if (n>=1000){
                n = 999;
            }
            ArrayList<Integer>  arrayList= new ArrayList<>();
            for (int i = 0; i<n ; i++) {
                arrayList.add(i);
            }
            int i = 0;
            while(arrayList.size()>1){
                i = (i+2)%arrayList.size();
                arrayList.remove(i);
            }
            System.out.println(arrayList.get(0));
        }
    }
}
