package cays.reflect;

import java.lang.reflect.Constructor;
import java.util.Arrays;

/**
 * 通过反射获取构造方法并使用
 *
 * @author Chai yansheng
 * @create 2019-07-25 15:54
 **/
public class GetConstructorsMethod {
    public static void main(String[] args) throws Exception {
        // 1. 加载Class对象
        Class studentClass = Class.forName("cays.reflect.Student");
        // 2. 获取所有公有构造方法
        System.out.println("**********************所有公有构造方法*********************************");
        Constructor[] constructors = studentClass.getConstructors();
        Arrays.stream(constructors).forEach(constructor -> System.out.println(constructor));
        System.out.println("************所有的构造方法(包括：私有、受保护、默认、公有)***************");
        Constructor[] constructors1 = studentClass.getDeclaredConstructors();
        Arrays.stream(constructors1).forEach(constructor -> System.out.println(constructor));
        System.out.println("*****************获取公有的无参的构造方法*******************************");
        // 1. 因为是无参的构造方法所以类型是一个null,不写也可以：这里需要的是一个参数的类型，切记是类型
        // 2. 返回的是描述这个无参构造函数的类对象
        Constructor c1 = studentClass.getConstructor(null);
        System.out.println("constructor = " + c1);
        // 调用
        Object object1 = c1.newInstance();
        System.out.println("******************获取私有构造方法并调用*******************************");
        c1 = studentClass.getDeclaredConstructor(char.class);
        System.out.println("constructor = " + c1);
        // 调用构造方法
        c1.setAccessible(true);// 暴力访问(忽略掉访问修饰符)
        object1 = c1.newInstance('男');

    }
}
