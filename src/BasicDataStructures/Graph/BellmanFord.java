package BasicDataStructures.Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName BellmanFord
 * @Author 孙天赐
 * @Date 2025/4/11 17:44
 * @Description TODO: 贝尔曼-福特最短路径算法
 */
public class BellmanFord {
    public static void main(String[] args) {
        Vertex v1 = new Vertex("v1");
        Vertex v2 = new Vertex("v2");
        Vertex v3 = new Vertex("v3");
        Vertex v4 = new Vertex("v4");

        v1.edges.add(new Edge(v2, 2));
        v1.edges.add(new Edge(v3, 1));

        v2.edges.add(new Edge(v3, -2));

        v3.edges.add(new Edge(v4, 1));

        List<Vertex> graph = new ArrayList<>();
        Collections.addAll(graph, v1, v2, v3, v4);

        bellmanFord(graph, v1);
    }

    // bellmanFord算法
    private static void bellmanFord(List<Vertex> graph, Vertex source) {
        source.distance = 0;
        int size = graph.size();
        // 总共遍历size-1次
        for (int i = 0; i < size - 1; i++) {
            // 遍历所有的边
            for (Vertex vertex : graph) {
                // 处理所有的边
                for (Edge edge : vertex.edges) {
                    // 处理每一条边
                    Vertex neighbor = edge.linked;
                    if(vertex.distance != Integer.MAX_VALUE && vertex.distance + edge.weight < neighbor.distance) {
                        neighbor.distance = vertex.distance + edge.weight;
                        neighbor.prev = vertex;
                    }
                }
            }
        }
        for (Vertex vertex : graph) {
            System.out.println(source.getName() + " -> " + vertex.getName() + " : " + vertex.distance + "prev: " + (vertex.prev != null ? vertex.prev.getName() : null));
        }
    }
}
