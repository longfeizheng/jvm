package cn.merryyou.chapter03_08;

/**
 * 方法静态分派演示
 * Created on 2017/12/11 0011.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
public class StaticDispatch {

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        StaticDispatch sr = new StaticDispatch();
        sr.sayHello(man);
        sr.sayHello(woman);
    }

    public void sayHello(Human guy) {
        System.out.println("hello guy!");
    }

    public void sayHello(Man guy) {
        System.out.println("hello gentleman!");
    }

    public void sayHello(Woman guy) {
        System.out.println("hello lady");
    }

    static abstract class Human {

    }

    static class Man extends Human {

    }

    static class Woman extends Human {

    }
}
