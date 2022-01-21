package BinaryTree;

import java.util.*;
// import BT;
public class spiralTra {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        sc.close();
        TreeNode root = BT.constructBinaryTree(arr,0);
        printSprialTraversal(root);
    }

    public static void printSprialTraversal(TreeNode root) {
        if(root==null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        int level =0;
        while(!q.isEmpty()){
            arr.add(new ArrayList<>());
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                arr.get(level).add(curr.val);
                if(curr.left != null){q.offer(curr.left);}
                if(curr.right != null){q.offer(curr.right);}
            }
            level++;
        }
        int top=0,last=arr.size()-1;
        boolean flag = true;
        while(top<=last){
            //l->r
            if(flag){
                for(int j=0;j<arr.get(top).size();j++){
                    System.out.print(arr.get(top).get(j)+ " ");
                }
                flag=false;
                top++;
            }else{
                //r-l
                for(int j=arr.get(last).size()-1;j>=0;j--){
                    System.out.print(arr.get(last).get(j)+" ");
                }
                flag = true;
                last--;
            }
        }
    }
}
