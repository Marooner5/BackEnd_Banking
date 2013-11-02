import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author Andrew Littler and Tam Huynh This class is going to act as the driver
 *         class for the program.
 */
public class Bank {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO send customers to teller and arrival q
		int tellerNumber = 3; // received from user, how many tellers available
		String s = ""; // string received from user
		boolean driveIn = true;// received from user, if drive in is available

		Scanner setUp = new Scanner(System.in);

		// this block received drive in info from the user
		driveIn = checkDriveInStatus(setUp, driveIn, s);

		// this block receives teller quantity info from the user
		tellerNumber = getTellerNumber(tellerNumber, setUp);

		// this block reads the file and creates customer objects from it
		readFile(driveIn);

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
	
	public static int getTellerNumber(int tellerNumber, Scanner setUp){
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
	
	public static void readFile(boolean driveIn){
		try {

			String fileName = "Customers.txt";

			File file = new File(fileName);
			Scanner in = new Scanner(file);

			long arrival;
			long tTime;
			boolean walkIn;

			int i = 0;

			while (i<15) {
				String line = in.nextLine();
				Scanner lineParts = new Scanner(line);

				try {
					arrival = lineParts.nextInt();
					tTime = lineParts.nextInt();
					walkIn = lineParts.nextBoolean();
					if (driveIn) {
						Customer custy = new Customer(arrival, tTime, walkIn);
					} else {
						Customer custy = new Customer(arrival, tTime, true);
					}
					i++;
					System.out.println(arrival + " " + tTime + " " + walkIn);
				} catch (InputMismatchException ime) {
					System.out.println("Data in the file is corrupt");
				} catch (NoSuchElementException nsee) {
					System.out.println("These are not the ints you are looking for");
				}

			}

		} catch (FileNotFoundException fnfe) {
			System.out.println("File not found");
		}
	}
	
}
	
