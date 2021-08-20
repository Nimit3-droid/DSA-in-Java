import java.util.*;

public class commonValueInMatrix {
    public static Integer[] commval(int[][] arr,int m,int n){
        ArrayList<Integer> ans = new ArrayList<>();
        int minIndex[]=new int[m];
        for(int i=0;i<m;i++){
            minIndex[i] =n-1;
        }
        int minVal=Integer.MAX_VALUE;
        //make a while loop until till all are -1 in minIndex
        // boolean all = false;
        while(true){
            for(int i=0;i<m;i++){
                minVal=(minIndex[i]>=0 && arr[i][minIndex[i]]<minVal)? arr[i][minIndex[i]]: minVal;
            }
            // System.out.println("minval : "+minVal);
            
            for(int i=0;i<m;i++){
                if(minIndex[i]>=0 && arr[i][minIndex[i]]>minVal){
                    minIndex[i] --;
                }
            }
            int flag=0;
            for(int i=0;i<m-1;i++){
                if(minIndex[i]>=0 && arr[i][minIndex[i]]!=arr[i+1][minIndex[i+1]]){
                    flag=1;
                    // System.out.print("flag "+ arr[i][minIndex[i]]+ " "+ arr[i+1][minIndex[i+1]]);
                }
            }
            if(flag==1){
                // System.out.println("all are Not equal");
                // continue;
            }else{
                ans.add(arr[0][minIndex[0]]);
                for(int i=0;i<m;i++){
                    minIndex[i]--;
                }
                flag=0;
                // System.out.println("flag "+1);
            }
            for(int i=0;i<m;i++){
                if(minIndex[i]==-1){
                    Integer a[]=new Integer[ans.size()];
                    a= ans.toArray(a);
                    return a;
                }
            }
            //if all the values are equal then add to ans
            //and decrease all by 1
        }


       
    }
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        int m= sc.nextInt();
        int n=sc.nextInt();
        int mat[][]=new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                mat[i][j]=sc.nextInt();
            }
        }
        Integer a[]=commval(mat,m,n);
        for(Integer i : a){
            System.out.print(i+ " ");
        }
        

    }
    
}
