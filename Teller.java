import java.util.Queue;

/**
 * 
 */

/**
 * @author Andrew Littler
 *This class is going to handle the creation and functionality of the tellers.
 */
public class Teller {
	
	private long idleTime;
	private long customersHelped;
	private int tellerID;
	private Queue tellerQ;
	
	
	
	public boolean checkDriveIn(Queue driveIn){
		//peek at drive in queue
		return !driveIn.isEmpty();
	}
	
	public void updateIdleTime(){
		// first need to determine when idle
		
	}
	
	public boolean checkIfIdle(Queue tellerQ){
		return this.tellerQ.isEmpty();
	}

}
