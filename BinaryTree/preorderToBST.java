package BinaryTree;
import java.util.*;
public class preorderToBST {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[]=new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        int index[]=new int[]{0};
        TreeNode root=buildBST(arr,index, Integer.MAX_VALUE);
        BT.preOrderPrint(root);
        sc.close();
    }

    private static TreeNode buildBST(int[] arr,int index[],int maxBound) {
        if(arr.length==index[0] ||arr[index[0]] > maxBound) return null;
        TreeNode root = new TreeNode(arr[index[0]++]);
        root.left=buildBST(arr,index,root.val);
        root.right=buildBST(arr,index,maxBound);
        return root;

    }
}
