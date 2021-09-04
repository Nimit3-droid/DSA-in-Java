import java.util.*;
public class WordBreak {
    //dp n^2
    public static int  wordbreakDP(String sent,HashSet<String> set){
        //dp[i]=up sent of length i ... how many sentence can can be formed from given string
        int dp[]=new int[sent.length()];
        for(int i = 0;i<dp.length;i++){
            for(int j=0;j<=i;j++){
                if(set.contains(sent.substring(j,i+1))){
                    if(j>0)
                    dp[i]+=dp[j-1];
                    else{
                        dp[i]++;
                    }
                }
            }
        }
        
        return dp[dp.length-1]==sent.length()?dp[dp.length-1] :-1;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        HashSet<String> dictionary = new HashSet<>();
        for(int i=0; i<n; i++){
            dictionary.add(sc.next());
        }
        String sentence = sc.next();
        System.out.println(wordbreakDP(sentence,dictionary));
        
    }   
}
