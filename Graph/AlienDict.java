import java.util.Scanner;
import java.util.*;
public class AlienDict{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int alpha=sc.nextInt();
        ArrayList<String> words=new ArrayList<String>();
        for(int i=0;i<n;i++){
            words.add(sc.next());
        }
        sc.close();
        ArrayList<ArrayList<Integer>> mat=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<alpha;i++){
            mat.add(new ArrayList<Integer>());
        }
        for(int i=0;i<n-1;i++){
            for(int j=0;j<Math.min(words.get(i).length(),words.get(i+1).length());j++){
                if(words.get(i).charAt(j)!=words.get(i+1).charAt(j)){
                    // System.out.println((words.get(i).charAt(j)-'a') +" "+(words.get(i+1).charAt(j)-'a'));
                    mat.get(words.get(i).charAt(j)-'a').add(words.get(i+1).charAt(j)-'a');
                    break;
                }
                
            }
        }
        int k=0;
        for(ArrayList<Integer> x: mat){

            System.out.print(k+ " : ");
            for(int i=0;i<x.size();i++){
                System.out.println((char)(x.get(i) + 'a'));
            }
            k++;
        }
        KahnTopoSort ob=new KahnTopoSort();
        ArrayList<Integer> ans=ob.tpsort(mat);
        for(int c : ans){
            System.out.print((char)(c+'a'));
        }
    }
    
}