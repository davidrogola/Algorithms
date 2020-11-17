import static java.lang.System.out;

import java.util.Arrays;
import java.util.HashMap;

public class Main {

  public static void main(String[] args) {
    out.println(houseRobber(new int []{3, 10, 3 , 5 , 2}));
    fibDriver(5);
    String word = "madam";
    out.println(isPalindrome(word,0,word.length() - 1));
  }

  public static int fibonacci(int n, HashMap<Integer,Integer> map) {
    if (map.containsKey(n)) {
      return map.get(n);
    }
    map.put(n, fibonacci(n - 1, map) + fibonacci(n - 2,map));
    return map.get(n);
  }

  public static void fibDriver(int n) {
    HashMap<Integer, Integer> map = new HashMap<>();
    map.put(1,1);
    map.put(2,2);
    out.println(fibonacci(n,map));
  }

  public static int fibDp(int n) {
    int n1 = 1;
    int n2 = 1;
    for (int i = 2; i < n + 1; i ++) {
      int temp = n1 + n2;
      n1 = n2;
      n2 = temp;
    }
    out.println(n2);
    return n2;
  }
   // 3, 10, 3 , 1 , 2
  public static int houseRobber(int [] houses) {
    int n1 = 0;
    int n2 = 0;

    for (int val : houses) {
      int max = Math.max(n2 , val + n1);
      n1 = n2;
      n2 = max;
    }
    return n2;
  }

  public static boolean isPalindrome(String word, int startIndex, int endIndex) {
    int n = word.length();
    if (startIndex >= n) {
      return true;
    }
    if (word.charAt(startIndex) != word.charAt(endIndex)) {
      return false;
    }
    startIndex++;
    endIndex--;
    return isPalindrome(word, startIndex, endIndex);
  }

}
