package Users;

public class Account {
    String email;
    String password;
    String account_type;
    static int ID;


    public void setEmail(String email){
        this.email = email;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setAccount_type(String account_type){
        this.account_type = account_type;
    }
    public String getEmail(){
        return email;
    }
    public String getPassword(){
        return password;
    }
    public String getAccount_type(){
        return account_type;
    }
}
