package chapter1.array;

/**
 * @author utopia
 * 自定义数组类，实现“动态”数组
 */
public class MyArray<T> {
    /**
     * 自定义的数组
     */
    private T[] data;
    /**
     * 数组的有效元素个数
     */
    private int size;

    /**
     * 构造函数，传入数组的容量capacity进行构造
     *
     * @param capacity 数组容量
     */
    public MyArray(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    /**
     * 构造函数，无容量参数传入时，默认生成一个容量为10的数组
     */
    public MyArray() {
        this(10);
    }

    /**
     * 获取数组中的元素数量
     *
     * @return 元素数量
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取数组的容量
     *
     * @return 数组的容量
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 判断数组是否为空
     *
     * @return 数组是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向数组末尾添加元素
     *
     * @param element 添加的元素
     */
    public void addLast(T element) {
        add(size, element);
    }

    /**
     * 向数组开头添加元素
     *
     * @param element 添加的元素
     */
    public void addFirst(T element) {
        add(0, element);
    }

    /**
     * 向指定位置添加元素
     *
     * @param index   指定位置的索引
     * @param element 添加的元素
     */
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add() failed, input index required >= 0 and <= size");
        }
        if (size == data.length) {
            resize(2 * getCapacity());
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = element;
        size++;
    }

    /**
     * 获取指定索引的元素
     *
     * @param index 指定的索引
     * @return 索引所在位置的元素
     */
    public T getElement(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("getElement() failed, index is illegal.");
        }
        return data[index];
    }

    /**
     * 修改指定索引位置的元素
     *
     * @param index   指定的索引
     * @param element 更新的元素
     */
    public void setElement(int index, T element) {
        if (index >= size) {
            throw new IllegalArgumentException("setElement() failed, index is illegal.");
        } else if (index < 0) {
            throw new IllegalArgumentException("setElement() failed, index is illegal.");
        }
        data[index] = element;
    }

    /**
     * 判断自定义数组中是否包含某个值
     *
     * @param value 需要判断的值
     * @return 该值存在与否
     */
    public boolean contains(T value) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(value)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找某个值在自定义数组中的索引，如果不存在该元素则返回-1
     * TODO：若存在多个该元素，只能得到第一个该元素的位置，可以设计findAllIndex()方法
     *
     * @param value
     * @return 若存在该元素则返回相应的索引，若不存在该元素则返回-1
     */
    public int find(T value) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 删除数组中指定索引的元素
     *
     * @param index 指定的索引
     * @return 返回删除的元素，实现为用户备份此元素
     */
    public T delete(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("delete() failed, index is illegal.");
        }
        T removeValue = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        //使用泛型后添加此语句，释放引用，从而交由Java自动回收机制处理，清理内存（非必须语句）
        // loitering objects ！= memory leak
        data[size] = null;

        if (size == data.length / 2) {
            resize(data.length / 2);
        }
        return removeValue;
    }

    /**
     * 删除数组的第一个元素
     *
     * @return 删除的元素
     */
    public T deleteFirst() {
        return delete(0);
    }

    /**
     * 删除数组的最后一个元素
     *
     * @return 删除的元素
     */
    public T deleteLast() {
        return delete(size - 1);
    }

    /**
     * 删除数组中的某个值
     * TODO：若存在多个该元素，只能删除第一个该元素，可以设计deleteAllElement()方法
     *
     * @param value 要删除的值
     */
    public void deleteElement(T value) {
        int index = find(value);
        if (index != -1) {
            delete(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }


    private void resize(int newCapacity) {
        T[] newData = (T[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
}
