package cn.merryyou.chapter02_02;

/**
 * 虚拟机栈和本地方法栈OOM测试
 * Created on 2017/12/17 0017.
 * VM Args: -Xss128k
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
public class JavaVMStackSOF {

    private int stackLength = 1;

    public static void main(String[] args) {
        JavaVMStackSOF oom = new JavaVMStackSOF();

        System.out.println("https://longfeizheng.github.io");
        try {
            oom.stackLeak();
        }catch (Throwable e){
            System.out.println("stack length:" + oom.stackLength);
        }
    }

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }
}
