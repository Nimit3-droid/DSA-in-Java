import java.util.*;
import java.io.*;
public class smallestWindow {
    //tc=o(len(str))
    public static void main(String[] args) throws IOException{
        
        Scanner sc = new Scanner(new File("input.txt"));
        String str= sc.nextLine();
        String text= sc.nextLine();

        int freqMap[]=new int[256];
        int count=0;
        for(int i=0;i<text.length();i++) {
            if(freqMap[i]==0) count++;
            freqMap[text.charAt(i)]++;
        }
        int i=0,j=0;
        int start=-1;
        int minLen=Integer.MAX_VALUE;
        while(j<str.length()){
            freqMap[str.charAt(j)]--;
            if(freqMap[str.charAt(j)]==0) count--;
            while(count==0){
                int ans = j-i+1;
                if(ans<minLen){
                    minLen=ans;
                    start=i;
                }
                freqMap[str.charAt(i)]++;
                if(freqMap[str.charAt(i)]>0) count++;
                i++;
            }
            j++;
        }
        FileWriter fw = new FileWriter(new File("output.txt"));
        String substr=str.substring(start,start+minLen);
        fw.write("Length : "+minLen +"\n" + "str = "+substr);
        fw.close();
        sc.close();
    }
}
