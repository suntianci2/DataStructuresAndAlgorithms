package BasicDataStructures.Graph;

import java.util.ArrayList;
import java.util.List;

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

    public Vertex(String name) {
        this.name = name;
        edges = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
}
