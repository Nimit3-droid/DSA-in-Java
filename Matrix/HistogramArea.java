import java.util.*;
public class HistogramArea {

    public static int calArea(Stack<Integer> stack,int curr,int arr[]) {
        int top=stack.pop();
        System.out.println("cal area of index : "+curr+" top of stack : "+top+" multi : "+(stack.isEmpty()?curr:curr-stack.peek()-1) );
        return arr[top]*(stack.isEmpty()?curr:curr-stack.peek()-1);
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        Stack<Integer> stack=new Stack<Integer>();
        int i=0;
        int maxArea=0;
        while(i<n){
            if(stack.isEmpty()==true || arr[stack.peek()]<=arr[i]){
                System.out.println("pushed to stack : "+i);
                stack.push(i++);
            }else{
                //area
                maxArea=Math.max(maxArea,calArea(stack,i,arr));
                System.out.println(maxArea);
            }
        }
        while(!stack.isEmpty()){
            maxArea=Math.max(maxArea,calArea(stack,i,arr));  
            System.out.println(maxArea);
        }
        System.out.println(maxArea);
        sc.close();
    }
}
