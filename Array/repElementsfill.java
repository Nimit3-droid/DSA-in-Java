import java.util.*;
public class repElementsfill {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }
        sc.close();
        
        for(int i=0; i<n; i++){
            arr[arr[i]%n]+=n;
        }
        for(int i=0; i<n; i++){
            if(arr[i]>=2*n){
                System.out.println(i);
            }
        }

    }
}
