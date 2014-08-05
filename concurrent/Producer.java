package amazon.practise.concurrent;

import java.util.concurrent.BlockingQueue;

public class Producer<T> implements Runnable{

	BlockingQueue<T> queue;
	T[] data;
	public Producer(BlockingQueue<T> queue, T[] data){
		this.queue = queue;
		this.data = data;
	}
	@Override
	public void run() {
		for (int i = 0; i<data.length;i++){
			try {
				queue.put(data[i]);
				System.out.println ("Producer producing data + " + data[i]);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
		}
		
	}

}
