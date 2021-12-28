import java.util.*;
public class paintersPartition {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        
        int a[] = new int[n];
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        int b = sc.nextInt();
        if(b>n){
            System.out.println("-1");
            return ;
        }
        int low =0;
        int high = 0;
        for(int i : a){
            low=Math.max(low,i);
            high+=i;
        }
        int ans=-1;
        while(low<=high){
            int mid=low + (high-low)/2;
            if(isvalid(a,b,mid)){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        System.out.println(ans);
    }

    private static boolean isvalid(int[] a, int b, int mid) {
        int painter=1, length =0;
        for(int i=0; i<a.length; i++){
            length+=a[i];
            if(length>mid){
                painter++;
                length = a[i];
            }
            if(painter>b){
                return false;
            }
        }
        return true;
    }
    
}
