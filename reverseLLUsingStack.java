import java.util.*;
class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        next=null;
    }

    Node pushNode(int ele,Node Head){
        Node newNode = new Node(ele);
        newNode.next =Head;
        Head=newNode;
        return Head;
    }
}

public class reverseLLUsingStack {
    public static Node reverseInKSet(Node head,int k){
        if(head==null || head.next==null){
            return head;
        }
        Node curr=head, pre=null;
        Stack<Node> stack=new Stack<Node>();
        int count=0;
        while(curr!=null){
            count=0;
            while(count<k && curr!=null){
                stack.push(curr);
                curr=curr.next;
                count++;
            }
            while(!stack.isEmpty()){
                if(pre==null){
                    pre=stack.pop();
                    head=pre;
                }else{
                    pre.next=stack.pop();
                    pre=pre.next;

                }
            }
        }
        pre.next=null;
        return head;
    }
    public static void print(Node head) {
        Node curr=head;
        while(curr!=null){
            System.out.print(curr.data+" -> ");
            curr=curr.next;
        }
        System.out.println();
        
    }
    public static void main(String[] args)
    {
        Node head = new Node(1002);
        head=head.pushNode(12,head);
        head=head.pushNode(2,head);
        head=head.pushNode(1,head);
        head=head.pushNode(142,head);
        head=head.pushNode(212,head);
        print(head);
        int k=2;
        head=reverseInKSet(head,k);
        print(head);
    }
}
