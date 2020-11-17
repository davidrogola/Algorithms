public class DutchNationalFlagProblem {
  //
  public static void main(String [] args) {
    int [] result = sortColors(new int[] {2,0,2,1,1,0});
    for (int i = 0; i < result.length; i++) {
      System.out.print(result[i] + ",");
    }
  }

  public static int [] sortColors(int [] colors) {
    int smaller = 0, eq = 0, larger = colors.length - 1;
    while (eq <= larger) {
      if (colors[eq] == 0) {
        swap(colors, smaller, eq);
        eq++; smaller++;
      } else if (colors[eq] == 2) {
        swap(colors, larger, eq);
        --larger;
      } else {
        eq++;
      }
    }

   return colors;
  }

  public static void swap(int [] values, int i, int j) {
     int temp = values[i];
     values[i] = values[j];
     values[j] = temp;
  }
}
