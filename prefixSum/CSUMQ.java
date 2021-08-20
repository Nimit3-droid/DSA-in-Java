package PrefixSum;

import java.util.Scanner;

public class CSUMQ {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        int ps[]=new int[n];
        arr[0] =sc.nextInt();
        ps[0]=arr[0];
        for(int i=1;i<n;i++){
            arr[i]=sc.nextInt();
            ps[i]=ps[i-1]+arr[i];
        }
        int q=sc.nextInt();
        while(q!=0){
            int a=sc.nextInt(), b=sc.nextInt();
            if(a==0)System.out.println(ps[b]);
            else
                System.out.println(ps[b]-ps[a-1]);

            q--;
        }
        
    }
}
