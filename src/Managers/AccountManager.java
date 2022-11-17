package Managers;

import Users.Account;
import com.opencsv.CSVWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class AccountManager {
    ArrayList<Account> account_list = new ArrayList<>();
    String accounts_csv_path = "C:\\Users\\msoli\\IdeaProjects\\Assignmnet3\\src\\LocalDatabase\\accounts.csv";
    public void LoadAccounts() throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(accounts_csv_path));
        String line = "";

        boolean first_line = true;
        while((line = br.readLine()) != null){
            String [] accounts = line.split(",");
            if(first_line == false){
//                System.out.println(accounts[0]);
//                System.out.println(accounts[1]);
//                System.out.println(accounts[2]);
                Account account = new Account();
                account.setEmail(accounts[0]);
                account.setPassword(accounts[1]);
                account.setAccount_type(accounts[2]);
                account_list.add(account);
            }

            first_line = false;
        }
//        for(int i = 0; i < account_list.size(); i++){
//            System.out.println(account_list.get(i).getEmail());
//            System.out.println(account_list.get(i).getPassword());
//        }
        br.close();
    }
    public Account ValidateUser(String email, String password) throws IOException {
        LoadAccounts();
        for(int i = 0; i < account_list.size(); i++){
            System.out.println(account_list.get(i).getEmail());
            System.out.println(account_list.get(i).getPassword());
            if((Objects.equals(account_list.get(i).getEmail(), email)) && (Objects.equals(account_list.get(i).getPassword(), password))){
                //System.out.println("hi");
                Account account = new Account();
                account.setEmail(account_list.get(i).getEmail());
                account.setPassword(account_list.get(i).getPassword());
                account.setAccount_type(account_list.get(i).getAccount_type());
                return account;
            }
            //System.out.println(account_list.get(i).password);
            //System.out.println(password);
        }
        return null;
    }

    public void addUser(String email, String password, String account_type) throws IOException {

        if(account_list.isEmpty()){
            LoadAccounts();
        }
        FileWriter outputfile = new FileWriter(accounts_csv_path);
        // create CSVWriter object filewriter object as parameter
        //CSVWriter writer = new CSVWriter(outputfile);
        CSVWriter writer = new CSVWriter(outputfile, ',',
                CSVWriter.NO_QUOTE_CHARACTER,
                CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                CSVWriter.DEFAULT_LINE_END);
        String[] account = { email, password, account_type };
        ArrayList<String[]> csv_data = new ArrayList<String[]>();
        csv_data.add(new String[]{"Email", "Passowrd", "Account Type"});
        for(int i = 0; i < account_list.size(); i++){
            csv_data.add(new String[] {account_list.get(i).getEmail(), account_list.get(i).getPassword(), account_list.get(i).getAccount_type()});
        }
        csv_data.add(account);
        writer.writeAll(csv_data);
        writer.close();
    }

    public boolean userExists(String email, String password) throws IOException {
        if(account_list.isEmpty()){
            LoadAccounts();
        }
        for(int i = 0; i < account_list.size(); i++){
            if((Objects.equals(account_list.get(i).getEmail(), email)) && (Objects.equals(account_list.get(i).getPassword(), password))){
                return true;
            }
        }
        return  false;
    }

}
