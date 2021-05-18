package cn.com.wsng.algorithms;

import cn.com.wsng.leetCodeUtils.ListNode;

/**
 *
 * @author wsng
 * @date 2019/11/13
 *
 * 注意链表的特性，表头即整个表，每个数据都是一个物理节点
 *
 *有一列  1.给出 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)  要求 Output: 7 -> 0 -> 8
 *
 *
 */
public class AddTwoNumbers {
    public static ListNode addTwoNum(ListNode num1, ListNode num2){
        //定义表头
        ListNode pre = null;
        //定义最终表
        ListNode last = null;
        int a ,b,c,d=0;
        while (num1!=null||num2!=null){
            //取表头相加取余 若大于10 后位进制+1
           ListNode node = new ListNode();
           a = num1==null?0:num1.val;
           b = num2==null?0:num2.val;
           c = (a+b)%10;
           d = (a+b)/10;
           if(d>0){
               c=c+1;
           }
           node.val = c;
           if(pre!=null){
               pre.next = node;
           }else{
               //最终表的表头
               last = node;
           }
           num1 = num1.next;
           num2 = num2.next;
           pre = node;
        }
        return last;
    }

}
