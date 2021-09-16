package dynamic;


import org.junit.Test;

/*给定一个整数数组 nums，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

示例 1：
输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
输出：6
解释：连续子数组[4,-1,2,1] 的和最大，为6 。
示例 2：

输入：nums = [1]
输出：1
示例 3：

输入：nums = [0]
输出：0
示例 4：

输入：nums = [-1]
输出：-1
示例 5：

输入：nums = [-100000]
输出：-100000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-subarray
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/


/*
 * 动态规划要点
 * 1、累加
 * 2、累加值和当前值取最大或者是最小，放到值temp中，temp初始化为0
 * 3、res值与temp取最大值，res是元素的第一个值
 *
 * */
public class MaxSubSum_53_like {
    public static int solution(int[] arr) {
        //pre存储当前子序和最大值
        int pre = 0, maxRes = arr[0];
        for (int i : arr) {
            System.out.println(pre+" "+i);
            pre = Math.max(pre + i, i);     //之前的值+当前值  与 当前值比较 取最大值
            maxRes = Math.max(maxRes, pre);
        }

        return maxRes;
    }

    public static void solution2(int[] arr) {
        //最大子序和
        int pre = 0, res = arr[0];
        for (int i : arr) {
            pre = Math.max(pre + i, i);
            res = Math.max(pre, res);

        }
        System.out.println(res);
    }

    @Test
    public void test01() {

        System.out.println(MaxSubSum_53_like.solution(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
