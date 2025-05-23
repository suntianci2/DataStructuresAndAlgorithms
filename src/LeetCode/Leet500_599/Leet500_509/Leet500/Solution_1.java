package LeetCode.Leet500_599.Leet500_509.Leet500;

import java.util.Collections;
import java.util.HashSet;

/**
 * TODO:**方法一	暴力求解**	（1ms）
 */
class Solution_1 {
    public String[] findWords(String[] words) {
        HashSet<Character> hs1 = new HashSet<>();
        HashSet<Character> hs2 = new HashSet<>();
        HashSet<Character> hs3 = new HashSet<>();
        Collections.addAll(hs1, 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p');
        Collections.addAll(hs1, 'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P');
        Collections.addAll(hs2, 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l');
        Collections.addAll(hs2, 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L');
        Collections.addAll(hs3, 'z', 'x', 'c', 'v', 'b', 'n', 'm');
        Collections.addAll(hs3, 'Z', 'X', 'C', 'V', 'B', 'N', 'M');
        int count = 0;
        String[] outcome = new String[20];
        // 对于每个单词，分三种情况
        for (String str : words) {
            char[] thisWord = str.toCharArray();
            if (hs1.contains(thisWord[0]) && wordIsInOneRow(hs1, thisWord)) {
                outcome[count] = str;
                count++;
            } else if (hs2.contains(thisWord[0]) && wordIsInOneRow(hs2, thisWord)) {
                outcome[count] = str;
                count++;
            } else if (hs3.contains(thisWord[0]) && wordIsInOneRow(hs3, thisWord)) {
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

    // 判断当前单词是否由当前同一行的字母组成
    boolean wordIsInOneRow(HashSet<Character> hs, char[] thisWord) {
        for (char c : thisWord) {
            if (!hs.contains(c)) {
                return false;
            }
        }
        return true;
    }
}
