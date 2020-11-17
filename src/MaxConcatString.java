//https://www.youtube.com/watch?v=pD3cHFNyW2I

public class MaxConcatString {
  public static void main (String [] args) {
    System.out.println(isUnique("aab"));
  }

  public static boolean isUnique(String str) {
    int [] counts = new int[26];
    for (char c : str.toCharArray()) {
      if(counts[c - 'a']++ > 0) {
        return false;
      }
    }
    return true;
  }

}
