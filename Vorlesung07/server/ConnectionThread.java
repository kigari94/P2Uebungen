package server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

public class ConnectionThread extends Thread {

	private boolean isRunning = true;
	private ServerSocket serverSocket;
	private BlockingQueue<String> queue;
	private LinkedList<PrintWriter> printList;

	public ConnectionThread(BlockingQueue<String> queue, ServerSocket serverSocket, LinkedList<PrintWriter> printList) {
		this.serverSocket = serverSocket;
		this.queue = queue;
		this.printList = printList;
	}

	@Override
	public void run() {
		try {
			while (isRunning) {
				Socket socket = serverSocket.accept();

				PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
				printList.add(printWriter);

				// Input
				Scanner scanner = new Scanner(socket.getInputStream());
				ReaderThread reader = new ReaderThread(scanner, queue);

				// Starting the input thread
				reader.start();

				if (!reader.isAlive()) {
					printWriter.close();
					scanner.close();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void quit() {
		isRunning = false;
		System.out.println("Connector gestoppt");
	}
}
