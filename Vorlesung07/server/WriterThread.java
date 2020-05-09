package server;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;

public class WriterThread extends Thread {

	private BlockingQueue<String> queue;
	private PrintWriter printWriter;
//	private List<PrintWriter> list;
	private boolean isRunning = true;

	public WriterThread(BlockingQueue<String> queue, PrintWriter printwriter) {
		super();
		this.queue = queue;
		this.printWriter = printwriter;
//		this.list = list;
	}
	
	@Override
	public void run() {
		while(isRunning) {
			try {
				String message = queue.take();
				printWriter.println(message);
				printWriter.flush();
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
