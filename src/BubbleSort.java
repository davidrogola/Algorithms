import java.util.Arrays;

public class BubbleSort {

  public static void main(String[] args) {
    int [] arr = new int [] {5, 3, 8, 11, 18, 15};
    bubbleSort(arr);
    System.out.println(Arrays.toString(arr));
  }

  public static int[] bubbleSort(int[] array) {
    while (!isSorted(array)) {
      for (int i = 1; i < array.length; i ++) {
        if (array[i - 1] > array[i]) {
          swap(array, i, i -1);
        }
      }
    }
    return array;
  }

  public static void swap(int[] array, int fromIdx, int toIdx) {
    int from  = array[fromIdx];
    array[fromIdx] = array[toIdx];
    array[toIdx] = from;
  }

  public static boolean isSorted(int [] array) {
    for (int i = 1; i < array.length; i ++) {
      if (array[i -1] > array[i]) {
        return false;
      }
    }
    return true;
  }
}
