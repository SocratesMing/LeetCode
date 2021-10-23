package sort;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {7, 3, 8, 5, 1, 2};
//        sort1(arr);
        sort2(arr);
    }

    public static void sort2(int[] arr) {
        int len = arr.length;
        for (int i = len; i >0 ; i--) {
            buildMinHeap(arr,i); //构建大顶堆，保证第一个元素时最大值
            swap(arr,0,i-1); //交换第一个元素和最后未排序的元素
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void buildMinHeap(int[] arr, int len) {
        for (int i = len / 2 - 1; i >= 0; i--) {
            int leftLeaf = 2 * i + 1;
            int rightLeaf = leftLeaf + 1;
            if (leftLeaf < len && arr[leftLeaf] < arr[i]) {
                swap(arr, i, leftLeaf);
                //判断左字数是否符合大顶堆
                if (2 * leftLeaf + 1 < len && arr[leftLeaf] > arr[2 * leftLeaf + 1] || 2 * leftLeaf + 2 < len && arr[leftLeaf] > arr[2 * leftLeaf + 2]) {
                    buildMinHeap(arr,len);
                }
            }
            if (rightLeaf < len && arr[rightLeaf] < arr[i]) {
                swap(arr, i, rightLeaf);
                //判断右子树是否是大顶堆
                if (2 * rightLeaf + 1 < len && arr[rightLeaf] > arr[2 * rightLeaf + 1] || 2 * rightLeaf + 2 < len && arr[rightLeaf] > arr[2 * rightLeaf + 2]) {
                    buildMinHeap(arr,len);
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("--------");
    }



    //大顶堆排序
    public static void sort1(int[] arr) {
        int len = arr.length;
        for (int i = len; i >0 ; i--) {
            buildMaxHeap(arr,i); //构建大顶堆，保证第一个元素时最大值
            swap(arr,0,i-1); //交换第一个元素和最后未排序的元素
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void buildMaxHeap(int[] arr, int len) {
        for (int i = len / 2 - 1; i >= 0; i--) {
            int leftLeaf = 2 * i + 1;
            int rightLeaf = leftLeaf + 1;
            if (leftLeaf < len && arr[leftLeaf] > arr[i]) {
                swap(arr, i, leftLeaf);
                //判断左字数是否符合大顶堆
                if (2 * leftLeaf + 1 < len && arr[leftLeaf] < arr[2 * leftLeaf + 1] || 2 * leftLeaf + 2 < len && arr[leftLeaf] < arr[2 * leftLeaf + 2]) {
                    buildMaxHeap(arr,len);
                }
            }
            if (rightLeaf < len && arr[rightLeaf] > arr[i]) {
                swap(arr, i, rightLeaf);
                //判断右子树是否是大顶堆
                if (2 * rightLeaf + 1 < len && arr[rightLeaf] < arr[2 * rightLeaf + 1] || 2 * rightLeaf + 2 < len && arr[rightLeaf] < arr[2 * rightLeaf + 2]) {
                    buildMaxHeap(arr,len);
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("--------");
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
