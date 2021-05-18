package cn.com.wsng.leetCodeUtils;

/**
 *
 * @author wsng
 * @date 2019/11/13
 *
 * 在节点ListNode定义中，定义为节点为结构变量。
 *节点存储了两个变量：value 和 next。value 是这个节点的值，next 是指向下一节点的指针，
 * 当 next 为空指针时，这个节点是链表的最后一个节点。
 * 注意注意val只代表当前指针的值，比如p->val表示p指针的指向的值；而p->next表示链表下
 * 一个节点，也是一个指针。
 * 构造函数包含两个参数 _value 和 _next ，分别用来给节点赋值和指定下一节点
 *
 */
public  class ListNode {
    /**
     * 定义val变量值，存储节点值
     */

    public int val;
    /**
     * 定义next指针，指向下一个节点，维持节点连接
     */

    public ListNode next;
}
