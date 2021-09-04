import java.util.*;
public class LongestPrefixWhichIsAlsoSuffix {
    //namive approach n^2
    public static int LCS(String s) {
        int n=s.length();
        int j=(n+1)/2;
        int i=0;
        while(j<n){
            if(s.charAt(i)==s.charAt(j)){
                i++;j++;
            }else{
                j=(j-i+1);
                i=0;
            }
        }

        return i;
    }

    // o(N)
    public static int LCS_DP(String s){
        int n=s.length();
        int dp[]=new int[n];
        dp[0]=0;
        int j=1;
        int i=0;//length
        while(j<n){
            if(s.charAt(i)==s.charAt(j)){
                i++;
                dp[j]=i;
                j++;
            }else{
                // This is tricky. Consider the example.
                // AAACAAAA and i = 7. The idea is similar
                // to search step. 0 1 2 
                if(i==0){
                    dp[j]=i;
                    j++;
                }else{
                    i=dp[i-1];
                }
            }
        }
        for(i=0; i<dp.length; i++){
            System.out.print(dp[i]+ " ");
        }

        return dp[n-1];
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        System.out.println(LCS(str));
        System.out.println(LCS_DP(str));
    }
    
}
