import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
// https://leetcode.com/problems/minimum-cost-for-tickets/submissions/
public class MinCostTickets {



  public static void  main(String [] args) {
    System.out.println(maximumGap(Arrays.asList(1,5,5,2,6)));
  }

  int[] costs;
  Integer[] memo;
  Set<Integer> dayset;

  public int mincostTickets(int[] days, int[] costs) {
    this.costs = costs;
    memo = new Integer[366];
    dayset = new HashSet();
    for (int d: days) dayset.add(d);

    return dp(1);
  }

  public int dp(int i) {
    if (i > 365)
      return 0;
    if (memo[i] != null)
      return memo[i];

    int ans;
    if (dayset.contains(i)) {
      ans = Math.min(dp(i+1) + costs[0],
          dp(i+7) + costs[1]);
      ans = Math.min(ans, dp(i+30) + costs[2]);
    } else {
      ans = dp(i+1);
    }

    memo[i] = ans;
    return ans;
  }

  public static int maximumGap(final List<Integer> list) {
    int size = list.size();

    if (size <= 1) {
      return -1;
    }

    if (list.get(0) <= list.get(size - 1)) {
      return size - 1;
    }

    // Max between list[0:size-1] and list[1:size]
    return Math.max(
        maximumGap(list.subList(0, size - 1)),
        maximumGap(list.subList(1, size))
    );
  }
}
