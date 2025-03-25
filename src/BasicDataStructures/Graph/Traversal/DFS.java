package BasicDataStructures.Graph.Traversal;

import BasicDataStructures.Graph.Edge;
import BasicDataStructures.Graph.Vertex;

import java.util.LinkedList;

/**
 * @ClassName DFS
 * @Author 孙天赐
 * @Date 2025/3/25 9:02
 * @Description TODO: DFS深度优先搜索(Depth-First Search)
 */
public class DFS {

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

//        dfsByRecursion(v1);
        dfsByStack(v1);
    }

    // 非递归实现深度优先搜索
    private static void dfsByStack(Vertex v) {
        // 使用栈完成DFS
        LinkedList<Vertex> stack = new LinkedList<>();
        v.visited = true;
        stack.push(v);
        while (!stack.isEmpty()) {
            Vertex top = stack.pop();
            top.visited = true;
            System.out.println(top.name);
            // 遍历所有的边
            for (Edge edge : top.edges) {
                // 如果边另一端的顶点没有被访问过，则入栈
                if (!edge.linked.visited) {
                    stack.push(edge.linked);
                }
            }
        }

    }

    // 递归实现深度优先搜索
    private static void dfsByRecursion(Vertex v) {
        v.visited = true;
        System.out.println(v.name);
        // 遍历所有的边
        for (Edge edge : v.edges) {
            // 如果边另一端的顶点没有被访问过，则递归访问
            if (!edge.linked.visited) {
                dfsByRecursion(edge.linked);
            }
        }
    }
}
