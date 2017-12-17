package cn.merryyou.chapter02_02;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 使用unsafe分配本机内存
 * Created on 2017/12/17 0017.
 *
 * VM Args:-Xmx20M -XX:MaxDirectMemorySize=10M
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
public class DirectMemoryOOM {

    private static final  int _1MB =  1024 * 1024;

    public static void main(String[] args) throws Exception {
        System.out.println("https://longfeizheng.github.io");

        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true){
            unsafe.allocateMemory(_1MB);
        }
    }
}
