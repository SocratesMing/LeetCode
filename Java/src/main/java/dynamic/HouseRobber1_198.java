package dynamic;

import org.junit.Test;

public class HouseRobber1_198 {

    public static int solution(int[] nums) {
            int prev = 0;
            int curr = 0;

            // 每次循环，计算“偷到当前房子为止的最大金额”
            for (int i : nums) {
                // 循环开始时，curr 表示 dp[k-1]，prev 表示 dp[k-2]
                // dp[k] = max{ dp[k-1], dp[k-2] + i }
                int temp = Math.max(curr, prev + i);
                prev = curr;
                curr = temp;
                // 循环结束时，curr 表示 dp[k]，prev 表示 dp[k-1]
            }

            return curr;
        }

    public static int solution2(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            // 子问题：
            // f(k) = 偷 [0..k) 房间中的最大金额
            // f(0) = 0
            // f(1) = nums[0]
            // f(k) = max{ rob(k-1), nums[k-1] + rob(k-2) }
            int N = nums.length;
            int[] dp = new int[N+1];
            dp[0] = 0;
            dp[1] = nums[0];
            for (int k = 2; k <= N; k++) {
                dp[k] = Math.max(dp[k-1], nums[k-1] + dp[k-2]);
            }
            return dp[N];
        }


        //空间优化版本的



    @Test
    public void test01() {
        System.out.println(HouseRobber1_198.solution2(new int[]{2, 7, 9, 3, 1}));
    }
}
