import java.util.ArrayList;
import java.util.List;

public class PhotoCombs {


     public static void main(String [] args) {
       System.out.println(getPhotoCombinations(2,3));
     }



     public static int getPhotoCombinations(int even, int odd) {
       int [] oddNumbers = generateOddNums(odd);
       int [] evenNumbers = generateEvenNums(even);
       int totalCombinations = 0;

       for (int i = 0; i < oddNumbers.length; i++) {
            List<Integer> youngerEvens = getYoungerMembers(evenNumbers, oddNumbers[i]);
            youngerEvens.add(oddNumbers[i]);
           totalCombinations += Combination.getCombination(youngerEvens.toArray(new Integer[0]),oddNumbers[i]);
       }

       for (int i = 0; i < evenNumbers.length; i++ ) {
         List<Integer> youngerOdds = getYoungerMembers(oddNumbers, evenNumbers[i]);
         youngerOdds.add(evenNumbers[i]);
         totalCombinations += Combination.getCombination(youngerOdds.toArray(new Integer[0]),evenNumbers[i]);
       }

       return totalCombinations;
     }



     public static int [] generateOddNums(int length) {
        int [] oddNums = new int [length];
        int start = 1;
        for (int i = 0; i < length; i++) {
          oddNums[i] = start;
          start += 2;
        }
        return oddNums;
     }

     public static int [] generateEvenNums(int length) {
       int [] evenNums = new int [length];
       int start = 2;
       for (int i = 0; i < length; i++) {
         evenNums[i] = start;
         start += 2;
       }
       return evenNums;
     }

     public static List<Integer> getYoungerMembers(int [] members, int max) {
       List<Integer> youngerMembers = new ArrayList<>();
       for (int i= 0; i < members.length; i ++) {
            if (members[i] < max) {
              youngerMembers.add(members[i]);
            }
       }
       return  youngerMembers;
     }



}
