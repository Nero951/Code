import sun.reflect.generics.tree.Tree;

import javax.swing.tree.TreeNode;

class MyTreeNode{
    int value;
    MyTreeNode left;
    MyTreeNode right;

    public MyTreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}
public class MyBinaryTree {
    public Boolean isEmpty(MyTreeNode root){
        if(root == null){
            return true;
        }
        return false;
    }
     public void presort(MyTreeNode root){
         if(!isEmpty(root)){
             
         }
     }
}
