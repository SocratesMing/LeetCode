package greddy;

import java.util.Arrays;
import java.util.Comparator;

public class noOverlappingIntervals435 {
    public static void main(String[] args) {
        int[][] nums = {{1,2},{2,3},{3,4},{1,3} };
        System.out.println(solution(nums));
    }

    public static int solution(int[][] nums) {
        int res = 1,len = nums.length;
        Arrays.sort(nums, Comparator.comparingInt(e -> e[1]));
        System.out.println(Arrays.deepToString(nums));
        int temp = nums[0][1];
        for (int i = 1; i < len; i++) {
            if (nums[i][0] > temp) {
                res++;
                temp = nums[i][1];
            }

        }
        return len-res;
    }
}
