import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://www.geeksforgeeks.org/rearrange-odd-and-even-values-in-alternate-fashion-in-ascending-order/
public class EvenOddArrangement {

  public static void main(String [] args) {
    int [] arr =  {1, 3, 2, 5, 4, 7, 10};
    int [] arr2 = {9, 8, 13, 2, 19, 14};
    // output 1, 2, 3, 4, 5, 10, 7
   System.out.println(Arrays.toString(solution(arr2)));
  }

  public static int [] solution(int [] arr) {
    Arrays.sort(arr);
    boolean isEven = arr[0] % 2 == 0;
    List<Integer> even = new ArrayList<>();
    List<Integer> odd = new ArrayList<>();


    for (int i = 0; i < arr.length; i ++) {
      if (arr[i] % 2 == 0)
        even.add(arr[i]);
      else
        odd.add(arr[i]);
    }
     int start = 0;
     int [] result = new int[arr.length];
     int evenIndex = 0;
     int oddIndex = 0;

     while (start < arr.length) {
       if (isEven) {
         result[start] = even.get(evenIndex);
         start ++;
         evenIndex ++;
         isEven = false;
       }else {
         result[start] = odd.get(oddIndex);
         start ++;
         oddIndex ++;
         isEven = true;
       }
     }

    return result;
  }

}
