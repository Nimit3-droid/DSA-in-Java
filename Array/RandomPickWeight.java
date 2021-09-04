import java.util.*;
//microsoft
public class RandomPickWeight {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int weight[]=new int[n];
        for(int i=0; i<n; i++){
            weight[i]=sc.nextInt();
        }
        double weightSum=0;
        for(int w:weight){
            weightSum+=w;
        }
        double probability[]=new double[n];
        for(int i=0; i<n; i++){
            weight[i]+=(i==0?0:weight[i-1]);  //cumulativeSum
            probability[i]=weight[i]/weightSum;
        }
        int answerIndex=0;
        answerIndex= Math.abs(Arrays.binarySearch(probability, Math.random())) - 1;
        System.out.println(answerIndex);
        System.out.println(Math.random());
    }
}

//leetcod solution
// class Solution {

//     Random random;
//     int[] wSums;
    
//     public Solution(int[] w) {
//         this.random = new Random();
//         for(int i=1; i<w.length; ++i)
//             w[i] += w[i-1];
//         this.wSums = w;
//     }
    
//     public int pickIndex() {
//         int len = wSums.length;
//         int idx = random.nextInt(wSums[len-1]) + 1;
//         int left = 0, right = len - 1;
//         // search position 
//         while(left < right){
//             int mid = left + (right-left)/2;
//             if(wSums[mid] == idx)
//                 return mid;
//             else if(wSums[mid] < idx)
//                 left = mid + 1;
//             else
//                 right = mid;
//         }
//         return left;
//     }
// }
