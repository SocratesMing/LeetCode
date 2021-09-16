package test;

import org.junit.Test;

public class findMax {
    public static int solution(int[] nums) {
        int left = 0, right = nums.length - 1;
        int max = nums[0];
        if (nums.length == 1) {
            return nums[0];
        }

        while (left < right) {

            int mid = left+(right-left)/2;
            System.out.println(left+" "+right+" " +mid);
            if  (nums[mid] >= nums[mid - 1] && nums[mid] >= nums[mid + 1]) {
                max = nums[mid];
            }

            if (nums[mid] > nums[mid - 1] && nums[mid] < nums[mid + 1]) {
                left=mid+1;
            }else if (nums[mid] < nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                right=mid-1;
            }else {

            }
        }
        return max;

    }

    @Test
    public void test01() {
        System.out.println(findMax.solution(new int[]{1, 2, 3, 5, 6, 4, 3, 1}));
    }


}
