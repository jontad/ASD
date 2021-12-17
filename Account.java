abstract class Account {

    private String email;
    private String password;
    private boolean adminAccountStatus = false;


    public Account(String email, String password, boolean adminAccountStatus) {
        this.email = email;
        this.password = password;
        this.adminAccountStatus = adminAccountStatus;
    }

    public boolean getAdminAccountStatus() {
        return false;
    }

    public String getPassword() {
        return this.password;
    }

    public String getEmail() {
        return this.email;
    }

   
}