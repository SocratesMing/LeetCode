package dynamic;

import org.junit.Test;

import java.util.Arrays;

/*
*
* 给定一个数组 prices ，它的第i 个元素prices[i] 表示一支给定股票第 i 天的价格。

你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。

返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。


示例 1：

输入：[7,1,5,3,6,4]
输出：5
解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
示例 2：

输入：prices = [7,6,4,3,1]
输出：0
解释：在这种情况下, 没有交易完成, 所以最大利润为 0。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
*/
public class maxProfit_121 {

    public static void solution1(int[] num) {
        int minpri = Integer.MAX_VALUE, res = 0;
        for (int i : num) {
            minpri = Math.min(minpri, i);
            res = Math.max(i - minpri, res);

        }
        System.out.println(res);
    }

    public static void solution2(int[] num) {
        //明确dp[i]和dp[i][j]代表什么
        //dp[i] 表示前 ii 天的最大利润，因为我们始终要使利润最大化，
        int[] dp = new int[num.length];
        int minPric = Integer.MAX_VALUE;
        dp[0] = 0;
        for (int i = 1; i < num.length; i++) {
            minPric = Math.min(minPric, num[i]);
            dp[i] = Math.max(dp[i - 1], i - minPric);

        }
        System.out.println(Arrays.stream(dp).max());
    }

    @Test
    public void test() {
        int[] arr = new int[]{7, 1, 5, 3, 6, 4};
        solution1(arr);

    }
}
