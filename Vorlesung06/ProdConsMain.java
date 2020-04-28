import java.util.HashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProdConsMain {

	public static void main(String[] args) {
		
		BlockingQueue<PanGalacticGargleBlaster> queue = new LinkedBlockingQueue<PanGalacticGargleBlaster>();
		Consumer consumer = new Consumer(queue);
		Producer producer = new Producer(queue);
		
		consumer.start();
		producer.start();
	}

}
