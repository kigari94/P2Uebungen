package datastructures;

import java.util.HashSet;
import java.util.Scanner;

public class EventMain {

	public static void main(String[] args) {
		boolean tmp = false;
		
		HashSet<Event> events = new HashSet<Event>();
		events.add(new Event("Gamescom", "Koeln", "21.08.2020"));
		events.add(new Event("Gamescom", "Koeln", "21.08.2020"));
		events.add(new Event("Gamescom", "Koeln", "21.08.2020"));
		events.add(new Event("Ostern", "Erde", "14.04.2020"));
		events.add(new Event("Muttertag", "Erde", "10.05.2020"));
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter event name: ");
		String valName = input.nextLine();
		System.out.println("Enter event place: ");
		String valPlace = input.nextLine();
		System.out.println("Enter date: ");
		String valDate = input.nextLine();
		input.close();

		Event newEvent = new Event(valName, valPlace, valDate);
		
		//TODO siehe Feedback in der AccountMain
		for (Event event : events) {
			if (newEvent.equals(event)) {
				System.out.println("User already exists!");
				tmp = true;
				return;
			} else {
				tmp = true;
			}
		}
		
		if(tmp) {
			events.add(newEvent);
		}
		
		for (Event event : events) {
			System.out.println(event.getEventName() + " " + event.getPlace() + " " + event.getCalendar());
		}
	}

}
