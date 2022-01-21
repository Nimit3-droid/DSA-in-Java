package Heap;
import java.util.*;
class Heap{


        static int arr[]=new int[1000000];
        static int size=0;

        static void heapify(int indx){
            int n=size;
            int largest = indx;
            int left=2*indx+1, right=2*indx +2;
            if(left<n && arr[largest]<arr[left]){
                largest = left;
            }

            if(right<n && arr[largest]<arr[right]){
                largest = right;
            }

            if(largest!=indx){
                int temp=arr[largest];
                arr[largest]=arr[indx];
                arr[indx]=temp;
                heapify(largest);
            }
        }

        static  void upheapify(int index){
            int parent = (index-1)/2;
            // System.out.println("index " + index + " is " + parent);
            if(arr[parent]>0){
                if(arr[parent] < arr[index]){
                    int temp=arr[parent];
                    arr[parent]=arr[index];
                    arr[index]=temp;
                    upheapify(parent);
                }
            }


        }

        static void insert(int ele){
            arr[size]=ele;
            size++;
            upheapify(size-1);
        }

        static int delRoot(){
            int deleted=arr[0];
            arr[0]=arr[size-1];
            size--;
            heapify(0);
            return deleted;
        }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt(), k=sc.nextInt();
        int arri[]=new int[n];
        for(int i=0;i<n;i++){
            arri[i]=sc.nextInt();
        }
        // int ans[]=new int[n-k+1];
        sc.close();
        int start=0;
        while(start<n-k+1){
            for(int curr=start;curr<k+start;curr++){
                insert(arri[curr]);
            }
            System.out.print(delRoot()+ " ");
            start++;
        }
    }
}