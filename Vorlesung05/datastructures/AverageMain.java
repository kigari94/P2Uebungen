package datastructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class AverageMain {

	public static void main(String[] args) {
		double sum = 0;
		int count = 0;
		
		ArrayList<AverageValue> average = new ArrayList<>();
		average.add(new AverageValue(42.0, "start"));
		average.add(new AverageValue(1000.0, "new"));
		average.add(new AverageValue(9.5, "test"));
		average.add(new AverageValue(42, "quit"));
		average.add(new AverageValue(19.5, "test"));
		average.add(new AverageValue(37, "test"));
		
		for(AverageValue value : average) {
			if(value.getStatus().equals("quit")) {
				sum += value.getValue();
				count += 1;
				System.out.println("Average value: " + (sum / count));
				return;
			}	
			
			sum += value.getValue();
			count += 1;				
		}
		
	}

}
