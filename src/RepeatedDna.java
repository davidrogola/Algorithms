import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RepeatedDna {

  public static void main(String [] args) {
    System.out.println(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT").size());
  }

  public static List<String> findRepeatedDnaSequences(String s) {
    HashMap<String, Integer> seen = new HashMap<>();
    List<String> result = new ArrayList<>();
    int i = 0;
    while(i + 10 <= s.length()) {
      String strSub = s.substring(i, i++ + 10);
      seen.put(strSub, seen.getOrDefault(strSub, 0) + 1);

      if (seen.get(strSub) == 2) {
        result.add(strSub);
      }
    }
    return result;
  }
}
