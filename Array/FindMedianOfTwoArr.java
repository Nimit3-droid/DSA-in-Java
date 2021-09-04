import java.util.*;

public class FindMedianOfTwoArr {

    public static double medianOfTwoArr(int arr1[], int arr2[],  int n, int m) {
        if(n>m) return medianOfTwoArr(arr2,arr1,m,n);
        int low=0, high=n;
        while(low<=high) {
            int mid1=(low+high)/2;
            int mid2=(n+m+1)/2 - mid1;  // works for booth even and odd
            int l1=mid1==0?Integer.MIN_VALUE:arr1[mid1-1];
            int l2= mid2==0?Integer.MIN_VALUE:arr2[mid2-1];
            int r1=mid1==n?Integer.MAX_VALUE:arr1[mid1];
            int r2=mid2==m?Integer.MAX_VALUE:arr2[mid2];

            if(l1<=r2 && l2<=r1){
                if((n+m)%2==0){
                    return (Math.max(l1,l2) + Math.min(r1,r2))/2;
                }else{
                    return (Math.max(l1,l2));
                }
            }else if(l1>r2){
                high=mid1-1;
            }else{
                low=mid1+1;
            }
        }

        return 0;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt() ;
        int arr1[] = new int[n];
        for(int i=0; i<n; i++){
            arr1[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int arr2[]=new int[m];
        for(int i=0; i<m; i++){
            arr2[i] = sc.nextInt();
        }
        // using binary search
        double median = medianOfTwoArr(arr1,arr2,n,m);
        System.out.println(median);

    }
    
}
