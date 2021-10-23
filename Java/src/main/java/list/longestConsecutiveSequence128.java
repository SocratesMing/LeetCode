package list;

import java.util.HashSet;

public class longestConsecutiveSequence128 {
    private static int solution(int[] arr) {
        HashSet<Integer> hashSet = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            hashSet.add(arr[i]);
        }
        int res = 0;
        for (Integer integer : hashSet) {
            Integer currentNum = integer;
            if (!hashSet.contains(currentNum - 1)) {  //如果包含前一个数说明计算过了，直接跳过
                int temp = 1;

                while (hashSet.contains(currentNum + 1)) {
                    currentNum++;
                    temp++;

                }
                res = Math.max(res, temp);
                System.out.println(res);
            }

        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2};
        System.out.println(solution(arr));

    }
}
