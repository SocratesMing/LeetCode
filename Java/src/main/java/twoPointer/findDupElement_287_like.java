package twoPointer;
/*给定一个包含 n + 1 个整数的数组 nums ，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。

假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。

你设计的解决方案必须不修改数组 nums 且只用常量级 O(1) 的额外空间。

示例 1：
输入：nums = [1,3,4,2,2]
输出：2
示例 2：
输入：nums = [3,1,3,4,2]
输出：3
示例 3：
输入：nums = [1,1]
输出：1
示例 4：
输入：nums = [1,1,2]
输出：1
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-the-duplicate-number*/

import org.junit.Test;

//环形指针
//不能改变数组元素内容
public class findDupElement_287_like {

    public static int solution(int[] nums) {
        int fast = 0, slow = 0;
        do {
            System.out.println(slow + "-->" + fast);
            slow = nums[slow];  //fast向后移动一步
            fast = nums[nums[fast]];//fast向后移动两步
        } while (slow != fast); //找到环的入点

        System.out.println("======="+slow+"---" +fast);
        // 相遇之后 fast 位于 slow的下一个位置，slow回到原点
        fast = slow;
        slow = 0;
        // fast、slow 步调一致向后移动，直到相遇时即为重复元素
        //https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/yi-yan-jiu-kan-dong-de-ti-jie-shuang-zhi-4sag/
        while (fast != slow) {
            System.out.println(slow + "-->" + fast);
            fast = nums[fast];  //向后移动一个
            slow = nums[slow];  //向后移动一个

        }

        return slow;

    }

    @Test
    public void tests() {
        System.out.println(findDupElement_287_like.solution(new int[]{1, 2, 3, 4, 5,6,7,3}));
    }
}
