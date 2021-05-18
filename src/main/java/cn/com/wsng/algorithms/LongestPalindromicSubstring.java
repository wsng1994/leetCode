package cn.com.wsng.algorithms;

/**
 * 求一串字符串的最长回文
 * @author wsng
 * @date 2019/11/17
 */
public class LongestPalindromicSubstring {
    //核心思想：取字符中的某值向两边扩散并判断是否相等，相等即为回文
    //注意得考虑回文的奇偶性

    public static String  longestPalindromicSubstring(String s){
        //初始化字符串长度，最大回文长度，回文起点位置
        int n = s.length(),max=0,start=0;
        //若回文长度为1则返回字符串本身
        if(n<2){
            return s;
        }
        //循环处理回文
        for(int i=0;i<n-1;){
            if(n-i<max/2){
                //当剩下的字符串长度不及已找到的最大回文长度的一半时
                //说明最大回文已经不可能在余下的字符串中了，此时直接
                //跳出循环
                break;
            }else{
                //定义每次循环时回文的起、始位
                int l = i,r=i;
                while(r<n-1&&s.charAt(r)==s.charAt(r+1)){
                    //此时相当于相邻的两个字符相等，于是扩充
                    //回文的右边边界
                    r++;
                }
                //定义下次循环的起点，这里本来值应为i=i+1,但是若上面含有相邻值相等的情况
                //就会重复多余的循环查询
                i=r+1;
                while(r<n-1&&l>0&&s.charAt(r+1)==s.charAt(l-1)){
                    //起点字符两侧的字符相等，此时将回文串向两侧扩充
                    l--;
                    r++;
                }
                if(max<=r-l+1){
                    max = r-l+1;
                    start = l;
                }

            }

        }
        return s.substring(start,start+max);
    }
    public static void main(String[] args){
          //to do something interesting
          System.out.println(longestPalindromicSubstring("cccmscc"));
    }
}




