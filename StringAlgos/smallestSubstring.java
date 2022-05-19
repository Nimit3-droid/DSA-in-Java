import java.util.*;
public class smallestSubstring {
    static String gstr="";
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        
        String[] s = new String[n];
        for(int i = 0; i < n; i++){
            s[i] = sc.next();
        }
        while(n!=1){
            int max =0;
            int l=0,r=0;
            String res="";

            for(int i=0;i<n-1;i++){
                for(int j=i+1;j<n;j++){
                   int ans = maxStringMatch(s[i],s[j]);
                    if(ans > max){
                        max = ans;
                        res=gstr;
                        l=i;r=j;  
                    }

                }

            }
            n--;
            if(max==0){
                s[0]=s[0]+s[n];
            }else{
                s[l]=res;
                s[r]=s[n];
            }
            System.out.println(s[0]);
        }
        sc.close(); 
        
    }

    private static int maxStringMatch(String str1, String str2) {
        int n1= str1.length();
        int n2= str2.length();
        int ans =0;
        for(int i=1;i<=Math.min(n1,n2);i++){
            if((str1.substring(0,i).compareTo(str2.substring(n2-i))==0) && ans<i){
                ans = i;
                gstr=str2 + str1.substring(i);
            }
        }
        for(int i=1;i<=Math.min(n1,n2);i++){
            if((str1.substring(n1-i).compareTo(str2.substring(0,i))==0) && ans<i){
                ans = i;
                gstr=str1 + str2.substring(i);
            }
        }
        return ans;
    }
}
