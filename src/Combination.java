import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Combination {

  public static void main(String[] args) {
    List<Integer> test = Arrays.asList(1,2,3);
    List<List<Integer>> permutations = new ArrayList<>();
    combinationHelper(test, new ArrayList<>(),permutations);
  }

  public static void combinationHelper(List<Integer> array, List<Integer> currentPerm,
      List<List<Integer>> permutations) {
    if (array.size() == 0 && currentPerm.size() > 0) {
      permutations.add(currentPerm);
    } else {
      for (Integer num : array) {
        List<Integer> newArray = new ArrayList<>(array);
        newArray.remove(num);
        List<Integer> newPerm = new ArrayList<>(currentPerm);
        newPerm.add(num);
        combinationHelper(newArray, newPerm, permutations);
      }
    }
  }



}
