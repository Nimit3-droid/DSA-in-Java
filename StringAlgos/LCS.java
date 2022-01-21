import java.util.*;
public class LCS {
    public static int recursion(String s1,String s2,int n1,int n2) {
        if(n1 <0 || n2 <0){
            return 0;
        }
        if(s1.charAt(n1)==(s2.charAt(n2))){
            return 1+ recursion(s1,s2,n1-1,n2-1);
        }else{
            return Math.max(recursion(s1,s2,n1-1,n2),recursion(s1,s2,n1,n2-1));
        }
    }
    public static int usingDp(String s1, String s2, int n1, int n2) {
        int dp[][]=new int[n1+1][n2+1];
        for(int i=0;i<=n1;i++){
            for(int j=0;j<=n2;j++){
                // to find LRS ->longest repeating subsequence 
                if(i==0 || j==0){ //add i!=j here
                    dp[i][j]=0;
                }
                else if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[n1][n2];
    }
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        String s1=sc.next();
        String s2=sc.next();
        int maxLen=recursion(s1,s2,s1.length()-1,s2.length()-1);
        System.out.println(maxLen);
        maxLen=usingDp(s1,s2,s1.length(),s2.length());
        System.out.println(maxLen);
        sc.close();
    }
    
}
