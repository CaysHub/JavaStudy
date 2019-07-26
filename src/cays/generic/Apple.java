package cays.generic;

/**
 * 苹果
 *
 * @author Chai yansheng
 * @create 2019-07-26 16:20
 **/
public class Apple implements Fruit<String> {
    @Override
    public String getFruit() {
        return "apple";
    }
}
