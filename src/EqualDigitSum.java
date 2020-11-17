import java.util.HashMap;

public class EqualDigitSum {

  // https://medium.com/@molchevsky/numbers-with-equal-digit-sum-c8a7e01ad7db
  public static void main(String[] args) {
    int [] arr =  new int[] {51, 17, 71, 42};
    int [] arr1 = new int[] {51, 32, 43};
    int [] arr2 = new int[] {42, 33, 60};
    System.out.println(solution(arr2));
  }

  public static int digit_sum(int num) {
    int sum = 0;
    while (num > 0) {
      sum += num % 10;
      num /= 10;
    }
    return sum;
  }

  public static int solution(int[] a) {
    HashMap<Integer, Integer> sumMap = new HashMap<>();
    int maxSum = 0;
    for (int i = 0; i < a.length; i++) {
      int sum = digit_sum(a[i]);
      if (!sumMap.containsKey(sum)) {
        sumMap.put(sum, a[i]);
      } else {
        int currentNum = sumMap.get(sum);
        maxSum = Math.max(maxSum, a[i] + currentNum);
        sumMap.put(sum, Math.max(a[i], currentNum));
      }
    }
    return maxSum > 0 ? maxSum : -1;
  }
}
