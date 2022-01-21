import java.util.*;
public class searchInRotatedArray {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        // int b = sc.nextInt();
        System.out.println(find(arr));
        sc.close();
    }

    private static int find(int[] a) {
        int n=a.length;
        int low=0, high=n-1;
        while(low<=high){
            int mid = (high+low)/2;
            System.out.println(low +" "+high+" "+mid);
            if((mid-1 < 0 || a[mid-1]>a[mid]) && (mid+1>=n || a[mid]<a[mid+1])){
                return mid;
            }else if(a[low]<a[mid]&&a[low]>a[high]){
                low = mid+1;
                System.out.println("low ->");
            }else{
                high = mid-1;
                System.out.println("high <- ");
            }
        }
        
        return n-1;
    }

}
