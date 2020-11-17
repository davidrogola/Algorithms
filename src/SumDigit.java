public class SumDigit {

  public static void main(String [] args) {
    // "10 The 55is 108 seCONNd4 A 10 test20 1000yes yrttt30000"
   //System.out.println(sumChars("67 400 009"));
   System.out.println(infString("abcd", "abcde"));
    System.out.println(infString("ghijk", "ghijkghijkiiqw"));


  }

  public static int sumChars(String word) {
    int sum = 0;
    int n = word.length();
    for (int i = 0; i < n; i ++) {
      while (i < n && (Character.isLetter(word.charAt(i)))) {
        i++;
      }

      StringBuilder strNum = new StringBuilder();
      while (i < n && Character.isDigit(word.charAt(i))) {
        strNum.append(word.charAt(i));
        i++;
      }
      if (!strNum.toString().equals(""))
      sum += Integer.parseInt(strNum.toString());
    }
    return sum;
  }

  public static String infString(String a, String b) {
    int lenA = a.length();
    int lenB = b.length();
    if (lenA == lenB && a.equals(b)) {
        return "YES";
    }
    boolean matches = false;
    for (int i = 0; i < lenB; i ++) {
      matches = i + lenA <= lenB && b.substring(i, lenA + i).equals(a);
       i += lenA - 1;
    }
    return matches ? "YES" : "NO";
  }

}
