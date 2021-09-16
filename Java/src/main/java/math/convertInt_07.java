package math;

import org.junit.Test;

/*给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。

        如果反转后整数超过 32 位的有符号整数的范围[−231, 231− 1] ，就返回 0。

        假设环境不允许存储 64 位整数（有符号或无符号）。
        

        示例 1：

        输入：x = 123
        输出：321
        示例 2：

        输入：x = -123
        输出：-321
        示例 3：

        输入：x = 120
        输出：21
        示例 4：

        输入：x = 0
        输出：0

        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/reverse-integer
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
/*
* 要点
* 求余数和整除的使用
*
* */
public class convertInt_07 {
    public static int solution(int num) {

        int res = 0;
        while (num!=0) {
            res = res * 10 + num % 10;
            num /= 10;
        }
        System.out.println(res);
        return res;
    }


    @Test
    public void test01() {
        System.out.println(convertInt_07.solution(23456));
        System.out.println(convertInt_07.solution(-2345678));
        System.out.println(convertInt_07.solution(0));
        System.out.println(convertInt_07.solution(120));
    }
}
