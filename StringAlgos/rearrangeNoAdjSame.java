import java.util.*;
import java.io.*;
public class rearrangeNoAdjSame {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(new File("input.txt"));
        String str= sc.nextLine();
        int n= str.length();
        int freqMap[]=new int[26];
        for(int i=0; i<n; i++){
            freqMap[str.charAt(i)-'a']++;
        }

        int maxFreq=0;
        char c=0;
        for(int i=0;i<26;i++){
            if(freqMap[i]>maxFreq){
                maxFreq=freqMap[i];
                c=(char)(i+'a');
            }
        }
        if(maxFreq>(n+1)/2){
            FileWriter fw = new FileWriter(new File("output.txt"));
            fw.write("No\n");
            fw.close();
            return;
        }
        int index=0;
        char ans[]=new char[n];
        while(maxFreq>0){
            ans[index]=c;
            maxFreq--;
            index+=2;
        }
        freqMap[c-'a']=0;
        for(int i=0;i<26;i++){
            while(freqMap[i]>0){
                if(index>=n){
                    index=1;
                }
                ans[index]=(char)(i+'a');
                freqMap[i]--;
                index+=2;
            }
            

        }


        FileWriter fw = new FileWriter(new File("output.txt"));
        fw.write(new String(ans)+"\n");
        fw.close();
        sc.close();
    }
}
