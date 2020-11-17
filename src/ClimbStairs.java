import com.sun.deploy.util.ArrayUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClimbStairs {

  public static void main(String [] args) {
    int [] arr = new int[] {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};

    int [] copy = Arrays.copyOfRange(arr, 0, 5);
     System.out.println(Arrays.toString(copy));
     System.out.println(minCostClimbingStairs(new int[] {1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
  }

  public static int climbStairs(int n) {
    int[] memo = new int[n + 1];
    return climb_Stairs(0, n, memo);
  }

  public static  int climb_Stairs(int i, int n, int[] memo) {
    if (i > n) {
      return 0;
    }
    if (i == n) {
      return 1;
    }
    if (memo[i] > 0) {
      return memo[i];
    }
    memo[i] = climb_Stairs(i + 1, n, memo) + climb_Stairs(i + 2, n, memo);
    return memo[i];
  }

  public static int climbStairsDP(int n) {
    if(n==1) {
      return 1;
    }
    int [] dp = new int[n + 1];
    dp[1] = 1;
    dp[2] = 2;

    for(int i = 3; i <=n; i ++ ) {
      dp[i] = dp[i-1] + dp[i-2];
    }
    return dp[n];
  }

  public static int minCostClimbingStairs(int [] cost) {
    int len = cost.length;
    int [] dp = new int[cost.length];
    dp[0] = cost[0];
    dp[1] = cost[1];
    for (int i = 2; i < len; i++ ) {
      dp[i] += Math.min(dp[i - 1], dp[i - 2]) + cost[i];
    }

    return Math.min(dp[len - 1], dp[len -2]);
  }

  public int minCostClimbingStairsV2(int[] cost) {
    int f1 = 0, f2 = 0;
    for (int i = cost.length - 1; i >= 0; --i) {
      int f0 = cost[i] + Math.min(f1, f2);
      f2 = f1;
      f1 = f0;
    }
    return Math.min(f1, f2);
  }
}
