
import java.util.*;

public class BestTrade {

  public static void main(String[] args) {
    System.out.println(trade_dp(new int[] {10, 22, 5, 75, 65, 80}));
  }


  public static int trade(int[] prices) {
    if (prices.length == 1) {
      return 0;
    }
    int n = prices.length;
    int fCount = n / 2;
    int sCount = n - fCount;

    int[] firstHalf = Arrays.copyOfRange(prices, 0, fCount);
    int[] secondHalf = Arrays.copyOfRange(prices, sCount, n);
    int profit = getMax(secondHalf) - getMin(firstHalf);
    return Math.max(Math.max(trade(firstHalf), trade(secondHalf)), profit);
  }

  public static int getMax(int[] arr) {
    int max = arr[0];
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] > max) {
        max = arr[i];
      }
    }
    return max;
  }

  public static int getMin(int[] arr) {
    int min = arr[0];
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] < min) {
        min = arr[i];
      }
    }
    return min;
  }

  public static int trade_dp(int[] prices) {
    int n = prices.length;
    int trades = 2;
    int[] best_trades = new int[n];
    best_trades[0] = 0;
    int best_profit = 0;
    int sell_day = 0;
    int profit;
    int totalProf = 0;

    for (int i = 1; i < n && trades > 0; i++) {
      if (prices[i] < prices[best_trades[i - 1]]) {
        best_trades[i] = i;
      } else {
        best_trades[i] = best_trades[i - 1];
      }
      profit = prices[i] - prices[best_trades[i]];
      if (profit > best_profit) {
        best_profit = profit;
        totalProf += profit;
        sell_day = i;
        trades --;
      }
    }
    System.out.println(sell_day);
    return totalProf;
  }


}
