import java.util.ArrayList;
import java.util.Collections;

/* Author: Zachary Betters
 * Created: 1/4/19
 * Title: Birthday paradox test
 */



/** BEGIN CLASS Driver **/
public class Driver {

	/** BEGIN METHOD main() **/
	public static void main(String[] args) {
		
		System.out.println("This code is built to prove the birthday paradox.\n\t"
				+ "With 10 people, the chances of matching 2 birthdays is 12%.\n\t"
				+ "With 20 people, that number jumps to 41%.\n\t"
				+ "With 50 people, the number is 97%.\n\t"
				+ "With just 50 people, it is pretty much guaranteed to have 2 matching birthdays despite 365 days in a year."
				+ "Hence, the paradox...\n");
		
		//array list to hold data
		ArrayList<Integer> results = new ArrayList<Integer>();
		
		//execute tests ith amount of times
		for (int i = 0; i < 100; i++) {
			
			//arraylist to store birthday
			ArrayList<Integer> birthdays = new ArrayList<Integer>();
			
			boolean match = false;	
			
			int counter = 1;
		
			//loop until birthday match is found
			while (!match) {
				
				System.out.println("\nTurn: #" + counter);
				
				//random number between 1 and 365
				int newBirth = 1 + (int) (Math.random() * ((365 - 1) + 1));
				
				//if a birthday has been added
				if (!birthdays.isEmpty()) {
					
					//if same birthday is found
					if (birthdays.contains(newBirth)) {
						
						//match is found
						System.out.println("\n\tWE HAVE A MATCH!");
						
						match = true;
						
						//add to results
						results.add(counter);
					}
					//not a matching birthday
					else {
						
						System.out.println("\tBirthday: " + newBirth);
						
						//add to record of birthdays
						birthdays.add(newBirth);	
						
						//increase counter
						counter++;
					}					
				}	
				//no birthdays have been added
				else {
					
					System.out.println("\tBirthday: " + newBirth);
					
					//add new birthday
					birthdays.add(newBirth);
					
					//increase counter
					counter++;
				}
				
				//if executed 20 times
				if (counter == 51) {
					
					//no matches found
					System.out.println("\n\tNO MATCH!");
					
					//record result
					counter = -1;
					results.add(counter);
					
					break;		
				}
			}
			System.out.println("\n\n ------------- \n\n");
		}		
		
		//print out data
		for (int i : results) 			
			System.out.println(i);
		
		//calculate percentage of failure
		double percentage = 100 - ( (double) Collections.frequency(results, -1) / (double) results.size() ) * 100;
		System.out.printf("Match percentage: %.2f%%", percentage);
	}
	/** END METHOD main()**/
}
/** END CLASS Driver **/