import java.util.*;
public class stock2Diff{
    public static int max1Diff(int arr[],int s,int e){
        
        int maxdiff=0;
        int currsum=0;
        for(int i=s; i<e; i++ ){
            int currdiff=arr[i+1]-arr[i];
            if(currsum>0){
                currsum+=currdiff;
            }else{
                currsum=currdiff;
            }
            if(currsum>maxdiff){
                maxdiff=currsum;
            }

        }
        return maxdiff;
    }
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++) {
            arr[i]=sc.nextInt();
        }

        // int maxans=0;
        // for(int i=1;i<n-2;i++) {
        //     maxans=Math.max(maxans,max1Diff(arr,0,i) + max1Diff(arr,i+1,n-1));
        // }
        // System.out.println(maxans);

        //another method to calculate
        int profit[]=new int[n];
        int maxprice=arr[n-1];
        for(int i=n-2;i>=0;i--){
            if(arr[i]>maxprice){
                maxprice=arr[i];
            }
            profit[i]=Math.max(profit[i+1],maxprice-arr[i]);
        }
        int minprice=arr[0];
        for(int i=1;i<n;i++){
            if(arr[i]<minprice){
                minprice=arr[i];
            }
            profit[i]=Math.max(profit[i-1],profit[i]+arr[i]-minprice);
        }
        
        System.out.println(profit[n-1]);
    }
}