package BinaryTree;

import java.util.*;


class pair{
    TreeNode first;
    Integer second;
    pair(TreeNode first, Integer second){
        this.first=first;
        this.second=second;
    }
    
}

public class AllTraversal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[]=new int[n];
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }
        TreeNode root = BT.constructBinaryTree(arr,0);
        printAllTraversals(root);



    }
    public static void printAllTraversals(TreeNode root) {
        Stack<pair> stack =new Stack<>();
        ArrayList<Integer> preOrder = new ArrayList<>();
        ArrayList<Integer> inOrder = new ArrayList<>();
        ArrayList<Integer> postOrder = new ArrayList<>();
        stack.push(new pair(root,1));
        System.out.println(stack.peek().second);
        while (!stack.isEmpty()){
            pair p = stack.pop();
            if(p.second==1){
                preOrder.add(p.first.val);
                p.second+=1;
                stack.push(p);
                if(p.first.left!=null){
                    stack.push(new pair(p.first.left,1));
                }

            }else if(p.second==2){
                inOrder.add(p.first.val);
                p.second+=1;
                stack.push(p);
                if(p.first.right!=null){
                    stack.push(new pair(p.first.right,1));
                }


            }else{
                postOrder.add(p.first.val);
            }
        }
        System.out.println(preOrder);
        System.out.println(inOrder);
        System.out.println(postOrder);
        
    }
    
}
