package amazon.practise.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerPattern {

    public static void main(String args[]){
  
     //Creating shared object
     BlockingQueue<Integer> sharedQueue = new LinkedBlockingQueue<Integer>();
 
     //Creating Producer and Consumer Thread
     Integer[] array = {1,2,3,4,5,6,7,8,9,10,11,12};
     Producer producer = new Producer(sharedQueue, array);
     Consumer consumer = new Consumer(sharedQueue);

     //Starting producer and Consumer thread
    Thread thread1 = new Thread(producer);
    Thread thread2 = new Thread(consumer);
    thread2.start();
    thread1.start();
   
    }
 
}

