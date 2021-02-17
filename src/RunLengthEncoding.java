import java.util.HashMap;

public class RunLengthEncoding {

  public static void main(String [] args) {
    System.out.println(solution("************^^^^^^^$$$$$$%%%%%%%!!!!!!AAAAAAAAAAAAAAAAAAAA"));
  }

  public static String solution(String string) {
    System.out.println(string.indexOf("^"));
    HashMap<Character, Integer> occuranceCount = new HashMap();
    for(char c : string.toCharArray()) {
      occuranceCount.put(c, occuranceCount.getOrDefault(c, 0) + 1);
    }
    StringBuilder builder = new StringBuilder();
    int max = 9;
    for(char c : occuranceCount.keySet()) {
      int count = occuranceCount.get(c);
      if(count >= 10) {
        int diff = count - max;
        builder.append(String.format("%c%d%c%d",c,max,c,diff));
      }else {
        builder.append(String.format("%c%d",c,count));
      }
    }
    return builder.toString();
  }

  }


