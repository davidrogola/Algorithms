import java.util.Arrays;

public class FairIndexes {

public static void main(String [] args) {
  int[] A1 = {4,-1,0,3}, B1 = {-2, 5, 0 ,3};
  int[] A2 = {2,-2,-3,3}, B2 = {0,0,4,-4};
  int[] A3 = {4,-1,0,3}, B3 = {-2,6,0,4};
  int[] A4 = {3,2,6}, B4 = {4,1,6};
  int[] A5 = {1,4,2,-2,5}, B5 = {7,-2,-2,2,5};
  System.out.println(getNumOfFairIndexes(A1, B1));
  System.out.println(getNumOfFairIndexes(A2, B2));
  System.out.println(getNumOfFairIndexes(A3, B3));
  System.out.println(getNumOfFairIndexes(A4, B4));
  System.out.println(getNumOfFairIndexes(A5, B5));
}

  private static int getNumOfFairIndexes(int[] A, int[] B) {
    int res = 0, sumA = 0, sumB = 0;
    for(int i=0;i<A.length;i++) {
      sumA += A[i];
      sumB += B[i];
    }
    int tmpA = 0, tmpB = 0;
    for(int i=0;i<A.length-1;i++) {
      tmpA += A[i];
      tmpB += B[i];
      if(sumA == 2 * tmpA && sumB == 2 * tmpB && tmpA == tmpB) {
        res++;
       System.out.println("Sum A" + sumA);
       System.out.println("Temp A" + tmpA);
      }
    }
    return res;
  }

  public static  int getNumberOfFairIndexes(int [] A, int [] B) {
     int n = A.length;
     int count = 0;
     for (int i = 1; i < n; i++) {
     int leftSumA = getSum(Arrays.copyOfRange(A, 0, i));
     int rightSumA = getSum(Arrays.copyOfRange(A, i , n ));

      int leftSumB = getSum(Arrays.copyOfRange(B, 0, i));
      int rightSumB = getSum(Arrays.copyOfRange(B, i   , n ));

       if (leftSumA == rightSumA && leftSumB == rightSumB && leftSumA == leftSumB) {
          count++;
      }
     }

     return count;
  }

  public static int getSum(int [] array) {
    int sum = 0;
    for (int i = 0; i < array.length; i++) {
        sum += array[i];
    }
    return sum;
  }
}
