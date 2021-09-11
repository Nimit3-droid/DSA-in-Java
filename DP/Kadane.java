import java.util.*;
public class Kadane {
    ///most eff and works for -ve / +ve
    public static int contigiousMaxSum(int[] arr, int n){
        int currMax=arr[0];
        int maxSoFar=arr[0];
        for(int i=1; i<n; i++){
            currMax=Math.max(arr[i],currMax + arr[i]);
            maxSoFar=Math.max(maxSoFar,currMax);
        }
        return maxSoFar;
    }
    
static int maxSubArraySum(int a[],int size)
{
     
    int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;
    int start=0,end=0;
    int currStart=0;
 
    for (int i = 0; i < size; i++)
    {
        max_ending_here = max_ending_here + a[i];
        if (max_ending_here < 0){
            max_ending_here = 0;
            currStart=i+1;
        }
        else if (max_so_far < max_ending_here){
            max_so_far = max_ending_here;
            start=currStart;
            end=i;
        }
         
    }
    System.out.println("Index : start="+start + " end="+end); 
    return max_so_far;
}
 
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(contigiousMaxSum(arr,n));
        System.out.println(maxSubArraySum(arr,n));
    }
}
