package PrefixSum;

import java.util.Scanner;

public class streetLight {
    static int arr[]=new int[10000001];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int p=sc.nextInt();
        while(n--!=0){
            int a=sc.nextInt();
            int b=sc.nextInt();
            arr[Math.max(0,a-b)]++;
            arr[Math.min(p+1,a+b+1)]--;
        }
        for(int i=1;i<=p;i++){
            arr[i]+=arr[i-1];
        } 
        int c=0;int max=0;
        for(int i=0;i<=p;i++){
            if(arr[i]!=1){
                c++;
            }else{
                max=Math.max(max,c);
                c=0;
            }
        }
        max=Math.max(max,c);

        System.out.println(max);
        
    }
}
