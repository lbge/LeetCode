package com.company.hashtable;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MyHashSet {
    private final int BUCKET_SIZE = 5039;
    private List<Integer>[] buckets;

    private int getKey(int key) {
        return key % BUCKET_SIZE;
    }

    private List<Integer> getList(int key) {
        int index = getKey(key);
        return buckets[index];
    }

    public MyHashSet() {
        /**
         * 因为ArrayList是使用数组实现的,若要从数组中删除或插入某一个对象，需要移动后段的数组元素，
         * 从而会重新调整索引顺序,调整索引顺序会消耗一定的时间，所以速度上就会比LinkedList要慢许多.
         * 相反,LinkedList是使用链表实现的,若要从链表中删除或插入某一个对象,只需要改变前后对象的引用即可!
         */
        buckets = new LinkedList[BUCKET_SIZE];
    }

    public void add(int key) {
        List<Integer> list = getList(key);
        if (list == null) {
            list = new LinkedList<>();
            list.add(key);
            int index = getKey(key);
            buckets[index] = list;
        } else {
            list.add(key);
        }
    }

    public void remove(int key) {
        List<Integer> list = getList(key);
        if (list == null) {
            return;
        }
        // 用foreach遍历，不能对某一个元素进行操作，也就无法完成删除。选择迭代器
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer temp = iterator.next();
            if (temp == key) {
                iterator.remove();
            }
        }
    }

    public boolean contains(int key) {
        List<Integer> list = getList(key);
        if (list == null) {
            return false;
        }
        return list.contains(key);
    }
}
