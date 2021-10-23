package sort;

import java.util.Arrays;

//基本思想
//选取一个值为标准值然后把小于标准值的放在左边，大于标准值的放在右边
public class QuickSort {
    public static void sort(int arr[], int l, int r) {
        if (l >= r) {
            return;
        }
        int left = l, right = r;
        int pivot = arr[left]; //最左边的值为比较的标准值
        while (left < right) {
            while (left < right && arr[right] >= pivot) {
                right--;
            }
            if (left < right ) {
                arr[left] = arr[right];
                left++;
            }
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            if (left < right) {
                // swap(arr,left,right);
                arr[right] = arr[left];
                right--;
            }
        }

        arr[left] = pivot;

        sort(arr,l,right-1);
        sort(arr,right+1,r);
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 87, 5, 8, 45, 98, 43, 56, 7, 32};
        QuickSort.sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

}
