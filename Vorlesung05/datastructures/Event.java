package datastructures;

import java.util.Calendar;

public class Event {

	private String eventName;
	private String place;
	private String calendar;

	public Event(String eventName, String place, String calendar) {
		super();
		this.eventName = eventName;
		this.place = place;
		this.calendar = calendar;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getCalendar() {
		return calendar;
	}

	public void setCalendar(String calendar) {
		this.calendar = calendar;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj && this != null && obj instanceof Account) {
			return true;
		}
		return false;
	}

}
