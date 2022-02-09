import java.util.*;
public class MaxDIff {
    public static void main(String args[]){
        Scanner sc =new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++) {
            arr[i]=sc.nextInt();
        }
        
        // int minSoFar=arr[0];
        // int maxdiff=0;
        // for(int i=0; i<n; i++) {
        //     int diff=arr[i]-minSoFar;
        //     if(diff>maxdiff) {
        //         maxdiff=diff;
        //     }
        //     if(minSoFar>arr[i]) 
        //         minSoFar=arr[i];
        // }
        // System.out.println(maxdiff);

        //Another method
        int maxdiff=0;
        int currsum=0;
        for(int i=0; i<arr.length-1; i++ ){
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
        System.out.println(maxdiff);
        sc.close();
    }
    
}
