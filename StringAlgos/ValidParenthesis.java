import java.util.*;
public class ValidParenthesis{
    //TC : (4^n)/root(n)
    public static List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        if(n==0){
            ans.add("");
        }else{
            for(int i=0;i<n;i++){
                for( String left: generateParenthesis(i)){
                    for(String right : generateParenthesis(n-1-i)){
                        ans.add( left+"("+right+")");
                    }
                }
            }
        }
        return ans;

    }

    //Faster
    public static void dfs(List<String> ans, int left,int right, int pos, StringBuilder str){
        if(left>pos || right >  pos) return ;
        if(left==pos && right == pos) {
            ans.add(str.toString());
        }

            str.append("(");
            dfs(ans,left+1,right,pos,str);
            str.setLength(str.length()-1);
        
        if(right<left){
            str.append(")");
            dfs(ans,left,right+1,pos,str);
            str.setLength(str.length()-1);
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        //using 
        System.out.println(generateParenthesis(n));

        //using DFS
        List<String> ans=new ArrayList<>();
        dfs(ans,0,0,n,new StringBuilder());
        System.out.println(ans);
    }
}