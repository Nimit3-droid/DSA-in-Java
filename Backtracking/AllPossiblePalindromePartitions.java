import java.util.*;
public class AllPossiblePalindromePartitions {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);    
        String str = sc.next();
        ArrayList<ArrayList<String>> pallindromes=new ArrayList<ArrayList<String>>();
        ArrayList<String> list=new ArrayList<String>();
        solvePallinfromes(str,0,list,pallindromes);
        System.out.println(pallindromes);
        sc.close();
    }

    private static void solvePallinfromes(String str, int i, ArrayList<String> list,
            ArrayList<ArrayList<String>> pallindromes) {
                if(i==str.length()){
                    pallindromes.add(new ArrayList<String>(list));
                    return;
                }
                for(int j=i;j<str.length();j++){
                    if(isPallin(str,i,j)){
                        list.add(str.substring(i,j+1));
                        solvePallinfromes(str,j+1,list,pallindromes);
                        list.remove(list.size()-1);
                    }
                }
    }


    private static boolean isPallin(String str, int i, int j) {
        while(i<j){
            if(str.charAt(i)!=str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
