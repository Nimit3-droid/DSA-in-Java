package numberTheory;

import java.util.Arrays;
import java.util.Scanner;

public class nextGreatestInt{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String A=sc.next();
        char []c=A.toCharArray();
        int n=A.length();
        //find first i-1 which is c[i-1]<c[i]
        //find smallest digit int right of x
        //swap i-1 with j
        //sort right of i-1
        int x=-1;
        for(int i=n-1;i>=1;i--){
            if(c[i-1]<c[i]){
                x=i-1;
                break;
            }
        }
        if(x==-1){
            return ;
        }
        int minidx=x+1;
        char min=c[x+1];
        for(int i=x+1;i<n;i++){
            if(min>c[i]){
                minidx=i;
                min=c[i];
            }
        }
        if(minidx!=-1){
            char t=c[x];
            c[x]=c[minidx];
            c[minidx]=t;
        }
        Arrays.sort(c,x+1,n);
        String ans="";
        for(char a:c){
            ans+=a;
        }
        System.out.println(ans);

    }
}