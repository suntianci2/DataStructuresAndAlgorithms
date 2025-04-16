package BasicDataStructures.Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @ClassName FloydWarshall
 * @Author 孙天赐
 * @Date 2025/4/15 9:37
 * @Description TODO: Floyd-Warshall多源最短路径算法
 */
public class FloydWarshall {
    public static void main(String[] args) {
        Vertex v1 = new Vertex("v1");
        Vertex v2 = new Vertex("v2");
        Vertex v3 = new Vertex("v3");
        Vertex v4 = new Vertex("v4");

        v1.edges.add(new Edge(v3, -2));
        v2.edges.add(new Edge(v1, 4));
        v2.edges.add(new Edge(v3, 3));
        v3.edges.add(new Edge(v4, 2));
        v4.edges.add(new Edge(v2, -1));

        List<Vertex> graph = new ArrayList<>();
        Collections.addAll(graph, v1, v2, v3, v4);

        floydWarshall(graph);
    }

    // floydWarshall算法
    private static void floydWarshall(List<Vertex> graph) {
        int size = graph.size();
        // 距离矩阵
        int[][] dist = new int[size][size];
        // 路径矩阵 行 -> 列 ：目标节点的上一个节点为prev[行][列]
        Vertex[][] prev = new Vertex[size][size];
        // 初始化距离矩阵
        for (int i = 0; i < size; i++) {
            Vertex v = graph.get(i); // 起始顶点
            // 使用Map存储边的信息，key为目标顶点，value为边的权重
            Map<Vertex, Integer> map = v.edges.stream().collect(Collectors.toMap(e -> e.linked, e -> e.weight));
            for (int j = 0; j < size; j++) {
                Vertex u = graph.get(j);  // 目标顶点
                // 同一节点，距离为0
                if (v == u) {
                    dist[i][j] = 0;
                } else {
                    // 不同节点，若直接连通，距离为边的权重，否则为无穷大
                    dist[i][j] = map.getOrDefault(u, Integer.MAX_VALUE);
                    prev[i][j] = map.get(u) != null ? v :  null;
                }
            }
        }

        // 看能否借路到达其他顶点
        /**
         * 借路： v2 -> v1       v1 -> v?
         *       dist[1][0]  +  dist[0][0]
         *       dist[1][0]  +  dist[0][1]
         *       dist[1][0]  +  dist[0][2]
         *       dist[1][0]  +  dist[0][3]
         */
        for(int k = 0; k < size; k++) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
//                    dist[i][k] + dist[k][j];  // i行的顶点，借助k顶点，到达j列顶点
                    // 若i行的顶点借助k顶点到达j列顶点的距离 小于 i行的顶点直接到达j列顶点的距离，则更新距离矩阵
                    // 只有当i到k和k到j连通（不是无穷大），才进行更新
                    if(dist[i][k] != Integer.MAX_VALUE &&
                       dist[k][j] != Integer.MAX_VALUE &&
                       dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        prev[i][j] = prev[k][j];
                    }
                }
            }
        }
        print(dist);
        print(prev);
    }

    private static void print(int[][] dist) {
        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist[i].length; j++) {
                System.out.print((dist[i][j] == Integer.MAX_VALUE ? "∞" : dist[i][j]) + "\t" );
            }
            System.out.println();
        }
    }

    private static void print(Vertex[][] prev) {
        for (int i = 0; i < prev.length; i++) {
            for (int j = 0; j < prev[i].length; j++) {
                System.out.print((prev[i][j] == null? "null" : prev[i][j].getName()) + "\t" );
            }
            System.out.println();
        }
    }
}
