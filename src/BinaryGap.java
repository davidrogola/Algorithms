public class BinaryGap {
 // https://leetcode.com/problems/binary-gap/
  public static void main(String [] args) {
    System.out.println(binaryGap(529));
  }

  public static int binaryGap(int N) {
    String binary = Integer.toBinaryString(N);
    int max = 0;
    int l = 0;
    int r = 1;
    char [] chars = binary.toCharArray();
    while (r < chars.length) {
      if (chars[r] == '0') {
        r ++;
        continue;
      }
      if (chars[r] == chars[l]) {
        max = Math.max(Math.abs(l - r), max);
        l = r;
        r++;
      } else {
        l ++;
      }
    }
    return max;
  }

}
