import java.util.ArrayList;
import java.util.List;

/**
 * 
 */

/**
 * @author Andrew Littler
 *This class is going to handle grabbing and calculating the statistics required in the program.
 *As well as hold the necessary stats variables
 */

public class Statistics {

	public static ArrayList<Integer> custyWaitTime = new ArrayList<Integer>();
	public static ArrayList<Integer> tellerIdleTime = new ArrayList<Integer>();
	
	public static double standardDev(List<Integer> waitTimeList){
		return Math.sqrt(getVariance(waitTimeList));
	}
	
	private static double getVariance(List<Integer> waitTimeList){
		double mean = getMean(waitTimeList);
		double q = 0;
		for(double a:waitTimeList)
			q = q + (mean-a)*(mean-a);
			return q/waitTimeList.size();
		
	}
	
	public static double getMean(List<Integer> waitTimeList){
		double sum = 0;
		for(double a : waitTimeList)
			sum = sum + a;
		return sum/waitTimeList.size();
	}
}
