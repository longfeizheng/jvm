package cn.merryyou.chapter02_02;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 借助CGLib使方法区出现内存溢出异常
 * Created on 2017/12/17 0017.
 *
 * VM Args: -XX:PermSize=10M -XX:MaxPermSize=10M
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
public class JavaMethodAreaOOM {
    public static void main(String[] args) {
        System.out.println("https://longfeizheng.github.io");
        while (true){
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object obj, Method method, Object[] args1, MethodProxy proxy) throws Throwable {
                    return proxy.invoke(obj, args1);
                }
            });
            enhancer.create();
        }
    }

    static class OOMObject{

    }
}
