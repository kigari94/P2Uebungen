
public class TimerThread extends Thread {
	
	private long time = 0;
	private boolean running = true;
	
	@Override
	public void run() {
		super.run();
		
		while(running) {
			try {
				Thread.sleep(1000);
				System.out.println("Timer: " + time++ + "s");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
		}
	}
	
	public void stopTimer() {
		running = false;
	}
}
