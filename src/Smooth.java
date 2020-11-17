import java.util.ArrayList;
import java.util.List;

public class Smooth {

  public static void main(String [] args) {
    System.out.println(isSmooth("4 1 1 8 2"));
  }

  public static String isSmooth(String values) {
    String[] spiltNums = values.trim().split(" ");
    int n = Integer.parseInt(spiltNums[0]);
    List<Integer> nums = new ArrayList<>();
    for (int i = 0; i < spiltNums.length; i++) {
      nums.add(Integer.parseInt(spiltNums[i]));
    }
    String smooth = "NO";
    for (int i = 0; i < n; i ++) {
      if((i + 1) <= n && Math.abs(nums.get(i) - nums.get(i +1)) <= 1) {
        smooth = "YES";
      }
    }
    return smooth;
  }
}
