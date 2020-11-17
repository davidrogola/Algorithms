public class DuplicateArr {

   public static  void main(String [] args) {
        System.out.println(removeDuplicatesInPlace(new int[] {1,1,2,2,4,5,7,8,8,9,9,9,10}));
   }

   public static  int removeDuplicatesInPlace(int [] arr) {
       // [1,1,2,2,4,5,7,8,8,9,9,9,10]
     int num = 0;
     for (int i = 0; i < arr.length; i ++) {
       if(i == 0 || arr[i] != arr[i- 1]) {
           arr[num++] = arr[i];
       }
     }
     return num;
   }
}
