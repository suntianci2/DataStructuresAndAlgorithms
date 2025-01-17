import java.util.Arrays;

/**
 * @ClassName Test
 * @Author 孙天赐
 * @Date 2025/1/11 18:37
 * @Description TODO:
 */
public class Test {
    // 计算前缀表 双指针法
    public static int[] calPrefixTable(char[] a){
        int[] prefixTable = new int[a.length];
        if(prefixTable.length == 0 || prefixTable.length == 1){
            return prefixTable;
        }
        // 前缀表第一个元素必为0
        // 所以第一个指针从第一个位置开始，第二个指针从第二个位置开始
        int index1 = 0;
        int index2 = 1;
        while(index2 < a.length){
            // 计算数组索引从0到index2的子数组的相同最大前后缀长度，并存入prefixTable[index2]中
            if(a[index1] == a[index2]){
                // 如果子数组开始和结束位置的元素相同，则最大相同前后缀长度为 前一次循环计算结果+1
                prefixTable[index2] = prefixTable[index2 - 1] + 1;
                // 两个指针都向前移动一位
                index1++;
                index2++;
            }else{
                // 如果子数组开始和结束位置的元素不相同，则在前面寻找之前出现过的共同前后缀
                // 下面的代码非常难以理解，建议翻阅其他资料。我这里只使用文字解释不清楚
                // 递推查找前面的前后缀来根据新的元素组成新的最大相同前后缀
                while(index1 != 0){
                    // 前一个共同前后缀中的其中一个的共同前后缀长度
                    int preLen = prefixTable[index1 - 1];
                    // 更换index1的位置，寻找新的可能的最大相同前后缀
                    index1 = preLen;
                    // 当前index1位置元素与index2位置元素相同，则找到了最大相同前后缀
                    if(a[index1] == a[index2]){
                        prefixTable[index2] = index1 + 1;
                        index1++;
                        index2++;
                        break;
                    }
                }
                // 如果index1回到了最初的位置，仍然分为两种情况
                if(index1 == 0){
                    if(a[index1] == a[index2]){
                        // 1. 第一个元素与index2处元素相同
                        prefixTable[index2] = 1;
                        index1++;
                        index2++;
                    }else{
                        // 2. 第一个元素与index2处元素不相同
                        prefixTable[index2] = 0;
                        index2++;
                    }
                }


            }
        }
        return prefixTable;
    }

    public static void main(String[] args) {
        char[] a = new char[]{'a','b','a','a','b','a','b','a','a','b','a','b','a','b'};
        int[] ints = calPrefixTable(a);
        System.out.println(Arrays.toString(ints));
    }
}
