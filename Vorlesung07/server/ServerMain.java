package server;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ServerMain {

	public void createServer() {
		try {
			ServerSocket serverSocket = new ServerSocket(3445, 10);

			ConnectionThread connector = new ConnectionThread(serverSocket);
			connector.start();
//			ServerSocket serverSocket = new ServerSocket(3445, 1);
//			Socket socket = serverSocket.accept();
//			
//			System.out.println("Server gestartet");
//
//			PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
//			Scanner scanner = new Scanner(socket.getInputStream());
//			BlockingQueue<String> queue = new LinkedBlockingQueue<String>();
//
//			ReaderThread reader = new ReaderThread(scanner, queue);
//			WriterThread writer = new WriterThread(queue, printWriter);
//
//			reader.start();
//			writer.start();
//
//			
//
//			if (!reader.isAlive()) {
//				scanner.close();
//			}
//
//			if (!writer.isAlive()) {
//				printWriter.close();
//				socket.close();
//				serverSocket.close();
//			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ServerMain server = new ServerMain();
		server.createServer();

	}

}
