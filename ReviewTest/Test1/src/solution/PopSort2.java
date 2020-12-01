package solution;
import java.util.Arrays;
import java.util.Scanner;

public class PopSort2 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String[] string=in.nextLine().split(" ");
        int[] array=new int[string.length-1];
        for(int i=0;i<string.length-1;i++){
            array[i]=Integer.parseInt(string[i]);
        }
        Arrays.sort(array);
        for(int i=0;i<Integer.parseInt(string[string.length-1]);i++){
            System.out.print(array[i]);
            if(i!=Integer.parseInt(string[string.length-1])-1){
                System.out.print(" ");
            }
        }
    }
}
