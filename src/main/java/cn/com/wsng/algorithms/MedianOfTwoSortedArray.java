package cn.com.wsng.algorithms;

/**
 *
 * @author wsng
 * @date 2019/11/13
 *
 * 求解两个数组的中位数
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity
 * should be O(log (m+n)).
 * You may assume nums1 and nums2 cannot be both empty.
 * Example 1:
 * nums1 = [1, 3]  nums2 = [2] The median is 2.0
 *
 * Example 2:
 * nums1 = [1, 2]  nums2 = [3, 4] The median is (2 + 3)/2 = 2.5
 * @see
 *
 */
public class MedianOfTwoSortedArray {

    /**
     * 类似窗口问题，设置起点，定义边界
     * 递归函数缩小边界，找到临界点
     * 例：找下面两个数组的中位数
     * 获取中位数 <==> 获取两个数组组合后数组中的第（n+m+1）/2---（定义这个数为k）的数
     * 与第（n+m+2）/2的数的平均值
     * 将两个数组中的中位数比较小的那方,去除前k/2的数,即将数组逐渐缩小，直到返回最终结果
     *
     * {3}{2,4,5}
     *
     * @param nums1
     * @param nums2
     * @return
     */


    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //定义初始数组长度，中位数位置标识，左右数组起始边界
        int n = nums1.length,m=nums2.length,l=(n+m+1)/2,r=(n+m+2)/2,i=0,j=0;
        //取出较小参数与较大参数取平均
//        System.out.println(findkth(nums1,nums2,0,0,l));
//        System.out.println(findkth(nums1,nums2,0,0,r));
        int a = findkth(nums1,nums2,0,0,l);
        System.out.println(a);
        int b = findkth(nums1,nums2,0,0,r);
        System.out.println(b);
        return (a+b)/2.0;

    }

    /**
     * @param nums1
     * @param nums2
     * @param i
     * @param j
     * @param k
     * @return
     */
    public static int findkth(int[] nums1,int[] nums2,int i,int j,int k){
        //若某个数组长度为0，即直接返回另一个数组的中位数
        //在这种操作中只会返回计算中位数所需参数中较大的或一样大的参数
        if(i>=nums1.length){
            return nums2[j+k-1];
        }
        if(j>=nums2.length){
            return nums1[i+k-1];
        }
        if(k==1){
            //这时有两种情况，nums1 和 nums2的长度组合只有（1,0）（1,1）这两种
            //其中 第一种情况，上面的处理直接可以返回结果，若是第二种
            //此时上面操作会帮我们取到值较大的那个，所以这里我们需要把较小的参数
            //取出来，所以有以下操作
            int a = Math.min(nums1[i+k-1],nums2[j+k-1]);
            return a;
        }
        //取出左右数组当前的中位数，若此时中位数的位数大于等于数组长度，说明
        //目标值已不在当前数组中，我们直接操作另一个数组,并且另一个数组的前k/2
        //个数也可以不考虑 因为前一个数组的长度加上k/2 小于k 即中位数的理论位置
        int midValueL = (i+k/2-1)<nums1.length?nums1[i+k/2-1]:Integer.MAX_VALUE;
        int midValueR = (j+k/2-1)<nums2.length?nums2[j+k/2-1]:Integer.MAX_VALUE;
        if(midValueL<midValueR){
            //将中值较小的数组的起始值右移（增加）k/2位置，因为此时目标值已不在这个范围
            // 内，并且将k也减小k/2（二分法,对称移除K/2的位数后，理论中位数的位置）,再递归该方法直至找到目标值
            return findkth(nums1,nums2,i+k/2,j,k-k/2);
        }else{
            //同上镜像处理
            return findkth(nums1,nums2,i,j+k/2,k-k/2);
        }

    }


    public static void main(String[] args){
        //to do something interesting
        int[] nums1 = {1};
        int[] nums2 = {2};

      System.out.println(findMedianSortedArrays(nums1,nums2));


    }






}
