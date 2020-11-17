public class MinDeletionCost {
// https://leetcode.com/problems/minimum-deletion-cost-to-avoid-repeating-letters/submissions/
  public static void main(String [] args) {
  }

  public int minCost(String s, int[] cost) {
    int minCost = 0;
    char pChar = '*';
    int pMin = 0;

    for(int i = 0; i < s.length(); i++) {
      if(s.charAt(i) == pChar) {
        if(pMin < cost[i]) {
          minCost += pMin;
          pMin = cost[i];
        }else {
          minCost+= cost[i];
        }
      } else {
        pChar = s.charAt(i);
        pMin = cost[i];
      }
    }

    return minCost;
  }



}
