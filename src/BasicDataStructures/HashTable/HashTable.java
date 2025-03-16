package BasicDataStructures.HashTable;

/**
 * @ClassName HashTable
 * @Author 孙天赐
 * @Date 2025/3/15 14:39
 * @Description TODO: 哈希表
 */
public class HashTable {
    static class Entry {
        // 哈希码
        int hash;

        // 键
        Object key;

        // 值
        Object value;

        // 指向下一个元素（拉链法解决哈希冲突）
        Entry next;

        public Entry(int hash, Object key, Object value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }
    }

    // 哈希表
    Entry[] table = new Entry[16];

    // 哈希表元素个数
    int size = 0;

    // 根据哈希码获取value
    Object get(int hash, Object key) {
        // 计算索引
        int idx = hash & (table.length - 1);
        if (table[idx] == null) {
            // 没有值
            return null;
        }
        // 遍历链表
        Entry entry = table[idx];
        while (entry != null) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
            entry = entry.next;
        }
        return null;
    }

    // 向哈希表存入新 key value，如果key重复，则更新value
    void put(int hash, Object key, Object value) {
        // 计算索引
        int idx = hash & (table.length - 1);
        if (table[idx] == null) {
            // 1.idx处没有元素，直接插入
            table[idx] = new Entry(hash, key, value);
        } else {
            // 2.idx处有元素，遍历链表
            Entry entry = table[idx];
            while (entry != null) {
                if (entry.key.equals(key)) {
                    // 2.1 找到key，更新value
                    entry.value = value;
                    return;
                }
                if (entry.next == null) {
                    // 2.2 没有找到key，跳出循环，插入到链表末尾
                    break;
                }
                entry = entry.next;
            }
            entry.next = new Entry(hash, key, value);
        }
        size++;
    }

    // 根据哈希码删除，返回删除的value
    Object remove(int hash, Object key) {
        // 计算索引
        int idx = hash & (table.length - 1);
        if (table[idx] == null) {
            // 没有值
            return null;
        }
        // 当前节点
        Entry entry = table[idx];
        // 上一个节点
        Entry prev = null;
        while (entry != null) {
            if (entry.key.equals(key)) {
                // 找到key，删除
                // 删除的是第一个节点
                if (prev == null) {
                    table[idx] = entry.next;
                } else {
                    prev.next = entry.next;
                }
                size--;
                return entry.value;
            }
            prev = entry;
            entry = entry.next;
        }
        return null;
    }
}
