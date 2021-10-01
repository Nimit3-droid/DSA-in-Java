package Heap;
import java.util.*;
public class MedianofStream {
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
    static PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    public static void addInteger(int val){
        int n=maxHeap.size();
        int m=minHeap.size();
        if(n==0){
            maxHeap.add(val);
        }else if(n==m){
            if(maxHeap.peek()<=minHeap.peek() && minHeap.peek()<=val){
                maxHeap.add(minHeap.poll());
                minHeap.add(val);
            }else if(minHeap.peek()<maxHeap.peek()){
                int max = minHeap.poll();
                int min = maxHeap.poll();
                minHeap.add(min);
                maxHeap.add(max);
                maxHeap.add(val);
            }else{
                maxHeap.add(val);
            }
        }else{
            if(maxHeap.peek()<=val){
                minHeap.add(val);
            }else if(val<=maxHeap.peek()){
                minHeap.add(maxHeap.poll());
                maxHeap.add(val);
            }else{
                int max = minHeap.poll();
                int min = maxHeap.poll();
                minHeap.add(min);
                maxHeap.add(max);
                minHeap.add(val);
            }
        }
    }
    static float findMedian(){
        if(minHeap.size() == maxHeap.size()){
            return (minHeap.peek()+ maxHeap.peek())/2;
        }
        return maxHeap.peek();
    }
    public static void main(String[] args){
        int A[] = {5, 15, 1, 3, 2, 8, 7, 9, 10, 6, 11, 4};
        for(int i = 0; i < A.length; i++) {
            addInteger(A[i]);
            System.out.print(findMedian()+" ");
        }
    }
    
}
