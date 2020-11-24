public class AntiOrder {

    Node root;

    public int count(int[] A, int n) {
        // write code here
        if(n==0)
            return 0;
        root = new Node(A[0]);
        int res = 0;
        for(int i=1; i<n; i++){
            root.insert(A[i]);
            res += root.getRank(A[i]);
        }
        return res;
    }
}

class Node{
    int val;
    Node left;
    Node right;

    Node(int v){
        val = v;
    }
    int leftSize = 0;

    public void insert(int v){
        if(v>val){
            if(left!=null)
                left.insert(v);
            else{
                left = new Node(v);
            }
            leftSize += 1;
        }else{
            if(right!=null)
                right.insert(v);
            else
                right = new Node(v);
        }
    }

    public int getRank(int v){
        if(v==val)
            return leftSize;
        else if(v>val){
            return left.getRank(v);
        }
        else{
            return leftSize + 1 + right.getRank(v);
        }
    }
}