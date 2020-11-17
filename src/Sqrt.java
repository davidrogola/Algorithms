import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Sqrt {
 public static void main(String [] args) {
   ArrayDeque<String> test = new ArrayDeque<>();
   test.add("test");
   test.add("test 2");

   while (!test.isEmpty()) {
     System.out.println(test.pop());
   }

   Stack<String> stack = new Stack<>();
   stack.push("test");
   stack.push("test 2");

   while (stack.size() > 0) {
     System.out.println(stack.pop());
   }

   System.out.println(mySqrt(2147395599));
 }

  public static int mySqrt(int x) {
    double left = 1;
    double right = x;

    if(x < 2) {
      return x;
    }

    while(left < right) {
      double mid = left + Math.floor(( right - left) / 2);
      if(mid * mid == x) {
        return (int) mid;
      }else if (mid * mid > x) {
        right = mid;
      }else if (mid * mid < x){
        left = mid + 1;
      }
    }
    return (int) left - 1;
  }

}
