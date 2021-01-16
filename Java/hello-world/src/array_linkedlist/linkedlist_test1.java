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

    ListNode head = new ListNode(-1);
    head.next = new ListNode(1);
    head.next.next = new ListNode(2);
    head.next.next.next = new ListNode(3);
    head.next.next.next.next = new ListNode(4);
    head.next.next.next.next.next = new ListNode(5);

    reverse_list(head);
    show_list(head);

    System.out.println();

    reverse_list_from_to(head, 1, 3);
    show_list(head);

    System.out.println();

    reverse_list_every_k(head, 2);
    show_list(head);

  }

  public static void show_list(ListNode head) {
    while (head != null) {
      System.out.print(head.val + " ");
      head = head.next;
    }
  }


  public static void reverse_list(ListNode head) {

    ListNode pre = head;
    ListNode curr = pre.next;
    pre = null;
    while (curr != null) {
      ListNode temp = curr.next;
      curr.next = pre;
      pre = curr;
      curr = temp;
    }
    head.next = pre;
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

  public static void reverse_list_every_k(ListNode head, int k) {
    ListNode temp = head.next;
    int step = 0;

    ListNode start_k = null;
    ListNode start_kpre = head;
    ListNode end_k = null;

    while (temp != null) {
      ListNode temp_next = temp.next;
      if (step == 0) {
        start_k = temp;
        step++;
      } else if (step == k - 1) {
        end_k = temp;
        ListNode pre = start_k;
        ListNode curr = start_k.next;

        if (curr == null) {
          break;
        }

        ListNode end_knext = end_k.next;
        while (curr != end_knext) {
          ListNode next = curr.next;
          curr.next = pre;
          pre = curr;
          curr = next;
        }

        start_kpre.next = end_k;
        start_k.next = end_knext;

        // 当前的k个为一组以及翻转完毕，开始下一轮的k个一组翻转
        start_kpre = start_k;
        step = 0;
      } else {
        step++;
      }

      temp = temp_next;
    }
  }
}
