package list;/*
*
* 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
你可以按任意顺序返回答案。


示例 1：
输入：nums = [2,7,11,15], target = 9
输出：[0,1]
解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
示例 2：

输入：nums = [3,2,4], target = 6
输出：[1,2]
示例 3：

输入：nums = [3,3], target = 6
输出：[0,1]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/two-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */


import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

//这题的要点在于用Map
public class TwoSum_01 {

    public static int[] solution(int[] arr, int target) {
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            //看当前hashmap中有没有 target-当前值，有的话返回
            if (hashmap.containsKey(target - arr[i])) {
                return new int[]{hashmap.get(target - arr[i]), i};
            }else {
                hashmap.put(arr[i], i); //没有余数就保存当前值以及对应的索引
            }
        }

        return new int[]{};
    }

    @Test
    public void test() {

        int[] ints = TwoSum_01.solution(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(ints));
    }
}



