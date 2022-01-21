// package LinearSearch;

// import java.util.Scanner;

// public class LinearSearch{
//     public static void main(String[] args){
//         Scanner sc = new Scanner(System.in);
//         int t=sc.nextInt();
//         while(t-->0){
//             String s = sc.next();
//             // int isfirst=-1;
//             // int islast=-1,i=0;
//             int n=s.length();
//             String ans="";
//             while(i<n){
//                 if(!(s.charAt(i)=='1' && (i!=n-1  || s.charAt(i+1)=='1'))){
//                     ans+=s.charAt(i);
//                     i++;continue;
//                 }
//                 if(!(s.charAt(i)=='0' && (i!=n-1  || s.charAt(i+1)=='0'))){
//                     ans+=s.charAt(i);
//                     i++;continue;
//                 }
//                 i++;

//             }
//             long an=Integer.parseInt(ans);
//             System.out.println(an);
//         }
//     }
// }