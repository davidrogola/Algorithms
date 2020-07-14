public class Combination {


  /*Driver function to check for above function*/
  public static void main(String[] args) {
    Integer arr[] = {1, 2, 3, 4};
    int n = arr.length;
    int r = n;

    System.out.println(getCombination(arr, 4));
  }

  /* arr[]  ---> Input Array
   data[] ---> Temporary array to store current combination
   start & end ---> Staring and Ending indexes in arr[]
   index  ---> Current index in data[]
   r ---> Size of a combination to be printed */
  public static int combinationUtil(Integer arr[], int data[], int start,
      int end, int index, int r, int subject) {
    // Subject is the odd or even number that must be present in the photo and we only increment the
    // counter when we have a valid subject in the combination
    int counter = 0;
    boolean hasSubject = false;
    if (index == r) {
      for (int j = 0; j < r; j++) {
        if (data[j] == subject) {
          hasSubject = true;
        }
      }
      if (hasSubject) {
        counter++;
      }
      return counter;
    }
    // replace index with all possible elements. The condition
    // "end-i+1 >= r-index" makes sure that including one element
    // at index will make a combination with remaining elements
    // at remaining positions
    for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
      data[index] = arr[i];
      counter += combinationUtil(arr, data, i + 1, end, index + 1, r, subject);
    }
    return counter;
  }

  // The main function that prints all combinations of size r
  // in arr[] of size n. This function mainly uses combinationUtil()
  public static int getCombination(Integer arr[], int subject) {
    int total = 0;
    int n = arr.length;
    int r = n;
    // Starts at 2 because that's the minimum number of combinations we can have and goes all the way
    // to the total size of the list.
    for (int c = 2; c <= r; c++) {
      // A temporary array to store all combination one by one
      int data[] = new int[c];

      // Print all combination using temporary array 'data[]'
      total += combinationUtil(arr, data, 0, n - 1, 0, c, subject);
    }
    return total;
  }
}
