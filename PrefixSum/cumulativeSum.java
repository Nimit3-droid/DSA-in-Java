package PrefixSum;

import java.util.Scanner;

public class cumulativeSum{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[]=new int[n];
        int ps[]=new int[n+1];
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }
        ps[0]=0;
        for(int i=1; i<=n; i++){
            ps[i]=ps[i-1]+arr[i-1];
        }

        int q=sc.nextInt();
        while(q--!=0){
            int a=sc.nextInt();
            int b=sc.nextInt();
            System.out.println(ps[b+1]-ps[a]);
        }
        sc.close();
    }
}