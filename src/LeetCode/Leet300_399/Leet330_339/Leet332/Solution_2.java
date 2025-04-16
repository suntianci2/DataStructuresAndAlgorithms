package LeetCode.Leet300_399.Leet330_339.Leet332;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName Solution_2
 * @Author 孙天赐
 * @Date 2025/4/16 9:46
 * @Description TODO: 方法二 递归回溯优化    超时
 *                  先排序，然后找答案，找到的第一个答案就是最小的
 */
class Solution_2 {
    boolean[] used;
    List<String> result = new ArrayList<>();
    List<String> path = new ArrayList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        Collections.sort(tickets, (a, b) -> a.get(1).compareTo(b.get(1)));
        used = new boolean[tickets.size()];
        path.add("JFK");
        doFindItinerary(tickets, "JFK");
        return result;
    }

    public boolean doFindItinerary(List<List<String>> tickets, String from){
        if(path.size() == tickets.size() + 1){
            result = new ArrayList<>(path);
            return true;
        }

        for(int i = 0;i < tickets.size();i++){
            if(!used[i] && tickets.get(i).get(0).equals(from)){
                String to = tickets.get(i).get(1);
                path.add(to);
                used[i] = true;

                if(doFindItinerary(tickets, to)){
                    return true;
                }

                used[i] = false;
                path.remove(path.size() - 1);

            }
        }
        return false;
    }
}