// package SegmentTree;

import java.util.Scanner;

public class MinRange {
    static int arr[];
    static int tmin[];
    public static void built(int node , int start,int end){
        if(start==end){
            tmin[node]=arr[start];
            return;
        }
        int mid=(start+end)/2;
        built(2*node, start,mid);
        built(2*node+1, mid+1, end);
        tmin[node]=Math.min(tmin[2*node],tmin[2*node+1]);
    }
    public static int query(int node, int a, int b,int start,int end){
        if(b<start || end<a){
            return Integer.MAX_VALUE;
        }
        if(start>=a&& end<=b){
            return tmin[node];
        }
        int mid=(start+end)/2;
        int lm=query(2*node, a, b, start, mid);
        int rm=query(2*node+1, a, b, mid+1, end);
        return Math.min(lm, rm);
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(), q=sc.nextInt();
        arr=new int[n];
        tmin=new int[4*n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        built(1,0,n-1);
        while(q--!=0){
            int a =sc.nextInt(), b=sc.nextInt();
            System.out.println(query(1,a-1,b-1,0,n-1));
        }
    }
}
