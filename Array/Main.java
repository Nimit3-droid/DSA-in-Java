import java.util.*;
import java.io.*;

class Main
{
	    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
	private static int mergeSortCountInv(int[] nums, int i, int j) {
        int count =0;
        if(i>=j) return count;
        int mid = (i+j)/2;
        count+=mergeSortCountInv(nums,i,mid);
        count+=mergeSortCountInv(nums,mid+1,j);
        count+=mergeCountInv(nums,i,mid,j);
        return count;
    }

    private static int mergeCountInv(int[] nums, int i, int mid, int j) {
        int count = 0;
        int temp[]=new int[nums.length];
        int left=i, right = mid+1,k=i;
        while(left<=mid && right <=j){
            if(nums[left]<=nums[right]){
                temp[k++]=nums[left++];
            }else{
                temp[k++]=nums[right++];
                count+=(mid+1)-left;
            }
        }

        while(left<=mid){
            temp[k++]=nums[left++];
        }
        while(right<=j){
            temp[k++]=nums[right++];
        }
        for(int l=i;l<=j;l++){
            nums[l]=temp[l];
        }

        return count;
    }
	public static void main (String[] args) throws java.lang.Exception{
		FastReader sc = new FastReader();
        int t= sc.nextInt();
        while(t--!=0){
            int n = sc.nextInt();
            int nums[]=new int[n];
            for(int i=0;i<n;i++) nums[i]=sc.nextInt();
            System.out.println(mergeSortCountInv(nums,0,n-1));
        }

	}
}