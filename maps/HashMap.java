package audible.catalog.maps;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

public class HashMap<K , V >  extends AbstractMap<K, V> implements Serializable,Cloneable{

	private static class HashEntry<K,V> implements Entry<K,V>{
		final K key;
		V value;
		final int hash;
		HashEntry<K,V> next = null;
		
		public HashEntry(K key, V val, int hash){
			this.key = key;
			this.value = val;
			this.hash = hash;
			this.next = null;
		}

		public HashEntry(K key, V val, int hash, HashEntry<K,V> next){
			this.key = key;
			this.value = val;
			this.hash = hash;
			this.next = next;
			
		}
		
		@Override
		public K getKey() {
			// TODO Auto-generated method stub
			return key;
			
		}

		@Override
		public V getValue() {
			// TODO Auto-generated method stub
			return value;
		}
		
		public HashEntry<K,V> getNext(){
			return next;
		}

		@Override
		public V setValue(V arg0) {
			this.value = arg0;
			// TODO Auto-generated method stub
			return value;
		}
		
		@Override 
		public final boolean  equals(Object o) {
				if (!(o instanceof Entry)) {
					return false;
				}
				Entry<?, ?> e = (Entry<?, ?>) o;
				return Objects.equals(e.getKey(), key)
						&& Objects.equals(e.getValue(), value);
		}


		@Override public final int  hashCode() {

			return (key == null ? 0 : key.hashCode()) ^
					(value == null ? 0 : value.hashCode());

		}

			
		@Override public final String  toString() {

			return key + "=" + value;
		}
	}
	

	HashEntry<K,V>[] arr = null;
	
	int size = 0;
	
	// Let it be  a factor of 2. Easy To Rehash.
	int MIN_SIZE = 4;
	
	HashEntry<K,V>[] EMPTY_TABLE = new HashEntry[MIN_SIZE/2];
	int MAX_SIZE = 1 >> 30;
	int threshold = 3;
	double loadFactor = 0.75;
	private transient Set<Entry<K,V>> entrySet = null;
	private transient Set<K> keySet = null;
	private transient HashEntry<K,V> entryForNullKey = null;
	
	public HashMap(){
		arr =  new HashEntry[MIN_SIZE];
		this.size = this.MIN_SIZE;
	}
	
	public HashMap(int size){
	
		if (size < 0){
			throw new IllegalArgumentException("Invalid Size Given");
		} else if (size == 0){
			arr = EMPTY_TABLE;
			return;
		} else if (size<MIN_SIZE){
			size = MIN_SIZE;
		} else if (size > MAX_SIZE){
			size = MAX_SIZE;
		} else {
			size = roundToNearestTwo(size);
			
		}
		makeTable(size);
	}
	
	public HashMap(int initialCapacity, float loadFactor){
		this(initialCapacity);
	}
	
	public HashMap(Map<? extends K,? extends V> m){
		this(m.size());
        constructorPutAll(m);	    	
	}
	public void constructorPutAll(Map<? extends K, ? extends V> m) {
		// TODO Auto-generated method stub
		for (Entry<? extends K, ? extends V> k : m.entrySet()){
			this.put(k.getKey(), k.getValue());
		}
	}

	
	public int roundToNearestTwo(int size){
		int ret = MIN_SIZE;
		while (ret<size){
			ret = ret<<1;	
		}
		return ret;
	}
	
	public void makeTable(int size){
		arr = new HashEntry[size];
		
		threshold = (size >> 1) + (size >> 2);
	}
	
	// It removes all entries
	public void clear(){
	   if (size > 0){
		   Arrays.fill(arr, null);
		   size = 0;
	   }
	   
	}
	
	
	public Object  clone(){
		
		HashMap<K,V> result = new HashMap<K,V>();
		result.makeTable(this.arr.length);
		result.size = 0;
		result.constructorPutAll(this);
		return result;
	
	}
	
	public boolean containsKey(K key){
		if (size > 0 && key != null){
		   int hashCode = this.computeHashIndex(key);
		   int hash = key.hashCode();
		   if (arr[hashCode] != null ){
			   HashEntry<K,V> entry = arr[hashCode];
			   while (entry != null){
				   if (entry.key.equals(key) && entry.hash == hash){
					   return true;
				   }
				   entry = entry.getNext();
			   }
			   
		   }
		}
		return false;
	}
	
	@Override
	public boolean containsValue(V value){
		for (int i = 0; i<arr.length; i++){
			HashEntry<K,V> iter = (HashEntry<K,V>)arr[i];
			while (iter != null){
				if (iter.value.equals(value)){
					return true;
				}
				iter = iter.getNext();
			}
		}
		return false;
	}
	public V put(K key, V value){
		// If key == null what do you want to do ?
		if (key==null){
			return insertNullInMap(value);
		} else {
			int hash = key.hashCode();
			int index = computeHashIndex(key);
			
			
			for(HashEntry<K,V> iter = arr[index] ; iter != null ; iter = iter.getNext()){
				if (iter.key.equals(key) && iter.hash ==hash){
						V old = iter.value;
						iter.value = value;
						return old;
					}
					
				}
			if (size+1 > arr.length * loadFactor){
				arr = resizeArray();
				index = computeHashIndex(key);
				
			}
			insertNonNullEntry(key,value,index,arr[index],hash);
			return null;
		}
		
		
		
		
	}
	
	public HashEntry<K,V>[] resizeArray(){
		return null;
	}
	
	public void insertNonNullEntry(K key, V value, int index, HashEntry<K,V> entry, int hash){
		arr[index] = new HashEntry(key,value,hash,entry);
		size++;
	}
	
	public V insertNullInMap(V value){
		HashEntry<K,V> entry = this.entryForNullKey;
		if (entry == null){
			this.entryForNullKey = new HashEntry(null,value,0,null);
			size++;
			return null;
		} else {
			V old = this.entryForNullKey.value;
			this.entryForNullKey = new HashEntry(null,value,0,null);
			return old;
		}
		
	}
	public V get(K key){
		int index = computeHashIndex(key);
		int hash = key.hashCode();
		
		if (arr[index] != null){
			HashEntry<K,V> entry = arr[index];
			while (entry != null){
				if (entry.key != null && entry.key.equals(key) && entry.hash == hash){
					return entry.value;
				}
			}
		}
		return null;
	}
	
	public void putAll(Map<? extends K,? extends V> m){
		if (m == null){
			return;
		}
		constructorPutAll(m);
	}
	
	public V remove(K key){
		if (key == null){
			if (this.entryForNullKey != null){
				V ret = this.entryForNullKey.value;
				this.entryForNullKey = null;
				return ret;
			}
			return null;
		} else {
			int hash = key.hashCode();
			int index = this.computeHashIndex(key);
			
			V ret = null;
			HashEntry<K,V> prev = null;
			HashEntry<K,V> next = null;
			for (HashEntry<K,V> entry = arr[index]; entry != null; entry = entry.next){
				next = entry.next;
				if (entry.key.equals(key) && hash == entry.hash){
					ret = entry.value;
					deleteEntry(entry,prev, next,index);
				}
				
				prev = entry;
			}
			return ret;
		}
	}
	private class ValueIterator<V> extends HashIterator<V>{

		@Override
		public V next() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}
	private abstract class HashIterator<E> implements Iterator<E>{

		int sizeHash = 0;
		HashEntry<K,V> next = null;
		HashEntry<K,V> current = null;
		int currentIndex = 0;
		HashIterator(){
			sizeHash = size;
			int i;
			for (i = 0,next= arr[i]; i<arr.length && arr[i]==null; i++,next=arr[i]){
			}
			currentIndex= i;
		}
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return (next == null);
		}

	    public final Entry<K,V> nextEntry(){
	    	if (sizeHash != size){
	    		throw new RuntimeException("The underlying collection has been modified");
	    	} else if (!hasNext()){
	    		throw new RuntimeException("No such element is present");
	    	}
	    	else{
	    		HashEntry<K,V> ret = next;
	    		next = next.next;
	    		if (next == null){
	    			int i = currentIndex;
	    			for (i = currentIndex,next= arr[i]; i<arr.length && arr[i]==null; i++,next=arr[i],currentIndex=i){
	    			}
	    			
	    		}
	    		current = ret;
	    		return ret;
	    	}
	    
	    }
	    

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}
	public Collection<V> values(){
		
	}
	public void deleteEntry(HashEntry<K,V> entry, HashEntry<K,V> prev, HashEntry<K,V> next, int index){
		if (prev == null){
			arr[index]= next;
		} else {
			prev.next = next;
		}
	}
	public boolean isEmpty(){
		return (this.size == 0 ? true : false);
	}
	
	public Set<K> keySet(){
		if (this.keySet == null){
			return new HashSet<K>();
		}
		return keySet;
	}
	public int computeHashIndex(K key){
		return key.hashCode()%size;
	}
	public void print(){
		if (arr != null){
			for (int i = 0; i<arr.length; i++){
				System.out.println(arr[i].key.toString());
				System.out.println(arr[i].value.toString());
			}
		}
	}
	
	public static void main(String[] args){
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("test", "value");
		System.out.println(map.get("test"));
	}

	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		Set<Entry<K,V>> ret = this.entrySet;
		return (ret != null ?  ret: new HashSet<Entry<K,V>>()); 
	}
	
	
		
}
