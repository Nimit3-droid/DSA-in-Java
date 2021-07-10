package PrefixSum;

import java.util.Scanner;

public class bulletPrbm {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t--!=0){
            int n=sc.nextInt();
            int arr[]=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();

            }
            long sum=0;
            for(int i=0;i<n;i++){
                if(arr[i]==-1 && sum!=0){
                    arr[i]=(int)Math.ceil((sum)/(i));
                    sum+=arr[i];
                }else if(arr[i]!=-1){
                    sum+=arr[i];
                }
            }
            for(int i=0;i<n;i++){
                System.out.print(arr[i]+" ");
                
            }
            System.out.println();
        }
    }
}
