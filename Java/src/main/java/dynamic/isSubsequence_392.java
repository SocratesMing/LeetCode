package dynamic;
/*
*
* 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。

示例 1：

输入：s = "abc", t = "ahbgdc"
输出：true

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/is-subsequence
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*
* */
public class isSubsequence_392 {
    //双指针算法
    public static void solution(String s,String t){
        int sl = s.length();
        int tl = t.length();
        int l1 = 0, l2 = 0;
        while (l1 < sl && l2 < tl) {
            if (s.charAt(l1) == t.charAt(l2)) {
                l1++;
            }
            l2++;
        }
    }
}
