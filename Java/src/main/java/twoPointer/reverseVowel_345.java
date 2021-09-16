package twoPointer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/*345. 反转字符串中的元音字母
编写一个函数，以字符串作为输入，反转该字符串中的元音字母。



示例 1：

输入："hello"
输出："holle"
示例 2：

输入："leetcode"
输出："leotcede"*/
public class reverseVowel_345 {

    public final static HashSet<Character> vowel = new HashSet<>(
            Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
    );

    public static void solution(String str) {
        char[] res = new char[str.length()];
        int left = 0, right = str.length()-1;
        while (left <= right) {
            char lc = str.charAt(left);
            char rc = str.charAt(right);
            if (!vowel.contains(lc)) {
                res[left++] = lc;
            } else if (!vowel.contains(rc)) {
                res[right--] = rc;
            } else {
                res[right--] = lc;
                res[left++] = rc;
            }

        }
        System.out.println(Arrays.toString(res));
    }

    @Test
    public void test01() {
        reverseVowel_345.solution("leetcode");
    }
}
