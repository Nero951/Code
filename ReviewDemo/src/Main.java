import javafx.scene.transform.Scale;

import java.util.HashMap;
import java.util.Scanner;

/**
 * created by Intellij IDEA
 * Description:Mian
 * User:Wade Winston Wilson
 * Year:2020
 * Time:23:51
 */
public class Main {
    public static void main1(String[] args) {
        int[] array = {3,4,1,2,6,2,3,5,7};
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println(TwoSum(array, n));
    }

    private static int TwoSum(int[] array, int n) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            int another = n - array[i];
            if(map.containsKey(another)){
                return map.get(another);
            }
            return i;
        }
        return 0;
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        list.disPlay(list.head);
        //list.ReverseList(list.head);
        list.disPlay(list.ReverseList(list.head));

    }
}
