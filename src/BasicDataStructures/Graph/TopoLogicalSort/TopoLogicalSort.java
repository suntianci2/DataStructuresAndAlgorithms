package BasicDataStructures.Graph.TopoLogicalSort;

import BasicDataStructures.Graph.Edge;
import BasicDataStructures.Graph.Vertex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName TopoLogicalSort
 * @Author 孙天赐
 * @Date 2025/3/25 9:49
 * @Description TODO: 拓扑排序
 */
public class TopoLogicalSort {
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

        // 1. 统计每个顶点的入度
        for (Vertex vertex : graph) {
            for (Edge edge : vertex.edges) {
                edge.linked.inDegree++;
            }
        }

        // 2. 将入度为0的顶点，加入队列中
        LinkedList<Vertex> queue = new LinkedList<>();
        for (Vertex vertex : graph) {
            if(vertex.inDegree == 0){
                queue.offer(vertex);
            }
        }

        // 3. 队列中不断移除顶点，每移除一个顶点，把它相邻顶点入度减1，若减到0则入队
        List<String> result = new ArrayList<>();
        while(!queue.isEmpty()){
            Vertex vertex = queue.poll();
            result.add(vertex.name);
            for (Edge edge : vertex.edges) {
                edge.linked.inDegree--;
                if(edge.linked.inDegree == 0){
                    queue.offer(edge.linked);
                }
            }
        }
        // 4. 若最终结果的顶点个数与图中顶点个数相同，则说明图中没有环，否则说明有环
        if(result.size() == graph.size()){
            System.out.println("没有环");
        }else{
            System.out.println("有环");
        }
        System.out.println(result);
    }
}
