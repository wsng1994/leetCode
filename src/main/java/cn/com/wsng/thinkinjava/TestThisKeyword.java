package cn.com.wsng.thinkinjava;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wsng on 2019/11/18.
 */
public class TestThisKeyword {
    TestThisKeyword(){
        System.out.println("使用this");
        nd();
//        this.nd();
    }
    public void nd(){
        System.out.println("不使用this");
    }
    public static void main(String[] args){
          //to do something interesting
        TestThisKeyword t = new TestThisKeyword();
//        t.d();

        int i = 1;
        System.out.println();
        Map map = new HashMap();
    }
}
