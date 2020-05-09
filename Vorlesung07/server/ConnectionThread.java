package server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ConnectionThread extends Thread{

	private boolean isRunning = true;
	private ServerSocket serverSocket;
	private BlockingQueue<String> queue;
	
	
	
	public ConnectionThread(BlockingQueue<String> queue, ServerSocket serverSocket) {
		this.serverSocket = serverSocket;
		this.queue = queue;
	}



	@Override
	public void run() {
		try {
			
			while(isRunning) {
				Socket socket = serverSocket.accept();
				
//				// Input
//				PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
//				LinkedList<PrintWriter> printList = new LinkedList<PrintWriter>();
//				printList.add(printWriter);
				
				// Output
				Scanner scanner = new Scanner(socket.getInputStream());
//				BlockingQueue<String> queue = new LinkedBlockingQueue<String>();

				ReaderThread reader = new ReaderThread(scanner, queue);
//				WriterThread writer = new WriterThread(queue, printList);

				// Starting the threads
				reader.start();
//				writer.start();			

				if (!reader.isAlive()) {
					scanner.close();
				}

//				if (!writer.isAlive()) {
//					printWriter.close();
//					socket.close();
//					serverSocket.close();
//				}
			}			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
