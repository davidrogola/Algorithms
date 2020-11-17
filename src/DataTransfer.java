import com.sun.deploy.util.ArrayUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class DataTransfer {

  public static void main(String [] args) {
    System.out.println(FindIntersection(new String[] {"1, 3, 9, 10, 17, 18", "-1, 0, 0, 11"}));
  }

  public static String FindIntersection(String[] strArr) {
    String str1 = strArr[0];
    String str2 = strArr[1];

    HashSet<Integer> nums = new HashSet();
    String [] strNum1s = str1.split(",");
    for(int i = 0; i < strNum1s.length; i ++) {
       nums.add(Integer.valueOf(strNum1s[i].trim()));
    }

    String [] strNum2s = str2.split(",");
    StringBuilder builder = new StringBuilder();
    for(int i = 0; i < strNum2s.length; i ++) {
      if(nums.contains(Integer.valueOf(strNum2s[i].trim()))) {
        builder.append(strNum2s[i].trim());
        builder.append(",");
      }
    }
    String result = builder.toString();
    return result.length() > 0 ? result.substring(0, result.length() - 1) : "false";
  }

}
