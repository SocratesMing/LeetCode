package other;

import java.util.HashMap;
import java.util.concurrent.ConcurrentSkipListSet;

public class LURCache {

    public static void main(String[] args) {
        LURCache cache = new LURCache(2);
        cache.put(1,1);
        cache.put(2,2);
        System.out.println(cache.get(1));
        cache.put(3,3);
        System.out.println(cache.get(2));
        cache.put(4,4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
    //链表
     class DLinkNode {
        int key;
        int value;
        DLinkNode pre;
        DLinkNode next;

         public DLinkNode() {
         }

         public DLinkNode(int key, int value) {
             this.key = key;
             this.value = value;
         }
     }
    //Has和Map的key，value是节点类型
    private HashMap<Integer, DLinkNode> cache = new HashMap<>();
    private  int size;
    private  int capacity;
    private final DLinkNode head,tail;


    public LURCache(int capacity) {
        this.size=0;    //大小
        this.capacity = capacity;   //lru的容量
        head = new DLinkNode();
        tail = new DLinkNode();
        head.next= tail;
        tail.pre = head;
    }

    public int get(int key) {
        DLinkNode node = cache.get(key);
        if (node == null) {
            return  -1;
        }else
        moveToHead(node);   //node不为空就放到开头
//        printLinkNode();
        return node.value;
    }

    private void printLinkNode() {
        DLinkNode node = head.next;
        while (node != tail) {
            System.out.print("[");
            System.out.print(node.value);
            System.out.print("]");

            node = node.next;
        }
        System.out.println();

    }
    public void put(int key, int value) {
        DLinkNode node = cache.get(key);    //首先看有没有这个key
        if (node == null) {
            //如果没有就新建一个DLinkNode节点
            DLinkNode dLinkNode = new DLinkNode(key, value);
            size++;
            cache.put(key, dLinkNode);
            addToHead(dLinkNode);   //把当前节点放到链表的头
            if (size > capacity) {  //如果size大于容量就一处掉最后一个，szie--
                DLinkNode tail = removeTail();
                cache.remove(tail.key);
                size--;
            }
        }
        else {
            node.value = value;
            moveToHead(node);   //使用一次就放到开头
        }
        printLinkNode();

    }

    //移除一个节点
    public void  removeNode(DLinkNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    //移动到头部
    private void moveToHead(DLinkNode node) {
        removeNode(node);
        addToHead(node);
    }

    private DLinkNode removeTail() {
        DLinkNode res = tail.pre;
        removeNode(res);
        return res;
    }

    //添加到头部
    public void addToHead(DLinkNode node) {
        //当前节点的前后节点
        node.pre = head;
        node.next = head.next;

        head.next.pre =node;    //之前头部节点的前一个节点
        head.next = node;       //头部节点的下一个节点
    }

    public void addToTail(DLinkNode node) {
        tail.pre.next= node;
        tail.pre = node;
        node.pre = tail.pre.pre;
    }

}
