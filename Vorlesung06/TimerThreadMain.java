import java.util.Scanner;

public class TimerThreadMain {

	public static void main(String[] args) {
		
		TimerThread thread = new TimerThread();
		thread.start();	
		
		Scanner input = new Scanner(System.in);			
		input.nextLine();
		input.close();
		
		thread.stopTimer();
		
	}

}
