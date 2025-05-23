package LeetCode.Leet400_499.Leet400_409.Leet406;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/5/22 14:14
 * @Description TODO: 方法一   模拟  25ms    5.41%
 *                  先按照身高排序，然后从身高最矮的开始排，
 */
class Solution_1 {
    int[][] result;

    public int[][] reconstructQueue(int[][] people) {
        result = new int[people.length][2];
        // 结果数组均初始化为-1，用于判断当前位置是否已经添加元素
        for (int i = 0; i < result.length; i++) {
            result[i][0] = -1;
            result[i][1] = -1;
        }
        // 先按照身高排序
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        // 然后从身高最矮的开始排
        for (int i = 0; i < people.length; i++) {
            putPeople(people[i][0], people[i][1]);
        }
        return result;
    }

    // 找到应该插入的位置，然后插入
    public void putPeople(int height, int peopleCount) {
        int t = peopleCount;
        for (int i = 0; i < result.length; i++) {
            if (t == 0 && result[i][0] == -1) {
                result[i][0] = height;
                result[i][1] = peopleCount;
                return;
            } else if (result[i][0] == -1 || result[i][0] >= height) {
                t--;
            }
        }
    }
}