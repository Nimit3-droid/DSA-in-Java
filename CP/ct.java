package CP;
import java.util.*;
import java.io.*;

public class ct {
    static long primeMod=999999999999989L;
    static class pair {
        int x, y, p;
        pair(int x, int y, int p) {
            this.x = x;
            this.y = y;
            this.p = p;
        }
    }

   

    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int arr[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        int p=sc.nextInt();
        int q=sc.nextInt();
        sc.close();
        Queue<pair> que=new LinkedList<>();
        que.add(new pair(0,p,arr[0][p]));
        que.add(new pair(n-1,q,arr[n-1][q]));
        int ans =0;
        while(!que.isEmpty()){
            pair pair=que.remove();
            int r=pair.x;
            int c=pair.y;
            int val=pair.p;
            ans=Math.max(ans,val);
            int dir[][]={{1,-1},{1,0},{1,1}};
            for(int i=0;i<3;i++){
                int nr=r+dir[i][0];
                int nc=c+dir[i][1];
                if(nr>=0 && nr<n && nc>=0 && nc<m){
                    que.add(new pair(nr,nc,arr[nr][nc]+val));
                }
            }
        }
        que.clear();
        que.add(new pair(n-1,q,arr[n-1][q]));
        while(!que.isEmpty()){
            pair pair=que.remove();
            int r=pair.x;
            int c=pair.y;
            int val=pair.p;
            ans=Math.max(ans,val);
            int dir[][]={{-1,-1},{-1,0},{-1,1}};
            for(int i=0;i<3;i++){
                int nr=r+dir[i][0];
                int nc=c+dir[i][1];
                if(nr>=0 && nr<n && nc>=0 && nc<m){
                    que.add(new pair(nr,nc,arr[nr][nc]+val));
                }
            }
        }
        System.out.println(ans);
    }
}


