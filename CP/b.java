package CP;
import java.util.*;

public class b {


    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int t= sc.nextInt();
        while(t--!=0){
            int n=sc.nextInt();
            int arr[]=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            int even =0, odd =0,ans=0;
            for(int i=1; i<n-1; i++){
                if(arr[i]%2==0){
                    even++;
                }else{
                    odd++;
                }
            }
            if(odd>even || even==0){
                System.out.println(-1);
            }else{

                int count =even-odd+n-2;
                ans=count;
                if(odd==0) ans=even;
                System.out.println(ans);
            }
        }
            
        sc.close();
    }
}
