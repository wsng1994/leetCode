package baseTest;

import cn.com.wsng.leetCodeUtils.ListNode;

import static cn.com.wsng.algorithms.AddTwoNumbers.addTwoNum;
import static cn.com.wsng.algorithms.LengthOfLongestSubString.lengthOfLongestSubString;
import static cn.com.wsng.algorithms.LongestPalindromicSubstring.longestPalindromicSubstring;
import static cn.com.wsng.algorithms.MedianOfTwoSortedArray.findMedianSortedArrays;
import static cn.com.wsng.algorithms.Solution.sum;

/**
 * Created by wsng on 2019/11/16.
 */
public class BaseTest {
    public static void main(String[] args){
//        testAddTwoNumbers();
       System.out.println(testLongestPalindromicSubstring());
    }

    /**
     * 测试链表相加问题
     */
    public static void testAddTwoNumbers(){
        // 测试链表相加问题
        ListNode l1 = null;
        ListNode l2 = null;
        ListNode start1 = null;
        ListNode start2 = null;
        for(int i=0;i<3;i++){
            ListNode node2= new ListNode();
            ListNode node1= new ListNode();
            node1.val = 2+i;
            node2.val = 1+i;
            if(l1!=null){
                //定义指针方向
                l1.next = node1;
                l2.next = node2;
            }else{
                //定义整个链表起点
                start2 = node2;
                start1 = node1;
            }
            //定义单个循环中链表起点
            l1 = node1;
            l2 = node2;
        }
        ListNode testNode = null;
        testNode = addTwoNum(start1,start2);
        while(testNode!=null){
            System.out.println(testNode.val);
            testNode = testNode.next;
        }
    }
    /**
     * 测试找出数组中和为给定值的问题
     */
    public static void testSolution(){
        int[] a = {1,5,2,4};
        System.out.println(sum(a,3));
    }
    /**
     * 测试获取无重复字符的最长字串
     */
    public static void testLengthOfLongestSubString(){
        System.out.println(lengthOfLongestSubString("iokjhooiiiddd"));
    }
    /**
     *测试求两个数组的中位数
     */
    public static double testMedianOfTwoSortedArray(){

        int[] nums1 = {1,3};
        int[] nums2 = {2,4,5};

        return findMedianSortedArrays(nums1,nums2);

    }
    /**
     * 测试字符串最大回文子串
     */
    public static String testLongestPalindromicSubstring(){
        return longestPalindromicSubstring("sdsssasda");
    }


}
