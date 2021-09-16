package Link;

public class LinkCommon {

    public static void printNode(Node a) {
        while (a != null) {
            System.out.print(a.value);
            a = a.next;
        }
        System.out.println();
    }

    public static void reversePrint(Node a) {
        //优先考虑递归
        //递归从最先面到最上面开始执行

        if (a.next == null) {
            System.out.print(a.value);
        }
        if (a.next != null) {
            reversePrint(a.next);
            System.out.print(a.value);
        }
        System.out.println();
    }
    public static void Length(Node root) {
        if (root == null) return;
        int l = 0;
        Node id = root;
        while (id != null) {
            l++;
//            System.out.println(id.value);
            id = id.next;
        }
        System.out.println("链表的长度:" + l);
    }

    public static Node reverse(Node head) {

        Node prev = null;   //当前节点的前一个节点
        Node curr = head;  //当前节点
        while (curr != null) {
            Node next = curr.next;  //把当前节点暂存起来
            curr.next = prev; //把当前节点的前一个节点作为下一个节点
            prev = curr; //更新pre为当前节点
            curr = next; //更新cur为节点
        }
        return prev;
    }

    //俩俩交换
    public static Node swapPairs(Node head) {
        Node dummyHead = new Node("0");
        dummyHead.next = head;
        Node temp = dummyHead;
        while (temp.next != null && temp.next.next != null) {
            Node node1 = temp.next;
            Node node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return dummyHead.next;
    }

    //找出单链表中的倒数第k个元素：
    public static void findLastKElement(Node root, int k) {
        //基本思路：使用双指针
        //第一个指针移动到第K个位置，第二个指针指向第一个位子
        //两个指针同时移动，直到默认，此时第二个指针所在位置就是倒数第K个元素
        if (root == null) return;
        Node p1 = root;
        Node p2 = root;
        for (int i = 0; i < k-1; i++) {
            p2 = p2.next;
        }
//        System.out.println(p2.value);

        while (p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        System.out.println("查找第K个元素："+p1.value);
    }

    public static void findMidElement(Node a) {
        Node oneStep = a;
        Node twoStep = a;
        while (twoStep != null && twoStep.next != null && twoStep.next.next != null) {
            oneStep = oneStep.next;
            twoStep = twoStep.next.next;
        }
        System.out.println("中间节点：" + oneStep.value);
    }

    public static boolean isCircle(Node root) {
        Node fast = root;
        Node slow = root;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast.value == slow.value) {
                return true;
            }
        }
        return false;
    }

    public static void findCircleEntryPoint(Node root) {
        Node fast = root;
        Node slow = root;

        while (fast != null && fast.next != null) { //找到相遇点
            fast = fast.next.next;
            slow = slow.next;
            if (fast.value == slow.value) {
                break;
            }
        }
        slow = root;

        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        System.out.println(slow.value);
    }

    public static void main(String[] args) {
        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");
        Node d = new Node("d");
        Node e = new Node("e");
        Node f = new Node("f");
        Node g = new Node("g");
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
        g.next = c;

//        System.out.println(isCircle(a));
//        Length(a);
//        findLastKElement(a, 3);
//        findMidElement(a);
//        reversePrint(a);
//        printNode(a);
//        Node reverse = reverse(a);

//        Node node = swapPairs(a);
//        printNode(node);
        findCircleEntryPoint(a);

    }
}

class Node {
    public Node next;
    public String value;
    public Node(String value) {
        this.value = value;
    }
}