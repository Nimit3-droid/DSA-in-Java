import java.util.*;
public class Main{
    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> li=new ArrayList<>();
        for(int i=0;i<4;i++){

            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(1);
            list.add(2);
            list.add(3);
            li.add(list);
        }
        
        System.out.println(li);
    }
}