package BasicDataStructures.Graph.Traversal;

import BasicDataStructures.Graph.Edge;
import BasicDataStructures.Graph.Vertex;

import java.util.LinkedList;

/**
 * @ClassName BFS
 * @Author 孙天赐
 * @Date 2025/3/25 9:19
 * @Description TODO: BFS广度优先搜索(Breadth-First Search)
 */
public class BFS {
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

        bfs(v1);
    }

    private static void bfs(Vertex v) {
        // 使用队列完成BFS
        LinkedList<Vertex> queue = new LinkedList<>();
        v.visited = true;
        queue.offer(v);
        while (!queue.isEmpty()) {
            Vertex first = queue.poll();
            System.out.println(first.getName());
            // 遍历所有的边
            for (Edge edge : first.edges) {
                // 如果边另一端的顶点没有被访问过，则入队
                if (!edge.linked.visited) {
                    edge.linked.visited = true;
                    queue.offer(edge.linked);
                }
            }
        }
    }
}
