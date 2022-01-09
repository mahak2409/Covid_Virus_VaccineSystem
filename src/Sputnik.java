/*
 * Class for sputnik vaccine 
 */
public class Sputnik extends Vaccine{
	
public Sputnik(int wave) {
		
		super.setBoost(10+10*(wave-1));
		super.setReductionFactor(4);
		super.setDurability(100+(50*(wave-1)));
		super.setResistence(8);
		
	}

}
