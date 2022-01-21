import java.util.*;
public class MinTrans {


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int trans[][]=new int[n][2];
        int sumAmt=0;
        for(int i=0; i<n; i++){
            trans[i][0]=i+1;
            trans[i][1]=sc.nextInt();
            sumAmt+=trans[i][1];
        }
        sc.close();
        sumAmt=(int)Math.floor(sumAmt/n);
        
        for(int i=0; i<n; i++){
            trans[i][1]=sumAmt-trans[i][1];
        }
        Arrays.sort(trans,(a,b)->(a[1]-b[1]));
        for(int i=0; i<n; i++){
            System.out.println(trans[i][0] +" "+trans[i][1]);
        }
        int rec=0, send=n-1;
        ArrayList<String> mintrans=new ArrayList<>();
        while(rec<send){
            if(trans[rec][1]==0 ){
                rec++;
            }else if(trans[send][1]==0){
                send--;
            }
            int sum = trans[rec][1]+trans[send][1];
            if(sum<0){
                mintrans.add(trans[send][0]+"->"+trans[rec][0] +" = "+trans[send][1]);
                trans[rec][1]+=trans[send][1];
                trans[send][1]=0;
                send--;

            }else if(sum>0){
                mintrans.add(trans[send][0]+"->"+trans[rec][0] +" = "+Math.abs(trans[rec][1]));
                trans[send][1]+=trans[rec][1];
                trans[rec][1]=0;
                rec++;
            }else{
                mintrans.add(trans[send][0]+"->"+trans[rec][0] +" = "+trans[send][1]);
                trans[send][1]=0;
                trans[rec][1]=0;
                rec++;
                send--;
            }

        }
        for(int i=0;i<n;i++){
            if(trans[i][1]!=0){
                System.out.println("no ans");
                return ;
            }
        }
        System.out.println(mintrans);
    }
    
}
