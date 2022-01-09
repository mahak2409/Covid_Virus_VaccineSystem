/*
 * Class for covishield vaccine 
 */
public class Covishield extends Vaccine{
	
	public Covishield(int wave) {
		
		super.setBoost(10+(10*(wave-1)));
		super.setReductionFactor(10);
		super.setDurability(100+(50*(wave-1)));
		super.setResistence(10);
		
	}
	
	
	
	
}
