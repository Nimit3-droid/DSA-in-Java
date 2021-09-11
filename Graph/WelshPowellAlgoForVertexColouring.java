import java.util.*;
public class WelshPowellAlgoForVertexColouring {
    public HashMap<Integer,Integer> color(ArrayList<ArrayList<Integer>> adj,int v){
        Integer arr[][]=new Integer[v][2];
        for(int i=0;i<v;i++){
            arr[i][0]=adj.get(i).size();
            arr[i][1]=i;
        }
        Arrays.sort(arr,(a,b)->b[0]-a[0]);

        int color=1;
        HashMap<Integer,Integer> coloured=new HashMap<Integer,Integer>();
        int curr=0;
        int src=arr[curr][1];
        while(coloured.size()!=v){
            if(!coloured.containsKey(src)) {
                coloured.put(src,color);
                for(int i=0;i<v;i++){
                    if(i==src) continue;
                    if(!coloured.containsKey(i)&&!adj.get(i).contains(src)){
                        coloured.put(i,color);
                    }
                }
            }
            color++;
            curr++;
            if(coloured.size()==v) break;
            src=arr[curr][1];
        }
        
        return coloured;
    }
   
}
