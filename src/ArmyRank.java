import java.util.HashSet;

public class ArmyRank {

  // https://medium.com/@onexlab.io/in-the-army-each-soldier-has-an-assigned-rank-codility-4d4d33b43dd5
  public static int rank(int[] ranks) {
    HashSet<Integer> reportingRanks = new HashSet<>();
    for (int i = 0; i < ranks.length; i ++) {
      reportingRanks.add(ranks[i]);
    }

    int sum = 0 ;

    for (int i = 0; i < ranks.length; i ++) {
      if (reportingRanks.contains(ranks[i] + 1)) {
        sum ++;
      }
    }
    return sum;
  }
}
