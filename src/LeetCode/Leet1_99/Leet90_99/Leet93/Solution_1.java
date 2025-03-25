package LeetCode.Leet1_99.Leet90_99.Leet93;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution_1
 * @Author 孙天赐
 * @Date 2025/3/24 12:23
 * @Description TODO: 方法一   递归回溯    1ms   99.75%
 */
class Solution_1 {
    List<String> result = new ArrayList<>();
    List<String> nowResult = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        char[] sArr = s.toCharArray();
        doRestoreIpAddresses(sArr, 0, 0);
        return result;
    }

    public void doRestoreIpAddresses(char[] sArr, int startIndex, int ipIndex){
        // 递归终止条件，startIndex超过数组长度，则递归中止
        // 剪枝优化1，ip的组成部分超过4个，则递归中止
        if(ipIndex > 4 || startIndex > sArr.length){
            return;
        }
        // 找到一个ip
        if(ipIndex == 4 && startIndex == sArr.length){
            // 记录答案
            StringBuilder sb = new StringBuilder();
            for(String s : nowResult){
                sb.append(s);
            }
            result.add(sb.toString());
            return;
        }else if(ipIndex != 0){
            // 如果ip还不完整，则加入一个点
            nowResult.add(".");
        }

        // 记录ip的当前部分
        int tempIp = 0;
        for(int i = startIndex;i < sArr.length;i++){
            // 剪枝优化2，如果当前ip的部分长度大于3，则直接跳出循环
            if(i - startIndex >= 3){
                break;
            }
            tempIp = 10 * tempIp + sArr[i] - '0';
            // 只有当前整数在范围内，才加入答案
            if(tempIp >= 0 && tempIp <= 255){
                nowResult.add(String.valueOf(tempIp));
                doRestoreIpAddresses(sArr, i + 1, ipIndex + 1);
                nowResult.remove(nowResult.size() - 1);  // 回溯
                // 如果第一个数字为0，则不用再循环了，后续循环会出现前导0的错误答案
                if(tempIp == 0){
                    break;
                }
            }
        }

        // 删除添加的点
        if(ipIndex != 0){
            nowResult.remove(nowResult.size() - 1);
        }
    }
}