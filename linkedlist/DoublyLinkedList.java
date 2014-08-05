package audible.catalog.linkedlist;

import java.util.Arrays;

public class DoublyLinkedList<T> {


	LinkedNode<T> head = null;
	int size = 0;
	public DoublyLinkedList(T[] array){
		
		if (array == null || array.length == 0){
			return;
		} else {
			Arrays.sort(array,0,array.length);
			size = array.length;
			LinkedNode<T> prev = null;
			LinkedNode<T> current = null;
			for (int i = 0; i<array.length; i++){
				current = new LinkedNode(array[i]);
				if(head == null){
					head = current;
				}
				current.left = prev;
				current.right = null;
				
				if (prev != null){
					prev.right = current;
				}
				prev = current;
				current = current.right;
			}
			
		}
	}
	
	public void printLinkedList(){
		LinkedNode<T> temp = head;
		while (temp != null){
			System.out.println(temp.data);
			temp = temp.right;
		}
		
	}
	public static class LinkedNodePair<T>{
		LinkedNode<T> first;
		LinkedNode<T> second;
		
		public LinkedNodePair(LinkedNode<T> first, LinkedNode<T> second){
			this.first = first;
			this.second = second;
		}
	}
	public void converToBST(){
		this.head = convertToBST(this.head, 0, size-1, new LinkedNodePair<T>(null,null));
	}
	
	
	public LinkedNode<T> convertToBST(LinkedNode<T> head, int start, int end, LinkedNodePair<T> nodePair){
		if (head == null || start > end){
			return null;
		} 
		else {
			int mid = start + (end-start)/2;
			LinkedNode<T> left = convertToBST(head, start, mid-1,nodePair);
			LinkedNode<T> curr = null;
			if (nodePair.first != null){
				curr= nodePair.first;
				nodePair.first = nodePair.first.right;
			} else {
				curr = head;
				nodePair.first = head.right;
			}
			curr.left = left;
			curr.right = convertToBST(nodePair.first, mid+1, end,nodePair);
			
			return curr;
		}
	}
	
	public void printTree(){
		printTree(head);
	}
	
	public void printTree(LinkedNode<T> head){
		if (head == null){
			return;
		} else {
			printTree(head.left);
			System.out.println(head.data);
			printTree(head.right);
		
		}
	}
	
	
	public static void main(String[] args){
		Integer[] array = {1,2,3,4,5,6,7,8,9,10};
		DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>(array);
		list.printLinkedList();
		list.converToBST();
		list.printTree();
	}
}
