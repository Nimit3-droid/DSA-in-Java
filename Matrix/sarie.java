import java.util.*;
class matp{
    int x, y,n,m;
    matp(int x,int y,int n,int m){
        this.x=x;
        this.y=y;
        this.n=n;
        this.m=m;
    }
}
public class sarie {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();
        while (t--!= 0) {
            int n= sc.nextInt(),r= sc.nextInt(),c= sc.nextInt();
            matp arr[]= new matp[n];
            int mat[][]=new int[r][c];
            for(int i=n-1;i>=0;i--){
                matp p=new matp(sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt());
                arr[i]=p;
            }
            HashMap<String,Integer> map = new HashMap<>();
            for(int i=n-1;i>=0;i--){
                if(map.containsKey(arr[i].x+"-"+arr[i].y)){
                    continue;
                }
                map.put(arr[i].x+"-"+arr[i].y,1);
                for(int row=arr[i].x;row<(arr[i].n+arr[i].x);row++){
                    for(int col=arr[i].y;col<(arr[i].m+arr[i].y);col++){
                        mat[row][col]=i+1;
                    }
                }
            }
            //10*(20,000*25*10,00,000)
            Set<Integer> ans = new HashSet<Integer>();
            for(int i=0;i<r;i++){
                for(int j=0;j<c;j++){
                    ans.add(mat[i][j]);
                }
            }
            System.out.println(ans.size()-1);

        }
        sc.close();
    }
    
}
