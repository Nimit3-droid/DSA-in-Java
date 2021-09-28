import java.util.*;
class Job{
    int start, end, profit;
    Job(int start, int end, int profit){
        this.start = start;
        this.end = end;
        this.profit =profit;
    }
}

public class WeightedJobScheduling {
    //TC:n*2^n
    public static int findNonConflitingIndex(Job jobs[],int n){
        //use binary search to reduce Tc 
        int stCurr=jobs[n-1].start;
        for(int i=n-1;i>=0;i--){
            if(jobs[i].end<=stCurr){
                return i;
            }
        }
        return -1;

        // using BS:
        // searchRange= 0 To n-1
        // condition = if(jobs[i].end<=stCurr) =>  return i
        //(1 2),(1 4) (2 5) key => (2,5) -> key= job[i-1].start
    }
    public static int binarySearch(Job jobs[],int n){
        int key=jobs[n-1].start;
        int left=0;
        int right=n-1;
        while(left<=right){
            int mid=left + (right-left)/2;
            if(jobs[mid].end<=key){
                if(jobs[mid+1].end<=key){
                    left=mid+1;
                }else 
                    return mid;
            }else{
                right=mid-1;
            }
        }
        return -1;
    }
    public static int recursion(Job jobs[],int n,int dp[]){
        if(n==1){
            dp[1]=jobs[0].profit;
            return jobs[0].profit;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int includeProfit=jobs[n-1].profit;
        // int nonConflitingprogitIndex=findNonConflitingIndex(jobs,n);
        int nonConflitingprogitIndex=binarySearch(jobs,n);
        if(nonConflitingprogitIndex!=-1){
            if(dp[nonConflitingprogitIndex+1]!=-1){
                includeProfit+=dp[nonConflitingprogitIndex+1];
            }else{
                int x=recursion(jobs,nonConflitingprogitIndex+1,dp);
                dp[nonConflitingprogitIndex+1]=x;
                includeProfit+=x;
            }

        }
        
        return dp[n]= Math.max(dp[n-1]!=-1?dp[n-1]:recursion(jobs,n-1,dp),includeProfit);
        
    }
    public static int weigthtedSchedule(Job jobs[],int n,int dp[]){
        Arrays.sort(jobs,new Comparator<Job>(){
            @Override
            public int compare(Job job1,Job job2){
                return job1.end - job2.end;
            }
        });
        return recursion(jobs,n,dp);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        Job jobs[]=new Job[n];
        for(int i=0; i<n; i++){
            jobs[i]=new Job(sc.nextInt(),sc.nextInt(),sc.nextInt());
        }
        
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        dp[0]=0;
        weigthtedSchedule(jobs,n,dp);
        System.out.println(dp[n]);
    }
}
