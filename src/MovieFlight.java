import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MovieFlight {

  public static void main(String[] args) {
    System.out.println(getMatchingSum(new int[] {2, 3, 4, 8, 6}, 10));
  }

  public static boolean canTwoMoviesFillFlight(int[] movieLengths, int flightLength) {

    // movie lengths we've seen so far
    Set<Integer> movieLengthsSeen = new HashSet<>();

    for (int firstMovieLength : movieLengths) {

      int matchingSecondMovieLength = flightLength - firstMovieLength;
      if (movieLengthsSeen.contains(matchingSecondMovieLength)) {
        return true;
      }

      movieLengthsSeen.add(firstMovieLength);
    }

    // we never found a match, so return false
    return false;
  }

  public static boolean getMatchingSum(int[] A, int sum) {
    Map<Integer, Integer> sums = new HashMap<>();
    for (int num : A) {
      int diff = sum - num;
      if(sums.containsKey(diff)) {
        if(sums.get(diff) == num) {
          return true;
        }
      }else {
        sums.put(num, diff);
      }

    }
    return false;
  }
}
