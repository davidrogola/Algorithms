import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class MaxSubsetSum {
// https://www.hackerrank.com/challenges/max-array-sum/problem
  public static void main(String [] args) {
    String is = "01";
    System.out.println(is.substring(1));
    maxSubsetSum(new int[]{3 ,7, 4,6,5});
  }
  static int maxSubsetSum(int[] arr) {
    if(arr.length == 0) {
      return 0;
    }
    int [] maxSums = new int[arr.length];
    maxSums[0] = Math.max(0, arr[0]);
    if(arr.length == 1) {
      return maxSums[0];
    }
    maxSums[1] = Math.max(maxSums[0], arr[1]);

    for(int i =  2; i < arr.length; i ++) {
      maxSums[i] = Math.max(maxSums[i-1], arr[i] + maxSums[i - 2]);
    }

    return maxSums[arr.length - 1];
  }


}
