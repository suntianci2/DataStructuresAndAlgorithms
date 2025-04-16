/**
 * @ClassName Test
 * @Author 孙天赐
 * @Date 2025/1/11 18:37
 * @Description TODO:
 */
public class Test {
    private static int x = 100;
    public static void main(String[] args) {
        Test test = new Test();
        test.x++;
        Test.x++;
        System.out.println(x);
    }
}
