package amazon.practise.stack;

public class Stack<T> {

	int maxSize = 100;
	int stackSize = 100;
	T[] stack = null;
	int size = 0;
	public Stack(){
		stack = (T[])(new Object[maxSize]); 
	}
	
	public boolean isEmpty(){
		if (size == 0){
			return true;
		}
		return false;
	}
	
	public boolean isFull(){
		if (size+1 == stackSize){
			return true;
		}
		return false;
	}
	
	public void push(T elem){
		if (!this.isFull()){
			stack[++size] = elem;
		}
	}
	
	public T pop(){
		if (!this.isEmpty()){
			T elem = stack[size];
			size--;
			return elem;
		}
		return null;
	}
	
	public T peek(){
		if (!this.isEmpty()){
			return stack[size];
		}
		return null;
	}
	
}
