import java.util.*;


public class Cache<K,V> {

	private class Node<K,V> {
		V price;
		K key;
		
		public Node(K key, V value) {
			price = value;
			this.key = key;
		}
	}
	
	private final HashMap<String,Node> hash;
	private final int size;
	private final Queue<Node> queue;
	private static volatile Cache cache;

	private Cache(int size) {
		this.size = size;
		hash = new HashMap<String,Node>(size);
		queue = new LinkedList<Node>();
	}
	
	public static Cache getInstance(int size) {
		
		if(cache == null) {
			synchronized(Cache.class) {
				if(cache == null) {
					cache = new Cache(size);
					return cache;
				} 
			}
		}
		return cache;
	}
	

	public synchronized void put(K key, V value ) {
		if(hash.containsKey(key)) {
			Node n = hash.get(key);
			queue.remove(n);
			n.price = value;
			queue.add(n);
			hash.put((String)key, n);
		} else {
			if(hash.size() >= size) {
				Node del = queue.poll();
				hash.remove(del.key);
			}
			Node n = new Node(key,value);
			queue.add(n);
			hash.put((String) key, n);
			
		}
	}
	
	public V get(K key) {
		Node<K,V> n = hash.get(key);
		if(n != null) {
			return n.price;
		}
		return null;
	}
	
}
