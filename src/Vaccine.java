/*
 * Vaccine class is the base class for all the vaccines
 */
public class Vaccine {
	
	private int Durability=0;
	private int Boost=0;
	private int reductionFactor=0;
	private int resistence=0;
	private Boolean flag=false;
	
	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	public int getResistence() {
		return resistence;
	}

	public void setResistence(int resistence) {
		this.resistence = resistence;
	}

	public int getReductionFactor() {
		return reductionFactor;
	}

	public void setReductionFactor(int reductionFactor) {
		this.reductionFactor = reductionFactor;
	}

	public int getDurability() {
		return Durability;
	}

	public void setDurability(int durability) {
		Durability = durability;
	}

	public int getBoost() {
		return Boost;
	}

	public void setBoost(int boost) {
		Boost = boost;
	}

	/*
	 * Inject function reduces virus's life by reduction factor
	 */
	public void inject(Virus virus) {
		int life=0;
		life =virus.getLife();
		life -= this.reductionFactor;
		virus.setLife(life);
		if(life<=0) {
			life=0;
			
		}
	}

	/*
	 * Effect function sets the flag true when effect option is being selected by the user
	 */
	public void effect() {
		
		flag=true;
		
	}

}
