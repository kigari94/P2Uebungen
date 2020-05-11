package server;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

public class WriterThread extends Thread {

	private BlockingQueue<String> queue;
	private ArrayList<PrintWriter> printList;
	private boolean isRunning = true;

	public WriterThread(BlockingQueue<String> queue, ArrayList<PrintWriter> printList) {
		super();
		this.queue = queue;
		this.printList = printList;
	}

	@Override
	public void run() {
		while (isRunning) {
			try {
				String message = queue.take();

				// Sending the message to all connected clients
				// using synchronized() for thread safety
				synchronized (printList) {
					try {
						for (PrintWriter printWriter : printList) {
							printWriter.println(message);
							printWriter.flush();
						}
					} catch (Exception e) {
						e.getStackTrace();
					}

				}

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void quit() {
		isRunning = false;
		System.out.println("Writer gestoppt");
	}
}
