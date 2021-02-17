import java.util.Comparator;
import java.util.PriorityQueue;

public class MinDeletions {
 // https://molchevskyi.medium.com/best-solutions-for-microsoft-interview-tasks-min-deletions-to-obtain-string-in-right-format-37a3365ce348
  public static void main(String [] args) {
    System.out.println(getDeletionsToGetUniqueFrequencyOfEachChar("example")); // abbbcccdddddeeeeee
    //System.out.println(getMinDeletions("AAAAAAAAAAAAAAAAAAAAAAABAAAAAAAAAAABAAAAAABBBBBBBBBBBBBBBBBBBABBB"));
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

//https://molchevskyi.medium.com/best-solutions-for-microsoft-interview-tasks-min-deletions-to-make-frequency-of-each-letter-unique-16adb3ec694e
  public static int getDeletionsToGetUniqueFrequencyOfEachChar(String s) {
    int count = 0;
    int [] occurances = new int[26];
    for (char c : s.toCharArray()) {
      occurances[c - 'a'] ++;
    }
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new IntegerComparator());
    for (int i = 0; i < 26; i ++) {
     if (occurances[i] > 0) {
       priorityQueue.add(occurances[i]);
     }
    }

    while (!priorityQueue.isEmpty()) {
      int mostFrequent = priorityQueue.poll();

      if (priorityQueue.isEmpty()) {
        return count;
      }

      if (mostFrequent == priorityQueue.peek()) {
        if (mostFrequent >= 1) {
          priorityQueue.add(mostFrequent - 1);
          count ++;
        }
      }
    }

    return count;
  }

  public static class IntegerComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
      if (o1 == o2)
        return 0;
      return o1 < o2 ? 1 : -1;
    }
  }
}
