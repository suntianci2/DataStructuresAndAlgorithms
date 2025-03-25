package BasicDataStructures.Graph.TopoLogicalSort;

import BasicDataStructures.Graph.Edge;
import BasicDataStructures.Graph.Vertex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName TopoLogicalSortDFS
 * @Author 孙天赐
 * @Date 2025/3/25 10:13
 * @Description TODO: DFS实现拓扑排序
 */
public class TopoLogicalSortDFS {
    public static void main(String[] args) {
        Vertex v1 = new Vertex("网页基础");
        Vertex v2 = new Vertex("Java基础");
        Vertex v3 = new Vertex("JavaWeb");
        Vertex v4 = new Vertex("Spring框架");
        Vertex v5 = new Vertex("微服务框架");
        Vertex v6 = new Vertex("数据库");
        Vertex v7 = new Vertex("实战项目");

        v1.edges.add(new Edge(v3));
        v2.edges.add(new Edge(v3));
        v3.edges.add(new Edge(v4));
        v6.edges.add(new Edge(v4));
        v4.edges.add(new Edge(v5));
        v5.edges.add(new Edge(v7));
        // 设置环
//        v7.edges.add(new Edge(v5));

        List<Vertex> graph = new ArrayList<>();
        Collections.addAll(graph, v1, v2, v3, v4, v5, v6, v7);

        // 最终栈中存放的元素顺序即为拓扑排序结果
        LinkedList<String> stack = new LinkedList<>();
        for (Vertex vertex : graph) {
            // 对未访问过的顶点，进行DFS
            if(vertex.status == 0){
                dfs(vertex, stack);
            }
        }
        System.out.println(stack);
    }

    private static void dfs(Vertex vertex, LinkedList<String> stack) {
        // 已访问，直接返回
        if(vertex.status == 2){
            return;
        }
        // 访问中，说明有环
        if(vertex.status == 1){
            throw new RuntimeException("发现了环");
        }
        // 访问中
        vertex.status = 1;
        // 递归访问相邻节点
        for (Edge edge : vertex.edges) {
            dfs(edge.linked, stack);
        }
        // 访问结束，加入栈中
        vertex.status = 2;
        stack.push(vertex.name);
    }
}
