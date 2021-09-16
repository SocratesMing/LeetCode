package twoPointer;

import org.junit.Test;

import java.util.Arrays;

public class MoveZeros {
        public static void   solution(int[] nums) {
            int slow=0,fast=0;
            while(fast<nums.length){
                if (nums[fast]!=0){
                    int temp=nums[slow];
                    nums[slow]=nums[fast];
                    nums[fast]=temp;
                    slow++;
                }
                fast++;
            }
            System.out.println(Arrays.toString(nums));

        }

    public static void solution2(int[] nums) {
        int k = 0;
        for (int i : nums) {
            if (i!=0) {
                nums[k] = i;
                k++;
            }

        }
        System.out.println(k);
        for (int i = k; i < nums.length; i++) {
            nums[i]=0;
        }

        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void test01() {
             MoveZeros.solution(new int[]{0,1,0,3,12});
             MoveZeros.solution2(new int[]{0,1,0,3,12});
    }
    }
