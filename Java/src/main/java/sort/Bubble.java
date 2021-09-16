package sort;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class Bubble {
    int[] arr= {5, 7, 6, 2, 9, 1, 22, 11, 58, 21, 14};
    @Test
    public void test01() {
        //冒泡排序

        int len = arr.length;
        for (int i = 0; i < len-1; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    int tmp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));

    }
}
