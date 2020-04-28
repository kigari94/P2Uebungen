
public class CalculatingThread extends Thread {

	@Override
	public void run() {
		super.run();

		for (int i = 0; i < 20; i++) {
			System.out.println(i);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
