package cn.merryyou.chapter02_02;

/**
 * 创建线程导致内存溢出异常
 * Created on 2017/12/17 0017.
 *
 * VM Args: -Xss2M
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 *
 * 上述代码执行有较大的风险，可能会导致操作系统假死
 */
public class JavaVMStackOOM {

    private void dontStop(){
        while (true){

        }
    }

    public void stackLeakByThread(){
        while (true){
            Thread thread;
            thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    JavaVMStackOOM.this.dontStop();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        System.out.println("https://longfeizheng.github.io");
        oom.stackLeakByThread();
    }
}
