import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoinChange {
   public static void main(String [] args) {
     Object [] arr = new Object [] {5, 2, new Object []{7, -1}, 3, new Object[] {6, new Object []{-13, 8}, 4}};
     System.out.println(productSum(arr));
     System.out.println(numberOfWaysToMakeChange( 6, new int[]{1,5, 6, 2}));
   }

  public static int numberOfWaysToMakeChange(int n, int[] denoms) {
    int [] ways = new int [n + 1];
    ways[0] = 1;
    for(int denom : denoms) {
      for (int i = 1; i <= n; i ++) {
         if (denom <= i) {
            ways[i] += ways[i - denom];
         }
      }
    }
    return ways[n];
  }

  public static int productSum(Object [] array) {
    // Write your code here.
    return sumHelper(array, 1);
  }

  public static int sumHelper(Object [] array, int multiplier) {
    int sum = 0;
    System.out.println(sum + "MUlt");
    for(Object obj : array) {
      if(obj instanceof Object []) {
        sum +=  sumHelper((Object[]) obj, multiplier + 1);
      } else {
        sum += (int) obj;
      }
    }
    return sum * multiplier;
  }
}
