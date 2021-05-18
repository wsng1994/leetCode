package cn.com.wsng.algorithms;

import java.util.Arrays;

/**
 *
 * @author wsng
 * @date 2019/11/13
 *获取无重复字符的最长字串
 * Examples:
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 *
 * Given "bbbbb", the answer is "b", with the length of 1.
 *
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the
 * answer must be a substring, "pwke" is a subsequenceand not a substring.
 *
 */
public class LengthOfLongestSubString {

    /**
     * 在这里我们可以通过一个类似滑动窗口来实现，res代表无重复字符的长度，
     * left代表滑动窗口最左边的字符，m是一个大小为256的一维数组，代表256个ASCII码。
     * @return
     */

    public static int lengthOfLongestSubString(String str){
        //定义一个窗口移动的集合(可包含全字符集)
        int[] m = new int[256];
        //left为窗口左边界 res为窗口大小
        int left = -1,res = 0;
        // 初始化 m
        Arrays.fill(m,left);
        //循环字符
        for(int i =0;i<str.length();i++){
            //定义窗口左边界（每当有重复字符串时候，左边界向右移动）;
            left = Math.max(left,m[str.charAt(i)]);
            //扩展窗口右边界，i为窗口移动大小
            m[str.charAt(i)] = i;
            //获取并比较每次窗口大小（i-left）
            res = Math.max(res,i-left);
        }
        return res;

    }

}
