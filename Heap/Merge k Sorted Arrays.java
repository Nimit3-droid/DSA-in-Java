package Heap;
import java.util.*;

class MergeNode {
    int value;
    int r,c;
    MergeNode(int value, int r, int c){
        this.value = value;
        this.r = r;
        this.c = c;
    }
}


class Merge_k_Sorted_Arrays {
    public static void merge(int arr[][],int n, int ans[]){
        PriorityQueue<MergeNode> q=new PriorityQueue<>(new Comparator<MergeNode>(){
            @Override
            public int compare(MergeNode m1,MergeNode m2){
                return m1.value - m2.value;
            }
        });
        for(int i=0;i<arr.length;i++){
            q.add(new MergeNode(arr[i][0],i,1));
        }
        int m=ans.length;
        int index=0;
        while(index<m){
            MergeNode curr=q.peek();
            q.remove();
            ans[index++]=curr.value;
            if(curr.c>=arr[curr.r].length){
                continue;
            }else{
                q.add(new MergeNode(arr[curr.r][curr.c],curr.r,curr.c+1));
            }
        }
        
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        //jagged array input
        int arr[][]=new int[n][];
        int size=0;
        for(int i=0;i<n;i++){
            int m=sc.nextInt();
            size+=m;
            arr[i]=new int[m];
            for(int j=0;j<m;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        int ans[]=new int[size];
        merge(arr,n,ans);

        for(int i=0;i<size;i++){
            System.out.print(ans[i]+" ");
        }




    }
}
