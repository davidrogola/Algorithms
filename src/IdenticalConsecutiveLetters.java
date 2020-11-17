public class IdenticalConsecutiveLetters {
 // https://medium.com/@molchevsky/microsoft-interview-tasks-min-moves-to-make-string-without-3-identical-consecutive-letters-abe61ed51a10
  public static void main(String[] args) {
    System.out.println(solution("AAAAAAAAAAAAAAAAAAAAAAABAAAAAAAAAAABAAAAAABBBBBBBBBBBBBBBBBBBBBB"));
  }

  public static int solution(String letters) {
    int count = 0;
    int currSequence = 0;
    int limit = 3;
    int n = letters.length();
    for (int i = 0; i < n; i++) {
      while ((i + 1 < n) && (letters.charAt(i) == letters.charAt(i + 1))) {
        currSequence++;
        i++;
      }
      count += currSequence / limit;
      currSequence = 0;
    }

    return count;
  }
}
