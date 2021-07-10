import java.util.Scanner;
import java.util.Stack;
class Node {
    int data;
    Node left;
    Node right;
    Node (int d){
        data=d;
        left=null;
        right=null;
    }

}
public class constructBTFromGivenString{
        public static int index(String str,int s,int e)
        {
            if(s>e)return -1;
            Stack<Character> st=new Stack<>();
            for(int i=s;i<=e;i++){
                if(str.charAt(i)=='(') {
                    st.push('(');
                }else if(str.charAt(i)==')'){
                    st.pop();
                    if(st.isEmpty()){
                        return i;
                    }
                }
            }
            return -1;
        }

    public static Node convetToTree(String str,int s,int e){
        if(s>e) return null;
        Node root=new Node(str.charAt(s)-'0');
        int mid=-1;
        if (s + 1 <= e && str.charAt(s+1) == '('){
            mid=index(str, s+1, e);
        }
        if(mid!=-1){
            root.left=convetToTree(str, s+2, mid-1);
            root.right=convetToTree(str, mid+2, e-1);
        }
        return root;
    }
    public static void printTree(Node tree){
        if(tree==null) return;
        System.out.print(tree.data+"  ");
        printTree(tree.left);
        printTree(tree.right);
    }
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        printTree(convetToTree(str,0,str.length()-1));

    }
}