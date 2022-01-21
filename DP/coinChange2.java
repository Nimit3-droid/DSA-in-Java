import java.util.Scanner;

class coinChange{

    
    public static int change(int amount, int[] coins) {
        int n=coins.length;
        int dp[]=new int[amount+1];
        dp[0]=1;
        for(int i=0;i<n;i++){
            for(int j=coins[i];j<=amount;j++){
                System.out.println();
                dp[j]+=(dp[j-coins[i]]);
            }
        }
        
        return dp[amount];
        
        
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int coins[]=new int[n];
        for(int i=0; i<n; i++) coins[i]=sc.nextInt();
        int amount=sc.nextInt();
        sc.close();
        System.out.println(change( amount,coins));
    }
}