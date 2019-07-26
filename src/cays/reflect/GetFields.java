package cays.reflect;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * 获取成员变量
 *
 * @author Chai yansheng
 * @create 2019-07-25 16:06
 **/
public class GetFields {
    public static void main(String[] args) throws Exception {
        // 1. 获取Class对象
        Class studentClass = Class.forName("cays.reflect.Student");
        // 2. 获取字段
        System.out.println("************获取所有公有的字段********************");
        Field[] fields = studentClass.getFields();
        Arrays.stream(fields).forEach(field -> System.out.println(field));
        System.out.println("************获取所有的字段(包括私有、受保护、默认的)********************");
        Field[] fields1 = studentClass.getDeclaredFields();
        Arrays.stream(fields1).forEach(field -> System.out.println(field));
        System.out.println("*************获取公有字段**并调用***********************************");
        Field field = studentClass.getField("name");
        System.out.println(field);
        Object object = studentClass.getConstructor().newInstance();
        field.set(object, "Cays");
        Student student = (Student)object;
        System.out.println("姓名：" + student.name);
        System.out.println("**************获取私有字段****并调用********************************");
        field = studentClass.getDeclaredField("phoneNum");
        System.out.println(field);
        // 暴力反射，解除私有限定
        field.setAccessible(true);
        field.set(object, "15736567896");
        System.out.println("电话：" + student);

    }
}
