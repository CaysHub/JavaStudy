package cays.time;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * 日期测试
 *
 * @author Chai yansheng
 * @create 2019-07-30 9:26
 **/
public class CalendarTest {
    public static void main(String[] args) {
        System.out.println("当前时间："+new Date());
        // Calendar.getInstance() 获取Calendar实例，并获取系统默认的TimeZone
        Calendar calendar = Calendar.getInstance();
        System.out.println("Calendar的系统默认TimeZone ID：" +
                calendar.getTimeZone().getID());
        System.out.println(calendar.getTime());
        // 指定时区，例如意大利的罗马时区：Europe/Rome
        // 罗马时区属于东1区，也就是UTC+1或GMT+1
        TimeZone itTimeZone = TimeZone.getTimeZone("Europe/Rome");

        // Calendar指定罗马时区
        calendar.setTimeZone(itTimeZone);
        System.out.println("Calendar指定TimeZone ID：" + itTimeZone.getID());

        // 夏令时时间，比标准时间快1小时，即3600000毫秒，
        // 根据系统时间计算，如果不在夏令时生效范围内，则为0毫秒，反之为3600000毫秒
        int dstOffset = calendar.get(Calendar.DST_OFFSET);
        // 取得与GMT之间的时间偏移量，例如罗马属于东1区，则时间偏移量为3600000毫秒
        int zoneOffset = calendar.get(Calendar.ZONE_OFFSET);

        System.out.println("夏令时时间："+dstOffset);
        System.out.println("时间偏移量："+zoneOffset);
    }
}
