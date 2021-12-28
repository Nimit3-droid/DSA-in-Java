package Trie;

import java.util.*;

// class TrieNode {
//     final int SIZE = 26;
//     TrieNode children[] = new TrieNode[SIZE];
//     int wordEnd;

//     TrieNode() {
//         wordEnd = 0;
//         for (int i = 0; i < SIZE; i++) {
//             children[i] = null;
//         }
//     }
//     boolean contains(char ch) {
//         return children[ch-'a']!=null;
//     }
//     void put(char c , TrieNode node){
//         children[c-'a'] = node;
//     }
//     TrieNode get(char ch) {
//         return children[ch-'a'];
//     }
//     int getWordEnd(){
//         return wordEnd;
//     }
//     void setWordEnd(int x){
//         wordEnd =x;
//     }
//     void add(TrieNode node,String word) {
//         for(int i=0;i<word.length();i++) {
//             if(!node.contains(word.charAt(i))) {
//                 node.put(word.charAt(i),new TrieNode());
//             }
//             node = node.get(word.charAt(i));
//         }
//         setWordEnd(getWordEnd() +1); 

//     }


//     // void add(TrieNode node, String s) {

//     //     int n = s.length();
//     //     TrieNode curr = node;

//     //     for (int i = 0; i < n; i++) {
//     //         int index = s.charAt(i) - 'a';
//     //         if (curr.children[index] == null) {
//     //             curr.children[index] = new TrieNode();
//     //         }
//     //         curr = curr.children[index];
//     //     }
//     //     curr.wordEnd++;

//     // }

//     boolean search(TrieNode node, String s) {
//         int n = s.length();

//         TrieNode curr = node;
//         for (int i = 0; i < n; i++) {
//             int index = s.charAt(i) - 'a';
//             if (curr.children[index] == null) {
//                 return false;
//             }
//             curr = curr.children[index];
//         }
//         return (curr.wordEnd > 0);

//     }

//     TrieNode delete(TrieNode node, String s, int currLevel) {
//         if (node == null)
//             return null;
//         if (currLevel == s.length()) {
//             if (node.wordEnd > 0) {
//                 node.wordEnd--;
//             }
//             if (isEmpty(node)) {
//                 node = null;
//             }
//             return node;
//         }
//         int index = s.charAt(currLevel) - 'a';
//         node.children[index] = delete(node.children[index], s, currLevel + 1);
//         if (isEmpty(node) && node.wordEnd <= 0) {
//             node = null;
//         }
//         return node;
//     }

//     boolean isEmpty(TrieNode node) {
//         for (int i = 0; i < SIZE; i++) {
//             if (node.children[i] != null) {
//                 return false;
//             }
//         }
//         return true;
//     }

//     boolean containsKey(TrieNode node, char c) {
//         if (node.children[c - 'a'] == null) {
//             return false;
//         }
//         return true;
//     }

//     String longestSuffix(TrieNode node) {

//         String ans = "";
//         ArrayList<TrieNode> q = new ArrayList<>();
//         TrieNode curr = node;
//         int idx = 0;
//         for (int i = 0; i < SIZE; i++) {
//             if (curr.children[i] != null) {
//                 idx = i;
//                 q.add(curr.children[i]);
//             }
//         }
//         if (q.size() != 1) {
//             return "";
//         }
//         curr = q.get(0);
//         ans = (char) (idx + 'a') + "";
//         if (curr.wordEnd > 0) {
//             return ans;
//         }
//         String maxstr = "";
//         int maxlen = 0;
//         for (int i = 0; i < SIZE; i++) {
//             if (curr.children[i] != null) {
//                 String tp = longestSuffix(curr);
//                 int len = tp.length();
//                 if (maxlen < len) {
//                     maxlen = len;
//                     maxstr = tp;
//                 }

//             }
//         }
//         return ans + maxstr;

//     }
// }

class TrieNode {

    TrieNode child[];
    private int SIZE;
    int end;
    TrieNode(){
        this.SIZE=26;
        this.child =new TrieNode[SIZE];
        this.end=0;
    }
    public boolean contains(char c) {

        return child[c-'a']!=null;
    }
    public void insert(char c,TrieNode node){
        child[c-'a'] = node;
    }
    public TrieNode getChild(char c) {
        return child[c-'a'];
    }
    public int getEnd(){
        return end;
    }
    public void setEnd(int x){
        this.end = x;
    }
}
class Trie{
    private TrieNode root;
    Trie(){
        this.root = new TrieNode();
    }
    public void insert(String word){
        TrieNode curr  =  this.root;
        for(int i=0;i<word.length();i++){
            if(!curr.contains(word.charAt(i))){
                //insert a new child
                curr.insert(word.charAt(i),new TrieNode());
            }
            curr=curr.getChild(word.charAt(i));
        }
        curr.setEnd(curr.getEnd()+1);

    }
    
    public boolean search(String word){
        TrieNode curr = root;
        for(int i=0;i<word.length();i++){
            if(!curr.contains(word.charAt(i))){
                return false;
            }
            curr=curr.getChild(word.charAt(i));
        }
        return curr.getEnd()>0;

    }
    public boolean startsWith(String word){
        TrieNode curr = root;
        for(int i=0;i<word.length();i++){
            if(!curr.contains(word.charAt(i))){
                return false;
            }
            curr=curr.getChild(word.charAt(i));
        }
        return true;
    }

}
public class TrieImplement {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        String arr[]= new String[n];
        for(int i=0; i<n; i++){
            arr[i]=sc.next();
        }
        Trie root=new Trie();
        root.insert("apple");
        System.out.println(root.search("apple"));
        System.out.println(root.startsWith("appleee"));
        System.out.println(root.search("apee"));
        root.insert("app");
        System.out.println(root.search("app"));
        System.out.println(root.startsWith("appl"));

        // for(int i=0; i<n; i++){
        // root.add(root,arr[i]);
        // }
        // String srch=sc.next();
        // root.delete(root,srch,0);
        // System.out.println(root.search(root,srch));
        // System.out.println(root.longestSuffix(root));
        // root.delete(root,"nimitttt",0);

    }
}