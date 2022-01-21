// package BinaryTree;
// import java.util.*;
// public class BURN_Tree {
//     public static int BURN(TreeNode root, int x) {
//         if(root==null) return 0;
//         HashMap<TreeNode,TreeNode> map =new HashMap<>();
//         Queue<TreeNode> q=new LinkedList<>();
        
//         q.add(root);
//         map.put(root,new TreeNode(-1));
//         while(!q.isEmpty()){
//             TreeNode curr = q.poll();
//             if(curr.left!=null){
//                 map.put(curr.left,curr);
//                 q.offer(curr.left);
//             }
//             if(curr.right!=null){
//                 map.put(curr.right,curr);
//                 q.offer(curr.right);
//             }
//         }
//         q.clear();
//         TreeNode serNode=BT.search(root,x);
//         q.add(serNode);
//         serNode.isVisited=true;
//         int timer =0;
        
//         while(!q.isEmpty()){
//             int size=q.size();
//             timer++;
//             for(int i=0;i<size;i++){
//                 TreeNode curr = q.poll();
//                 if(curr.left!=null && !curr.left.isVisited){
//                     curr.left.isVisited=true;
//                     q.offer(curr.left);
//                 }
//                 if(curr.right!=null&& !curr.right.isVisited){
//                     curr.right.isVisited=true;
//                     q.offer(curr.right);
//                 }
//                 if(map.get(curr).val!=-1 && !map.get(curr).isVisited){
//                     map.get(curr).isVisited=true;
//                     q.offer(map.get(curr));
//                 }
//             }
//         }
//         return timer;
//     }
//     public static void main(String[] args){
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int arr[]=new int[n];
//         for(int i=0; i<n; i++){
//             arr[i]=sc.nextInt();
//         }
//         TreeNode root = BT.constructBinaryTree(arr,0);
//         int x = sc.nextInt();
//         System.out.println(BURN(root,x));
//         sc.close();
//     }

    
// }
