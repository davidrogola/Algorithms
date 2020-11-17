import java.util.HashSet;

public class LongestSubstringNoRepeatingChars {

  public static void main(String[] args) {
    System.out.println(longestOnes(new int[] {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1},3));
  }

  public static int longestSubstring(String str) {
    int l = 0, r = 0, result = 0;
    HashSet<Character> seen = new HashSet<>();
    while (r < str.length()) {
      if (!seen.contains(str.charAt(r))) {
        result = Math.max(result, r - l + 1);
        seen.add(str.charAt(r));
        r++;
      } else {
        seen.remove(str.charAt(l++));
      }
    }

    return result;
  }

  public static boolean checkInclusion(String s1, String s2) {
    int l = 0, r = 0;

    while (r < s2.length()) {
      while (r - l + 1 != s1.length()) {
        r++;
      }
      if (r + 1 <= s2.length() && equalPermutation(s1, s2.substring(l, r + 1))) {
        return true;
      }
      l++;
    }
    return false;
  }

  public static boolean equalPermutation(String s1, String s2) {
    HashSet<Character> seen = new HashSet<>();
    for (int i = 0; i < s1.length(); i++) {
      seen.add(s1.charAt(i));
    }
    for (int i = 0; i < s2.length(); i++) {
      seen.remove(s2.charAt(i));
    }
    return seen.isEmpty();
  }

  public boolean checkInclusionArr(String s1, String s2) {
    if (s1.length() > s2.length()) {
      return false;
    }
    int[] s1map = new int[26];
    for (int i = 0; i < s1.length(); i++) {
      s1map[s1.charAt(i) - 'a']++;
    }
    for (int i = 0; i <= s2.length() - s1.length(); i++) {
      int[] s2map = new int[26];
      for (int j = 0; j < s1.length(); j++) {
        s2map[s2.charAt(i + j) - 'a']++;
      }
      if (matches(s1map, s2map)) {
        return true;
      }
    }
    return false;
  }

  public boolean matches(int[] s1map, int[] s2map) {
    for (int i = 0; i < 26; i++) {
      if (s1map[i] != s2map[i]) {
        return false;
      }
    }
    return true;
  }

  private static int helper_tail_recursion(int start, int[] ls, int acc) {
    if (start >= ls.length) {
      return acc;
    }
    // this is a tail recursion because the final instruction is the recursive call.
    return helper_tail_recursion(start + 1, ls, acc + ls[start]);
  }

  public static int sum_tail_recursion(int[] ls) {
    if (ls == null || ls.length == 0) {
      return 0;
    }
    return helper_tail_recursion(0, ls, 0);
  }

  public static double myPow(double x, int n) {
    if (n < 0) {
      n = n * -1;
      x = 1 / x;
    }
    return helper(x, x, n);
  }

  public static double helper(double x, double acc, int n) {
    if (n == 1) {
      return acc;
    }
    return helper(x, acc * x, n - 1);
  }

  public static int longestOnes(int[] A, int K) {
    int maxLen = 0;
    int zeros = 0;
    int lo = 0;

    for (int hi = 0; hi < A.length; hi++) {
      zeros += A[hi] == 0 ? 1 : 0;
      if (zeros > K) {
        zeros -= A[lo++] == 0 ? 1 : 0;
      }
      maxLen = hi - lo + 1;
    }
    return maxLen;
  }
}
