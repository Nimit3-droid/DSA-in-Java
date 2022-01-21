package Heap;
import java.util.*;

class HuffmanNode{
    char c;
    int f;
    HuffmanNode left, right;
    HuffmanNode (char c, int f){
        this.c = c;
        this.f = f;
        this.left = null;
        this.right = null;
    }
    HuffmanNode (char c, int f,HuffmanNode left,HuffmanNode right){
        this.c = c;
        this.f = f;
        this.left = left;
        this.right = right;
    }

}
public class HuffmanCoding {
    public static void print(HuffmanNode root, String s) {
        if(root == null) return ;
        if(root.left == null && root.right == null && Character.isLetter(root.c)) {
            System.out.println(root.c +" : "+s);
            return;
        } 
        print(root.left, s+"0");
        print(root.right, s+"1");
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        char chararray[]=new char[n];
        int arr[]=new int[n];
        for(int i=0; i<n; i++){
            chararray[i]=sc.next().charAt(0);
            arr[i]=sc.nextInt();
        }
        sc.close();
        PriorityQueue<HuffmanNode> pq=new PriorityQueue<>(n,new Comparator<HuffmanNode>(){
            public int compare(HuffmanNode n1,HuffmanNode n2){
                return n1.f-n2.f;
            }
        });
        for(int i=0;i<n;i++){
            pq.add(new HuffmanNode(chararray[i],arr[i]));
        }
        HuffmanNode root=null;
        while(pq.size() > 1){
            HuffmanNode a=pq.poll(),b=pq.poll();
            HuffmanNode newNode=new HuffmanNode('-',a.f+b.f,a,b);
            root = newNode;
            pq.add(newNode);
        }
        print(root,"");

    }
}
