package cays.reflect;

import java.lang.reflect.Method;

/**
 * 获取成员方法
 *
 * @author Chai yansheng
 * @create 2019-07-25 16:17
 **/
public class GetMethods {
    public static void main(String[] args) throws Exception {
        // 1. 获取Class
        Class studentClass = Class.forName("cays.reflect.Student");
        // 2. 获取所有公有方法
        System.out.println("***************获取所有的公有方法*******************");
        studentClass.getMethods();
        Method[] methodArray = studentClass.getMethods();
        for(Method m : methodArray){
            System.out.println(m);
        }
        System.out.println("***************获取所有的方法，包括私有的*******************");
        methodArray = studentClass.getDeclaredMethods();
        for(Method m : methodArray){
            System.out.println(m);
        }
        System.out.println("***************获取公有的show1()方法*******************");
        Method m = studentClass.getMethod("show1", String.class);
        System.out.println(m);
        // 实例化一个Student对象
        Object obj = studentClass.getConstructor().newInstance();
        m.invoke(obj, "刘德华");

        System.out.println("***************获取私有的show4()方法******************");
        m = studentClass.getDeclaredMethod("show4", int.class);
        System.out.println(m);
        // 解除私有限定
        m.setAccessible(true);
        // 需要两个参数，一个是要调用的对象（获取有反射），一个是实参
        Object result = m.invoke(obj, 20);
        System.out.println("返回值：" + result);
    }
}
