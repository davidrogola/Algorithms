import java.util.Arrays;

public class JumpGame {


  public static void main(String [] args) {
    System.out.println(canJump(new int[] {3,2,1,0,4}));
  }

  public static boolean canReachDFS(int[] arr, int start) {
   if (start >= 0 && start < arr.length && arr[start] >= 0) {
       if (arr[start] == 0) {
         return true;
       }
       arr[start] = -arr[start];
     return canReachDFS(arr, arr[start] + start) || canReachDFS(arr,  start - arr[start]);
   }
    return false;
  }

  public static boolean canJump(int [] nums) {
   return jumpHelper(0, nums);
  }

  // 3,2,1,0,4
  private static  boolean jumpHelper(int position, int [] nums) {
    if (position == nums.length - 1) {
      return true;
    }

    int furthestJump = Math.min(position + nums[position], nums.length - 1);
    for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
      if (jumpHelper(nextPosition, nums)) {
        return true;
      }
    }

    return false;
  }

  enum Status {
    GOOD, BAD, UNKNOWN
  }

  class Solution {
    Status[] memo;
    public boolean canJump(int[] nums) {
      memo = new Status[nums.length];
      Arrays.fill(memo, Status.UNKNOWN);
      memo[nums.length - 1] = Status.GOOD;
      return canJumpHelper(0, nums);
    }

    public boolean canJumpHelper(int position, int [] nums) {
      if(memo[position] != Status.UNKNOWN) {
        return memo[position] == Status.GOOD;
      }
      int furthestJump = Math.min(position + nums[position], nums.length - 1);
      for(int nextJump = position + 1; nextJump <= furthestJump; nextJump++) {
        if(canJumpHelper(nextJump, nums)) {
          memo[position] = Status.GOOD;
          return true;
        }
      }
      memo[position] = Status.BAD;
      return false;
    }

  }
}
