package list;

import java.util.Arrays;

public class removeDuplicatesFromSortedArray26 {

    public static int solution(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        int left = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[left] = nums[i];
                left++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return left;


    }
    public static void main(String[] args) {
        int[] arr = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(solution(arr));
    }
}
