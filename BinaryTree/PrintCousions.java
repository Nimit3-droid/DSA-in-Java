package BinaryTree;
import java.util.*;
public class PrintCousions {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n; i++){
            arr[i] = sc.nextInt();
        }
        int key=sc.nextInt();
        TreeNode root=BT.constructBinaryTree(arr, 0);
        System.out.println(getCousions(root,key));
        sc.close();
    }

    public static ArrayList<Integer> getCousions(TreeNode root,int key) {
        ArrayList<Integer> ans =new ArrayList<>();
        if(root==null) return ans;
        if(root.val==key){
            return ans;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean found = false;
        while(!q.isEmpty()){
            int size = q.size();
            ans =new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                if((curr.left!=null && curr.left.val==key) ||( curr.right!=null && curr.right.val==key )) found = true;
                else{
                    if(curr.left!=null ){
                        q.offer(curr.left);
                        ans.add(curr.left.val);
                    }
                    if(curr.right!=null ){
                        q.offer(curr.right);
                        ans.add(curr.right.val);
                        System.out.println(curr.right.val);
                    }
                }

                
            }
            if(found)
                return ans;
        }


        return ans;
    }
}
