/*
 * Class for pfizer vaccine 
 */
public class Pfizer extends Vaccine{
	
public Pfizer(int wave) {
		
		super.setBoost(10+(10*(wave-1)));
		super.setReductionFactor(6);
		super.setDurability(100+(50*(wave-1)));
		super.setResistence(4);
		
	}

}
