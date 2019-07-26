package cays.customer;

import java.util.ArrayList;
import java.util.List;

/**
 * 仓库存储
 *
 * @author Chai yansheng
 * @create 2019-07-26 14:53
 **/
public class Buffer {
    private static final int BUFFER_SIZE = 20;
    private int[] buffer;
    private int in, out;

    public Buffer() {
        buffer = new int[BUFFER_SIZE];
        in = 0;
        out = 0;
    }

    /**
     * 判断buffer是否为空
     * @return
     */
    public boolean isEmpty() {
        return in == out;
    }

    /**
     * 判断buffer是否满了
     * @return
     */
    public boolean isFull() {
        return ((out + 1) % BUFFER_SIZE) == in;
    }

    public void add(int item) {
        buffer[in] = item;
        in = (in + 1) % BUFFER_SIZE;
    }
    public int remove() {
        int item = buffer[out];
        out = (out + 1) % BUFFER_SIZE;
        return item;
    }

    public int[] getBuffer() {
        return buffer;
    }

    public void setBuffer(int[] buffer) {
        this.buffer = buffer;
    }

    public int getIn() {
        return in;
    }

    public void setIn(int in) {
        this.in = in;
    }

    public int getOut() {
        return out;
    }

    public void setOut(int out) {
        this.out = out;
    }
}
