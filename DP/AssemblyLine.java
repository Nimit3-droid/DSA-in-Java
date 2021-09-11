public class AssemblyLine{
    
    public static int carAssembly(int a[][], int t[][], int e[], int x[]){
        int first=a[0][0]+e[0];
        int second=a[1][0]+e[1];
        for(int i=1;i<a[0].length;i++){
            int fst=Math.min(first + a[0][i],second + t[1][i]+a[0][i]);
            int snd=Math.min(second + a[1][i],first + t[0][i]+ a[1][i]);
            first=fst;second=snd;
        }
        return Math.min(first+x[0], second+x[1]);
    }
    public static void main (String[] args)
    {
        int a[][] = {{4, 5, 3, 2},
                    {2, 10, 1, 4}};
        int t[][] = {{0, 7, 4, 5},
                    {0, 9, 2, 8}};
        int e[] = {10, 12}, x[] = {18, 7};
     
        System.out.println(carAssembly(a, t, e, x));   
     
    }
}