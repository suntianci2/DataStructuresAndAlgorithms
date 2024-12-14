package LeetCode.Leet1_99.Leet20_59.Leet59;

/**
 * TODO: 方法一    模拟  （0ms）
 * 根据当前位置的上下左右四个位置的合法性（越界，或者已经有新元素），来计算下一个元素应该填入的位置
 */
class Solution_1 {
    public int[][] generateMatrix(int n) {
        int[][] outcome = new int[n][n];
        int index1 = 0;
        int index2 = 0;
        for(int i = 0;i < n * n ;i++){
            // 将元素添加到当前位置
            outcome[index1][index2] = i + 1;

            //// 计算下一个元素的位置
            // 左侧位置合法
            boolean leftIsLegal = isLegal(outcome, index1, index2 - 1);
            // 上侧位置合法
            boolean upIsLegal = isLegal(outcome, index1 - 1, index2);
            // 右侧位置合法
            boolean rightIsLegal = isLegal(outcome, index1, index2 + 1);
            // 下侧位置合法
            boolean downIsLegal = isLegal(outcome, index1 + 1, index2);
            // 当前元素左侧和上侧位置不合法，右侧合法，则下一个位置为右侧
            if(!leftIsLegal && !upIsLegal && rightIsLegal){
                index2++;
            }else if(!upIsLegal && !rightIsLegal && downIsLegal){
                // 当前元素上侧和右侧位置不合法，下侧合法，则下一个位置为下侧
                index1++;
            }else if(!rightIsLegal && !downIsLegal && leftIsLegal){
                // 当前元素右侧和下侧位置不合法，左侧合法，则下一个位置为左侧
                index2--;
            }else if(!downIsLegal && !leftIsLegal && upIsLegal){
                // 当前元素下侧和左侧位置不合法，上侧合法，则下一个位置为上侧
                index1--;
            }
        }
        return outcome;
    }

    // 判断当前位置的元素是否合法（1.越界   2.已有元素（也就是此处位置元素非0））
    public boolean isLegal(int[][] array, int index1, int index2){
        // 1.越界
        if(index1 >= array.length || index2 >= array.length || index1 < 0 || index2 < 0){
            return false;
        }
        // 2.已有元素
        if(array[index1][index2] != 0){
            return false;
        }
        return true;
    }
}