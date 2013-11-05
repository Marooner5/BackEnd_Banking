import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author Andrew Littler and Tim Huynh This class is going to act as the driver
 *         class for the program.
 */
public class Bank {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO send customers to teller
		// need to place customers in specific teller Q. 
		int tellerNumber = 3; // received from user, how many tellers available
		String s = ""; // string received from user
		boolean driveIn = true;// received from user, if drive in is available
		Queue<Customer> customerQ = new LinkedList<Customer>();

		Scanner setUp = new Scanner(System.in);

		// this block received drive in info from the user
		driveIn = checkDriveInStatus(setUp, driveIn, s);

		// this block receives teller quantity info from the user
		tellerNumber = getNumberOfTellers(tellerNumber, setUp);
		setUp.close();
		// this block reads the file and creates customer objects from it and places them in a Q.
		readFile(driveIn, customerQ);

		
		

	}// main
	
	public static boolean checkDriveInStatus(Scanner in, boolean driveIn, String s){
		do{
			System.out.println("Is the drive-thru active? Yes or no");
			s = in.next().toLowerCase();
			if (s.equals("yes"))
				driveIn = true;
			else if (s.equals("no"))
				driveIn = false;
			else {
				System.out.println("Please enter in valid data. Which is a 'yes' or 'no'.. without the quotes.");
			}
		} while (!s.equals("yes") && !s.equals("no"));
		
		return driveIn;
	}
	
	public static int getNumberOfTellers(int tellerNumber, Scanner setUp){
		do {
		System.out.println("How many tellers do you want to try?");
		if (!setUp.hasNextInt()) {
			System.out.println("Please enter valid data. I.E. an integer. Preferably greater than zero");
		} else {
			tellerNumber = setUp.nextInt();
			if (tellerNumber > 0) {
				System.out.println("That's a valid entry, starting program.");
				break;
			} else if (tellerNumber == 0) {
				System.out.println("Must be a sunday. No tellers available. Closing up bank.");
				break;
			} else if (tellerNumber < 0)
				System.out.println("I'm sorry but that is just impossible. Negative tellers? Please try again.");
			}
		} while (setUp.nextInt() < 0);
			return tellerNumber;
	}
	
	public static void readFile(boolean driveIn, Queue<Customer> customerQ){
		try {
			String fileName = "Customers.txt";

			File file = new File(fileName);
			Scanner in = new Scanner(file);
			Scanner lineParts = null;
			Customer custy;

			long arrival;
			long tTime;
			boolean walkIn;
			long leaveTime = 0; // zero for now until we can calculate it. 

			//int i = 0; //testing purposes

			//while (i<3) {
			while (in.hasNextLine()) {
				String line = in.nextLine();
				lineParts = new Scanner(line);

				try {
					arrival = lineParts.nextInt();
					tTime = lineParts.nextInt();
					walkIn = lineParts.nextBoolean();
					if (driveIn) {
						custy = new Customer(arrival, tTime, walkIn, leaveTime);
					} else {
						custy = new Customer(arrival, tTime, true, leaveTime);
					}
					customerQ.add(custy);
					 // i++; //testing purposes
				} catch (InputMismatchException ime) {
					System.out.println("Data in the file is corrupt");
				} catch (NoSuchElementException nsee) {
					System.out.println("These are not the ints you are looking for");
				}

			}
			in.close();
			lineParts.close();

		} catch (FileNotFoundException fnfe) {
			System.out.println("File not found");
		}
	}
	
}
	
