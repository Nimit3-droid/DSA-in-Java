import java.util.*;
public class MergeSortedArray{
    // nlogn
    public static void merge(int nums1[],int nums2[]){
        int m = nums1.length, n = nums2.length;
        int gap= (int)Math.ceil((n+m*1.0)/2);
        while(gap > 0){
            int i=0, j=i+gap;
            while(j<m){
                if(nums1[i]>nums1[j]){
                    int temp = nums1[i];
                    nums1[i]=nums1[j];
                    nums1[j]=temp;
                }
                i++;j++;
            }
            j=0;
            while(i<m && j<n){
                if(nums1[i]>nums2[j]){
                    int temp = nums1[i];
                    nums1[i]=nums2[j];
                    nums2[j]=temp;
                }
                i++;j++;
            }
            i=0;
            while(j<n){
                if(nums2[i]>nums2[j]){
                    int temp = nums2[i];
                    nums2[i]=nums2[j];
                    nums2[j]=temp;
                }
                i++;j++;
            }
            
            gap=gap/2;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int nums1[]=new int[m];
        int nums2[]=new int[n];
        for(int i=0;i<m;i++) nums1[i]=sc.nextInt();
        for(int i=0;i<n;i++) nums2[i]=sc.nextInt();
        merge(nums1,nums2);
        for(int i=0;i<m;i++) System.out.print(nums1[i]+" ");
        System.out.println();
        for(int i=0;i<n;i++) System.out.print(nums2[i]+" ");
        sc.close();

        
    }
}