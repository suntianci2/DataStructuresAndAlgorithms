package BasicDataStructures.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @ClassName Vertex
 * @Author 孙天赐
 * @Date 2025/3/25 8:53
 * @Description TODO: 顶点
 */
public class Vertex {
    // 顶点名称
    public String name;

    // 连接顶点的边
    public List<Edge> edges;

    // 是否被访问过，用在BFS和DFS中
    public boolean visited;

    // 入度
    public int inDegree;

    // 状态 0 未访问 1 访问中 2 已访问，用在拓扑排序中
    public int status;

    // 距离，从源顶点到当前顶点的距离，默认为整数的最大值
    public int distance = INF;

    // 前驱顶点，用于记录路径
    public Vertex prev;

    private static final int INF = Integer.MAX_VALUE;

    public Vertex(String name) {
        this.name = name;
        edges = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return Objects.equals(name, vertex.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
