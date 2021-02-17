import java.util.Arrays;
import java.util.stream.IntStream;

public class LexographicalySmallestStr {

  // https://molchevskyi.medium.com/best-solutions-for-microsoft-interview-tasks-lexicographically-smallest-string-fc7c0a3661fe

  public static void main(String [] args) {
    System.out.println(solution("abczd"));
  }

  public static String solution(String str) {
    char [] strChars = str.toCharArray();
    for (int i = 0; i < str.length(); i ++) {
      if (strChars[i] > strChars[i + 1]) {

        strChars[i] = strChars[i+1];
        break;
      }
    }
    return new String(strChars);
  }

}
