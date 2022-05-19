package InterviewBit;
import java.util.*;

class pair{
    int x,y;
    pair(int x,int y){
        this.x=x;
        this.y=y;
    }
    pair(){

    }
}


public class Solution {
    public static int solve(int r, int c, ArrayList<String> mat) {
        r=mat.size();
        c=mat.get(0).length();
        PriorityQueue<int []> pq=new PriorityQueue<>(new Comparator<int []>(){

            public int compare(int []a,int []b){
                return a[2]-b[2];
            }
        });
        pq.offer(new int[]{0,0,0});
        int arr[][]=new int[r][c];
        for(int i=0;i<r;i++) Arrays.fill(arr[i],Integer.MAX_VALUE);
        int dx[]={0,0,1,-1};
        int dy[]={1,-1,0,0};
        arr[0][0]=0;
        int ans =0;
        String s = "RLDU";
        while(!pq.isEmpty()){
            int []curr=pq.poll();
            if(curr[0]==r-1 && curr[1]==c-1) {
                ans = arr[curr[0]][curr[1]];
                break;
            }
            char chara=mat.get(curr[0]).charAt(curr[1]);
            for(int i=0;i<4;i++){
                //bdbd
                int cost=arr[curr[0]][curr[1]];
                int place[]={curr[0]+dx[i],curr[1]+dy[i],cost};
                if(s.charAt(i)!=chara) cost++;
                if(place[0]>=0 && place[0]<r && place[1]>=0 && place[1]<c){
                    if(arr[place[0]][place[1]]>cost){

                        pq.add(new int[]{place[0],place[1],cost});
                        arr[place[0]][place[1]]=cost;

                    }
                }
            }
        }
        
        return ans;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);    
        int n = sc.nextInt();
        ArrayList<String> A = new ArrayList<>();
        for(int i = 0; i < n; i++){
            A.add(sc.next());
        }
        sc.close();
        System.out.println(solve(n,A.get(0).length(),A));
        
    }

}

   
