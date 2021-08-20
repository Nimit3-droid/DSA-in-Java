public class multiplicationTable {
    public static void maketable(int n,int i){
        if(i>=1 && i<=10){
            System.out.println(n*i);
            maketable(n,i+1);
        }
    }
    public static void main(String[] args){
        maketable(4,1);
    }
    
}
