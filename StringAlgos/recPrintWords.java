import java.util.*;
import java.io.*;
public class recPrintWords {
    public static void print(ArrayList<ArrayList<String>> list,int r,int c,String str){

        if(r==list.size()){
            return;
        }
        str=str+" "+list.get(r).get(c);
        if(r==list.size()-1){
            System.out.println(str);
            return;
        }
        for(int i=0;i<list.get(r+1).size();i++){
                print(list,r+1,i,str);
        }
    }
    public static void printdfs(ArrayList<ArrayList<String>> list){
         
        String str="";
        for(int i=0;i<list.get(0).size();i++)
        {
            print(list,0,i,str);
        }
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("input.txt"));
        int n = sc.nextInt();
        ArrayList<ArrayList<String>> arr = new ArrayList<>();
        for(int i=0;i<n;i++){
            ArrayList<String> list = new ArrayList<>();
            int m = sc.nextInt();
            for(int j=0;j<m;j++){
                list.add(sc.next());
            }
            arr.add(list);
        }
       
        printdfs(arr);
        sc.close();
    }

}
