
public class ThreadsMain {

	public static void main(String[] args) {
		CalculatingThread calThread = new CalculatingThread();
		CalculatingThread calThread2 = new CalculatingThread();
		
		MinionRunner runner = new MinionRunner();
		Thread minionThread = new Thread(runner);
		
		minionThread.start();
		calThread2.start();
		calThread.start();
		
//		while(calThread.isAlive() || calThread2.isAlive()) {
//			System.out.println(".");
//		}
		
		try {
			calThread.join();
			System.out.println(".");
			calThread2.join();
			minionThread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("bin fertig");
	}

}
