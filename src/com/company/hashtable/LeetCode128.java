package com.company.hashtable;

import java.util.HashSet;
import java.util.Set;

public class LeetCode128 {
    public int longestConsecutive(int[] nums) {
        // 去重
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        // 遍历每个num+1，+2...计算长度
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int curr = num;
                int temp = 1;

                while (set.contains(curr + 1)) {
                    curr++;
                    temp++;
                }
                res = Math.max(res, temp);
            }
        }
        return res;
    }
}
