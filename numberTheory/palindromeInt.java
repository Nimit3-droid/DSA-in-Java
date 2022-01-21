package numberTheory;

import java.util.Scanner;

public class palindromeInt {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int A=sc.nextInt();
        sc.close();
        if(A<0) System.out.println(0);
        if(A>=0 && A<=9) System.out.println(1);
        int d=1;
        while(A/d>=10){
            d*=10;
        }
        while(A!=0){
            int l=A/d;
            int r=A%10;
            if(l!=r) {
                System.out.println(0);
                return;
            }
            //remove first and last digits of A
            A=(A%d)/10;
            d=d/100;


        }
        System.out.println(1);
    }
    
}
