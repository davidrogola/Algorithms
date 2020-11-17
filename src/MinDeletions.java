public class MinDeletions {
 // https://molchevskyi.medium.com/best-solutions-for-microsoft-interview-tasks-min-deletions-to-obtain-string-in-right-format-37a3365ce348
  public static void main(String [] args) {
    System.out.println(getMinDeletions("AAAAAAAAAAAAAAAAAAAAAAABAAAAAAAAAAABAAAAAABBBBBBBBBBBBBBBBBBBABBB"));
  }

  public static int getMinDeletions(String s) {
   char CHAR_A = 'A';
   int countOfB = 0;
   int min_deletions = 0;

   for (char c : s.toCharArray()) {
     if (c == CHAR_A) {
       min_deletions = Math.min(countOfB, min_deletions + 1);
     }else {
       countOfB ++;
     }
   }

   return min_deletions;
  }
}
