package audible.catalog.biggraph;

public class Edge<V extends Vertex> {

	public V  from;
	public V to;
	public float weight;
	public Edge(V v1,V v2, float weight){
		this.from = v1;
		this.to = v2;
		this.weight = weight;
	}
	
	public Edge(V v1, V v2){
		this.from = v1;
		this.to = v2;
	}

	@Override
	public String toString() {
		return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]";
	}
	
	
}
