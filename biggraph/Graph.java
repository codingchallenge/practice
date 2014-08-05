package audible.catalog.biggraph;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
public class Graph<V extends Vertex, E extends Edge<V>> {

	Map<V, List<E>> aMap = null;
	public Graph(Map<V,List<E>> map){
		this.aMap = map;
	}
	
	public Graph(List<E> edges){
		if (edges == null){
			return;
		} else {
			aMap = new HashMap<V,List<E>>();
		}
		for (E edge: edges){
			V v1 = edge.from;
			V v2 = edge.to;
			if (aMap.containsKey(v1)){
				List<E> inEdges = aMap.get(v1);
				inEdges.add(edge);
				aMap.put(v1,inEdges);
			} else {
				List<E> inEdges = new ArrayList<E>();
				inEdges.add(edge);
				aMap.put(v1, inEdges);
			}
			
			if (!aMap.containsKey(v2)){
				List<E> inEdges = new ArrayList<E>();
				aMap.put(v2, inEdges);
			}
		}
	}
	
	public void DepthFirstSearch(){
		Set<V> vertexSet = aMap.keySet();
		if (vertexSet == null){
			return;
		}
		List<V> vertices = new ArrayList<V>();
		for (V vertex: vertexSet){
			vertices.add(vertex);
		}
		
		for (V vertex: vertices){
			if (vertex.color== Vertex.Color.WHITE){
				DepthFirstSearch(vertex);
			}
		}
	}
	
	public void DepthFirstSearch(V v){
		if (v.color == Vertex.Color.GREY || v.color == Vertex.Color.BLACK){
				return;
		} else {
			System.out.println( " DFS" + v.data);
			v.color = Vertex.Color.GREY;
			
			List<E> edges = this.aMap.get(v);
			if (edges != null){
				for (E edge: edges){
					
					if (edge.to.color == Vertex.Color.WHITE){
						DepthFirstSearch(edge.to);
					}
				}
			}
			v.color = Vertex.Color.BLACK;
		}
	}
	
	
	@Override
	public String toString() {
		return "Graph [aMap=" + aMap + "]";
	}

	public static void main(String[] args){
		Vertex<Integer> v1 = new Vertex(1,1);
		Vertex<Integer> v2 = new Vertex(2,2);
		Vertex<Integer> v3 = new Vertex(3,3);
		Vertex<Integer> v4 = new Vertex(4,4);
		Vertex<Integer> v5 = new Vertex(5,5);
		
		Edge<Vertex> e1 = new Edge(v1,v2);
		Edge<Vertex> e2 = new Edge(v1,v5);
		Edge<Vertex> e3 = new Edge(v2,v3);
		Edge<Vertex> e4 = new Edge(v3,v4);
		
		System.out.println("Hello");
		List<Edge> edges = new ArrayList<Edge>();
		edges.add(e1);
		edges.add(e2);
		edges.add(e3);
		edges.add(e4);
		Graph<Vertex,Edge<Vertex>> graph = new Graph(edges);
		
		System.out.println(graph.toString());
		graph.DepthFirstSearch();
	}
	
}
