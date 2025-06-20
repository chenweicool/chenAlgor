package com.chen.algor.string;

/**
 * 给你两个 版本号字符串 version1 和 version2 ，请你比较它们。版本号由被点 '.' 分开的修订号组成。修订号的值是它 转换为整数 并忽略前导零。
 * 比较版本号时，请按 从左到右的顺序 依次比较它们的修订号。如果其中一个版本字符串的修订号较少，则将缺失的修订号视为 0。
 *
 * 举例：
 * 示例 1：
 * 输入：version1 = "1.2", version2 = "1.10"
 * 输出：-1
 * 解释：
 * version1 的第二个修订号为 "2"，version2 的第二个修订号为 "10"：2 < 10，所以 version1 < version2。
 * 示例 2：
 * 输入：version1 = "1.01", version2 = "1.001"
 * 输出：0
 * 解释：
 * 忽略前导零，"01" 和 "001" 都代表相同的整数 "1"。
 * 示例 3：
 */
public class LeetCode165 {

    //  正则表达式切分，然后逐个比较
    public int compareVersion(String version1, String version2) {
        String[] varchar1 = version1.split("\\.");
        String[] varchar2 = version2.split("\\.");

        int maxLength = Math.max(varchar2.length, varchar1.length);
        for (int i = 0; i < maxLength; i++) {
              int num1 = i < varchar1.length ? Integer.parseInt(varchar1[i]) : 0;
            int num2 = i < varchar2.length ? Integer.parseInt(varchar2[i]) : 0;

            if (num1 < num2) {
                return -1;
            }
           else if (num1 > num2) {
                 return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode165().compareVersion("1.1", "1.2"));
    }
}
