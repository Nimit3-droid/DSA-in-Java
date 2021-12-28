package BinaryTree;
class TreeNode{
    Integer val;
    TreeNode left,right;
    boolean isVisited;
    TreeNode(int val){
        this.val=val;
        this.left=null;
        this.right=null;
        this.isVisited=false;
    }
}
public class BT {
    public static TreeNode constructBinaryTree(int arr[],int i){
        if(i>=arr.length) return null;
        TreeNode root =new TreeNode(arr[i]);
        root.left=constructBinaryTree(arr,2*i+1);
        root.right=constructBinaryTree(arr,2*i+2);
        return root;
    }
    public static TreeNode search(TreeNode root,int x){
        if(root==null) return root;
        if(root.val==x) return root;

        TreeNode left=search(root.left,x);
        if(left!=null) return left;
        TreeNode right=search(root.right,x);
        return right;
        

    }
    public static void preOrderPrint(TreeNode root){
        if(root==null) return ;
        System.out.print(root.val + " ");
        inOrderPrint(root.left);
        inOrderPrint(root.right);
    }

    public static void inOrderPrint(TreeNode root){
        if(root==null) return ;
        inOrderPrint(root.left);
        System.out.print(root.val + " ");
        inOrderPrint(root.right);
    }
    public static void postOrderPrint(TreeNode root){
        if(root==null) return ;
        inOrderPrint(root.left);
        inOrderPrint(root.right);
        System.out.print(root.val + " ");
    }
}
