import java.util.Arrays;

public class Anagram {

  public static void main(String [] args) {
    String [] test = new String[]{"oy", "yo"};
    System.out.println(isAnagram("MUMM", "MMMM"));
  }

  public static boolean isAnagram(String str1, String str2) {
    int [] charsCount = new int [128];
    if (str1.length() != str2.length()) {
      return false;
    }

    for(int i = 0; i < str1.length(); i ++) {
      charsCount[str1.charAt(i) - 'A'] ++;
    }

    for(int i = 0; i < str1.length(); i ++) {
      charsCount[str2.charAt(i) - 'A'] --;
    }

    for(int i = 0; i < str1.length(); i ++) {
      if(charsCount[str2.charAt(i) - 'A'] < 0) {
        return false;
      }
    }
    return true;
  }

}
