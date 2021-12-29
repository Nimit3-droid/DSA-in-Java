import java.util.*;
public class Dijkestra{
    public static int findMin(int spt[],boolean found[]){
        int n=spt.length;
        int minIndex=-1;
        int minValue=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(!found[i]){
                if(spt[i]<=minValue){
                    minValue=spt[i];
                    minIndex=i;
                }
            }
        }
        return minIndex;
    }
    public static int [] shortestPath(int mat[][],int root){
        int n=mat.length;
        int spt[]=new int[n];
        Arrays.fill(spt,Integer.MAX_VALUE);
        boolean found[]=new boolean[n];
        spt[root]=0;//initilize shortest distance from root node
        for(int i=0;i<n-1;i++){
            int u=findMin(spt,found);
            found[u]=true;
            for(int j=0;j<n;j++){
                if(found[j]==false && mat[u][j]!=0&& spt[u]!=Integer.MAX_VALUE && mat[u][j]+spt[u]<spt[j]){
                    spt[j]=mat[u][j]+spt[u];
                }
            }

        }
        return spt;
    }
    public static void main(String[] args){
        int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                                      { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                                      { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                                      { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                                      { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                                      { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                                      { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                                      { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                                      { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
                                      
        int arr[]=shortestPath(graph,8);
        for(int i=0;i<arr.length; i++){
            System.out.println(i+" "+arr[i]+" ");
        }
    }
}