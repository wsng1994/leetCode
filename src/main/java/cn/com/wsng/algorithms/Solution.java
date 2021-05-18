package cn.com.wsng.algorithms;


import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author wsng
 * @date 2019/11/12
 *
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 *你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 *示例:
 *给定 nums = [2, 7, 11, 15], target = 9
 *因为 nums[0] + nums[1] = 2 + 7 = 9
 *所以返回 [0, 1]
 */
public class Solution {
    /**
     * 该方法仍有缺陷，当数组有重复时，方法需修改
     * @param nums
     * @param t
     * @return
     */
    public static String sum(int[] nums,int t){
        //初始化结果数组
        int[] result={0,0};
        //定义容器Map
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        //循环入参数组
        for(int i=0;i<nums.length;i++){
            //用两数差找满足条件key
            int val = t-nums[i];
            //判断map是否包含该key,且不是自己
            if(map.containsKey(val)&&val!=nums[i]){
                //若符合条件则输出结果
                //这里相当于输出了j
                result[0] = map.get(val);
                //这里同理输出i值
                result[1] = i;
            }
            //将nums[i]作为key，下标作为value存进map
            //在上面判断时，若map包含val,则说明数组中某个nums[j]=val=t-nums[i],i!=j
            //nums[i],nums[j]即为满足条件的值，i,j即为结果集所需
            map.put(nums[i],i);
        }
        return "["+result[0]+","+result[1]+"]";
    }

}
