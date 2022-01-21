package Stack;
import java.util.*;

public class MINstack {

    public static void main(String args[]){

        Mystack st= new Mystack();
        
        st.push(1);
        st.push(2);System.out.println( st.getMin());
        st.pop();
        st.push(4);System.out.println( st.getMin());
        st.push(3);System.out.println( st.getMin());
        st.pop();
        System.out.println( st.top());
    }
    
}

class Mystack{
    Stack<Integer> stack = new Stack<>();
    Integer min;
    

    public void push(int x){
        if(stack.isEmpty()){
            min=x;
            stack.push(x);
            return ;
        }
        if(x>=min){
            stack.push(x);
        }else{
            int m=2*x-min;
            stack.push(m);
            min=m;
        }

    }
    public int pop(){
        if(stack.isEmpty()) return -1;
        if(stack.peek()<min){
            return 2*min-stack.pop();
        }
        return stack.pop();

    }
    public int top(){
        if(stack.isEmpty()) return -1;
        if(stack.peek()<min){
            return min;
        }
        return stack.peek();

    }
    public int getMin(){
        if(stack.isEmpty()){
            return -1;
        }
        return min;

    }

}