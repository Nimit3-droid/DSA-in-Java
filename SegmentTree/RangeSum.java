package SegmentTree;

import java.util.Scanner;

public class RangeSum{
    static int tsum[];
    static int arr[];

    public static void built(int node , int start ,int end){
        if(start==end){
            tsum[node]=arr[start];
            return;
        }
        int mid=(start+end)/2;
        built(2*node,start,mid);
        built(2*node + 1 ,mid+1, end);
        tsum[node]=tsum[2*node]+tsum[2*node +1];
    }
    public static int query(int node,int a,int b,int start,int end){
        if(start>b||end<a){
            return 0;
        }
        if(start>=a && end<=b){
            return tsum[node];
        }
        int mid=(start+end)/2;
        int l= query(2*node, a, b, start,mid);
        int r=query(2*node+1, a, b,mid+1, end);
        return l+r;
    }
    public static void update(int node ,int indx,int value,int start ,int end){
        if(start==end){
            arr[node] = value;
            tsum[node]=value;
        }
        int mid=(start+end)/2;
        if(indx<=mid){
            update(2*node,indx,value,start,mid);
        }else{
            update(2*node +1, indx, value, mid+1, end);
        }
        tsum[node]=tsum[2*node]+tsum[2*node+1];
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt(), q=sc.nextInt();
        arr=new int[n];
        tsum=new int[4*n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        built(1,0,n-1);
        while(q--!=0){
            int a=sc.nextInt(),b=sc.nextInt();
            System.out.println(query(1,a-1,b-1,0,n-1));
            
        }
        
        sc.close();
    }
}