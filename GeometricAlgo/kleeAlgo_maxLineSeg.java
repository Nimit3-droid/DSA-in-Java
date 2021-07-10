package GeometricAlgo;

import java.util.ArrayList;
import java.util.Comparator;

class Pair{
    int first;
    boolean second;
    Pair(int first,boolean second){
        this.first=first;
        this.second=second;
    }
}
public class kleeAlgo_maxLineSeg {
    public static int maxLineSegment(int arr[][]){
        int n=arr.length;
        ArrayList<Pair> seg=new ArrayList<>();
        for(int i=0;i<n;i++){
            seg.add(new Pair(arr[i][0],false));
            seg.add(new Pair(arr[i][1],true));
        }

        seg.sort(new Comparator<Pair>(){
            @Override
            public int compare(Pair p1,Pair p2){
                if(p1.first>p2.first) return 1;
                else if(p1.first<p2.first) return -1;
                else{
                    if(p1.second==false && p2.second==true) return -1;
                    else if(p1.second==true && p2.second==false) return 1;
                    else{
                        return 0;
                    }
                }
            }
        });
        for(int i=0;i<seg.size();i++){
            System.out.println(seg.get(i).first+" "+seg.get(i).second);
        }
        int count=0;
        int result=0;
        int max=-1;
        for(int i=0;i<seg.size();i++){
            if(count>0){
                //update result
                result+=seg.get(i).first - seg.get(i-1).first;
            }
            max=Math.max(max, result);
            if(count==0) result=0;
            if(seg.get(i).second==false){
                count++;
            }else{
                count--;
            }
        }

        return max;

    }
    public static void main(String args[]){
        int arr[][]={{1,3},{2,9},{6 ,9},{9,12},{15,135}};
        System.out.println(maxLineSegment(arr));
    }
}
