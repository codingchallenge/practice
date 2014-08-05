package audible.catalog.biggraph;

public class Vertex<T> {
	public T data;
	public int index;
	public Color color;
	public static enum Color{
		WHITE,GREY,BLACK;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + index;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertex other = (Vertex) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (index != other.index)
			return false;
		return true;
	}

	public Vertex(T data, int index){
		this.data = data;
		this.index = index;
		this.color = Color.WHITE;
	}

	@Override
	public String toString() {
		return "Vertex [data=" + data + ", index=" + index + "]";
	}
	
	
}
