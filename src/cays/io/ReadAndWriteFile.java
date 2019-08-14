package cays.io;

import java.io.*;

/**
 * 读写文件，设定字符集
 *
 * @author Chai yansheng
 * @create 2019-08-14 16:41
 **/
public class ReadAndWriteFile {
    /**
     * 字节流读写文件
     * @throws IOException
     */
    public void readAndWriteFile() throws IOException {
        String file = "src\\cays\\io\\a.txt";
        String charset = "UTF-8";
        String str = "这是要保存的中文字符";
        // 写字符换转成字节流
        FileOutputStream outputStream = new FileOutputStream(file);
        OutputStreamWriter writer = new OutputStreamWriter(outputStream, charset);
        writer.write(str);
        writer.close();
        // 读取字节转换成字符
        FileInputStream inputStream = new FileInputStream(file);
        InputStreamReader reader = new InputStreamReader(inputStream, charset);
        StringBuffer buffer = new StringBuffer();
        char []buf = new char[1024];
        int count = 0;
        while ((count = reader.read(buf)) != -1) {
            buffer.append(buf, 0, count);
        }
        reader.close();
        System.out.println("buffer:" + buffer.toString());
    }
    public void encode() {
        String str = "I am 君山";
        System.out.println("java       encode: " + toHex(str.getBytes()));
        try {
            byte []iso8859 = str.getBytes("iso-8859-1");
            System.out.println("iso-8859-1 encode: " + toHex(iso8859));
            byte []gb2312 = str.getBytes("gb2312");
            System.out.println("gb2312     encode: " + toHex(gb2312));
            byte []gbk = str.getBytes("gbk");
            System.out.println("gbk        encode: " + toHex(gbk));
            byte []utf16 = str.getBytes("utf-16");
            System.out.println("utf-16     encode: " + toHex(utf16));
            byte []utf8 = str.getBytes("utf-8");
            System.out.println("utf-8      encode: " + toHex(utf8));

        }catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
    public String toHex(byte[] src) {
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return "";
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv+" ");
        }
        return stringBuilder.toString();
    }
    public static void main(String[] args) throws IOException {
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        readAndWriteFile.readAndWriteFile();
        readAndWriteFile.encode();
    }
}
