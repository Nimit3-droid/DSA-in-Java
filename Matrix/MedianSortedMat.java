import java.util.*;
public class MedianSortedMat {
    //this function is same as " find next arr[i] which is greater than given x"
    public static int findCountLessthanMid(int arr[],int x,int n){
        int low=0;
        int high = n-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid]<=x){
                low= mid+1;
            }else{
                high = mid-1;
            }
        }

        return low;
    }

    public static int findMedian(int mat[][],int m,int n) {
        int min=Integer.MIN_VALUE;
        int max=Integer.MAX_VALUE;
        for(int i=0;i<m;i++) {
            min=Math.min(min,mat[i][0]);
            max=Math.max(max,mat[i][n-1]);
        }
        while(min<=max) {
            int mid=  (max+ min) / 2;
            int count = 0;
            for(int i=0;i<m;i++) {
                count += findCountLessthanMid(mat[i],mid,n);
            }
            if( count <= (n*m)/2){
                min=mid+1;
            }else{
                max=mid-1;
            }
        }
        return min;

    }
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        int m= sc.nextInt();
        int n=sc.nextInt();
        int mat[][]=new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                mat[i][j]=sc.nextInt();
            }
        }
        System.out.println(findMedian(mat,m,n));
    }
    
}
