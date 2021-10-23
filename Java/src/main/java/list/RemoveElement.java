package list;


import java.util.Arrays;

public class RemoveElement {

    private static int solution(int[] arr, int val) {
        int left = 0;
        //使用了for循环就不需要右指针了
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != val) {
                arr[left] = arr[i];
                left++;
            }
        }
        System.out.println(Arrays.toString(arr));
        return left;
    }
    public static void main(String[] args) {
        int[] test = {0, 1, 2, 2, 3, 0, 4, 2};
        int res = solution(test, 2);
        System.out.println(res);

    }
}
