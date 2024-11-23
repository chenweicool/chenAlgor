package com.chen.algor.backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * 第46道题，全排列
 * 使用回溯法进行处理
 */
public class LeetCode46 {
    /**
     * 回溯算法，也就是递归调用
     */
    public List<List<Integer>> permute(int[] num) {
           // 声明一个数组，然后进行计算
        List<List<Integer>> result = new ArrayList<>();
        // 回朔算法的实现
        brackCaback(result, new ArrayList<>(), num);
        return result;
    }

    private void brackCaback(List<List<Integer>> result, ArrayList<Integer> temList, int[] num) {
        if (temList.size() == num.length) {
            result.add(new ArrayList<>(temList));
        }else{
            for (int i = 0; i < num.length; i++) {
                // 元素已经在临时表中，可以跳过
                if(temList.contains(num[i]))continue;
                temList.add(num[i]);
                brackCaback(result, temList, num);
                // if执行完之后执行,移除第一个递归
                temList.remove(temList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int[] nums2 = {0,1};
        System.out.println(new LeetCode46().permute(nums2));
       System.out.println(new LeetCode46().permute(nums));
    }
}
