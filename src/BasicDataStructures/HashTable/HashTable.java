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

    // 负载因子（ 哈希表元素个数/哈希表长度 的值超过负载因子，哈希表会扩容）
    float loadFactor = 0.75f;

    // 阈值（哈希表元素个数大于阈值，哈希表会扩容）
    int threshold = (int) (table.length * loadFactor);

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

    // 根据键获取value
    Object get(Object key) {
        return get(key.hashCode(), key);
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
        if (size > threshold) {
            // 扩容
            resize();
        }
    }

    // 向哈希表中存入键值对
    void put(Object key, Object value) {
        put(key.hashCode(), key, value);
    }

    // 扩容
    private void resize() {
        // 1.创建新的哈希表
        Entry[] newTable = new Entry[table.length << 1];
        // 2.遍历旧的哈希表，将元素存入新的哈希表
        for (int i = 0; i < table.length; i++) {
            Entry entry = table[i];  // 当前节点
            if (entry != null) {
                // 3.拆分链表，移动到新数组
                // 拆分规律：
                // 一个链表最多拆成两个链表
                // hash & 旧数组长度 == 0 的元素，放在第一个链表中
                // hash & 旧数组长度 != 0 的元素，放在第二个链表中
                // 3.1 拆分链表
                Entry a = null; // 第一个链表
                Entry b = null; // 第二个链表
                Entry aHead = null; // 第一个链表的头结点
                Entry bHead = null; // 第二个链表的头结点
                while (entry != null) {
                    if ((entry.hash & table.length) == 0) {
                        // 3.2 放在第一个链表尾部
                        if (a != null) {
                            a.next = entry;
                        } else {
                            // 记录头指针
                            aHead = entry;
                        }
                        a = entry;
                    } else {
                        // 3.3 放在第二个链表中
                        if (b != null) {
                            b.next = entry;
                        } else {
                            // 记录头指针
                            bHead = entry;
                        }
                        b = entry;
                    }
                    entry = entry.next;
                }

                // 3.4 移动到新数组
                // 链表末尾指向null
                if (a != null) {
                    a.next = null;
                    // 第一个链表位置不变
                    newTable[i] = aHead;
                }
                if (b != null) {
                    b.next = null;
                    // 第二个链表位置为 i + 旧数组长度
                    newTable[i + table.length] = bHead;
                }



            }
        }
        table = newTable;
        threshold = (int) (table.length * loadFactor);
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

    // 根据键删除value
    Object remove(Object key) {
        return remove(key.hashCode(), key);
    }
}
