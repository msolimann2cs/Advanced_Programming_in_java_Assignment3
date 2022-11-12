import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class AccountManager {
    ArrayList<Account> account_list = new ArrayList<Account>();
    public void LoadAccounts() throws IOException {
        String accounts_csv_path = "C:\\Users\\msoli\\IdeaProjects\\Assignmnet3\\src\\accounts.csv";
        BufferedReader br = new BufferedReader(new FileReader(accounts_csv_path));
        String line = "";
        Account account = new Account();
        boolean first_line = true;
        while((line = br.readLine()) != null){
            String [] accounts = line.split(",");
            if(first_line == false){
                account.email = accounts[0];
                account.password = accounts[1];
                account.account_type = accounts[2];
                account_list.add(account);
            }
            first_line = false;
        }
    }
    public Account ValidateUser(String email, String password) throws IOException {
        LoadAccounts();
        for(int i = 0; i < account_list.size(); i++){
            if((Objects.equals(account_list.get(i).email, email)) && (Objects.equals(account_list.get(i).password, password))){
                //System.out.println("hi");
                Account account = new Account();
                account.email = account_list.get(i).email;
                account.password = account_list.get(i).password;
                account.account_type = account_list.get(i).account_type;
                return account;
            }
            //System.out.println(account_list.get(i).password);
            //System.out.println(password);
        }
        return null;
    }
}
