package cn.com.wsng.algorithms;

/**
 * 将给定的字符串转成 Z 字型输出
 *
 *
 * @author wsng
 * @date 2019/11/18
 */
public class ZigZagConversion {

    public static  String convert(String s, int numRows) {
        if (numRows <= 1){
            return s;
        }

        int size = 2 * numRows - 2, n = s.length();

        for (int i = 0; i < numRows; i++) {
            String res = "";
            for (int j = i; j < n; j += size) {
                res += s.charAt(j);
                int pos = j + size - 2 * i;
                if (i != 0 && i != numRows - 1 && pos < n) {
                    res += s.charAt(pos);
                }
            }
            System.out.println(res);
        }
        return s;
    }

    public static void main(String[] args){
          //to do something interesting
        String a = convert("abcdefghijk",3);
    }



}
