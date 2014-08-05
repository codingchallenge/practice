package amazon.practise.strings;

import java.util.concurrent.Callable;
import static java.lang.Math.random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.ArrayList;
public class StringGenerator implements Callable<String> {

	public String call() throws Exception {
		String [] allStrings =
                {"Apple", "Ball", "Cat", "Dog", "Elephant",
                "Flower", "Grape", "Horse", "Ink","Joker"};
		int index = (int)(random()*100)/10;

		//Let's wait for sometime
		Thread.sleep(1000);
		return allStrings[index];
	}
	
	public static void main(String[] args) {

		//Create an array to store the future objects.
		ArrayList<Future<String>> results = new ArrayList<Future<String>>();
		for (int i=0; i<10; i++){
			//Create the instance of the Callable task
                        Callable<String> stringGenerator = new StringGenerator();

			//create the object of FutureTask
			FutureTask<String> task =
                                new FutureTask<String>(stringGenerator);

			//Add to the list
			results.add(task);

			//Create a thread object using the task object created
			Thread t = new Thread(task);

			//Start the thread as usual
			t.start();

		}

		//Compute the results now.
		StringBuilder resultStr = new StringBuilder();

		long start = System.currentTimeMillis();

		for(Future<String> result: results){
			try {
				//The blocking get call
				resultStr.append(result.get());
				resultStr.append(" ");

			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}

		long end = System.currentTimeMillis();

		System.out.println("The returned string is:\n"+resultStr);
		System.out.println("Execution time:"+(end - start));
	}
}


