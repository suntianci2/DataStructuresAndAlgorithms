import java.util.*;
import java.util.stream.Collectors;

/**
 * @ClassName Test
 * @Author 孙天赐
 * @Date 2025/1/11 18:37
 * @Description TODO:
 */
public class Test {
    public static void main(String[] args) {
        Set<List<Integer>> result = new HashSet<>();
        List<List<Integer>> collect = result.stream().collect(Collectors.toList());
    }
}
