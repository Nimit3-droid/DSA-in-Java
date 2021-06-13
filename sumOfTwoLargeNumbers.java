import java.util.Scanner;

public class sumOfTwoLargeNumbers {

    public static String FindBigSum(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        if (n2 > n1) {
            String temp = s1;
            s1 = s2;
            s2 = temp;
            n1 = s1.length();
            n2 = s2.length();
        }
        // int diff = n1 - n2;
        int carry = 0;
        int i = n1 - 1, j = n2 - 1;
        String answer = "";
        while (j >= 0 && i >= 0) {
            int sum = Integer.parseInt(s1.charAt(i) + "") + Integer.parseInt(s2.charAt(j) + "") + carry;
            answer = Integer.toString(sum % 10) + answer;
            carry = sum / 10;
            // diff--;
            i--;
            j--;
        }

        for (int leftOver = n1 - n2 - 1; leftOver >= 0; leftOver--) {
            int sum = Integer.parseInt(s1.charAt(leftOver) + "") + carry;
            answer = Integer.toString(sum % 10) + answer;
            carry = sum / 10;
        }

        if (carry > 0) {
            answer = Integer.toString(carry) + answer;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next(),str2 = sc.next();
        // String str1 = "1234", str2 = "456";
        System.out.println(FindBigSum(str1, str2));

    }
}
