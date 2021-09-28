import java.util.*;
public class subsequenceWithSumK {
    static HashMap<Integer,ArrayList<Integer>> list = new HashMap<>();
    public static int subsequenceWithSumKDp(int arr[],int k){
        int n=arr.length;
        int dp[]=new int[k+1];
        dp[0]=1;
        for(int i=0;i<n;i++){
            for(int j=k;j>=arr[i];j--){
                if(dp[j-arr[i]]==1){
                    dp[j]=1;
                    if(list.containsKey(j-arr[i])){
                        list.get(j-arr[i]).add(arr[i]);
                    }else{
                        list.put(j-arr[i],new ArrayList<Integer>());
                        list.get(j-arr[i]).add(arr[i]);

                    }

                }
            }
        }

            
        return dp[k];
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(subsequenceWithSumKDp(arr, k)==1?true:false);
        System.out.println(list);
    }
}
