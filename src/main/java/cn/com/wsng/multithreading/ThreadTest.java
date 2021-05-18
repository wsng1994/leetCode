package cn.com.wsng.multithreading;

/**
 *
 * @author wsng
 * @date 2019/12/16
 */
public class ThreadTest {

    public static void main(String[] args) {

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
            }
        }).start();
    }



}
