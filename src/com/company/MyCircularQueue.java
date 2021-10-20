public class MyCircularQueue {
    //数组
    private int[] data;
    //头
    private int head;
    //尾
    private int tail;
    //数组大小
    private int size;

    /**
     * 构造函数
     *
     * @param k 数组大小
     */
    public MyCircularQueue(int k) {
        data = new int[k];
        head = -1;
        tail = -1;
        size = k;

    }

    /**
     * 入队
     *
     * @param value
     * @return
     */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        if (isEmpty()) {
            head = 0;
        }
        tail = (tail + 1) % size;
        data[tail] = value;
        return true;
    }

    /**
     * 出队
     *
     * @return
     */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        if (head == tail) {
            //最后一个元素，移除后为空数组
            head = -1;
            tail = -1;
            return true;
        }
        head = (head + 1) % size;

        return true;
    }

    //返回队头
    public int Front() {
        if (isEmpty()) {
            return -1;
        } else {
            return data[head];
        }
    }

    //返回队尾
    public int Rear() {
        if (isEmpty()) {
            return -1;
        } else {
            return data[tail];
        }
    }

    public boolean isEmpty() {
        if (head == -1 && tail == -1) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if ((tail + 1) % size == head) {
            return true;
        }
        return false;
    }
}
