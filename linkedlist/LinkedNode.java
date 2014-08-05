package audible.catalog.linkedlist;

public class LinkedNode<T> {

	public T data;
	public LinkedNode<T> right;
	public LinkedNode<T> left;
	
	
	public LinkedNode(T data){
		this.data = data;
	}
	
	public LinkedNode(T data, LinkedNode<T> next, LinkedNode<T> before){
		this.data = data;
		this.right = next;
		this.left = before;
	}
}
