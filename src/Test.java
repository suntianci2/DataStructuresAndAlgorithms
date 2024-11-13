import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Stack;

public class Test {
    public static String[] findWords(String[] words) {
        HashSet<Character> hs1 = new HashSet<>();
        HashSet<Character> hs2 = new HashSet<>();
        HashSet<Character> hs3 = new HashSet<>();

        Collections.addAll(hs1,'q','w','e','r','t','y','u','i','o','p');
        Collections.addAll(hs1,'Q','W','E','R','T','Y','U','I','O','P');
        Collections.addAll(hs2,'a','s','d','f','g','h','j','k','l');
        Collections.addAll(hs2,'A','S','D','F','G','H','J','K','L');
        Collections.addAll(hs3,'z','x','c','v','b','n','m');
        Collections.addAll(hs3,'Z','X','C','V','B','N','M');

        int flag1 = 0;
        int flag2 = 0;
        int flag3 = 0;

        int count = 0;
        String[] outcome = new String[20];
        // 对于每个单词，分三种情况
        for(String str : words){
            char[] thisWord = str.toCharArray();
            for(char c : thisWord){
                if(hs1.contains(c)){
                    flag1 = 1;
                }else if(hs2.contains(c)){
                    flag2 = 1;
                }else{
                    flag3 = 1;
                }
            }
            if((flag1 + flag2 + flag3) == 1){
                outcome[count] = str;
                count++;
            }
        }
        String[] finalOutcome = new String[count];
        for(int i = 0;i < count;i++){
            finalOutcome[i] = outcome[i];
        }
        return finalOutcome;
    }

    public static void main(String[] args) {
        String[] words = findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"});
        for (String word : words) {
            System.out.println(word);
        }

        char c = 'a';

        System.out.println("糟糕");

        Stack<Character> stack = new Stack<>();

    }


}
