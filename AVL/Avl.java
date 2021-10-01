package AVL;

class AvlNode{
    int val,height;
    AvlNode left,right;
    AvlNode(int val){
        this.val=val;
        this.height=1;
    }
}
public class Avl{
    AvlNode root;
    public  AvlNode rightRotate(AvlNode node){
        AvlNode nodeLeft=node.left;
        AvlNode nodeLeftRight=nodeLeft.right;
        nodeLeft.right=node;
        node.left=nodeLeftRight;
        //update height
        node.height=Math.max(height(node.left),height(node.right))+1;
        nodeLeft.height=Math.max(height(nodeLeft.left),height(nodeLeft.right)) +1;
        return nodeLeft;

    }
    public  AvlNode leftRotate(AvlNode node){
        AvlNode nodeRight=node.right;
        AvlNode nodeRightLeft=nodeRight.left;
        nodeRight.left=node;
        node.right=nodeRightLeft;
        //update height
        node.height=Math.max(height(node.left),height(node.right))+1;
        nodeRight.height=Math.max(height(nodeRight.left),height(nodeRight.right)) +1;
        return nodeRight;

    }
    public int height(AvlNode root){
        if(root==null) return 0;
        return root.height;
    }
    public  AvlNode insertAvlNode(AvlNode root,int val){
        if(root==null){
            return new AvlNode(val);
        }else if(val<root.val){
            root.left=insertAvlNode(root.left,val);
        }else if(val>root.val){
            root.right=insertAvlNode(root.right,val);
        }else{
            return root;
        }

        root.height=Math.max(height(root.left),height(root.right))+1;

        int balanceFactor= height(root.left)-height(root.right);
        if(balanceFactor>1 && val<root.left.val){
            return rightRotate(root);
        }
        if(balanceFactor>1 && val>root.left.val){
            root.left=leftRotate(root.left);
            return rightRotate(root);
        }
        if(balanceFactor<-1 && val<root.left.val){
            root.right=rightRotate(root.right);
            return leftRotate(root);
        }
        if(balanceFactor<-1 && val>root.left.val){
            return leftRotate(root);
        }
        return root;
    }
    public  void preOrder(AvlNode root){
        if(root==null){
            return ;
        }
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    AvlNode minVal(AvlNode root){
        AvlNode curr=root;
        while(curr.left!=null){
            curr=curr.left;
        }
        return curr;
    }
    AvlNode deleteAvlNode(AvlNode root,int val){
        if(root==null){
            return root;
        }else if(val<root.val){
            root.left=deleteAvlNode(root.left,val);
        }else if(val>root.val){
            root.right=deleteAvlNode(root.right,val);
        }else{
            //one child of root 
            if(root.left==null||root.right==null){
                AvlNode onechild=null;
                if(root.left==null){
                    onechild=root.right;
                }else{
                    onechild=root.left;
                }
                root=onechild;
            }else{
                //both children of root 
                AvlNode inorderSuccOfRootRight=minVal(root.right);
                root.val=inorderSuccOfRootRight.val;
                root.right=deleteAvlNode(root.right, inorderSuccOfRootRight.val);
            }
        }
        if(root==null) return root;
        root.height=Math.max(height(root.left), height(root.right))+1;
        int balanceFactor= height(root.left)-height(root.right);
        if(balanceFactor>1 && (height(root.left.left)-height(root.left.right))>=0){
            return rightRotate(root);
        }
        if(balanceFactor>1 && (height(root.left.left)-height(root.left.right))<0){
            root.left=leftRotate(root.left);
            return rightRotate(root);
        }
        if(balanceFactor<-1 && (height(root.right.left)-height(root.right.right))>0){
            root.right=rightRotate(root.right);
            return leftRotate(root);
        }
        if(balanceFactor<-1 && (height(root.right.left)-height(root.right.right))<=0){
            return leftRotate(root);
        }
        return root;
    }
    public static void main(String[] args){
        Avl tree=new Avl();
        tree.root = tree.insertAvlNode(tree.root, 9);
        tree.root = tree.insertAvlNode(tree.root, 5);
        tree.root = tree.insertAvlNode(tree.root, 10);
        tree.root = tree.insertAvlNode(tree.root, 0);
        tree.root = tree.insertAvlNode(tree.root, 6);
        tree.root = tree.insertAvlNode(tree.root, 11);
        tree.root = tree.insertAvlNode(tree.root, -1);
        tree.root = tree.insertAvlNode(tree.root, 1);
        tree.root = tree.insertAvlNode(tree.root, 2);
        tree.preOrder(tree.root);
        tree.root = tree.deleteAvlNode(tree.root, 10);
        System.out.println();
        tree.preOrder(tree.root);
        
    }
}