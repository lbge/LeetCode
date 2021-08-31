package com.company.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    private static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }
        Arrays.sort(nums); //排序
        for (int i = 0; i < nums.length; i++) {
            int flag = nums[i];
            if (flag > 0) { //如果当前值大于零，之后不会再有三数满足
                return res;
            }
            //去除重复的的flag
            if (i > 0 && flag == nums[i - 1]) {
                //此处用nums[i - 1]判断，不能使用num[i+1],会丢失有用的数字
                continue;
            }
            //设置左右指针
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = flag + nums[l] + nums[r];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    res.add(list);
                    //去除重复项
                    while (l < r && nums[l + 1] == nums[l]) l++;
                    while (l < r && nums[r - 1] == nums[r]) r--;
                    //取完满足条件的三数，左右指针更新
                    l++;
                    r--;
                } else if (sum > 0) {
                    //和大于零，右指针太大
                    r--;
                } else {
                    //和小于零，左指针太小
                    l++;
                }
            }
        }
        return res;
    }
}
