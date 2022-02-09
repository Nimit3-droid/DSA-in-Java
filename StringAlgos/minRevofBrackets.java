import java.io.*;
import java.util.*;

class Pair{
    int x;
    char y;
    Pair(int x,char y){
        this.x=x;
        this.y=y;
    }
}

public class minRevofBrackets {
    
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("input.txt"));

        String str = sc.nextLine();
        Stack<Pair> stack = new Stack<>();
        for(int i=0;i<str.length();i++) {
            char c = str.charAt(i);
            if(c=='('){
                stack.push(new Pair(i,'('));
            }else{
                if(!stack.isEmpty() && stack.peek().y=='('){
                    stack.pop();
                }else{
                    stack.push(new Pair(i,c));
                }
            }
        }
        
        int m=0,n=0;
        ArrayList<Pair> list = new ArrayList<Pair>();
        while(!stack.isEmpty()) {
            if(stack.peek().y=='('){
                m++;
            }else{
                n++;
            }
            list.add(stack.pop());

        }
        
        FileWriter fw = new FileWriter(new File("output.txt"));
        int ans = (int) (Math.ceil((m*1.0)/2)+ Math.ceil((n*1.0)/2));
        fw.write(ans+"\n");
        fw.close();
        sc.close();
    }
}
