/**
 * 
 */

/**
 * @author Andrew Littler
 *This class is going to handle the creation of the customers. 
 */
public class Customer {

		private long arrival;
		private long tTime;
		private boolean walkIn;
		private long waitTime;
		private long leaveTime;
		
		public Customer(long arrival, long tTime, boolean walkIn, long leaveTime){
			this.arrival = arrival;
			this.tTime= tTime;
			this.walkIn=walkIn;
			this.leaveTime = leaveTime;
		}
		
		public long calculateWaitTime(){
			return Clock.globalTime - this.arrival;
		}
		
		public long getArrivalTime(){
			return this.arrival;
		}
		
		public long getTransTime(){
			return this.tTime;
		}
		
		public boolean getWalkInStatus(){
			return walkIn;
		}
		
		public long getWaitTime(){
			return waitTime;
		}
		
		public void goToTellerQ(){
			
		}
		
		public void updateLeaveTime(){
			this.leaveTime = Clock.globalTime + this.tTime;
		}
}
