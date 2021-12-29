package Heap;
import java.util.*;

class MyComparator implements Comparator<Integer>{
    public int compare(Integer a, Integer b) {
        return a.compareTo(b);
    }
}
public class pq {
    public static void main(String args[]){
        // PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>(){
        //     @override 
        //     public int compare (Integer a,Integer b){
        //         return a-b;
        //     }
        // });
        // PriorityQueue<Integer> queue = new PriorityQueue<>(new MyComparator());
        //maxHeap
        PriorityQueue<Integer> queue =new PriorityQueue<>(Collections.reverseOrder());
        queue.add(82);
        queue.add(10);
        System.out.println(queue.poll()+" "+queue.poll());
    }
    
}
