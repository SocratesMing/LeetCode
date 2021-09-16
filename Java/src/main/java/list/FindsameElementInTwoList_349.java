package list;
/*给定两个数组，编写一个函数来计算它们的交集。

示例 1：
输入：nums1 = [1,2,2,1], nums2 = [2,2]
输出：[2]

示例 2：
输入：nums1 = [], nums2 = [9,4,9,8,4]
输出：[9,4]

说明：

输出结果中的每个元素一定是唯一的。
我们可以不考虑输出结果的顺序。*/

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
//考虑到效率应当优先使用hashmap和hashset
public class FindsameElementInTwoList_349 {
    public static int[] solution(int[] num1, int[] num2) {
        HashSet<Integer> hashMap1 = new HashSet<>();
        HashSet<Integer> hashMap2 = new HashSet<>();
        for (int i : num1) {
            hashMap1.add(i);
        }

        for(int i:num2){
            hashMap2.add(i);
        }
        return getInsertSet(hashMap1, hashMap2);
    }

    public static int[] getInsertSet(HashSet<Integer> set1, HashSet<Integer> set2) {
        //这个语法值得学习
        if (set1.size() > set2.size()) {
            return getInsertSet(set2,set1);
        }

        HashSet<Integer> hashSet = new HashSet<>();
        for (int i : set1) {
            if (set2.contains(i)) {
                hashSet.add(i);
            }
        }

        int[] res = new int[hashSet.size()];
        int x=0;
        for (int i : hashSet) {
            System.out.println(i);
            res[x++]=i;     //注意这种使用方式x++
        }
        return res;
    }

    @Test
    public void test01() {
        int[] res = FindsameElementInTwoList_349.solution(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4});
        System.out.println(Arrays.toString(res));
    }
}
