import java.util.*;

public class nextGreatetInteger {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        nextGreatetInt(arr, n);
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        sc.close();
    }

    public static void nextGreatetInt(int[] arr, int n) {
        if (n <= 1)
            return ;
        int i = 0;
        for (i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                break;
            }
        }
        if (i < 0) {
            reverse(arr, 0, n - 1);
            return ;
        }
        for (int j = n - 1; j >= i; j--) {
            if (arr[j] > arr[i]) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                break;
            }
        }
        reverse(arr, i + 1, n - 1);
        return ;
    }

    private static void reverse(int[] arr, int l, int r) {
        while (l <= r) {
            int t = arr[l];
            arr[l] = arr[r];
            arr[r] = t;
            l++;r--;
        }
    }
}
