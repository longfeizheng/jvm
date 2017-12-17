package cn.merryyou.chapter02_02;

/**
 * jdk6: false false;
 * jdk7: true false;
 * 在JDK1.6 中，intern()方法会把首次遇到的字符串实例复制到到永久代中，返回的也就是永久代中这个字符串实例的引用，而由StringBuilder
 * 创建的字符串实例在Java堆上，所以必然不是同一个引用
 * 而JDK1.7中的intern()实现不会再复制实例，只是在常量池中记录首次出现的实例引用，因此intern()返回的引用和由StringBuilder创建的那个
 * 字符串实例是同一个。对Str2比较返回false是因为“java” 这个字符串在执行StringBuilder.toString()之前已经出现过，字符串常量池已经有
 * 它的引用了，不符合“首次出现”的原则，而“计算机软件”这个字符串则是首次出现的，因此返回true??
 * Created on 2017/12/17 0017.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
public class RuntimeConstantPoolOOM_01 {

    public static void main(String[] args) {
        System.out.println("https://longfeizheng.github.io");

        String str1 = new StringBuffer("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);

        String str3 = new StringBuilder("中").append("国").toString();
        System.out.println(str3.intern() == str3);

        String str4 = new StringBuilder("hello").append("world").toString();
        System.out.println(str4.intern() == str4);
    }
}
