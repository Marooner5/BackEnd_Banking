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
		
		public Customer(long arrival, long tTime, boolean walkIn){
			this.arrival = arrival;
			this.tTime= tTime;
			this.walkIn=walkIn;	
		}
		
}
