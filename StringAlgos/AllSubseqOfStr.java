import java.util.*;
public class AllSubseqOfStr {

    static List<String> lst=new ArrayList<>();
    //2^n tc
    public static void brutforce(String str,String ans){
        if(str.length()==0){
            lst.add(ans);
            return ;
        }
        brutforce(str.substring(1),ans+str.charAt(0) );
        brutforce(str.substring(1),ans);
    }
    static void printSubSeqRec(String str, int n, int index,
                               String curr)
    {
        // base case
        if (index == n) {
            return;
        }
        if (curr != null && !curr.trim().isEmpty()) {
            System.out.println(curr);
        }
        for (int i = index + 1; i < n; i++) {
            curr += str.charAt(i);
            printSubSeqRec(str, n, i, curr);
 
            // backtracking
            curr = curr.substring(0, curr.length() - 1);
        }
    }
    static void printSubSeq(String str)
    {
        int index = -1;
        String curr = "";
 
        printSubSeqRec(str, str.length(), index, curr);
    }

    public static void generate(List<String> st, String str){
        if(str.length()==0){
            return;
        }
        if(!st.contains(str)){
            st.add(str);
            for(int i=0;i<str.length();i++){
                String t=str;
                t=t.substring(0,i) + t.substring(i+1);
                generate(st,t);
            }
        }
    }
    public static void main(String[] args){
        // Scanner sc= new Scanner(System.in);
        // String str=sc.next();
        // brutforce(str,"");
        // Collections.sort(lst);
        // System.out.println(lst);
        // System.out.println(lst.size());
        //using set
        // List<String> st=new ArrayList<>();
        // generate(st,str);
        // Collections.sort(st);
        // System.out.println(st);
        printSubSeq("wqgsaaaaaaaasdasdfsnfgkjjbsdflkgbnks;dfngk.sdnf.kgndskfbgjhhsdhglksdjhflgjjhsdflkghlsdkfjhglksdfhnglk");

    }
}
