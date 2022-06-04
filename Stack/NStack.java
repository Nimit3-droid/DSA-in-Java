package Stack;

import java.util.*;
public class NStack {
    // Initialize your data structure.
    int next[];
    int freeslot;
    int top[];
    int arr[];
    public NStack(int k, int n) {
        // Write your code here.
        this.arr=new int[n];
        this.next=new int[n];
        this.top=new int[k];
        freeslot=0;
        
        Arrays.fill(top,-1);
        for(int i=0;i<n-1;i++){
            next[i]=i+1;
        }
        next[n-1]=-1;
    }

    // Pushes 'X' into the Mth stack. Returns true if it gets pushed into the stack, and false otherwise.
    public boolean push(int x, int m) {
        // Write your code here.
        if(freeslot==-1) return false;
        int index = freeslot;
        freeslot=next[index];
        arr[index]=x;
        next[index]=top[m-1];
        top[m-1]=index;
        return true;
    }

    // Pops top element from Mth Stack. Returns -1 if the stack is empty, otherwise returns the popped element.
    public int pop(int m) {
        // Write your code here.
        if(top[m-1]==-1) return -1;
        int index=top[m-1];
        top[m-1]=next[index];
        next[index]=freeslot;
        freeslot=index;
        return arr[index];
        
    }
}