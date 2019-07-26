package cays.reflect;

/**
 * 获取对象的三种方式
 * 1 Object ——> getClass();
 * 2 任何数据类型（包括基本数据类型）都有一个"静态"的class属性
 * 3 通过Class类的静态方法：forName（String  className）(常用)
 * @author Chai yansheng
 * @create 2019-07-25 15:46
 **/
public class GetClassMethod {
    public static void main(String[] args) {
        //第一种方式获取Class对象,new产生一个Student对象和一个Class对象
        Student student1 = new Student();
        //获取class对象
        Class studentClass1 = student1.getClass();
        System.out.println(studentClass1.getName());

        //第二种方式获取Class对象
        Class studentClass2 = Student.class;
        //判断第一种方式获取的Class对象和第二种方式获取的是否是同一个
        System.out.println(studentClass1 == studentClass2);
        //第三种方式获取Class对象
        try {
            Class studentClass3 = Class.forName("cays.reflect.Student");
            System.out.println(studentClass1 == studentClass3);
            System.out.println(studentClass2 == studentClass3);
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
