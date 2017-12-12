package cn.merryyou.chapter05_13;

import java.util.Vector;

/**
 * 对Vector县城安全的测试
 * Created on 2017/12/12 0012.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
public class VectorTest {
    private static Vector<Integer> vector = new Vector<>();

    public static void main(String[] args) {
        while (true) {
            for (int i = 0; i < 10; i++) {
                vector.add(i);
            }

            Thread removeThread = new Thread(() -> {
                for (int i = 0; i < vector.size(); i++) {
                    vector.remove(i);
                }
            });

            Thread printThread = new Thread(()->{
                for (int i = 0; i < vector.size(); i++) {
                    System.out.println(vector.get(i));
                }
            });

            removeThread.start();
            printThread.start();

            //不要同时产生过多的线程，否则会导致操作系统假死
            while (Thread.activeCount()>20);
        }
    }
}
