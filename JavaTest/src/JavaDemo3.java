/**
 * created by Intellij IDEA
 * Description:A java program
 * User:Wade Winston Wilson
 * Project:IntelliJ IDEA
 * Year:2020
 * Time:8:48
 */
import java.util.*;
public class JavaDemo3 {
    public static void main(String[] args) {
        MyArrrayList myArrrayList1=new MyArrrayList();
        for(int i=0;i<10;i++){
            myArrrayList1.add(i,i);
        }
        myArrrayList1.display();
        myArrrayList1.add(10,113);
        myArrrayList1.display();
    }
    public class MyArrrayList{
        public int[] elem;
        public int usedSize;
        public static final int intCapacity=10;
        public MyArrrayList(){
            this.elem=new int[intCapacity];
            this.usedSize=0;
        }
        private boolean isFull(){
            if(this.usedSize==this.elem.length){
                return true;
            }return false;
        }
        public void display(){

            for(int i=0;i<this.usedSize;i++){
                System.out.println(this.elem[i]);
            }
        }
        public void add(int pos,int data){
            int p=usedSize-1;
            if(isFull()){
                this.elem=
                        Arrays.copyOf(this.elem,2*this.elem.length);
            }
            if(pos<=usedSize && pos>=0){
                while(p>pos){
                    this.elem[p+1]=this.elem[p];
                    p--;
                }
                this.elem[pos]=data;
                this.usedSize++;
            }
        }
    }
    public class Student{
        String name;
        int age;
        String number;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }
    }
    public static void main5(String[] args) {

    }
    public static boolean My_sort(int[] array) {
        for(int i=1;i<array.length;i++){
            if(array[i]<=array[i-1]){
                return false;
            }
        }   return true;
    }
    public static void main4(String[] args) {
        int[] array={1,4,3,6,5,9,2};
        boolean a=My_sort(array);
        System.out.println(a);
    }
    public static int binarySearch(int[] array,int n){
        int left=0;
        int right=array.length-1;
        int mid=(left+right)/2;
        while(array[left]<array[right]){
            if(n>array[mid]){
                left=mid+1;
                return mid;
            }else if(n==array[mid]){
                return mid;
            }else{
                right=mid-1;
                return mid;
            }
        }return -(1);
}
   public static void main3(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        int[] array={1,2,4,3,5,6,7,8,10,11};
        int a=binarySearch(array,n);
        System.out.println(a);
    }
    public static int Max(int[] array) {
        int max=array[0];
        for(int i=1;i<array.length;i++){
            if(array[i]>max)
                max=array[i];
        }return max;
    }
    public static void main2(String[] args) {
        int[] array={1,2,3,4,5,6,7,8,0,-9};
        Max(array);
        System.out.println(Max(array));
    }
    public static int[] My_Copy(int[] array) {
        int[] ary=new int[array.length];
        for(int i=0;i<array.length;i++){
            ary[i]=array[i];
        }return ary;
    }
    public static void main1(String[] args) {
        int[] array={1,2,3,4,5,6,7,8,9};
        int[] ret=My_Copy(array);
        System.out.println(Arrays.toString(ret));
    }
}
