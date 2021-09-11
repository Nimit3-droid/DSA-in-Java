import java.util.*;
public class Ceil {
    public static int binarySearch(int arr[], int l, int r, int key){
        //returns ceil / equal to key
        // while(l<r){
        //     int mid=l+(r-l)/2;
        //     if(arr[mid]>=key){
        //         r=mid;
        //     }else{
        //         l=mid+1;
        //     }
            
        // }
        // if(arr[arr.length-1]<key) return -1;
        // return l;
        //ceil/equl
        while(r-l>1){
            int mid=l+(r-l)/2;
            if(arr[mid]>=key){
                r=mid;
            }else{
                l=mid;
            }
            
        }
        return r;
            //floor/equal
        // while(l<r){
        //     int mid=l+(r-l)/2;
        //     if(arr[mid]<=key){
        //         l=mid+1;
        //     }else{
        //         r=mid- 1;
        //     }
            
        // }
        // return l;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();

        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(binarySearch(arr, -1, n-1, 3));
    }
    
}
