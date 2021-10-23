package Link;

import org.junit.Test;

import java.util.*;

public class addTwoNumbers {

    @Test
    public void test01() {
        int[] arr = {3,6,1,7,2,5,9};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        List<Integer> ints = Arrays.asList(3,6,1,7,2,5,9);
        System.out.println(ints);
        Collections.sort(ints,(e1,e2)->e2-e1);
        System.out.println(ints);

    }
    public  ListNode solution(ListNode ListNode1,ListNode ListNode2) {

        ListNode head = null, tail = null;
        int carry = 0;
        while (ListNode1 != null || ListNode2 != null) {
            int n1 = ListNode1!=null? ListNode1.value :0;
            int n2 = ListNode2!=null? ListNode2.value :0;
            int num = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(num % 10);
            }else {
                tail.next = new ListNode(num % 10);
                tail=tail.next;
            }
            carry = num / 10;
            if (ListNode1 != null) {
                ListNode1 = ListNode1.next;
            }

            if (ListNode2 != null) {
                ListNode2 = ListNode2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }
}
