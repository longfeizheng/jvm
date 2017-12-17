package cn.merryyou.chapter04_10;

/**
 * 自动装箱的陷阱  IntegerCache - 128 - 127
 * Created on 2017/12/11 0011.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
public class AutoBoxingTest {
    public static void main(String[] args) {
        System.out.println("https://longfeizheng.github.io");

        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3l;
        Long h = 4l;
        Long i = 7l;
        Long j = 321l;
        Long k = 321l;
        System.out.println(c == d);
        System.out.println(e == f);
        System.out.println(c == (a + b));
        /** 源码显示
         public boolean equals(Object obj) {
         if (obj instanceof Integer) {
         return value == ((Integer)obj).intValue();
         }
         return false;
         }
         */
        System.out.println(c.equals(a + b));
        System.out.println(g == (a + b));
        System.out.println(g.equals(a + b));
        System.out.println(i == (g + h));
        System.out.println(i.equals(g + h));
        System.out.println(c.equals(g));
        System.out.println(k == j);
        System.out.println(k.equals(j));
    }
}
