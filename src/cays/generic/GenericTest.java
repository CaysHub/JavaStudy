package cays.generic;

/**
 * 一个简单的泛型
 * 此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型
 * 在实例化泛型类时，必须指定T的具体类型
 * @author Chai yansheng
 * @create 2019-07-26 16:00
 **/
public class GenericTest<T> {
    // 成员变量的类型为T,T的类型由外部指定
    private T value;

    public GenericTest(T value) {
        // 泛型构造方法形参key的类型也为T，T的类型由外部指定
        this.value = value;
    }

    /**
     * 泛型方法的返回值类型为T，T的类型由外部指定
     * @return
     */
    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
