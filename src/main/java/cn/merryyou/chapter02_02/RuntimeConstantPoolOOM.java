package cn.merryyou.chapter02_02;

import java.util.ArrayList;
import java.util.List;

/**
 * 运行时常量池导致的内存溢出异常
 * Created on 2017/12/17 0017.
 *
 * VM Args: -XX:PermSize=10M -XX:MaxPermSize=10M
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
        System.out.println("https://longfeizheng.github.io");
        //使用list保持常量池引用，避免Full Gc 回收常量池行为
        List<String> list = new ArrayList<String>();
        //10m 的PermSize 在integer范围内足够产生OOM
        int i= 0;
        while (true){
            list.add(String.valueOf(i++).intern());
        }
    }
}
