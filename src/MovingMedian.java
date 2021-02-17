import java.util.Arrays;

public class MovingMedian {

public static void main(String [] args) {

  int A[] = { 3, 1, 3, 5, 10, 6, 4, 3, 1 };  // 1,2,3,5,6,6,4,3
  int B[] = { 5, 2, 4, 6 };
  int C[] = { 3, 0, 0, -2, 0, 2, 0, -2 };
//
//  cout << MovingMedian(A, sizeof(A) / sizeof(A[0])) << endl; // 1,2,3,5,6,6,4,3
//  cout << MovingMedian(B, sizeof(B) / sizeof(B[0])) << endl; // 2,3,4
//  cout << MovingMedian(C, sizeof(C) / sizeof(C[0])) << endl; // 0,0,0,0,0,0,0

  System.out.println(movingMedian(C));
}

public static String movingMedian(int [] arr) {
  int windowSize = arr[0];
  int [] vals = Arrays.copyOfRange(arr, 1, arr.length);
  int [] medians = new int[vals.length];

  int startIdx = 0;
  for (int i = 0; i < vals.length; i ++) {
    if ((i - startIdx) + 1 == windowSize + 1) {
      startIdx += 1;
    }
   int [] currentWindow =  Arrays.copyOfRange(vals, startIdx, i + 1);
   medians[i] = calculateMedian(currentWindow);

  }
  return Arrays.toString(medians);
}

public static int calculateMedian(int [] subArr) {
  Arrays.sort(subArr);
  int n = subArr.length;
  if(n == 1) {
    return subArr[0];
  }
  int midIdx = n / 2;
  if (n % 2 == 0) {
    return (subArr[midIdx] + subArr[midIdx - 1]) / 2;
  }
  return subArr[midIdx];
}



}
