// package numberTheory;

// import java.util.ArrayList;
// import java.util.Scanner;


// class cityTour{
    
//     int p=1000000007;
//     int fact[]=new int[1001];
//     // int factInv[]=new int[1001];
//     public void fact(){
//         fact[0]=1;
//         for(int i=1;i<=1000;i++){
//             fact[i]=(int)((i*(long)fact[i-1])%p);
//         }
//     }
//     public int modInverse(int a)
//     {
//         int m=p;
//         int m0 = m;
//         int y = 0, x = 1;
 
//         if (m == 1)
//             return 0;
 
//         while (a > 1) {
//             // q is quotient
//             int q = a / m;
 
//             int t = m;
 
//             // m is remainder now, process
//             // same as Euclid's algo
//             m = a % m;
//             a = t;
//             t = y;
 
//             // Update x and y
//             y = x - q * y;
//             x = t;
//         }
 
//         // Make x positive
//         if (x < 0)
//             x += m0;
 
//         return x;
//     }
//     // public void factInv(){
//     //     for(int i=1;i<=1000;i++){
//     //         if(gcd(i,p-2)==1){
//     //             factInv[i]=(pow(i,p-2))%p;
//     //         }else{
//     //             factInv[i]=1;
//     //         }
            
//     //     }
//     //     for(int i=1;i<=1000;i++){
//     //         System.out.print(factInv[i]+" ");
//     //     }
//     // }

//     public int gcd(int a,int b){
        
//         if(b==0){
//             return a%p;
//         }else{
//             return gcd(b%p,(a%b)%p);
//         }
//     }
//     public int pow(int x,int y){
//         int ans=1%p;
//         x=x%p;
//         y=y%p;
//         while(y!=0){
//             if(y%2!=0){
//                 ans=(int)((long)((ans%p)*(x%p))%p);
//                 y--;
//             }else{
//                 x=(int)(((long)((x%p)*(x%p)))%p);     
//                 y/=2;
//             }
//         }
//         return ans%p;
//     }
//     public int solve(int A, ArrayList<Integer> B) {
        
//         fact();
//         // factInv();
//         int arr[]=new int[A+1];
//         for(int x:B){
//             arr[x]=1;
//         }
        
//         int ans=fact[A-(B.size())] ;

 
//         for(int j=1;j<=A;j++){
//             int zero=0;
//             if(arr[j]==0){
//                 while(j<=A && arr[j]==0){
//                     j++;
//                     zero++;
//                 }
//                 ans=(int)(((long)ans*(long)(pow(2,zero-1)%p)%p)*((long)modInverse(zero))%p)%p;
//                 // System.out.println("z "+ans);
//             }
//         }
        
//         int j=1;            
//         int zero=0;
//         while(j<=A && arr[j]==0){
//             j++;
//             zero++;
//         }

//         if(zero!=0){
//             ans=(int)((((long)ans)%p*((long)modInverse((pow(2,zero-1))%p))%p)%p);
//         }
        
        
//         zero=0;
//         j=A;
//         while(j<=A && arr[j]==0){
//             j--;
//             zero++;
//         }            
        
//         if(zero!=0){
//             ans=(int)((((long)ans)%p*((long)modInverse((pow(2,zero-1))%p))%p)%p);
//         }


        
//         return ans%p;
//     }
// }
// public class city {
//     public static void main(String args[]){
//         cityTour a=new cityTour();
//         Scanner sc = new Scanner(System.in);
//         int n=sc.nextInt();
//         int m=sc.nextInt();
//         ArrayList<Integer> ans=new ArrayList<Integer>();
//         while(m--!=0){
//             ans.add(sc.nextInt());
//         }
//         // a.fact();
//         // System.out.println(a.fact[1000]);
//         System.out.println(a.solve(n,ans));
//     }

    
    
    
// }


