package server;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ServerMain {

	public void createServer() {
		try {
			ServerSocket serverSocket = new ServerSocket(3445, 10);
			// Fehlerquelle
			Socket socket = serverSocket.accept();
		
			System.out.println("Server gestartet");

			PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
			LinkedList<PrintWriter> printList = new LinkedList<PrintWriter>();
			printList.add(printWriter);
			
			BlockingQueue<String> queue = new LinkedBlockingQueue<String>();
			
			ConnectionThread connector = new ConnectionThread(queue, serverSocket);
			connector.start();

			WriterThread writer = new WriterThread(queue, printList);

			writer.start();

			if (!writer.isAlive()) {
				printWriter.close();
				socket.close();
				serverSocket.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ServerMain server = new ServerMain();
		server.createServer();

	}

}
