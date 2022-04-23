package ex2.oom;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * -XX:MetaspaceSize=10M -XX:MaxMetaspaceSize=10M -XX:+PrintGCDetails
 */
public class MethodAreaOutOfMemory {
    public static void main(String[] args) {
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(TestObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    return methodProxy.invoke(objects,objects);
                }
            });
            enhancer.create();
        }
    }
}
class TestObject {
    private double a = 11.11;
    private Integer b = 999999;
}