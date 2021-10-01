
import java.util.*;

class Node {
    int value;
    int index;
    int col;
    Node(int value, int index, int col){
        this.value = value;
        this.index = index;
        this.col = col;
    }
}
class Heap{
     private Node heaparr[];
     private int size = 0;
     private int n;
     Heap(int n){
         this.n = n;
        heaparr=new Node[n];
     }
     Heap(){
        n=1000000;
        heaparr=new Node[n];
     }
     void downHeapify(int i){
        int smallest = i;
        int left= 2*i +1;
        int right = 2*i +2;
        if(left<size && heaparr[left].value<heaparr[smallest].value){
            smallest=left;
        }
        if(right<size && heaparr[right].value<heaparr[smallest].value){
            smallest=right;
        }
        if(smallest!=i){
            Node tp= heaparr[smallest];
            heaparr[smallest]=heaparr[i];
            heaparr[i]=tp;
            downHeapify(smallest);
        }
    }
     void upHeapify(int i){
        int parent = (i-1)/2;
        // if(heaparr[parent].value>0){ //pata mhi isse kyu use karte the . DONT USE IT works for all nos.
            if(heaparr[parent].value>heaparr[i].value){
                Node tp= heaparr[i];
                heaparr[i]=heaparr[parent];
                heaparr[parent]=tp;
                upHeapify(parent);
            }
        // }
    }
     Node delHeap(){
         if(size>0){
             Node del=heaparr[0];
             heaparr[0]=heaparr[size-1];
             size--;
             downHeapify(0);
             return del;
         }
         return null;
    }
     void addToHeap(Node ele){
         if(size<n){
             heaparr[size++]=ele;
             upHeapify(size-1);
         }
    }
    Node getValue(){
        if(size>0){
            Node value=heaparr[0];
            return value;
        }
        return null;
   }
}
public class MergeKSortedArr {
    public static void mergeK(int arr[][],int m,int n){
        Heap hp=new Heap(m);
        for(int i=0;i<m;i++){
            hp.addToHeap(new Node(arr[i][0],i,1));
        }
        Node top=hp.getValue();
        while(top!=null && top.value<Integer.MAX_VALUE){
            Node a=hp.delHeap();
            System.out.println(a==null ? "null" : a.value);
            if(a.col<n){
                hp.addToHeap(new Node(arr[a.index][a.col],a.index,a.col + 1));
            }else if(a.col==n){
                hp.addToHeap(new Node(Integer.MAX_VALUE,a.index,a.col + 1));
            }
            top=hp.getValue();
        }
    }
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        int m= sc.nextInt();
        int n=sc.nextInt();
        int mat[][]=new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                mat[i][j]=sc.nextInt();
            }
        }
        mergeK(mat,m,n);
        

    }

    
}
