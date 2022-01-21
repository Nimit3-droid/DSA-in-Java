import java.util.*;
public class UnboundedKnapscak {
    //O(Wn)
    //wt[] mai jo bhi hai usse tum infinite bar use kar sate ho
    //lekin standard knapsack mai shirf ek bar use kar sakte hai
    public static int unboundedKnapsack(int W,int n, int[] val, int[] wt){
        int dp[]=new int[W+1];
        for(int i=0;i<=W;i++){
            for(int j=0;j<n;j++){
                if(i>=wt[j]){
                    dp[i]=Math.max(dp[i],dp[i-wt[j]]+val[j]);
                }
            }
        }
        return dp[W];
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int w=sc.nextInt();
        int val[]=new int[n];
        int wt[]=new int[n];
        for(int i=0;i<n;i++){
            val[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            wt[i]=sc.nextInt();
        }
        sc.close();
        System.out.println(unboundedKnapsack(w, n, val, wt));
    }
}
