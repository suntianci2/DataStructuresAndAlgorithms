import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @ClassName Test
 * @Author 孙天赐
 * @Date 2025/1/11 18:37
 * @Description TODO:
 */
public class Test {
    public static int[][] reconstructQueue(int[][] people) {
        // 从身高最矮的开始排，
        int[][] result = new int[people.length][2];
        // 先按照身高排序
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (int[] ints : people) {
            for (int anInt : ints) {
                System.out.print( anInt + " ");
            }
            System.out.println();
        }
        return result;
    }

    public static void main(String[] args) {
        reconstructQueue(new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}});
        List<Integer> list = new ArrayList<>();
        list.add();
    }
}
