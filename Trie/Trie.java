package Trie;

import java.util.*;

class TrieNode {
    final int SIZE = 26;
    TrieNode children[] = new TrieNode[SIZE];
    int wordEnd;

    TrieNode() {
        wordEnd = 0;
        for (int i = 0; i < SIZE; i++) {
            children[i] = null;
        }
    }

    void add(TrieNode node, String s) {

        int n = s.length();
        TrieNode curr = node;

        for (int i = 0; i < n; i++) {
            int index = s.charAt(i) - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.wordEnd++;

    }

    boolean search(TrieNode node, String s) {
        int n = s.length();

        TrieNode curr = node;
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i) - 'a';
            if (curr.children[index] == null) {
                return false;
            }
            curr = curr.children[index];
        }
        return (curr.wordEnd > 0);

    }

    TrieNode delete(TrieNode node, String s, int currLevel) {
        if (node == null)
            return null;
        if (currLevel == s.length()) {
            if (node.wordEnd > 0) {
                node.wordEnd--;
            }
            if (isEmpty(node)) {
                node = null;
            }
            return node;
        }
        int index = s.charAt(currLevel) - 'a';
        node.children[index] = delete(node.children[index], s, currLevel + 1);
        if (isEmpty(node) && node.wordEnd <= 0) {
            node = null;
        }
        return node;
    }

    boolean isEmpty(TrieNode node) {
        for (int i = 0; i < SIZE; i++) {
            if (node.children[i] != null) {
                return false;
            }
        }
        return true;
    }

    boolean containsKey(TrieNode node, char c) {
        if (node.children[c - 'a'] == null) {
            return false;
        }
        return true;
    }

    String longestSuffix(TrieNode node) {

        String ans = "";
        ArrayList<TrieNode> q = new ArrayList<>();
        TrieNode curr = node;
        int idx = 0;
        for (int i = 0; i < SIZE; i++) {
            if (curr.children[i] != null) {
                idx = i;
                q.add(curr.children[i]);
            }
        }
        if (q.size() != 1) {
            return "";
        }
        curr = q.get(0);
        ans = (char) (idx + 'a') + "";
        if (curr.wordEnd > 0) {
            return ans;
        }
        String maxstr = "";
        int maxlen = 0;
        for (int i = 0; i < SIZE; i++) {
            if (curr.children[i] != null) {
                String tp = longestSuffix(curr);
                int len = tp.length();
                if (maxlen < len) {
                    maxlen = len;
                    maxstr = tp;
                }

            }
        }
        return ans + maxstr;

    }
}

public class Trie {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        String arr[]= new String[n];
        for(int i=0; i<n; i++){
        arr[i]=sc.next();
        }
        TrieNode root=new TrieNode();
        for(int i=0; i<n; i++){
        root.add(root,arr[i]);
        }
        String srch=sc.next();
        root.delete(root,srch,0);
        System.out.println(root.search(root,srch));
        System.out.println(root.longestSuffix(root));
        root.delete(root,"nimitttt",0);

    }
}