import java.util.*;

public class Main{
    static class Pair<E,T> {
        E x;T y;
        Pair(E x, T y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args){
        // Set<Pair<Integer,Integer>> set = new HashSet<>();
        // set.add(new Pair<Integer,Integer>(0,0));
        // set.add(new Pair<Integer,Integer>(1,0));
        // set.add(new Pair<Integer,Integer>(0,1));
        // set.add(new Pair<Integer,Integer>(0,0));
        // System.out.println(set);
        ArrayList<Integer> set = new ArrayList<Integer>();
        set.add(0);
        set.add(1);
        set.add(2);
        set.add(3);
        set.set(1,33);
        System.out.println(set);    
    }
}