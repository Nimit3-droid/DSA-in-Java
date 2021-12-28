package LinkedList;
import java.util.*;


class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class ReverseInSize
{
    static Node head;
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node tail = head;
            for(int i = 1; i < n; i++)
            {
                int a = sc.nextInt();
                tail.next = new Node(a);
                tail =tail.next;
            }
            
            int k = sc.nextInt();
            Solution ob = new Solution();
            Node res = ob.reverse(head, k);
            printList(res);
            System.out.println();
        }
    }
    
    public static void printList(Node node)
    {
        while(node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
    
}


class Solution
{
    public Node reverse(Node node, int k)
    {
        if(node==null || node.next==null )return node;
        Node pre=null;
        Node curr=node;
        Node next=null;
        int count=0;
        while(count <k && curr!=null ){
            next=curr.next;
            curr.next=pre;
            count++;
            pre=curr;
            curr=next;
            
        }
        
        node.next=reverse(curr,k);
        
        return pre;
                
    }
}
