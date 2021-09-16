package string;

import java.sql.PreparedStatement;

public class longest_palindromic_substring_05 {

    public static void main(String[] args) {
        String s = "babad";
        solution(s);
    }

    public static void solution(String str) {
        if (str.length() == 0 || str == null) {
            System.out.println("");
        }
        int start = 0, end = 0;
        for (int i = 0; i < str.length(); i++) {
            int len1 = expandCenter(str, i, i);
            int len2 = expandCenter(str, i, i+1);
            int temp = Math.max(len1,len2);
            if (temp > end-start) {
                start = i - (temp-1) / 2;
                end = i + temp / 2;
            }
        }

        System.out.println(str.substring(start,end+1));
    }

    public static int expandCenter(String s, int centPost1, int centPost2) {
        while (centPost2 < s.length() && centPost1 >= 0 && s.charAt(centPost1) == s.charAt(centPost2)) {
            centPost1--;
            centPost2++;
        }
        //回文串的长度是right-left+1-2 = right - left - 1
        return centPost2 - centPost1 - 1;
    }
}
