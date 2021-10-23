package list;

import org.junit.Test;
import sun.misc.Queue;

import java.util.Arrays;
import java.util.PriorityQueue;

public class kthLargestElement {

    public static void main(String[] args) {
        int[] arr = {5, 8, 4, 2, 3, 0, 1, 9};
//        System.out.println(solution2(arr, 2));
//        System.out.println(solution2(arr, 2));
        System.out.println(solution4(arr, 2));
    }

    //使用优先队列
    private static int solution2(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int j : arr) {
            if (pq.size() < k) {
                pq.offer(j);
            } else if (pq.peek() < j) {
                pq.poll();
                pq.offer(j);
            }
        }
        return pq.peek();
    }


    //基快排
    private static int solution1(int[] arr, int k) {
        int n = arr.length;
        int left = 0, right = n - 1;
        while (true) {
            int le = left, ri = right;
            while (le < ri) {
                while (le < ri && arr[le] < arr[ri]) ri--;


            }
        }

    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;

    }

    public static int solution3(int[] arr, int k) {
        int len = arr.length;
        int left = 0;
        int right = len - 1;

        int target = len - k;
        while (true) {
            int index = partion(arr, left, right);
            if (index < target) {  //小于target要缩小左边界
                left = index + 1;
            } else if (index > target) {//大于target要缩小右边界
                right = index - 1;
            } else {
                return arr[index];
            }
        }

    }

    //分治算法实现
    private static int partion(int[] arr, int left, int right) {
        int pivot = arr[left];//最左侧为基准值
        int le = left;  //指向小于基准值的最右侧元素
        for (int i = left + 1; i <= right; i++) {

            if (arr[i] < pivot) {   //当前值小于基准值放到左边
                le++;
                swap(arr, le, i);
            }
        }

        //交换之前：arr[left+1到le]<pivot  arr[le到right]>=pivot
//        System.out.println(Arrays.toString(arr));
        swap(arr, le, left);
//        System.out.println(Arrays.toString(arr));
        //交换之后：arr[left到le-1]<pivot  arr[le]=pivot  arr[le+1到right]>=pivot
        System.out.println("===========");
        return le;
    }


    public static int solution4(int[] arr, int k) {
        for (int i = 0; i < k; i++) {
            swim(arr, i);
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[0]) {
                swap(arr, i, 0);
                sink(arr, 0, k - 1);
            }
        }
        return arr[0];
    }

    //下沉从上到下调整堆
    private static void sink(int[] arr, int i, int k) {
        while (2 * i + 1 <= k) {
            int j = 2 * i + 1;
            if (j + 1 <= k && arr[j + 1] < arr[j]) {
                j++;
            }

            if (arr[j] > arr[i]) {
                break;
            }
            swap(arr, i, j);
            i = j;
        }
    }

    //从下到上调整堆
    private static void swim(int[] arr, int i) {
        while (i > 0 && arr[i] < arr[(i - 1) / 2]) {
            swap(arr, i, (i - 1) / 2);
            i = (i - 1) / 2;

        }
    }
}
