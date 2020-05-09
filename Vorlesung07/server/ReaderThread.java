package server;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

public class ReaderThread extends Thread {

	// Für den Server
	private Scanner scanner;
	private BlockingQueue<String> queue;
	private boolean isRunning = true;

	public ReaderThread(Scanner scanner, BlockingQueue<String> queue) {
		super();
		this.scanner = scanner;
		this.queue = queue;
	}

	@Override
	public void run() {
		while (isRunning) {
			try {
				String message = scanner.nextLine();
				if(message != null) {
//					System.out.println(message);
					queue.put(message);
				}				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void quit() {
		isRunning = false;
		System.out.println("Reader gestoppt");
	}
}
