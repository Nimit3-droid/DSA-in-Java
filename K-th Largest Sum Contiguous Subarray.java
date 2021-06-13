
import java.util.*;
class KthLargestSumContiguousSubarray {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt(),k=sc.nextInt();

        int arr[]=new int[n];
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }

        int preFSum[]=new int[n+1];
        for(int i=1; i<=n; i++){
            preFSum[i]=preFSum[i-1] + arr[i-1];
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=1;i<=n;i++){
            for(int j=i;j<=n;j++){
                int sum=preFSum[j]-preFSum[i-1];
                if(queue.size()<k){
                    queue.add(sum);
                }else{
                    if(queue.peek()<sum){
                        queue.remove(sum);
                        queue.add(sum);
                    }
                }
            }
        }

        System.out.println(queue.peek());

    }
}
