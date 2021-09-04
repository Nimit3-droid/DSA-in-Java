import java.util.*;
public class DetectCycleUndiGphDegree {
    public void detectCycle(ArrayList<ArrayList<Integer>> adj,int n){
        HashMap<Integer, Integer> degreeCount=new HashMap<Integer, Integer>();
        for(int i=0;i<n;i++){
            degreeCount.put(i,adj.get(i).size());
        }
        boolean visited[] = new boolean[n];
        Queue<Integer> queue = new LinkedList<Integer>();
        while(true) {

            for(int i=0;i<n;i++){
                if(degreeCount.get(i)==1 && !visited[i]){
                    queue.add(i);
                }
            }
            if(queue.isEmpty()) break;
            
            while(!queue.isEmpty()){
                int curr=queue.poll();
                visited[curr] = true;
                ArrayList<Integer> list=adj.get(curr);
                for(int x : list) {
                    
                    degreeCount.replace(x, degreeCount.get(x)==1?1:degreeCount.get(x)-1);
                    
                }
            }
        }

        for(int i=0;i<n;i++){
            if(!visited[i]){
                System.out.print(i + " ");
            }
        }
    }
}
    