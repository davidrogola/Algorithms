public class LinkedList {

  public static void main(String [] args) {

  }


  public static LinkedListNode reverse(LinkedListNode headOfList) {
    LinkedListNode currentNode = headOfList;
    LinkedListNode previousNode = null;
    LinkedListNode nextNode = null;

    // until we have 'fallen off' the end of the list
    while (currentNode != null) {

      // copy a pointer to the next element
      // before we overwrite currentNode.next
      nextNode = currentNode.next;

      // reverse the 'next' pointer
      currentNode.next = previousNode;

      // step forward in the list
      previousNode = currentNode;
      currentNode = nextNode;
    }

    return previousNode;
  }



  public static class LinkedListNode {

    public int value;
    public LinkedListNode next;

    public LinkedListNode() {

    }
    public LinkedListNode(int value) {
      this.value = value;
    }

    public LinkedListNode(int value, LinkedListNode next) {
      this.value = value;
    }

  }


  public static LinkedListNode mergeIterative(LinkedListNode l1, LinkedListNode l2) {
    LinkedListNode dummy = new LinkedListNode(0);
    LinkedListNode head = dummy;
    while(l1 != null && l2 != null) {
      if(l1.value <= l2.value) {
        dummy.next = l1;
        l1 = l1.next;
      }else {
        dummy.next = l2;
        l2 = l2.next;
      }
      dummy = dummy.next;
    }
    dummy.next = l1 != null ? l1 : l2;
    return head.next;
  }

}
