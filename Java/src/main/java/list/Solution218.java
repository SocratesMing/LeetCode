package list;

import java.util.Arrays;

public class Solution218 {
    private static int[] multiArr(int[] arr) {
        int[] res = new int[arr.length];

        res[0] = 1;
        for (int i = 1; i < arr.length; i++) {

            res[i] = arr[i-1] * res[i - 1];
        }
        int r = 1;
        System.out.println(Arrays.toString(res));
        for (int i = arr.length - 1; i >= 0; i--) {
            res[i] = res[i] * r; //先更新res
            r = r * arr[i];//在更新r
        }

        return res;

    }

    public static void main(String[] args) {
        int[] test = {1, 2, 3, 4, 5, 6};
        int[] res = multiArr(test);
        System.out.println(Arrays.toString(res));
     }

}
