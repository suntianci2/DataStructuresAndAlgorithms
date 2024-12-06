package LeetCode.Leet500_599.Leet500_509.Leet_500;

/**
 * TODO:==**方法二**==	（0ms）
 * <p>
 * 不在乎在哪一行出现，只在乎在几行出现，只要不是一行就不满足要求
 */
class Solution_2 {
    public String[] findWords(String[] words) {
        String s1 = "qwertyuiopQWERTYUIOP";
        String s2 = "asdfghjklASDFGHJKL";
        String s3 = "zxcvbnmZXCVBNM";

        int count = 0;
        String[] outcome = new String[20];
        // 对于每个单词，分三种情况
        for (String str : words) {
            // 记录该单词中的字母出现在哪一行中
            int flag1 = 0;  // 是否出现在第一行，值为1表示出现了
            int flag2 = 0;  // 是否出现在第二行，值为1表示出现了
            int flag3 = 0;  // 是否出现在第三行，值为1表示出现了

            char[] thisWord = str.toCharArray();
            for (char c : thisWord) {
                if (s1.contains(String.valueOf(c))) {
                    flag1 = 1;
                } else if (s2.contains(String.valueOf(c))) {
                    flag2 = 1;
                } else {
                    flag3 = 1;
                }
            }

            // 判断是否只在一行出现
            if ((flag1 + flag2 + flag3) == 1) {
                outcome[count] = str;
                count++;
            }
        }
        String[] finalOutcome = new String[count];
        for (int i = 0; i < count; i++) {
            finalOutcome[i] = outcome[i];
        }
        return finalOutcome;
    }

}
