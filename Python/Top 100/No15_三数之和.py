"""
给你一个整数数组 nums ，
判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。

注意：答案中不可以包含重复的三元组。
"""
from typing import List


class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        res = []
        sorted_nums = sorted(nums)

        for i, num in enumerate(sorted_nums):
            if i>=0 and sorted_nums[i]==sorted_nums[i-1]:
                continue
            l = i + 1
            r = len(nums) - 1
            target = -num
            while l < r:
                sum = sorted_nums[l] + sorted_nums[r]
                if (sum == target):
                    res.append([num, sorted_nums[l], sorted_nums[r]])
                    l += 1
                    r -= 1
                    while l < r and sorted_nums[l] == sorted_nums[l - 1]:
                        l += 1
                    while l < r and sorted_nums[r] == sorted_nums[r + 1]:
                        r -= 1
                elif sum < target:
                    l += 1
                else:
                    r -= 1
        return res