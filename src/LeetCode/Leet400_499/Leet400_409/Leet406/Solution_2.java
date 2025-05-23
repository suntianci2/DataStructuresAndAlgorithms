package LeetCode.Leet400_499.Leet400_409.Leet406;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @ClassName Solution_2
 * @Author 孙天赐
 * @Date 2025/5/22 14:53
 * @Description TODO: 方法二   模拟（贪心）  6ms 92.68%
 *                  先按照身高降序排序，身高相同按照人数升序排序，即先排序身高高的。相同身高先排序前面人数少的
 */
class Solution_2 {
    int[][] result;

    public int[][] reconstructQueue(int[][] people) {
        // 先按照身高降序排序，身高相同按照人数升序排序
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o2[0] - o1[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });

        // 根据身高从大到小的顺序，以前面身高大于等于该身高的人数为下标插入到list中
        // 因为是按照身高从大到小的顺序插入的，所以集合中已有身高绝对会大于等于该身高，所以下标即为前面元素的个数
        List<int[]> list = new ArrayList<>();
        for (int[] p : people) {
            list.add(p[1], p);
        }

        int[][] result = new int[people.length][2];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
