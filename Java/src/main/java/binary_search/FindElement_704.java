package binary_search;

import org.junit.Test;

public class FindElement_704 {
    public static int solution(int[] nums, int target) {
        int mid, left = 0, right = nums.length - 1;
        while (left < right) {

            mid = left + (right - left) /2; //这种方式是为了防止溢出，而不是使用（right+left）/2
            System.out.println(left + " " + mid + " " + right);
            if (nums[mid] == target) return mid;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }
        return -1;
    }


    @Test
    public void test01() {
        System.out.println(FindElement_704.solution(new int[]{-1, 0, 3, 5, 9, 12}, 9));
    }
}
