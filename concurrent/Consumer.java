package amazon.practise.concurrent;

import java.util.concurrent.BlockingQueue;

public class Consumer<T> implements Runnable {

	BlockingQueue<T> queue = null;
	public Consumer(BlockingQueue<T> queue){
		this.queue = queue;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true){
			try {
				System.out.println(" Consumer got the data " + queue.take());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
 