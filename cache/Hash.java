
public class Hash<K,V> {
	
	private class HashNode<K,V> {
		K key;
		V value;
		HashNode next;
		
		public HashNode(K k, V v) {
			key = k;
			value = v;
			next = null;
		}
	}
	
	private HashNode[] hashTable;
	private int size;
	
	public Hash(int size) {
		this.size = size;
		hashTable = new HashNode[size];
	}
	
	public V get(K key) {
		int hash = key.hashCode() % size;
		if(hashTable[hash] != null) {
			HashNode h = hashTable[hash];
			while(h != null && ! h.key.equals(key)) {
				h = h.next;
			}
			if(h != null)
				return (V) h.value;
		}
		return null;
	}
	
	public void put(K key, V value) {
		int hash = key.hashCode() % size;
		HashNode node = new HashNode(key,value);
		if(hashTable[hash] != null) {
			HashNode h = hashTable[hash];
			while(h.next != null && !h.key.equals(key))
				h = h.next;
			if(h.key.equals(key))
				h.value = value;
			else
				h.next = node;
		} else {
			hashTable[hash] = node;
		}
	}
	
}
