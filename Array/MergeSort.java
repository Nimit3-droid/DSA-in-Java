import java.util.*;
public class MergeSort {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nums[]=new int[n];
        for(int i=0;i<n;i++) nums[i]=sc.nextInt();
        mergeSort(nums,0,n-1);
        for(int i=0;i<n;i++) System.out.print(nums[i]+" ");

        sc.close();
    }

    private static void mergeSort(int[] nums, int i, int j) {
        if(i>=j) return;
        int mid = (i+j)/2;
        mergeSort(nums,i,mid);
        mergeSort(nums,mid+1,j);
        merge(nums,i,mid,j);
    }

    private static void merge(int[] nums, int start, int mid , int end) {
        int gap = (int )Math.ceil((end-start+1.0)/2);
        while(gap > 0){
            int i=start, j=i + gap;
            while(j<mid+1){
                if(nums[i]>nums[j]){
                    int temp = nums[i];
                    nums[i]=nums[j];
                    nums[j]=temp;
                }
                i++;j++;
            }
            j=mid+1;
            while(i<mid+1 && j<end+1){
                if(nums[i]>nums[j]){
                    int temp = nums[i];
                    nums[i]=nums[j];
                    nums[j]=temp;
                }
                i++;j++;
            }
            i=mid+1;
            while(j<end+1){
                if(nums[i]>nums[j]){
                    int temp = nums[i];
                    nums[i]=nums[j];
                    nums[j]=temp;
                }
                i++;j++;
            }

            gap =gap/2;
        }
    }
}
