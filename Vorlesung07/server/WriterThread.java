package server;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;

import datastructures.Account;

public class WriterThread extends Thread {

	private BlockingQueue<String> queue;
//	private PrintWriter printWriter;
	private LinkedList<PrintWriter> printList;
	private boolean isRunning = true;

	public WriterThread(BlockingQueue<String> queue, LinkedList<PrintWriter> printList) {
		super();
		this.queue = queue;
		this.printList = printList;
	}
	
	@Override
	public void run() {
		while(isRunning) {
			try {
				String message = queue.take();
				for (PrintWriter printWriter : printList) {
					printWriter.println(message);
					printWriter.flush();
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
