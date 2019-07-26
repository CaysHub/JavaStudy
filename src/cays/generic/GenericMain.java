package cays.generic;

import java.util.Arrays;

/**
 * 泛型测试类
 *
 * @author Chai yansheng
 * @create 2019-07-26 16:04
 **/
public class GenericMain {
    public static void main(String[] args) {
        // 传入的实参类型需与泛型的类型参数类型相同，即为String.
        GenericTest<String> str = new GenericTest<>("Hello");
        System.out.println("str:" + str.getValue());
        // 泛型的类型参数只能是类类型（包括自定义类），不能是简单类型
        // 传入的实参类型需与泛型的类型参数类型相同，即为Integer.
        GenericTest<Integer> integerGenericTest = new GenericTest<>(100);
        System.out.println("int:" + integerGenericTest.getValue());

        showValue(integerGenericTest);
        showValue(str);
        String sd = genericMethod(new GenericTest<String>("uu"));
        System.out.println(sd);
        printStrs("as", 12, 78.99);
        showValue1(new GenericTest<Integer>(12));

    }
    public static void showValue(GenericTest<?> value) {
        System.out.println(value.getValue());
    }

    /**
     * @param object 传入的泛型实参
     * @return T 返回值为T类型
     */
    public static <T> T genericMethod(GenericTest<T> object){
        T instance = object.getValue();
        return instance;
    }
    public static <T> void printStrs(T... args) {
        Arrays.stream(args).forEach(arg -> System.out.println(arg.getClass()));
    }
    public static void showValue1(GenericTest<? extends Number> object) {
        System.out.println(object.getValue() + ": " +object.getValue().getClass());
    }
}
