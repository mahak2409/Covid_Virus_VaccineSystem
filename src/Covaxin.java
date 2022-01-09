/*
 * Class for covaxine vaccine 
 */
public class Covaxin extends Vaccine{
	
public Covaxin(int wave) {
		
		super.setBoost(10+(10*(wave-1)));
		super.setReductionFactor(5);
		super.setDurability(100+(50*(wave-1)));
		super.setResistence(5);
		
	}

}
