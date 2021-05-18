package cn.com.wsng.algorithms;

import static java.lang.Math.abs;

/**
 *
 * 翻转整数
 * 例子：
 * input 123 output 321 input -134 output -431 input 190 output 91
 *
 * 注意处理整型溢出的情况！
 *
 * @author wsng
 * @date 2019/11/25
 */
public class ReverseInteger {

    public static int reverseInteger(int k){
        boolean minus = false;
        if(k<0){
            k = k*(-1);
            minus = true;
        }else if(k == 0){
            return 0;
        }
        String count = String.valueOf(k);
        String resString = "";
        int res = 0;
        while (count.length()>0){
            resString += count.charAt(count.length()-1);
            count = count.substring(0,count.length()-1);
        }
        while (resString.startsWith("0")){
            resString = resString.substring(1,resString.length());
        }
        if(minus){
            res = Integer.valueOf(resString)*(-1);
        }else{
            res = Integer.valueOf(resString);
        }
        return res;
    }

    public static void main(String[] args){
          //to do something interesting
          System.out.println(reverse(-2100058000));
    }

    /**
     * 官方解答
     * @param x
     * @return
     */

    public static int reverse(int x) {
            int res = 0;
            while (x != 0) {
                if (abs(res) > Integer.MAX_VALUE / 10){
                    return 0;
                }
                res = res * 10 + x % 10;
                x /= 10;
            }
            return res;
        }
}
