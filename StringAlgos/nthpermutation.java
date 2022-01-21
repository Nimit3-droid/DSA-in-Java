import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
public class nthpermutation {
    public static void main(String[] args) throws IOException{
        File file = new File("first.txt");
        Scanner sc = new Scanner(file);
        String string = sc.next();
        sc.close();
        char ch[]=string.toCharArray();
        int fact = factorial(ch.length);
        Arrays.sort(ch);
        int arr[]=new int[ch.length];
        for(int i=0; i<arr.length; i++){
            arr[i]=ch[i];
        }
        ArrayList<String> list = new ArrayList<String>();
        for(int i=0;i<fact;i++){

            nextGreatetInteger.nextGreatetInt(arr,arr.length);
            String s="";
            for(int ij=0; ij<arr.length; ij++){
                s+=toString(Character.toChars(arr[ij])) + "";                
            }
            if(!list.contains(s)){

                list.add(s);
            }
        }
        FileWriter writer = new FileWriter(file);
        for(String s : list){ writer.write(s+"\n"); }
        writer.close();
    }

    private static int factorial(int length) {
        if(length==0 || length==1) return 1;
        return length*factorial(length-1);
    }
    private static String toString(char[] a)
    {
        String string = new String(a);
 
        return string;
    }
}
