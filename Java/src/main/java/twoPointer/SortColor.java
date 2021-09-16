package twoPointer;

import org.junit.Test;

import java.util.Arrays;

public class SortColor {
    public static void solution(int[] nums) {
        int x = 0, y = 0, z = 0;
        for (int i = 0; i < nums.length; i++) {
            System.out.println(x + " " + y + " " + z);
            if (nums[i] == 2) {
                z++;

            } else if (nums[i] == 1) {
                nums[z] = 2;
                z++;
                nums[y] = 1;
                y++;

            } else {
                nums[z] = 2;
                z++;
                nums[y] = 1;
                y++;
                nums[x] = 0;
                x++;

            }

            System.out.println(Arrays.toString(nums));
        }

    }

    public static void solution2(int[] nums) {
        int solw = 0, fast = 0;
    }


    @Test
    public void test01() {
        SortColor.solution(new int[]{2, 0, 2, 1, 1, 0});
    }
}
