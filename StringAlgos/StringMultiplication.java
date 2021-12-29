import java.util.Scanner;

public class StringMultiplication {
    public static String multiply(String num1, String num2) {
        boolean sign =false;
        if(num1.charAt(0) == '-' || num2.charAt(0) == '-') sign= true;
        if(num1.charAt(0) == '-' && num2.charAt(0) == '-') sign= false;
		if (num1.charAt(0) == '-') {
			num1 = num1.substring(1);
		}
		if ( num2.charAt(0) == '-') {
			num2 = num2.substring(1);
		}
		String s1= new StringBuffer(num1).reverse().toString();
		String s2= new StringBuffer(num2).reverse().toString();

		int[] m = new int[s1.length() + s2.length()];

		// Go from right to left in num1
		for (int i = 0; i < s1.length(); i++) {
			// Go from right to left in num2
            int c=0;
            int j;
			for (j = 0; j < s2.length(); j++) {
				int x = m[i + j] + c + (s1.charAt(i) - '0') * (s2.charAt(j) - '0');
                m[i+j] = x%10;
                c=x/ 10;
			}
            if(c!=0) m[i+j]=c;
		}
        
        String ans= "";
        for(int i = m.length-1;i>=0; i--) {
            if(ans=="" && m[i]==0) continue;
            ans +=m[i];
        }
        if(sign) {
            // System.out.println("-"+ans); 
            return "-"+ans;
        }

        // System.out.print(ans);
        if(ans=="") return "0";
        return ans;
    }

	public static void main(String[] args)
	{
        Scanner sc = new Scanner(System.in);
        
		String num1 = sc.next();
		String num2 = sc.next();

        System.out.println(multiply(num1,num2));
        
	
	}
}
