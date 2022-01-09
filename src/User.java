
public class User{
    String username;
    String AdharNum;
    String vaccine;

    public User(String username,String AdharNum,String vaccine){
        this.username=username;
        this.AdharNum=AdharNum;
        this.vaccine=vaccine;
        
    }
    User(){

    }

    public String  getusername(){
        return this.username;
    }
    public String  getAdharNum(){
        return this.AdharNum;
    }
    public String  getvaccine(){
        return this.vaccine;
    }
    public void setusername(String username){
        this.username=username;
    }
    public void setAdharnum(String AdharNum){
        this.AdharNum=AdharNum;
    }
    public void setvaccine(String vaccine){
        this.vaccine=vaccine;
    }
}