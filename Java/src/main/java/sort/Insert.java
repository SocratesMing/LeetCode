package sort;

import org.junit.Test;

import java.util.Arrays;

public class Insert {
    int[] arr= {5, 7, 6, 2, 9, 1, 22, 11, 58, 21, 14};
    @Test
    public void test01() {
        //插入排序是稳定排序

        int len = arr.length;
        int pre,cur;
        for (int i = 1; i < len; i++) {
            pre = i - 1;
            cur = arr[i];
            while (pre >= 0 && arr[pre] > cur) {
                arr[pre + 1] = arr[pre];
                pre--;
            }
            arr[pre + 1] = cur;//当前指针指向的值小于cur，所以要放到pre的后一个指针

        }
        System.out.println(Arrays.toString(arr));

    }
}
