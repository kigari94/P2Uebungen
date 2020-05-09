package server;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ServerMain {

	public void createServer() {
		try {
			ServerSocket serverSocket = new ServerSocket(3445, 10);

			System.out.println("Server gestartet");

			LinkedList<PrintWriter> printList = new LinkedList<PrintWriter>();
			BlockingQueue<String> queue = new LinkedBlockingQueue<String>();

			// Initialize + start writer thread
			WriterThread writer = new WriterThread(queue, printList);
			writer.start();

			if (!writer.isAlive()) {
				serverSocket.close();
			}

			// Initialize + start connection thread
			ConnectionThread connector = new ConnectionThread(queue, serverSocket, printList);
			connector.start();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ServerMain server = new ServerMain();
		server.createServer();

	}

}
