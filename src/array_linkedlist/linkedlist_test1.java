package array_linkedlist;

/**
 * @program: hello-world
 * @description: 链表翻转
 * @author: wqdong
 * @create: 2020-01-01 15:10
 **/
public class linkedlist_test1 {

  public static class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public static void main(String[] args) throws Exception {

    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);

    head = reverse_list(head);
    show_list(head);

    System.out.println();

    reverse_list_from_to(head, 1, 3);
    show_list(head);

  }

  public static void show_list(ListNode head) {
    while (head != null) {
      System.out.print(head.val + " ");
      head = head.next;
    }
  }


  public static ListNode reverse_list(ListNode head) {

    ListNode rev_hear = null;
    while (head != null) {
      ListNode temp = head.next;
      head.next = rev_hear;
      rev_hear = head;
      head = temp;
    }
    return rev_hear;
  }

  public static void reverse_list_from_to(ListNode head, int from_index, int to_index)
      throws Exception {
    ListNode from_pre = null;
    ListNode from = null;
    ListNode to = null;
    ListNode to_next = null;

    ListNode temp = head.next;
    int curr_index = 1;
    while (temp != null) {
      if (curr_index == from_index - 1) {
        from_pre = temp;
      } else if (curr_index == from_index) {
        from = temp;
      } else if (curr_index == to_index) {
        to = temp;
      } else if (curr_index == to_index + 1) {
        to_next = temp;
      }

      temp = temp.next;
      curr_index++;
    }

    if (from == null || to == null) {
      throw new Exception("不符合条件！！！");
    }

    ListNode pre = from;
    ListNode curr = pre.next;
    while (curr != to_next) {
      ListNode next = curr.next;
      curr.next = pre;
      pre = curr;
      curr = next;
    }

    if (from_pre != null) {
      from_pre.next = to;
    } else {
      head.next = to;
    }

    from.next = to_next;
  }
}
