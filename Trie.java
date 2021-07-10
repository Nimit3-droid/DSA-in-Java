public class Trie {
    static int totalAlpha=26;
    public static class TrieNode{
        TrieNode[] children=new TrieNode[totalAlpha];
        boolean isLeaf=false;

        public TrieNode(){
            for(int i=0;i<totalAlpha;i++){
                children[i]=null;
                isLeaf=false;
            }
        }

    }

    public static void insertNode(){

    }

    // public static boolean searchNode(){

    // }

    public static void main(String[] args){

    }


}
