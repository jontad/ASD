public class AdminAccount extends Account {

    public AdminAccount(String email, String password) {
        super(email, password, true);
    }

    public void deleteUserAccount(UserAccount account) {
        return;
    }

    public void sendWarning(UserAccount account) {
        return;
    }
}