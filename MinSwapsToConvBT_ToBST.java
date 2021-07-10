import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
class Pair<E,T>{
    E x;
    T y;
    Pair(E x,T y){
        this.x=x;
        this.y=y;
    }
}
public class MinSwapsToConvBT_ToBST {
    public static int minSwapToSortArray(int arr[]){
        int n=arr.length;

        ArrayList<Pair<Integer, Integer>> map=new ArrayList<>();
        for(int i=0;i<n;i++){
            map.add(new Pair(arr[i],i));
        }
        map.sort( new Comparator<Pair<Integer, Integer>>(){
            @Override
            public int compare(Pair<Integer,Integer> p1,Pair<Integer,Integer> p2){
                if(p1.x<p2.x){
                    return -1;
                } else if(p1.x==p2.x)  {
                    return 0;
                }else{
                    return 1;
                }
            }
            
        });
        boolean isVisited[]=new boolean[n];
        int ans=0;
        for(int i=0;i<n;i++){
            if(isVisited[i]||i==map.get(i).y) continue;
            int j=i;
            int cycle=0;
            while(!isVisited[j]){
                cycle++;
                isVisited[j]=true;
                j=map.get(j).y;
            }
            if(cycle>0){
                ans+=cycle-1;
            }
        }

        return ans;
    }

    

    public static void main(String args[]) {
        Scanner sc =new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(minSwapToSortArray(arr));
    }
}