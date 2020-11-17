import java.util.ArrayList;
// https://molchevskyi.medium.com/best-solutions-for-microsoft-interview-tasks-unique-integers-that-sum-up-to-0-5440259a34f9
public class UniqueNumsAddingUpToZero {

  public static void main(String [] args) {
    System.out.println(solution(101).stream().reduce(Integer::sum).get());
  }

  public static ArrayList<Integer> solution(int n) {
    ArrayList<Integer> result = new ArrayList<>();
    int mod = n % 2;
    if (mod > 0) {
      result.add(0);
    }
    int limit = n / 2;
    for (int i = 1; i <= limit; i ++) {
      result.add(i);
      result.add(-i);
    }
    return result;
  }
}
