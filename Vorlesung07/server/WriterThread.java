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
				//TODO mach das hier threadsafe, eine LinkedList ist nicht threadsafe und viele Instanzen(ConnectionThreads) greifen auf diese Liste zu.
//				synchronized (printList) {
					for (PrintWriter printWriter : printList) {
						//TODO es kann theoretisch eine exception auftreten, wenn bei dem ersten client die verbindung nicht mehr da ist
						//TODO dann würden aber alle anderen die nachricht nicht mehr bekommen, da der catch-Block außerhalb der for Schleife liegt
						printWriter.println(message);
						printWriter.flush();
					}									
//				}
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
