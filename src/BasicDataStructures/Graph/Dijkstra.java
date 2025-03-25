package BasicDataStructures.Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName Dijkstra
 * @Author 孙天赐
 * @Date 2025/3/25 16:05
 * @Description TODO: 迪克斯特拉 单源最短路径算法
 *                  1.将所有顶点标记为未访问，创建一个未访问顶点的集合
 *                  2.为每个顶点分配一个临时距离值
 *                      对于我们的初始顶点，将其设置为0
 *                      对于其他所有顶点，将其设置为无穷大
 *                  3.每次选择最小临时距离的未访问顶点，作为新的当前顶点
 *                  4.对于当前顶点，遍历其所有未访问的邻居，并更新它们的临时距离为更小
 *                      例如，1 -> 6的距离是14，1 -> 3 -> 6的距离是11，这时将距离更新为11
 *                      否则，将保留上次的距离值
 *                  5.当前顶点的邻居处理完成之后，把它从未访问集合中删除
 *                  6.重复步骤3-5
 */
public class Dijkstra {
    public static void main(String[] args) {
        Vertex v1 = new Vertex("v1");
        Vertex v2 = new Vertex("v2");
        Vertex v3 = new Vertex("v3");
        Vertex v4 = new Vertex("v4");
        Vertex v5 = new Vertex("v5");
        Vertex v6 = new Vertex("v6");

        v1.edges.add(new Edge(v3, 9));
        v1.edges.add(new Edge(v2, 7));
        v1.edges.add(new Edge(v6, 14));

        v2.edges.add(new Edge(v4, 15));

        v3.edges.add(new Edge(v4, 11));
        v3.edges.add(new Edge(v6, 2));

        v4.edges.add(new Edge(v5, 6));

        v6.edges.add(new Edge(v5, 9));

        List<Vertex> graph = new ArrayList<>();
        Collections.addAll(graph, v1, v2, v3, v4, v5, v6);

        dijkstra(graph, v1);
    }

    public static void dijkstra(List<Vertex> graph, Vertex source) {
        // 未访问的顶点集合
        List<Vertex> unvisited = new ArrayList<>(graph);
        source.distance = 0;

        while (!unvisited.isEmpty()) {
            // 选取距离最小的顶点
            Vertex minVertex = chooseMinDistance(unvisited);
            // 更新当前节点的邻居节点的距离
            updateNeighbors(minVertex, unvisited);
            // 移除当前顶点
            unvisited.remove(minVertex);
        }

        for (Vertex vertex : graph) {
            System.out.println(source.getName() + " -> " + vertex.getName() + " : " + vertex.distance);
        }
    }

    // 更新当前节点的邻居节点的距离
    private static void updateNeighbors(Vertex vertex, List<Vertex> list) {
        for (Edge edge : vertex.edges) {
            Vertex temp = edge.linked;
            // 只有邻居节点在未访问的集合中，才更新距离
            if(list.contains(temp)) {
                int newDist = vertex.distance + edge.weight;
                // 找到更小的距离
                if(newDist < temp.distance) {
                    temp.distance = newDist;
                }
            }
        }
    }

    // 选择距离最小的顶点
    private static Vertex chooseMinDistance(List<Vertex> list) {
        Vertex minVertex = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if(list.get(i).distance < minVertex.distance) {
                minVertex = list.get(i);
            }
        }
        return minVertex;
    }
}
