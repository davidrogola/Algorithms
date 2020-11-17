import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PascalsTriangle {

  public static void main(String [] args) {
    System.out.println(getRow(3));
  }


  public static List<Integer> getRow(int rowIndex) {
   List<Integer> rowValues = new ArrayList<>();
   for (int r = 0; r <= rowIndex; r ++ ) {
       if (r == 0) {
         rowValues = Collections.singletonList(1);
         continue;
       }
       if (r == 1) {
         rowValues = Arrays.asList(1,1);
         continue;
       }
       rowValues = pascalHelper(rowValues, r);
   }
   return rowValues;
  }

  public static List<Integer> pascalHelper(List<Integer> previousRow, int rowIndex) {
      List<Integer> currentRowList = new ArrayList<>();
      currentRowList.add(1);
    for (int i = 1; i < rowIndex; i ++) {
        int val = previousRow.get(i - 1) + previousRow.get(i);
        currentRowList.add(val);
      }
    currentRowList.add(1);
    return currentRowList;
  }

}
