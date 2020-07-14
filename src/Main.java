public class Main {

  public static void main(String[] args) {
    //System.out.println(fibonacci(3));
    String word = "madam";
    System.out.println(isPalindrome(word,0,word.length() - 1));

  }

  public static int fibonacci(int n) {
    if (n <= 2) {
      return 1;
    }
    return fibonacci(n - 1) + fibonacci(n - 2);
  }

  public static boolean isPalindrome(String word, int startIndex, int endIndex) {
    int n = word.length();
    if (startIndex >= n) {
      return true;
    }
    if (word.charAt(startIndex) != word.charAt(endIndex)) {
      return false;
    }
    startIndex++;
    endIndex--;
    return isPalindrome(word, startIndex, endIndex);
  }




}
