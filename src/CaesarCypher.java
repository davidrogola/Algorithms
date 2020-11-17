public class CaesarCypher {
  public static void main(String [] args) {
   // xyz shift 2
    int min =  'a';
    int max = 'z';
    String str = "xyz";
    char [] strChar = str.toCharArray();
    for (int i = 0; i < str.length(); i ++ ) {
      strChar[i] = getNewVal(strChar[i], 2);
    }
    System.out.println(strChar);
  }
  private static char getNewVal(char c, int shift) {
    int newVal = c + shift;
    if (newVal > 'z') {
      newVal = 96 + newVal % 122;
    }
    return (char) newVal;
  }
}
