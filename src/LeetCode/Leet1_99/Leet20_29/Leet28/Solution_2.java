package LeetCode.Leet1_99.Leet20_29.Leet28;

/**
 * @ClassName Solution_2
 * @Author 孙天赐
 * @Date 2025/1/11 19:42
 * @Description TODO: 方法二   KMP算法优化
 *                  此处参考的其他人写的kmp算法代码，以我现在的水平确实写不出来这么好的代码
 *                  相比之下，只是求前缀表的逻辑发生了变化，更加简洁。
 */
class Solution_2 {
    public int strStr(String haystack, String needle) {
        char[] arr1 = haystack.toCharArray();
        char[] arr2 = needle.toCharArray();
        // 计算arr2的前缀表，根据前缀表寻找答案
        int[] prefixTable = calPrefixTable(arr2);
        // 定义两个指针，分别指向haystack和needle的起始位置
        int index1 = 0;
        int index2 = 0;
        // 开始循环
        while(index1 < arr1.length || index2 >= arr2.length){
            // 如果index2出了arr2的范围，表明找到答案了，这个时候index1 - arr2.length就是答案
            if(index2 >= arr2.length){
                return index1 - arr2.length;
            }
            if(arr1[index1] == arr2[index2]){
                // 如果两个指针处元素相同，则两个指针都向后移动一位
                index1++;
                index2++;
            }else{
                // 否则，如果两个指针处元素不相同
                // 如果index2位于起始位置，则index1向前移动
                if(index2 == 0){
                    index1++;
                }else{
                    // 如果index不在起始位置，则根据前缀表移动index2
                    // index1不需要移动
                    // index2移动到prefixTable[index2 - 1]处，既可以跳过已经比对过的信息
                    index2 = prefixTable[index2 - 1];
                }
            }
        }
        // 如果正常循环结束，说明没有答案
        return -1;
    }

    // 计算前缀表 双指针法
    public int[] calPrefixTable(char[] a){
        int[] prefixTable = new int[a.length];
        if(a.length == 0){
            return prefixTable;
        }
        int i = 0;  //前指针
        prefixTable[0] = 0;
        for(int j = 1;j < a.length;j++){
            // j：后指针
            // 如果出现了不同值，则向前寻找可能的答案。直至前指针到了索引0位置，或者前后指针元素相同
            while(i > 0 && a[i] != a[j]){
                i = prefixTable[i - 1];
            }
            // 当跳出循环，说明要前指针到了索引0位置，要么前后指针元素相同
            // 如果遇见了相同值，则前指针向后移动一位。如果没有遇到，则不移动前指针
            if(a[i] == a[j]){
                i++;
            }
            // 记录结果， prefixTable[j]的结果即为前指针的索引值
            prefixTable[j] = i;
        }

        return prefixTable;
    }
}
