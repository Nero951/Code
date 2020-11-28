import java.util.Scanner;

public class MainTest3 {
    public static void main1(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            String str1 = scan.nextLine();
            String str2 = scan.nextLine();
            String pattern = "[" + str2 + "]";
            String result = str1.replaceAll(pattern, "");
            System.out.println(result);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            String str1 = scan.nextLine();
            String str2 = scan.nextLine();
            for (int i = 0; i<str2.length() ; i++) {
                str1 = str1.replace(str2.substring(i,i+1),"");
            }
            System.out.println(str1);
        }
    }
}
