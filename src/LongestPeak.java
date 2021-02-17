public class LongestPeak {

  public static void main(String [] args) {
    System.out.println(longestPeak(new int[] {0, 2, 1, 5}));
  }
  public static int longestPeak(int[] array) {
    int longestPeak = 0;
    for(int i = 1; i < array.length -1; i++) {
      boolean isPeak = array[i] > array[i -1] && array[i] > array[i + 1];
      if(!isPeak) {
        continue;
      }
      int currentPeak = 0;
      int leftIdx = i - 2;
      while(leftIdx >= 0 && array[leftIdx] < array[leftIdx + 1]) {
        leftIdx --;
      }

      int rightIdx = i + 2;
      while(rightIdx < array.length && array[rightIdx] < array[rightIdx - 1]) {
        rightIdx ++;
      }
      currentPeak = rightIdx - leftIdx - 1;
      longestPeak = Math.max(longestPeak, currentPeak);

    }

    return longestPeak;
  }

}
