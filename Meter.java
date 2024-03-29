/**
 * Meter class describing objects that manage the consumption and production of particular utility.
 * @author Wojciech Rozowski (wkr1u18)
 *
 */
public class Meter {
	private String utilityName;
	private double unitCost;
	private float meterReading;
	
	/**
	 * Constructor creating Meter object with specified utility name, unit cost of measured utility and initial meterReading.
	 * @param utilityName String describing the type of the utility
	 * @param unitCost The cost of one unit of this type of utility
	 * @param meterReading float describing initial meter reading
	 */
	public Meter(String utilityName, double unitCost, float meterReading) {
		this.utilityName = utilityName;
		this.unitCost = unitCost;
		this.meterReading = meterReading;
	}
	
	/**
	 * This method takes the number of consumed units and adjusts the meter state accordingly.
	 * @param consumedUnits Float describing number of consumed units.
	 */
	public void consumeUnits(float consumedUnits) {
		meterReading += consumedUnits;
	}
	
	/**
	 * Passes the information about consumed units and the total price of units to the standard output.
	 * After passing the information, it resets the value of the meter.
	 * @return double primitive containing total count of spent money in given time span
	 */
	public double report() {
		System.out.println(meterReading + " units of " + utilityName + " have been consumed");
		double finalCost = unitCost*meterReading;
		
		//If the device generated more energy than it used, set the total cost equal to zero
		if(finalCost < 0) {
			finalCost = 0;
		}
		System.out.println("It cost: " + finalCost);
		//Clear the meter
		meterReading = 0;
		//Returns the total cost
		return finalCost;
	}
	
	/**
	 * Getter to utilityName field used in overrided versions of report() to access superclass data, used also in simulation saving extension.
	 * @return String with the name of managed utility by the meter.
	 */
	public String getUtilityName() {
		return utilityName;
	}
	
	/**
	 * Getter to meterReading field used in overrided versions of report() to access superclass data, used also in simulation saving extension.
	 * @return float stating the meter reading in units
	 */
	public float getMeterReading() {
		return meterReading;
	}
	
	/**
	 * Setter to meterReading field used in overrided versions of report to access superclass data, used also in simulation saving extension.
	 * @param meterReading float describing new state of meter reading
	 */
	public void setMeterReading(float meterReading) {
		this.meterReading = meterReading;
	}
	
	/**
	 * Getter to unitCost field used in overrided versions of report() to access superclass data, used also in simulation saving extension.
	 * @return double stating the price of unit managed by the meter
	 */
	public double getUnitCost() {
		return unitCost;
	}
	
}
