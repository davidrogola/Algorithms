import java.util.ArrayList;
import java.util.List;

public class Tree {


  // Definition for a binary tree node.
  public static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  public static void main(String[] args) {
    System.out.println(uniqueBST(3).size());
  }

  public static List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> values = new ArrayList<>();
    traverse(values, root);
    return values;
  }

  public static void traverse(List<Integer> vals, TreeNode node) {
    if (node != null) {
      vals.add(node.val);
      traverse(vals, node.left);
      traverse(vals, node.right);
    }
  }

  public  List<List<Integer>> breadthFirstSearch(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root != null) {
      levelOrderTraverse(result, root, 0);
    }
    return result;
  }

  private  void levelOrderTraverse(List<List<Integer>> list, TreeNode node, int level) {
    if (node == null) {
      return;
    }
    if(level == list.size()) {
      list.add(new ArrayList<>());
    }
    list.get(level).add(node.val);
    levelOrderTraverse(list, node.left, level + 1);
    levelOrderTraverse(list, node.right, level + 1);
  }

  public int numBusesToDestination(int[][] routes, int S, int T) {
     int buses = 0;
     for (int i = 0; i <routes.length; i ++) {
        for (int j = 0; j < routes[i].length; j ++) {
           if(routes[i][j] == S) {
              buses ++;
           }
           if (routes[i][j] == T) {

           }
        }
     }
    return -1;
  }

  public boolean hasPathSum(TreeNode root, int sum) {
    if(root != null) {
      sum -= root.val;
      if(sum == root.val && root.right == null && root.left == null) {
        return true;
      }
      return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }
    return false;
  }

  private static void printReverse(char [] str) {
    helper(0, str);
  }

  private static void helper(int index, char [] str) {
    if (str == null || index >= str.length) {
      return;
    }
    helper(index + 1, str);
    System.out.print(str[index]);
  }

  public static void reverseString(char[] s) {
    reverse(s, 0, s.length - 1);
  }
  public static void reverse(char[] arr, int start, int end) {
    if(start >= end) {
      return;
    }
    char swap = arr[start];
    arr[start++] = arr[end];
    arr[end--] = swap;
    reverse(arr, start, end);
  }

  public static char[] reverseIter(char [] s) {
    int left = 0;
    int right = s.length - 1;
    while (left < right) {
      char swap = s[left];
      s[left++] = s[right];
      s[right--] = swap;

    }
    return s;
  }


  public static List<TreeNode> uniqueBST(int n) {
    if (n == 0) {
      return new ArrayList<>();
    }
    return uniqueBSTHelper(1, n);
  }

  public static List<TreeNode> uniqueBSTHelper(int start, int end) {
    System.out.println(String.format("Start: %d End: %d", start, end));
    List<TreeNode> treeNodeList = new ArrayList<>();
    if (start > end) {
      treeNodeList.add(null);
      return treeNodeList;
    }
    for (int i = start; i <= end; i ++) {
      List<TreeNode> leftNodes = uniqueBSTHelper(start, i - 1);
      List<TreeNode> rightNodes = uniqueBSTHelper(i + 1, end);

      for (TreeNode leftNode : leftNodes) {

         for (TreeNode rightNode : rightNodes) {
            TreeNode root = new TreeNode(i);
            root.left = leftNode;
            root.right = rightNode;
            treeNodeList.add(root);
         }
      }
    }
    return treeNodeList;
  }


}
