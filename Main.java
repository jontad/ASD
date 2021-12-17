import java.util.HashMap;

class Database {
    public HashMap<String, Account> accounts;

    public Database(){
        HashMap<String, Account> accounts = new HashMap<String, Account>();
    }

    public HashMap<String, Account> getAccounts() {
        return this.accounts;
    }
}



class Server  {
    private Database db;

    public Server(){
        this.db = new Database();
    }


    public void setAccountToDB(Account account){
        HashMap<String, Account> accounts = this.db.getAccounts();
        //accounts.put(account.getEmail(), account);
    }


    public boolean validateAccount(String email, String password){

        HashMap<String, Account> accounts = this.db.getAccounts();
        try {
            Account account = accounts.get(email);
            
            String correctPassword = account.getPassword();
            if(correctPassword.equals(password) != true) {
                return false;
            } else {
                return true; 
            }

        } catch (NullPointerException e) {
            System.out.println("Account does not exist!");
            return false;
        }
    }
}

class Login {
    public boolean validateEmailAndPassword(Server server, String email, String password){
        boolean validated = server.validateAccount(email, password);
        return validated;
    }

    private void displayErrorMessage(String message){
        System.out.println(message);    
    }

    public void signIn(Server server, String email, String password) {
        boolean validated = this.validateEmailAndPassword(server, email, password);

        if(validated){
            System.out.println("Sign in succesful!");
            System.out.println("----- Redirect to main screen -----");
        } else {
            this.displayErrorMessage("Login failed");
        }
        
    }

}

public class Main {
    public static void main(String args[]) {
        Server server = new Server();

        Account account = new UserAccount("asd@gmail.com", "password");
        server.setAccountToDB(account);

        Login login = new Login();
        login.signIn(server, "asd@gmail.com", "password");

    }

}