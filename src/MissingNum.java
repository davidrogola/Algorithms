public class MissingNum {
  public static void main(String [] args) {
     System.out.println(firstMissingPositive(new int[] {3, 7, 1, 2, 8, 4, 5, -1 , 0}));
    System.out.println(missingNum(new int[] {3, 7, 1, 8, 4, 5, 6}));

  }

  // Only positive numbers
  public static int missingNum(int [] nums) {
    int sum = 0;
    for (int i = 0; i < nums.length; i ++) {
      sum += nums[i];
    }
    int actual = 0;
    for (int i = 1; i <= nums.length + 1; i ++) {
      actual += i;
    }

    System.out.println(actual);

    //There is exactly 1 number missing
    int n = nums.length + 1;
    int actualSum = (n * (n + 1)) / 2;
    System.out.println(actualSum);
    return actualSum - sum;
  }
  public static int firstMissingPositive(int[] nums) {
    int n = nums.length;

    // 1. mark numbers (num < 0) and (num > n) with a special marker number (n+1)
    // (we can ignore those because if all number are > n then we'll simply return 1)
    for (int i = 0; i < n; i++) {
      if (nums[i] <= 0 || nums[i] > n) {
        nums[i] = n + 1;
      }
    }
    // note: all number in the array are now positive, and on the range 1..n+1

    // 2. mark each cell appearing in the array, by converting the index for that number to negative
    for (int i = 0; i < n; i++) {
      int num = Math.abs(nums[i]);
      if (num > n) {
        continue;
      }
      num--; // -1 for zero index based array (so the number 1 will be at pos 0)
      if (nums[num] > 0) { // prevents double negative operations
        nums[num] = -1 * nums[num];
      }
    }

    // 3. find the first cell which isn't negative (doesn't appear in the array)
    for (int i = 0; i < n; i++) {
      if (nums[i] >= 0) {
        return i + 1;
      }
    }

    // 4. no positive numbers were found, which means the array contains all numbers 1..n
    return n + 1;
  }

}
