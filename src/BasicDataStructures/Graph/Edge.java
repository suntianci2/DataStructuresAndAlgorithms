package BasicDataStructures.Graph;

/**
 * @ClassName Edge
 * @Author 孙天赐
 * @Date 2025/3/25 8:55
 * @Description TODO: 边
 */
public class Edge {
    // 指向的顶点
    public Vertex linked;

    // 边的权重
    public int weight;

    public Edge(Vertex linked) {
        this(linked, 1);
    }

    public Edge(Vertex linked, int weight) {
        this.linked = linked;
        this.weight = weight;
    }
}
