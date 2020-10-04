class Node{
    int data;
    Node next = null;

    public Node(int data) {
        this.data = data;
    }
}
public class MyLinkedList {
    public Node head = null;
    public Node ReverseList(Node head){
        if(head == null){
            return null;
        }
        Node cur = this.head;
        Node cur1 = null;
        Node tmp = cur.next;
        while(cur != null){
            cur.next = cur1;
            cur1 = cur;
            cur = tmp;
            if(tmp != null){
                tmp = tmp.next;
            }
        }
        return cur1;
    }
    public void disPlay(Node cur){
        //Node cur = this.head;
        while(cur != null){
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }
    public void addLast(int data){
        Node node = new Node(data);

        if(this.head==null){
            this.head=node;
            return;
        }Node cur = this.head;
        while(cur.next != null){
            cur = cur.next;
        }
        cur.next = node;
    }

}

