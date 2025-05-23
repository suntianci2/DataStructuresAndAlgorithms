package LeetCode.Leet1_99.Leet30_39.Leet37;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/4/29 15:13
 * @Description TODO: 方法一	递归回溯	241ms	36.22%
 */
class Solution_1 {
    public void solveSudoku(char[][] board) {
        doSolveSudoku(board);
    }

    // 返回值为boolean，方便找到答案后快速返回
    public boolean doSolveSudoku(char[][] board){
        // 逐个寻找，直到找到一个还没有填充的空白
        for(int row = 0;row < board.length;row++){
            for(int column = 0;column < board[row].length;column++){
                // 未找到
                if(board[row][column] != '.'){
                    continue;
                }
                // 找到了
                // 递归回溯解决问题（当前位置可取值为1-9）
                for(char value = '1';value <= '9';value++){
                    // 当前位置可以填值value，则递归回溯解决问题
                    if(!hasConflict(board, row, column, value)){
                        board[row][column] = value;

                        // 递归，如果递归结果为true，说明此次递归最终能找到答案，则返回true
                        if(doSolveSudoku(board)){
                            return true;
                        }

                        board[row][column] = '.';   // 回溯
                    }
                }
                // 1~9都不满足
                return false;
            }
        }
        // 没找到空白，说明已经找到答案了
        return true;
    }

    // 判断board中row行column列处能否放value值（同行、同列、同九宫格内都没有出现value）
    public boolean hasConflict(char[][] board, int row, int column, char value){
        // 判断同行是否有冲突
        for(int j = 0;j < board[row].length;j++){
            if(board[row][j] == value){
                return true;
            }
        }
        // 判断同列是否有冲突
        for(int i = 0;i < board.length;i++){
            if(board[i][column] == value){
                return true;
            }
        }
        // 判断所在九宫格内是否有冲突
        // 1.找到当前位置所在九宫格的九宫格左上角元素位置
        int startRow = row / 3 * 3;
        int startColumn = column / 3 * 3;
        // 2.在该九宫格内判断是否有冲突
        for(int i = startRow;i <= startRow + 2;i++){
            for(int j = startColumn;j <= startColumn + 2;j++){
                if(board[i][j] == value){
                    return true;
                }
            }
        }

        // 都没有冲突，那就是可以放value值
        return false;
    }
}
