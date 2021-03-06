import java.util.*;;
public class MinSumFromArray extends sumOfTwoLargeNumbers {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int arr[] = new int[n];

        for (int i=0;i<n;i++) {
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr);
        String odd="";
        String even="";
        for(int i=0;i<n;i+=2) {
            even+=Integer.toString(arr[i]);
            if(i+1<n){
                odd+=Integer.toString(arr[i+1]);
            }
        }
        System.out.println(FindBigSum(even,odd));
        sc.close();
    }
}
