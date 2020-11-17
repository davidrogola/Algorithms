import java.util.Arrays;
import java.util.HashMap;

public class SameHeight {
  public static void main(String [] args) {
    System.out.println(solution(new int[] {5,2,1}));
  }

  public static int solution(int [] H) {
    Arrays.sort(H);
    int count = 0;
    int minimum  = Integer.MAX_VALUE;
    HashMap<Integer, Integer> heightCount = new HashMap<>();
    for (int i = 0; i < H.length; i ++) {
      minimum = Math.min(minimum, H[i]);
      heightCount.put(H[i], heightCount.getOrDefault(H[i], 0) + 1);
    }

    for (int i = 1; i < H.length; i ++) {
      if (H[i - 1] > H[i]) {
        H[i-1] = H[i];
        count++;
        int c = heightCount.get(H[i]);
        if (H[i] != minimum)
           count += c;
        heightCount.put(H[i], c+ 1);
      } else if (H[i - 1] < H[i]) {
        H[i] = H[i-1];
        count ++;
        int c = heightCount.get(H[i -1]);
        if (H[i] != minimum)
         count += c;
        heightCount.put(H[i - 1], c+ 1);
      }
    }
    return count;
  }

}
