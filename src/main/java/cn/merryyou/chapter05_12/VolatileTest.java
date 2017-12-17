package cn.merryyou.chapter05_12;

/**
 * volatile变量自增运算测试
 * Created on 2017/12/12 0012.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
public class VolatileTest {

    public static final int THREADS_COUNT = 20;
    public static volatile int race = 0;

    public static void increase() {
        race++;
    }

    public static void main(String[] args) {
        System.out.println("https://longfeizheng.github.io");

        Thread[] thread = new Thread[THREADS_COUNT];

        for (int i = 0; i < THREADS_COUNT; i++) {
            thread[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        increase();
                    }
                }
            });
            thread[i].start();
        }

        while (Thread.activeCount() > 1) {
            Thread.yield();
        }

        System.out.println(race);
    }

}
