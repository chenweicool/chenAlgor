package com.chen.algor.arrays;

/**
 * 加油站，题目描述
 * 在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 * 给定两个整数数组 gas 和 cost ，如果你可以按顺序绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。
 * 如果存在解，则 保证 它是 唯一 的。
 */
public class LeetCode134 {

    /**
     * 解题思路： 核心标签：数组，贪心
     * 通过模拟油量来完成这个题目：
     * 1 遍历加油站，当前油量，判断是不是可以继续
     * 2 当前油量，等于上一个加油站减去行驶所需要的油量
     * 3 判读是否可以继续，当前油量是否为负，如果为负，就更新起点为下一个加油站，并重置油量
     * 4  返回起点，如果能绕回来，那么就可以完成闭环
     */
    public int canCompleteCircuit(int[] gas, int[] cost){
         int totalGas = 0;
         int totalCos = 0;
         int currentGas = 0;
         int start = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCos += cost[i];
            currentGas += gas[i] - cost[i];
            if (currentGas < 0) {
                start = i + 1;
                currentGas = 0;
            }
        }
        return totalGas >= totalCos ? start : -1;
    }

    public static void main(String[] args) {
      int[] gas = {1,2,3,4,5};
      int[] cos = {3,4,5,1,2};
        System.out.println(new LeetCode134().canCompleteCircuit(gas,cos));
    }
}
