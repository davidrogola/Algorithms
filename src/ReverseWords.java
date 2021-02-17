import java.util.Arrays;

public class ReverseWords {

  public static void main(String [] args) {
    char [] chars = new char[] { 't', 'h', 'e', ' ', 'e', 'a', 'g', 'l', 'e', ' ',
        'h', 'a', 's', ' ', 'l', 'a', 'n', 'd', 'e', 'd' };
    reverseWords(chars);
    //System.out.println(chars);
    System.out.println(longestSubstringWithout3ContigousLetters("aabbaabbaabbaaaaaaabbaabbaabbaabbaabbaabbaa"));
  }

  public static void reverseWords(char[] message) {

    // first we reverse all the characters in the entire message array
    // this gives us the right word order
    // but with each word backward
    reverseCharacters(message, 0, message.length - 1);

    // now we'll make the words forward again
    // by reversing each word's characters

    // we hold the index of the *start* of the current word
    // as we look for the *end* of the current word
    int currentWordStartIndex = 0;
    for (int i = 0; i <= message.length; i++) {

      // found the end of the current word!
      if (i == message.length || message[i] == ' ') {

        // if we haven't exhausted the array, our
        // next word's start is one character ahead
        reverseCharacters(message, currentWordStartIndex, i - 1);
        currentWordStartIndex = i + 1;
      }
    }
  }

  private static void reverseCharacters(char[] message, int leftIndex, int rightIndex) {

    // walk towards the middle, from both sides
    while (leftIndex < rightIndex) {

      // swap the left char and right char
      char temp = message[leftIndex];
      message[leftIndex] = message[rightIndex];
      message[rightIndex] = temp;
      leftIndex++;
      rightIndex--;
    }
  }

  // https://molchevskyi.medium.com/best-solutions-for-microsoft-interview-tasks-5a738a6f8ba9
//  Input: "aabbaaaaabb"
//  Output: "aabbaa"
  // aabbaaaaabbaabb
  private static String longestSubstringWithout3ContigousLetters(String sub) {
    int maxLen = 0;
    int startMaxLen = 0;

    int count = 0;
    int start = 0;

    for (int i = 1; i < sub.length(); i ++) {
      if (sub.charAt(i) == sub.charAt(i - 1)) {
        count ++;
      } else {
        count = 1;
      }

      if (count <= 2) {
        if ((i - start) + 1 > maxLen) {
           maxLen = (i - start) + 1;
           startMaxLen = start;
        }
      }else {
        start = i - 1;
        count = 2;
      }

    }
    return sub.substring(startMaxLen, maxLen);
  }

}
