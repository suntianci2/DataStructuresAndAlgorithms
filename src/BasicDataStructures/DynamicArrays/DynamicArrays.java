package BasicDataStructures.DynamicArrays;

import java.util.Arrays;
import java.util.Iterator;
import java.util.StringJoiner;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class DynamicArrays implements Iterable<Integer> {
    private int size = 0;  // 已有元素个数
    private int length = 8; // 数组总长度
    private int[] arr = {};

    // 向尾部添加数据
    public void add(int element) {
        checkAndExpansion();
        if (size < length) {
            arr[size] = element;
            size++;
        }

    }

    // 向指定索引添加数据
    public void add(int index, int element) {
        checkAndExpansion();
        if (size < length && index < size) {
            copyArrayElements(arr, index, arr, index + 1, size - index);
            arr[index] = element;
            size++;
        }
    }

    // 数组的检查与扩容
    private void checkAndExpansion() {
        if (size == 0){
            arr = new int[length];
        }

        // 容量满
        if (size == length){
            length += length >> 1;
            int[] tempArr = new int[length];
            copyArrayElements(arr,0,tempArr,0,size);
            arr = tempArr;
        }
    }

    public int remove(int index){
        // 删除元素超出范围处理
        if (index>=size){
            throw new ArrayIndexOutOfBoundsException();
        }
        int removed = arr[index];
        if (index != size-1){
            copyArrayElements(arr,index+1,arr,index,size-index-1);
        }
        size--;
        return removed;
    }

    // 复制数组
    public void copyArrayElements(int[] fromArr, int fromIndex, int[] toArray, int toIndex, int elementCount) {
        int[] temp = new int[elementCount];  //临时存放数组
        for (int i = 0; i < elementCount; i++) {
            temp[i] = fromArr[fromIndex + i];
        }

        for (int i = 0; i < elementCount; i++) {
            toArray[toIndex + i] = temp[i];
        }

    }


    // 遍历数组
    public void foreach(Consumer<Integer> consumer) {
        for (int i = 0; i < size; i++) {
            consumer.accept(arr[i]);
        }
    }

    // toString 方法
    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(", ", "[", "]");
        for (int i = 0; i < size; i++) {
            sj.add(arr[i] + "");
        }
        return sj.toString();
    }

    // 迭代器遍历数组
    @Override
    public Iterator<Integer> iterator() {
        // 返回一个Iterator对象
        return new Iterator<Integer>() {
            int i = 0;

            @Override
            public boolean hasNext() { // 有没有下一个元素
                return i < size;
            }

            @Override
            public Integer next() {  // 返回当前元素，并移动到下一个元素
                return arr[i++];
            }
        };
    }

    // 获取流
    public IntStream stream(){
        return IntStream.of(Arrays.copyOfRange(arr,0,size));
    }
}
