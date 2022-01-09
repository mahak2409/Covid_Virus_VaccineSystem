/*
 * Virus class is the base class for all the viruses in different wave
 */
public class Virus {
 private int life=0;
 private double attackFactor=0;



public double getAttackFactor() {
	return attackFactor;
}

public void setAttackFactor(double attackFactor) {
	this.attackFactor = attackFactor;
}

public int getLife() {
	return life;
}

public void setLife(int life) {
	this.life = life;
}

/*
 * Attack function calculates the attack according to user's action as inject or effect
 * It takes vaccine class object as argument
 */
public void attack(Vaccine vaccine) {

	int vaccineDurability=vaccine.getDurability();
	
	//Generating random number for attackValue
	int attackValue=(int)((Math.random()*attackFactor)*life);
	
	/*
	 * When user selects effect then flag in vaccine class will be set true
	 * When effect is selected virus attack value is reduced by the vaccine's resistance 
	 * and then durability of vaccine is reduced with their resultant value
	 */
	if(vaccine.getFlag()) {
		
		int	value=attackValue-vaccine.getResistence();
		if(value>-1)
		vaccineDurability = vaccine.getDurability()-value;
		if(vaccineDurability<0)
			vaccineDurability=0;
		if(value<0)
			value=0;
		System.out.println("Virus reduces the vaccine's DURABILITY by "+value);
	}
	/*
	 * If user selects inject as option then else will get executed and vaccine durability is decreased by attackValue 
	 */
	else {
				
		vaccineDurability=vaccine.getDurability() - attackValue;
		if(vaccineDurability<0)
			vaccineDurability=0;
		System.out.println("Virus reduces the vaccine's DURABILITY by "+attackValue);
	}
	
	/*
	 * After calculating vaccine durability it is being set for corresponding vaccine
	 */
	vaccine.setDurability(vaccineDurability);
	
	
}
}
