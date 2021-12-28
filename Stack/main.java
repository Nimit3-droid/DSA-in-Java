package Stack;

public class main {
    public static void main(String[] args){
        LRUCache ch=new LRUCache(1);
        //6 1 S 2 1 S 2 2 G 2 S 1 1 S 4 1 G 1
        ch.put(2,1);
        ch.put(2,2);
        System.out.println(ch.get(2));
        ch.put(1,1);
        ch.put(4,1);
        System.out.println(ch.get(1));
    }
    
}
