public class MaxDistanceBtwnMonkeys {
  public static void main(String [] args) {
  System.out.println(maxDistanceBtwnMonkeys(new int[]{2,2,2}));
  }

  public static int maxDistanceBtwnMonkeys(int [] blocks) {
    int noOfBlocks = blocks.length;
    // left[i] stores the distance to each block left of  ith block that the frog has to jump
    // distance is 0 if block height is less that ith block
    int[] left = new int[noOfBlocks];
    left[0] = 0;
    for (int i = 1; i < noOfBlocks; i++) {
      if (blocks[i] <= blocks[i - 1]) {
        left[i] = left[i - 1] + 1;
      }
      else {
        left[i] = 0;
      }
    }

    // right[i] stores the distance to each block right of ith block that the frog has to jump
    // distance is 0 if block height is less that ith block
    int[] right = new int[noOfBlocks];
    right[noOfBlocks - 1] = 0;
    for (int i = noOfBlocks - 2; i >= 0; i--) {
      if (blocks[i] <= blocks[i + 1]) {
        right[i] = right[i + 1] + 1;
      }
      else {
        right[i] = 0;
      }
    }

    // start with both frogs at each block to pick the position that will make both frogs have maximum distance apart
    int maxDistance = 0;
    for (int i = 0; i < noOfBlocks; i++) {
      int currentDistance = left[i] + right[i] + 1;
      maxDistance = Math.max(maxDistance, currentDistance);
    }

    return maxDistance;
  }
}
