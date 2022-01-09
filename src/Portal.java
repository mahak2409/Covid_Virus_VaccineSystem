/*
 * Main Class for portal
 */
import java.util.Scanner;
import java.util.Random;

public class Portal {
	
	public static void main(String[] args) {
		
		int wave=1;
		Scanner sc = new Scanner(System.in);
		//Array of object is created to store patient data(Name,Adhar No,Vaccine)
		User obj[]=new User[100];
        int p=0,i,vaccine=0;
        String userchoice;
        System.out.println("<------Welcome to the portal------->\n");
        do{
            System.out.println("\nPlease select your option :\n1. New User \n2. Existing User \n3. Exit\n");
            userchoice = sc.nextLine();
            i=Integer.parseInt(userchoice);
			//Inputing choice of user
            switch(i){
                case 1:
                    obj[p]=new User();
					//Patient name input
                    System.out.print("Enter UserName:");
                    String username= sc.nextLine();                
                    obj[p].setusername(username);

					//Adhar number input
                    System.out.print("Enter Aadhar Number:");
                    Random random = new Random();
                    StringBuilder str = new StringBuilder();
                    for(int j = 0; j < 16; j++) {
                    str.append(random.nextInt(10));
                    }
                    String AdharNum= str.toString();
                    obj[p].setAdharnum(AdharNum);
                    System.out.println(obj[p].getAdharNum());

					// Vaccine input
                    System.out.println("Choose your Vaccine:");
					System.out.println("1. Covishield");
					System.out.println("2. Covaxin");
					System.out.println("3. Pfizer");
					System.out.println("4. Sputnik");
                    String vaccin = sc.nextLine();
                    int vaccinechoice=Integer.parseInt(vaccin);
					
					//Printing details of Patient
                    System.out.println("Paitient has been registered.");
                    System.out.println("Username: " + obj[p].getusername());
                    System.out.println("Adhar Number: " + obj[p].getAdharNum());
					vaccin="";
                    switch(vaccinechoice){
                        case 1:
                            vaccin="Covisheild";
                            break;
                        case 2:
                            vaccin="Covaxin";
                            break;
                        case 3:
                            vaccin="pfizer";
                            break;
                        case 4:
                            vaccin="Sputnik";
                            break;
                    }
					obj[p].setvaccine(vaccin);
                    System.out.println("Vaccine Opted: "+ obj[p].getvaccine());
                    p++;//pointer of array of object incremented
                    break;

				//checking for existing user if present then login is allowed
                case 2:
                    System.out.println("Enter Registered Username:");
                    String inputlogin=sc.nextLine();
                    System.out.print("Enter adhar Number:");
                    String inputpass=sc.nextLine();
                    System.out.println("Verifying...");
                    boolean flag=false;
                    int k;
					//name and adhar number verification. 
                    for( k=0;k<p;k++){
						
                        if(obj[k].getusername().equals(inputlogin) && obj[k].getAdharNum().equals(inputpass)){
                            System.out.println(obj[k].getusername());
                            flag=true;
                            break;
                        }
                    }
					//if patient found successfully
					if(flag ==true){
                        System.out.println("Patient Found!");
                        System.out.println("Welcome "+ inputlogin);
                        System.out.println("You're being tested for the 1st wave for the alpha variant of the virus :");
						String v=obj[k].getvaccine();
						//Retrieving vaccine which user entered during registration.
						if(v=="Covisheild")
							vaccine=1;
						else if(v=="Covaxin")
							vaccine=2;
						else if(v=="Pfizer")
							vaccine=3;
						else vaccine = 4;


						boolean exitFlag=false;
						//Every patient is tested for each wave.
						// whenever vaccine is  able to defeat virus
						// injectEffectCalculation() returns false otherwise returns true to exit the loop
						while(wave<5 && exitFlag==false) {	
							
							switch(vaccine) {
							
							case 1: Covishield covishield = new Covishield(wave);
									exitFlag =injectEffectCalculation(covidWave(wave),covishield,wave);
							break;
							case 2: Covaxin covaxin = new Covaxin(wave);
									exitFlag = injectEffectCalculation(covidWave(wave),covaxin,wave);
							break;
							case 3: Pfizer pfizer = new Pfizer(wave);
									exitFlag = injectEffectCalculation(covidWave(wave),pfizer,wave);
							break;
							case 4: Sputnik sputnik = new Sputnik(wave);
									exitFlag = injectEffectCalculation(covidWave(wave),sputnik,wave);
							}
							if(exitFlag==false)
							System.out.println("Virus Defeated !\nVaccine proves to be effective during the wave"+ wave+"!!!\n"
									+ "Moving on to the next wave.");

							// reinitialization for next Patient 
							else {
								wave=1;
								break;
							}
							++wave;
						}
						
						if(exitFlag==false && wave==5 ) {
							
							System.out.println("Virus Defeated !\n"
									+ "Vaccine proves to be effective during the fourth wave!!!\n"
									+ "Congratulations, your vaccine has overpowered all the variants of the virus and hence\n"
									+ "has proved to be effective in all the waves. Great Job!\n"
									+ "Thanks for your participation. Now let’s get Vaccinated !!!");
						}
					}
					
					else
                        System.out.println("Patient not found !!! If you haven't registered yet then please register first.");						
					break;

				case 3:
						System.out.println("Exiting portal...\nThanks for your participation! ");
						System.exit(0);
					break;
					}
				
				}while(true);
			
			
		}
	 
	 
		
		
/*
 * coviWave function is telling which virus will affect according to the wave
 * It returns the Virus class object
 */
	public static Virus covidWave(int wave) {
		
		switch(wave) {
		
			case 1: Alpha alpha = new Alpha();
					return alpha;
			
			case 2: Beta beta = new Beta();
					return beta;
			
			case 3: Gamma gamma = new Gamma();
					return gamma;
			
			case 4: Sigma sigma = new Sigma();
					return sigma;
			default: System.out.println("All Waves End");
		}
		Virus virus = new Virus();
		
		return virus;
	}


/*
 * This function is performing attack action according to the chosen option by the user
 * It returns the boolean value whether to proceed for the next wave or exit from it
 */
	public static boolean injectEffectCalculation(Virus virus, Vaccine vaccine,int wave) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Vaccine's BOOST : "+vaccine.getBoost()+"| Vaccine's DURABILITY : "+vaccine.getDurability()+
				" | Virus's Life : "+virus.getLife()+" | Virus Variant : "+virus.getClass());
		
		while(virus.getLife()!=0 && vaccine.getDurability()!=0) {
			System.out.println("Please Select an option:");
			System.out.println("1. Inject");
			System.out.println("2. Effect");
			System.out.println("3. Exit");
			
			
			int vaccineActionChoice= sc.nextInt();
			switch(vaccineActionChoice) {
			
			case 1:System.out.println("Your vaccine is boosted and it reduces the life of the virus by "+vaccine.getReductionFactor());
					vaccine.inject(virus);
					System.out.println("Vaccine's DURABILITY :"+vaccine.getDurability()+" | Virus's Life :"+virus.getLife());
					break;
			case 2: System.out.println("Virus's action reduced by "+vaccine.getResistence());
					vaccine.effect();
					System.out.println("Vaccine's DURABILITY :"+vaccine.getDurability()+" | Virus's Life :"+virus.getLife());
					break;
			case 3: System.out.println("Exited at wave"+wave+"!");
					System.out.println("Thanks for your participation. Let's get Vaccinated !!!");
					return true;
					
			
			}
			//if virus life is 0 then virus is defeated.
			if(virus.getLife()==0) {
				
				return false;
			}
			
			
			System.out.println("VIRUS'S ACTION !");
			virus.attack(vaccine);
			System.out.println("Vaccine's DURABILITY :"+vaccine.getDurability()+" | Virus's Life :"+virus.getLife());
				
		}
		
		if(vaccine.getDurability()==0) {
			System.out.println("Oops! Your vaccine fails to affect the "+virus.getClass()+" Variant.");
			System.out.println("\nHowever, The vaccine helps you fight against several attacks of the virus and proves to\n"
					+ "be useful. This shows how important the vaccine is in the fight against COVID-19.\n"
					+ "Thanks for your participation. Now Let's get Vaccinated !!!");
			return true;
		}
		
		return false;
		
	}
	
	

}
