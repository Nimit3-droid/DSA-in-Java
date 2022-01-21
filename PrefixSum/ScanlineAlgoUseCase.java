package PrefixSum;

import java.util.Scanner;

public class ScanlineAlgoUseCase{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int arr1[]=new int[n+2];
        int arr2[]=new int[n+2];
        while (q--!=0){
            int l=sc.nextInt();
            int r=sc.nextInt();
            arr1[l]++;
            arr1[r+1]--;
            arr2[r+1]-=(r-l+1);
        }
        for(int i=1;i<=n;i++){
            arr1[i]+=arr1[i-1];
            arr2[i]+=arr2[i-1]+arr1[i];
        }
        int m=sc.nextInt();
        while(m--!=0){
            int m1=sc.nextInt();
            System.out.println(arr2[m1]);
        }
        sc.close();

    }
}