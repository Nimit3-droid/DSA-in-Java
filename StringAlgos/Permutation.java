import java.util.*;
public class Permutation {
    // n*n!
    public static void permute(String s, String ans){
        if(s.length()==0){
            System.out.println(ans);
            return;
        }
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            permute(s.substring(0,i)+s.substring(i+1),ans+c);
        }
    }
    //n*n!
    public static void permute(String s,int l,int r){
        if(l==r){
            System.out.print(s+" ");
        }
        for(int i=l;i<=r;i++){
            s=swap(s,l,i);
            permute(s,l+1,r);
            s=swap(s,l,i);
        }
    }
    public static String swap(String s,int l,int r){
        char c[]=s.toCharArray();
        char tp=c[l];
        c[l]=c[r];
        c[r]=tp;
        return String.valueOf(c);

    }
    public static void permutationofArr(int arr[],int left,int right){
        if(left==right){
            for(int i=0;i<arr.length;i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return ;
        }
        for(int i=left;i<=right;i++){
            swap(arr,left,i);
            permutationofArr(arr,left+1,right);
            //to regain original str swap again
            swap(arr,left,i);
        }
    }
    private static void swap(int[] arr, int left, int i) {
        int t=arr[left];
        arr[left]=arr[i];
        arr[i]=t;
    }
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        // String str=sc.next();
        // permute(str,"");
        // permute(str,0,str.length()-1);
        int n = sc.nextInt();
        int arr[]=new int[n];
        for(int i=0; i<n; i++)
        {
            arr[i]=sc.nextInt();
        }
        permutationofArr(arr, 0, n-1);
        sc.close();
    }
    
}
