import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;

public class Producer extends Thread {

	private BlockingQueue<PanGalacticGargleBlaster> queue;

	public Producer(BlockingQueue<PanGalacticGargleBlaster> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		for (int i = 0; i < 420; i++) {
			HashMap<String, String> map = new HashMap<>();
			map.put("Alten Janx-Geist", "1 Flasche");
			map.put("Wasser aus den Meeren von Santraginus V", "ein Teil");
			map.put("arkturanischen Mega-Gin", "3 Würfel");
			PanGalacticGargleBlaster gargleBlaster = new PanGalacticGargleBlaster("Zaphod Beeblebrox", 42, map,
					"Man nehme den Inhalt einer Flasche Alten Janx-Geist..");

			try {
				queue.put(gargleBlaster);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
