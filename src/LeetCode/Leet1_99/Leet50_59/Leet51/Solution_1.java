package LeetCode.Leet1_99.Leet50_59.Leet51;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/4/21 13:51
 * @Description TODO: 方法一   递归回溯    2ms 80.45%
 */
class Solution_1 {
    List<List<String>> result = new ArrayList<>();
    char[][] oneResult;  // 可以理解为棋盘
    boolean[] rowUsed;  // 判断某行是否已经存在皇后
    boolean[] columnUsed;  // 判断某列是否已经存在皇后

    public List<List<String>> solveNQueens(int n) {
        rowUsed = new boolean[n];
        columnUsed = new boolean[n];

        // 初始化棋盘
        oneResult = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                oneResult[i][j] = '.';
            }
        }

        doSolveNQueens(0, n);
        return result;
    }

    // count:棋盘中已有皇后个数 n:棋盘大小，也是皇后的总个数
    public void doSolveNQueens(int count, int n) {

        if (count == n) {
            // 找到一个答案，记录答案
            List<String> temp = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    sb.append(oneResult[i][j]);
                }
                temp.add(sb.toString());
                sb.setLength(0);
            }
            result.add(temp);
            return;
        }

        // 肯定每行只有一个棋子，所以我们按行从上往下放，棋盘中已有count个皇后，所以在count层放
        // 尝试在每一列放，判断是否会冲突
        for (int j = 0; j < n; j++) {
            // 如果没有冲突，则放棋子，并递归回溯解决问题
            if (!hasConflict(count, j, n)) {
                oneResult[count][j] = 'Q';
                rowUsed[count] = true;
                columnUsed[j] = true;
                ;
                doSolveNQueens(count + 1, n);  // 递归
                columnUsed[j] = false;  // 回溯
                rowUsed[count] = false;  // 回溯
                oneResult[count][j] = '.';  // 回溯
            }
        }
    }

    // 判断指定棋盘位置能否放元素，也就是说当前位置的同一行或同一列或同一斜线上没有其它棋子
    // 其实不用判断行，因为本身递归就是每一行只找一个答案，所以行肯定不会出现冲突
    public boolean hasConflict(int row, int column, int n) {
        // 行和列
        if (rowUsed[row] || columnUsed[column]) {
            return true;
        }

        // 斜线
        // 左上
        for (int i = row, j = column; ; ) {
            if (i < 0 || j < 0) {
                break;
            }
            if (oneResult[i][j] != '.') {
                return true;
            }
            i--;
            j--;
        }
        // 右上
        for (int i = row, j = column; ; ) {
            if (i < 0 || j >= n) {
                break;
            }
            if (oneResult[i][j] != '.') {
                return true;
            }
            i--;
            j++;
        }
        // 左下
        for (int i = row, j = column; ; ) {
            if (i >= n || j < 0) {
                break;
            }
            if (oneResult[i][j] != '.') {
                return true;
            }
            i++;
            j--;
        }
        // 右下
        for (int i = row, j = column; ; ) {
            if (i >= n || j >= n) {
                break;
            }
            if (oneResult[i][j] != '.') {
                return true;
            }
            i++;
            j++;
        }

        return false;
    }
}
