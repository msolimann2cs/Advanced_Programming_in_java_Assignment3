import Managers.AccountManager;
import Screens.login_screen;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");
//        AccountManager account_manager = new AccountManager();
//        account_manager.LoadAccounts();
        new login_screen();
    }
}