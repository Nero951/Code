import java.util.Arrays;

/**
 * created by Intellij IDEA
 * Description:A java program
 * User:Wade Winston Wilson
 * Project:IntelliJ IDEA
 * Year:2020
 * Time:16:20
 */
public class MyArrayList {
    public int[] elem;
    public int usedSize;
    public static final int intCapacity = 10;

    public MyArrrayList() {
        this.elem = new int[intCapacity];
        this.usedSize = 0;
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