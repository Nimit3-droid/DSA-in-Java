import java.util.*;
public class repeatAndMiss {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[]=new int[n];
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }
        // for(int i=0;i<n;i++){
        //     while(arr[arr[i]-1]!= arr[i]){
        //         //swap
        //         int temp = arr[i];
        //         arr[i]=arr[arr[i]-1];
        //         arr[arr[i]-1]=temp;
        //     }
        // }
        int i=0;
        while(i<n){
            if(arr[i]-1!=i && arr[arr[i]-1]!=arr[i]-1 && arr[i]!=arr[arr[i]-1]){
                //swap
                System.out.println("Swap -> " + arr[arr[i]-1] + " " + arr[i]);
                int temp = arr[i];
                arr[i]=arr[arr[i]-1];
                arr[arr[i]-1]=temp;
            }else{
                i++;
            }
        }
        for(int j=0;j<n;j++){
            if(arr[j] != j +1){
               System.out.println(arr[j] + " " + j);
            }
        }
        System.out.println("NON");
    }
    
}
