package cays.reflect;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 执行配置文件类的方法
 *
 * @author Chai yansheng
 * @create 2019-07-25 16:26
 **/
public class LoadPropertiesMethod {
    public static void main(String[] args) throws Exception{
        // 1. 通过反射获取Class对象
        Class stuClass = Class.forName(getValue("className"));
        // 2. 获取show()方法
        Method m = stuClass.getMethod(getValue("methodName"));
        // 3. 调用show()方法
        m.invoke(stuClass.getConstructor().newInstance());
    }

    /**
     * 此方法接收一个key，在配置文件中获取相应的value
     * @param key
     * @return
     * @throws IOException
     */
    public static String getValue(String key) throws IOException {
        // 获取配置文件的对象
        Properties properties = new Properties();
        // 获取输入流
        FileReader in = new FileReader("src/cays/reflect/student.txt");
        // 将流加载到配置文件对象中
        properties.load(in);
        in.close();
        // 返回根据key获取的value值
        return properties.getProperty(key);
    }
}
