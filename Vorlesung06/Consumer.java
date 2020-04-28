import java.util.concurrent.BlockingQueue;

public class Consumer extends Thread {
	
	private BlockingQueue<PanGalacticGargleBlaster> queue;
	
	public Consumer(BlockingQueue<PanGalacticGargleBlaster> queue) {
		super();
		this.queue = queue;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				PanGalacticGargleBlaster drink = queue.take();
				System.out.println(queue.size());
				System.out.println(drink.getOwner() + "\n" + drink.getRecipe());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
